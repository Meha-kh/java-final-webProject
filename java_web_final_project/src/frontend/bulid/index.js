async function fetchCandies() {
  try {
    const response = await fetch("http:/localhost:8080/api/candies"); 
    if (!response.ok) {
      throw new Error("Failed to fetch candies");
    }
    const candies = await response.json();

    const candyContainer = document.getElementById("candyContainer");
    candyContainer.innerHTML = "";

    for (const candy of candies) {
      const candyElement = document.createElement("div");
      candyElement.innerHTML = `
        <h3>${candy.name}</h3>
        <p>Flavor: ${candy.flavor}</p>
        <p>Price: ${candy.price}</p>
      `;

      candyContainer.appendChild(candyElement);
    }
  } catch (error) {
    console.error("Error fetching candies:", error);
  }
}

async function addCandy(event) {
  event.preventDefault();

  const nameInput = document.getElementById("nameInput");
  const flavorInput = document.getElementById("flavorInput");
  const priceInput = document.getElementById("priceInput");

  const name = nameInput.value.trim(); 
  const flavor = flavorInput.value.trim();
  const price = parseFloat(priceInput.value);

  if (!name || !flavor || isNaN(price)) {
    console.error("Invalid candy data");
    return;
  }

  const candy = {
    name,
    flavor,
    price,
  };

  try {
    const response = await fetch("/api/candies", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(candy),
    });

    if (!response.ok) {
      throw new Error("Failed to add candy");
    }

    nameInput.value = "";
    flavorInput.value = "";
    priceInput.value = "";

    await fetchCandies();
  } catch (error) {
    console.error("Error adding candy:", error);
  }
}

const candyForm = document.getElementById("candyForm");
candyForm.addEventListener("submit", addCandy);

fetchCandies();
