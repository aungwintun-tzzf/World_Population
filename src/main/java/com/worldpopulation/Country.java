package com.worldpopulation;

public class Country {
    private String countryname, capitalname, regionname, subregionname;

    public Country(String countryname, String capitalname, String subregionname, String regionname) {
        this.countryname = countryname;
        this.capitalname = capitalname;
        this.subregionname = subregionname;
        this.regionname = regionname;
    }

    public String getCountryname() {
        return countryname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryname='" + countryname + '\'' +
                ", capitalname='" + capitalname + '\'' +
                ", regionname='" + regionname + '\'' +
                ", subregionname='" + subregionname + '\'' +
                '}';
    }

    public String getCapitalname() {
        return capitalname;
    }

    public String getRegionname() {
        return regionname;
    }

    public String getSubregionname() {
        return subregionname;
    }
}

