const productForm = document.getElementById("productForm");
const productRows = document.getElementById("productRows");
const productURL = "http://localhost:8080/api/products";

productForm.addEventListener("submit", async function(event) {
  event.preventDefault();

  const form = event.target;
  const formData = new FormData(form);
  const product = {
    image: formData.get('productImage'),
    name: formData.get('productName'),
    description: formData.get('productDescription'),
    price: formData.get('productPrice'),
    category: formData.get('productCategory')
  };


  try {
    const response = await fetch(productURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(product)
    });

    if (response.ok) {
      console.log("Product added successfully");
      getProduct(); // Fetch the updated list of products after adding a new product
    } else {
      throw new Error("Unable to add product: " + response.status);
    }
  } catch (error) {
    console.error("Error: " + error);
  }

  productForm.reset();
});

const getProduct = async () => {
  try {
    const response = await fetch(productURL);
    if (response.ok) {
      const data = await response.json();
      console.log(data);
      displayProducts(data); // Pass the retrieved products to the displayProducts function
    } else {
      throw new Error("Unable to get products");
    }
  } catch (error) {
    console.log("Error: " + error);
  }
};

const displayProducts = function(products) {
  productRows.innerHTML = "";
  products.forEach(product => {
    let row = document.createElement("tr");
    row.setAttribute("data-id", product.id);
    row.innerHTML = `
      <td><img src="${product.image}" alt="Product Image"></td>
      <td>${product.name}</td>
      <td>${product.description}</td>
      <td>${product.price}</td>
      <td>${product.category}</td>
    `;
    productRows.append(row);
  });
};

getProduct(); 
