package com.example.ecoplantai.model;

public class Plant {
    private String species;
    private String commonName;
    private String climateZone;
    private String sunlightNeeds;
    private String benefits; // e.g., "Carbon Offset", "Air Quality"

    // Constructors
    public Plant() {
    }

    public Plant(String species, String commonName, String climateZone, String sunlightNeeds, String benefits) {
        this.species = species;
        this.commonName = commonName;
        this.climateZone = climateZone;
        this.sunlightNeeds = sunlightNeeds;
        this.benefits = benefits;
    }

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getClimateZone() {
        return climateZone;
    }

    public void setClimateZone(String climateZone) {
        this.climateZone = climateZone;
    }

    public String getSunlightNeeds() {
        return sunlightNeeds;
    }

    public void setSunlightNeeds(String sunlightNeeds) {
        this.sunlightNeeds = sunlightNeeds;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}

