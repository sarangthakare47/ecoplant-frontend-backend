-- Insert sample plant data into the 'plants' table
INSERT INTO plants (common_name, scientific_name, type, climate_zone, sunlight_needs, water_needs, carbon_sequestration_rate, cooling_effect, air_quality_improvement, biodiversity_support, water_management_benefits) VALUES
('Oak Tree', 'Quercus robur', 'Tree', 'Temperate', 'Full Sun', 'Medium', 22.0, 2.5, 0.8, TRUE, TRUE),
('Mango Tree', 'Mangifera indica', 'Tree', 'Tropical', 'Full Sun', 'Medium', 25.0, 3.0, 0.7, TRUE, FALSE),
('Neem Tree', 'Azadirachta indica', 'Tree', 'Tropical, Arid', 'Full Sun', 'Low', 18.0, 2.0, 0.9, TRUE, TRUE),
('Aloe Vera', 'Aloe barbadensis miller', 'Herb', 'Arid, Subtropical', 'Partial Shade', 'Low', 0.1, 0.1, 0.2, FALSE, TRUE),
('Banyan Tree', 'Ficus benghalensis', 'Tree', 'Tropical', 'Full Sun', 'High', 30.0, 4.0, 0.95, TRUE, TRUE),
('Tulsi (Holy Basil)', 'Ocimum sanctum', 'Herb', 'Tropical, Subtropical', 'Full Sun', 'Medium', 0.05, 0.05, 0.1, TRUE, FALSE),
('Areca Palm', 'Dypsis lutescens', 'Shrub', 'Tropical', 'Partial Shade', 'Medium', 1.0, 0.5, 0.3, FALSE, FALSE),
('Bamboo', 'Bambusa vulgaris', 'Grass', 'Tropical, Temperate', 'Full Sun', 'High', 15.0, 1.5, 0.6, TRUE, TRUE);