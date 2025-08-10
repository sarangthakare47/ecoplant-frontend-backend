document.addEventListener('DOMContentLoaded', () => {
    // --- Get all necessary HTML elements ---
    const identificationForm = document.getElementById('identificationForm');
    const plantImageInput = document.getElementById('plantImageInput');
    const plantResultDiv = document.getElementById('plantResult');

    const recommendationForm = document.getElementById('recommendationForm');
    const recommendationResultDiv = document.getElementById('recommendationResult');
    const locationInput = document.getElementById('location');
    const sunlightInput = document.getElementById('sunlight');
    const goalInput = document.getElementById('goal');

    const calculatorForm = document.getElementById('calculatorForm');
    const impactResultDiv = document.getElementById('impactResult');
    const plantNameCalcInput = document.getElementById('plantNameCalc');
    const quantityCalcInput = document.getElementById('quantityCalc');

    // --- Function to display results and handle loading state ---
    function showResult(resultDiv, content) {
        resultDiv.innerHTML = content;
        resultDiv.style.display = 'block';
    }

    // --- 1. Handle Plant Identification Form Submission ---
    identificationForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Prevent the form from reloading the page

        // Display loading message
        showResult(plantResultDiv, '<p>Identifying plant... ⏳</p>');

        const file = plantImageInput.files[0];
        if (!file) {
            showResult(plantResultDiv, '<p style="color: #ff5757;">Please select an image file.</p>');
            return;
        }

        const formData = new FormData();
        formData.append('image', file);

        try {
            const response = await fetch('/api/plants/identify', {
                method: 'POST',
                body: formData,
            });

            const result = await response.json();

            if (response.ok) {
                // If the backend call was successful, display the identification text
                showResult(plantResultDiv, `<p><strong>Identified as:</strong> ${result.identification}</p>`);
            } else {
                // Handle non-OK responses from the backend
                showResult(plantResultDiv, `<p style="color: #ff5757;">Error: ${result.error || 'Failed to identify plant.'}</p>`);
            }
        } catch (error) {
            // Handle network or other unexpected errors
            console.error('Identification request failed:', error);
            showResult(plantResultDiv, '<p style="color: #ff5757;">A network error occurred. Please try again.</p>');
        }
    });

    // --- 2. Handle Plant Recommendations Form Submission ---
    recommendationForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        // Display loading message
        showResult(recommendationResultDiv, '<p>Finding recommendations... 🌳</p>');

        const location = locationInput.value;
        const sunlight = sunlightInput.value;
        const goal = goalInput.value;

        // Construct the query URL with user inputs
        const queryUrl = `/api/plants/recommend?location=${location}&sunlight=${sunlight}&goal=${goal}`;

        try {
            const response = await fetch(queryUrl);
            const recommendations = await response.json();

            if (response.ok) {
                if (recommendations.length > 0) {
                    let resultsHtml = '<ul class="result-list">';
                    recommendations.forEach(plant => {
                        resultsHtml += `
                            <li>
                                <strong>${plant.commonName}</strong> (${plant.species})
                                <br>
                                <small>Climate: ${plant.climateZone} | Sunlight: ${plant.sunlightNeeds}</small>
                                <p><strong>Benefits:</strong> ${plant.benefits}</p>
                            </li>
                        `;
                    });
                    resultsHtml += '</ul>';
                    showResult(recommendationResultDiv, resultsHtml);
                } else {
                    showResult(recommendationResultDiv, '<p>No plants found for your criteria. Please try different options.</p>');
                }
            } else {
                showResult(recommendationResultDiv, `<p style="color: #ff5757;">Error: ${recommendations.error || 'Failed to get recommendations.'}</p>`);
            }
        } catch (error) {
            console.error('Recommendation request failed:', error);
            showResult(recommendationResultDiv, '<p style="color: #ff5757;">A network error occurred. Please try again.</p>');
        }
    });

    // --- 3. Handle Climate Impact Calculator Form Submission ---
    calculatorForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        // Display loading message
        showResult(impactResultDiv, '<p>Calculating impact... 🌍</p>');

        const plantName = plantNameCalcInput.value;
        const quantity = quantityCalcInput.value;

        // Construct the query URL with user inputs
        const queryUrl = `/api/plants/calculate-impact?plantName=${plantName}&quantity=${quantity}`;

        try {
            const response = await fetch(queryUrl);
            const impact = await response.json();

            if (response.ok) {
                if (impact.error) {
                    showResult(impactResultDiv, `<p style="color: #ff5757;">${impact.error}</p>`);
                } else {
                    const resultsHtml = `
                        <p><strong>Total Carbon Offset:</strong> ${impact.carbonOffset} kg/year</p>
                        <p><strong>Total Cooling Effect:</strong> ${impact.coolingEffect} BTU/year</p>
                        <p><strong>Air Quality Improvement:</strong> ${impact.airQualityImprovement}</p>
                    `;
                    showResult(impactResultDiv, resultsHtml);
                }
            } else {
                showResult(impactResultDiv, `<p style="color: #ff5757;">Error: ${impact.error || 'Failed to calculate impact.'}</p>`);
            }
        } catch (error) {
            console.error('Impact calculation request failed:', error);
            showResult(impactResultDiv, '<p style="color: #ff5757;">A network error occurred. Please try again.</p>');
        }
    });
});
