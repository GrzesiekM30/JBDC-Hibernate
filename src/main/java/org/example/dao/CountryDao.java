package org.example.dao;

import org.example.model.CountryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDao {
    private final Connection connection;
    public CountryDao(Connection connection) {
        this.connection = connection;
    }

    public CountryEntity getCountryById(String id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT country_id, country_name, region_id FROM countries WHERE country_id = ?");
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
           CountryEntity countryEntity = new CountryEntity(
                    resultSet.getString("country_id"),
                    resultSet.getString("country_name"),
                    resultSet.getInt("region_id")
            );
            preparedStatement.close();
            return countryEntity;
        }
        preparedStatement.close();
        return null;
    }
}
