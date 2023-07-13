const productsContainer = document.getElementById('accessory');
const productURL = "http://localhost:8080/api/accessory";


async function generateProductCards() {
  try {
    const response = await fetch(accessoryURL);
    if (response.ok) {
      const accessoryArr = await response.json();
      console.log(accessoryArr);

      accessoryArr.forEach((accessory) => {
        if (accessory.category === "Accessory") {
          const card = document.createElement('div');
          card.classList.add('col-12', 'col-md-6', 'col-lg-4', 'col-xl-3', 'pb-3');

          // Define the card's content using template literals
          const cardContent = `
            <div class='card'>
                <img src='${accessory.image}' class='card-img-top' alt='card-img-top'>
                <div class='card-body d-flex flex-column justify-content-between'>
                    <div>
                        <h5 class='card-title fw-bold'>${accessory.name}</h5>
                        <p class='card-text'>${accessory.description}</p>
                    </div>
                    <div class="d-flex mt-1 justify-content-between">
                        <p class='card-text fs-5 fw-bold'>$ ${accessory.price}</p>
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
          accessoryContainer.append(card);
        }

      });
    } else {
      throw new Error("Unable to get accessory");
    }
  } catch (error) {
    console.log("Error: " + error);
  }
}

generateAccessoryCards();


