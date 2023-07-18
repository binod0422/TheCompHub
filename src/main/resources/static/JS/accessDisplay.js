//const accessoryContainer = document.getElementById('accessory');
////const accessoryURL = "http://localhost:8080/api/accessory";
//const accessoryURL = "/api/accessory"
//
//async function generateAccessoryCards() {
//  try {
//    const response = await fetch(accessoryURL);
//
//    if (!response.ok) {
//      throw new Error(`Unable to get accessory. Status: ${response.status}`);
//    }
//
//    const accessoryArr = await response.json();
//    console.log(accessoryArr);
//
//    accessoryArr.forEach((accessory) => {
//      const card = createAccessoryCard(accessory);
//      accessoryContainer.appendChild(card);
//    });
//  } catch (error) {
//    console.error("Error:", error);
//  }
//}
//
//function createAccessoryCard(accessory) {
//  const card = document.createElement('div');
//  card.classList.add('col-12', 'col-md-6', 'col-lg-4', 'col-xl-3', 'pb-3');
//
//  const image = document.createElement('img');
//  image.src = accessory.image;
//  image.classList.add('card-img-top');
//  image.alt = 'Card Image Top';
//
//  const cardBody = document.createElement('div');
//  cardBody.classList.add('card-body', 'd-flex', 'flex-column', 'justify-content-between');
//
//  const title = document.createElement('h5');
//  title.classList.add('card-title', 'fw-bold');
//  title.textContent = accessory.name;
//
//  const description = document.createElement('p');
//  description.classList.add('card-text');
//  description.textContent = accessory.description;
//
//  const price = document.createElement('p');
//  price.classList.add('card-text', 'fs-5', 'fw-bold');
//  price.textContent = accessory.price;
//
//  const quantityInput = document.createElement('input');
//  quantityInput.type = 'number';
//  quantityInput.classList.add('ps-3');
//  quantityInput.value = '1';
//  quantityInput.min = '1';
//  quantityInput.max = '10';
//
//  const addToCartButton = document.createElement('button');
//  addToCartButton.type = 'button';
//  addToCartButton.classList.add('btn', 'addcart', 'btn-yellow', 'mt-1');
//  addToCartButton.textContent = 'Add to cart';
//
//  const buyNowButton = document.createElement('button');
//  buyNowButton.type = 'button';
//  buyNowButton.classList.add('btn', 'btn-green', 'mt-1');
//  buyNowButton.textContent = 'Buy now';
//
//  const quantityAndButtonsDiv = document.createElement('div');
//  quantityAndButtonsDiv.classList.add('d-flex', 'justify-content-between');
//  quantityAndButtonsDiv.append(quantityInput, addToCartButton, buyNowButton);
//
//  cardBody.append(title, description, price, quantityAndButtonsDiv);
//  card.append(image, cardBody);
//
//  return card;
//}
//
//generateAccessoryCards();

const productsContainer = document.getElementById('accessory');
//const productURL = "http://localhost:8080/api/accessory";
const productURL = "/api/accessory";

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
                <img src=${product.image} class='card-img-top' alt='card-img-top'>
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
          productsContainer.append(card);
      });
    } else {
      throw new Error("Unable to get products");
    }
  } catch (error) {
    console.log("Error: " + error);
  }
}

generateProductCards();

