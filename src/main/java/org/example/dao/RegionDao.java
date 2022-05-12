package org.example.dao;

import org.example.model.RegionEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//DAO data acces object
public class RegionDao {
    //wszystkie operacje na regionie
    //CRUD- create read update delate
    private final Connection connection;

    public RegionDao(Connection connection) {
        this.connection = connection;
    }

    public RegionEntity getRegionById(Integer id)throws SQLException {
        PreparedStatement regionsStatement = connection.prepareStatement(
                "SELECT region_id, region_name FROM regions WHERE region_id = ?");
        regionsStatement.setInt(1, id);
        ResultSet resultSet = regionsStatement.executeQuery();
        if(resultSet.next()) {
             RegionEntity regionEntity = new RegionEntity(
                    resultSet.getInt("region_id"),
                    resultSet.getString("region_name"));
            regionsStatement.close();
            return regionEntity;
        }
        regionsStatement.close();
        return null;
    }
    public List<RegionEntity> getAllRegions()throws SQLException{
        PreparedStatement regionsStatement = connection.prepareStatement(
                "SELECT region_id, region_name FROM regions");
        ResultSet resultSet = regionsStatement.executeQuery();
        List<RegionEntity> regionEntities = new ArrayList<>();
        while(resultSet.next()) {
            RegionEntity regionEntity = new RegionEntity(
                    resultSet.getInt("region_id"),
                    resultSet.getString("region_name"));
            regionsStatement.close();
            regionEntities.add(regionEntity);
        }
        return regionEntities;
    }

    public void save(RegionEntity region)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO regions ( region_name) VALUES(?)");
        preparedStatement.setString(1,region.getRegionName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(Integer id)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM regions WHERE region_id = ?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void update(RegionEntity region)throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE regions SET region_name = ? WHERE region_id = ?");
        preparedStatement.setString(1, region.getRegionName());
        preparedStatement.setInt(2, region.getRegionId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteTwo(Integer id1, Integer id2, String dummy) throws SQLExceptions{
       try {
        connection.setAutoCommit(false);
        delete(id1);
        //dodane żeby wyrzucić wyjątek
        dummy.split("");
        delete(id2);
        connection.commit();
        }catch (NullPointerException e){
           System.out.println("Rollback!!!");
           connection.rollback();
       }
        connection.setAutoCommit(true);
    }


}
