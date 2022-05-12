package org.example.model;

public class CountryEntity {
    private String countryId;
    private String countryName;
    private Integer regionId;

    public CountryEntity(String countryId, String countryName, Integer regionId) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.regionId = regionId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return "CountryEntity {" +
                "country_id = '" + countryId + '\'' +
                ", country_name = '" + countryName + '\'' +
                ", region_id = " + regionId +
                "}";
    }
}
