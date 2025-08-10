DROP TABLE IF EXISTS plants;

-- Create the 'plants' table
CREATE TABLE plants (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each plant, auto-incremented
    common_name VARCHAR(255) NOT NULL, -- Common name of the plant (e.g., "Oak Tree")
    scientific_name VARCHAR(255),      -- Scientific name (optional)
    type VARCHAR(50),                  -- Type of plant (e.g., "Tree", "Shrub", "Herb")
    climate_zone VARCHAR(100),         -- Suitable climate zones (e.g., "Tropical", "Temperate")
    sunlight_needs VARCHAR(50),        -- Sunlight requirements (e.g., "Full Sun", "Partial Shade")
    water_needs VARCHAR(50),           -- Water requirements (e.g., "Low", "Medium", "High")
    carbon_sequestration_rate DOUBLE,  -- Carbon absorbed per year (e.g., kg CO2/year)
    cooling_effect DOUBLE,             -- Cooling effect (e.g., in degrees Celsius)
    air_quality_improvement DOUBLE,    -- Air quality improvement potential (e.g., index value)
    biodiversity_support BOOLEAN,      -- Whether it supports local biodiversity
    water_management_benefits BOOLEAN 
);