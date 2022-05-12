package org.example.model;

//POJO plain java object podstawowy objekt java
public class RegionEntity {
    private Integer regionId;
    private String regionName;

    public RegionEntity(Integer regionId, String regionName) {
        this.regionId = regionId;
        this.regionName = regionName;
    }

    public RegionEntity(String regionName) {
        this.regionName = regionName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "RegionEntity {" +
                "regionId = " + regionId +
                ", regionName = '" + regionName + '\'' +
                "}";
    }
}
