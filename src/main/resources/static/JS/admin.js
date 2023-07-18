const productForm = document.getElementById("productForm");
const productRows = document.getElementById("productRows");

//const productURL = "http://localhost:8080/api/products";
//const bestSellersURL = "http://localhost:8080/api/bestSellers";
//const newArrivalsURL = "http://localhost:8080/api/newarrivals/add";
//const accessoryURL = "http://localhost:8080/api/accessory";
const productURL = "api/products";
const bestSellersURL = "api/bestSellers";
const newArrivalsURL = "api/new-arrivals/add";
const accessoryURL = "api/accessory";


productForm.addEventListener("submit", async function (event) {
  event.preventDefault();

  const form = event.target;
  const formData = new FormData(form);
  const product = {
    image: formData.get("productImage"),
    name: formData.get("productName"),
    description: formData.get("productDescription"),
    price: formData.get("productPrice"),
    category: formData.get("productCategory"),
  };

  console.log(product);
  console.log(product.category);

  try {
    let url;
    if (product.category === "Products") {
      url = productURL;
    } else if (product.category === "Bestsellers") {
      url = bestSellersURL;
    } else if (product.category === "Newarrivals") {
      url = newArrivalsURL;
    }
    else if (product.category === "accessory"){
    url = accessoryURL;
    }
    else {
      throw new Error("Invalid product category");
    }

    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    });

    if (response.ok) {
      console.log("Product added successfully");
    } else {
      throw new Error("Unable to add product: " + response.status);
    }
  } catch (error) {
    console.error("Error: " + error);
  }
  productForm.reset();
});