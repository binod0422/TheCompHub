const accessoryFormForm = document.getElementById("accessoryForm");
const accessoryRows = document.getElementById("accessoryRows");
const accessoryURL = "http://localhost:8080/api/accessory"; 

accessoryForm.addEventListener("submit", async function(event) {
  event.preventDefault();

  const form = event.target;
  const formData = new FormData(form);
  const accessory = {
    image: formData.get('accessoryImage'),
    name: formData.get('accessoryName'),
    description: formData.get('accessoryDescription'),
    price: formData.get('accessoryPrice'),
    category: formData.get('accessoryCategory')
  };


  try {
    const response = await fetch(accessoryURL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(accessory)
    });

    if (response.ok) {
      console.log("Accessory added successfully");
      getAccessory(); // Fetch the updated list of products after adding a new product
    } else {
      throw new Error("Unable to add accessory: " + response.status);
    }
  } catch (error) {
    console.error("Error: " + error);
  }

  productForm.reset();
});

const getAccessory = async () => {
  try {
    const response = await fetch(accessoryURL);
    if (response.ok) {
      const data = await response.json();
      console.log(data);
      displayAccessory(data); // Pass the retrieved accessory to the displayAccessory function
    } else {
      throw new Error("Unable to get accessory");
    }
  } catch (error) {
    console.log("Error: " + error);
  }
};

const displayAccessory = function(accessory) {
  accessoryRows.innerHTML = "";
  accessory.forEach(accessory => {
    let row = document.createElement("tr");
    row.setAttribute("data-id", accessory.id);
    row.innerHTML = `
      <td><img src="${accessory.image}" alt="Accessory Image"></td>
      <td>${accessory.name}</td>
      <td>${accessory.description}</td>
      <td>${accessory.price}</td>
      <td>${accessory.category}</td>
    `;
    accessoryRows.append(row);
  });
};

getAccessory(); 
