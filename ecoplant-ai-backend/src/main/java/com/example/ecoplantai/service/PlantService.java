package com.example.ecoplantai.service;
import com.example.ecoplantai.model.ImpactResult;
import com.example.ecoplantai.model.Plant;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService {
    private final List<Plant> plantDatabase = Arrays.asList(
        new Plant("Quercus robur", "Oak Tree", "Temperate", "Full Sun", "Carbon Offset"),
        new Plant("Acer rubrum", "Red Maple", "Temperate", "Partial Shade", "Air Quality"),
        new Plant("Cocos nucifera", "Coconut Palm", "Tropical", "Full Sun", "Home Cooling"),
        new Plant("Plumeria", "Frangipani", "Subtropical", "Full Sun", "Air Quality"),
        new Plant("Ficus benjamina", "Weeping Fig", "Tropical", "Full Shade", "Home Cooling")
    );

    /**
     * Simulates an AI plant identification.
     * In a real application, this would call an AI API like Google Cloud Vision.
     *
     * @return A hardcoded identification string.
     */
    public String identifyPlant() {
        // This is a placeholder. In a real app, you would process the image file
        // and call an AI service.
        return "Oak Tree (Quercus robur)";
    }

    /**
     * Recommends plants based on user-provided criteria.
     *
     * @param location The climate zone.
     * @param sunlight The sunlight availability.
     * @param goal The user's green goal.
     * @return A filtered list of plants matching the criteria.
     */
    public List<Plant> getRecommendations(String location, String sunlight, String goal) {
        return plantDatabase.stream()
                .filter(plant -> plant.getClimateZone().equalsIgnoreCase(location))
                .filter(plant -> plant.getSunlightNeeds().equalsIgnoreCase(sunlight))
                .filter(plant -> plant.getBenefits().equalsIgnoreCase(goal))
                .collect(Collectors.toList());
    }

    /**
     * Calculates the climate impact of a given plant and quantity.
     *
     * @param plantName The common name of the plant.
     * @param quantity The number of plants.
     * @return An ImpactResult object with the calculated values.
     */
    public ImpactResult calculateImpact(String plantName, int quantity) {
        // Find the plant to get its base impact values (hardcoded for this example)
        Plant plant = plantDatabase.stream()
                .filter(p -> p.getCommonName().equalsIgnoreCase(plantName))
                .findFirst()
                .orElse(null);

        if (plant == null) {
            return new ImpactResult("Plant not found in our database.");
        }

        
        double baseCarbonOffset = 22.0; // kg/year for an Oak Tree
        double baseCoolingEffect = 10000.0; // BTU/year

        if (plant.getCommonName().equalsIgnoreCase("Red Maple")) {
            baseCarbonOffset = 18.0;
            baseCoolingEffect = 8500.0;
        } else if (plant.getCommonName().equalsIgnoreCase("Coconut Palm")) {
             baseCarbonOffset = 15.0;
            baseCoolingEffect = 12000.0;
        }

        double totalCarbonOffset = baseCarbonOffset * quantity;
        double totalCoolingEffect = baseCoolingEffect * quantity;
        String airQualityImprovement = "Significant air quality improvement due to " + plant.getCommonName() + ".";

        return new ImpactResult(totalCarbonOffset, totalCoolingEffect, airQualityImprovement);
    }
}

