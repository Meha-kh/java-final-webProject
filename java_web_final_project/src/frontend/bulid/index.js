document.addEventListener("DOMContentLoaded", () => {
  const candyForm = document.getElementById("candyForm");
  const candyContainer = document.getElementById("candyContainer");

  
  const fetchCandies = async () => {
    try {
      const response = await fetch("/candy");
      const candies = await response.json();
      renderCandies(candies);
    } catch (error) {
      console.error("Error fetching candies:", error);
    }
  };

  
  const renderCandies = (candies) => {
    candyContainer.innerHTML = "";

    candies.forEach((candy) => {
      const candyElement = document.createElement("div");
      candyElement.innerHTML = `
        <h3>${candy.name}</h3>
        <p>Flavor: ${candy.flavor}</p>
        <p>Price: ${candy.price}</p>
      `;
      candyContainer.appendChild(candyElement);
    });
  };

  
  candyForm.addEventListener("submit", async (e) => {
    e.preventDefault();

    const nameInput = document.getElementById("nameInput");
    const flavorInput = document.getElementById("flavorInput");
    const priceInput = document.getElementById("priceInput");

    const candy = {
      name: nameInput.value,
      flavor: flavorInput.value,
      price: parseFloat(priceInput.value),
    };

    try {
      const response = await fetch("/candy", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(candy),
      });

      if (response.ok) {
        fetchCandies();
        nameInput.value = "";
        flavorInput.value = "";
        priceInput.value = "";
      } else {
        console.error("Failed to create candy:", response.statusText);
      }
    } catch (error) {
      console.error("Error creating candy:", error);
    }
  });

  
  fetchCandies();
});
