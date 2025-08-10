package com.example.ecoplantai.model;

public class ImpactResult {
    private double carbonOffset; // in kg/year
    private double coolingEffect; // in BTU/year
    private String airQualityImprovement; // a descriptive string
    private String error;

    // Constructors
    public ImpactResult(double carbonOffset, double coolingEffect, String airQualityImprovement) {
        this.carbonOffset = carbonOffset;
        this.coolingEffect = coolingEffect;
        this.airQualityImprovement = airQualityImprovement;
    }

    public ImpactResult(String error) {
        this.error = error;
    }

    // Getters and Setters
    public double getCarbonOffset() {
        return carbonOffset;
    }

    public void setCarbonOffset(double carbonOffset) {
        this.carbonOffset = carbonOffset;
    }

    public double getCoolingEffect() {
        return coolingEffect;
    }

    public void setCoolingEffect(double coolingEffect) {
        this.coolingEffect = coolingEffect;
    }

    public String getAirQualityImprovement() {
        return airQualityImprovement;
    }

    public void setAirQualityImprovement(String airQualityImprovement) {
        this.airQualityImprovement = airQualityImprovement;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

