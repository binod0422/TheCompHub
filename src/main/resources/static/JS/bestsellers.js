const additionalOptions = document.getElementById('moreProducts');
const bestSellersURL = "http://localhost:8080/api/bestSellers";
const productURL = "http://localhost:8080/api/products";
//const productURL = "api/products";
//const bestSellersURL = "api/bestSellersURL";



const getBestSellers = async () => {
    try {
        const response = await fetch(bestSellersURL);
        if (response.ok) {
            const data = await response.json();
            console.log(data);
            generateBestSellers(data); // Pass the retrieved data to the generateBestSellers function
        } else {
            throw new Error("Unable to retrieve the data");
        }
    } catch (error) {
        console.log("Error: " + error);
    }
};

// Function to generate product cards for best sellers
function generateBestSellers(bestSellers) {
    // Get reference to the container element for best sellers
    const bestSellersContainer = document.getElementById("bestSellers");

    // Clear the container before adding new cards
    bestSellersContainer.innerHTML = "";

    // Loop through each product in bestSellers array and create a card
    bestSellers.forEach((product) => {
        const card = createProductCard(product);
        // Append the card to the best sellers container
        bestSellersContainer.appendChild(card);
    });
}

// Function to create a product card
function createProductCard(product) {
    const card = document.createElement("div");
    card.classList.add("col-12", "col-md-6", "col-lg-4", "col-xl-3", "pb-3");

    // Define the card's content using template literals
    const cardContent = `
        <div class='card'>
            <img src='${product.image}' class='card-img-top' alt='card-img-top'>
            <div class='card-body d-flex flex-column justify-content-between'>
                <div>
                    <h5 class='card-title'>${product.name}</h5>
                    <p class='card-text'>${product.description}</p>
                </div>
                <div class="d-flex mt-1 justify-content-between">
                    <p class='card-text fs-5 fw-bold'>$ ${product.price}</p>
                    <input type="number" class="ps-3" value="1" min="1" max="10">
                </div>
                <div class="d-flex justify-content-between">
                    <button type='button' class='btn btn-yellow mt-1'>Add to cart</button>
                    <button type='button' class='btn btn-green mt-1'>Buy Now</button>
                </div>
            </div>
        </div>
    `;

    // Set the card's HTML content
    card.innerHTML = cardContent;

    return card; // Return the created card
}

// Call the getBestSellers function to fetch best sellers data and generate the product cards
getBestSellers();


async function generateProductCards() {
  try {
    const response = await fetch(productURL);
    if (response.ok) {
      const productArr = await response.json();
      console.log(productArr);
      productArr.forEach((product) => {
          const card = document.createElement('div');
          card.classList.add('col-12', 'col-md-6', 'col-lg-4', 'col-xl-3', 'pb-3');

          // Define the card's content using template literals
          const cardContent = `
            <div class='card'>
                <img src='${product.image}' class='card-img-top' alt='card-img-top'>
                <div class='card-body d-flex flex-column justify-content-between'>
                    <div>
                        <h5 class='card-title fw-bold'>${product.name}</h5>
                        <p class='card-text'>${product.description}</p>
                    </div>
                    <div class="d-flex mt-1 justify-content-between">
                        <p class='card-text fs-5 fw-bold'>$ ${product.price}</p>
                        <input type="number" class="ps-3" value="1" min="1" max="10">
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type='button' class='btn addcart btn-yellow mt-1'>Add to cart</button>
                        <button type='button' class='btn btn-green mt-1'>Buy now</button>
                    </div>
                </div>
            </div>
          `;

          // Set the card's HTML content
          card.innerHTML = cardContent;
          // Append the card to the products container
          additionalOptions.append(card);
      });
    } else {
      throw new Error("Unable to get products");
    }
  } catch (error) {
    console.log("Error: " + error);
  }
}

generateProductCards();
