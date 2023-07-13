class ProductController {
    constructor() {
      this.currentID = 0;
      this.productArray = [];
    }
  
    addProduct(image, name, description, price, category) {
      const productObj = {
        image: image,
        name: name,
        description: description,
        price: price,
        category: category,
        id: this.currentID++
      };
      this.productArray.push(productObj);
    }
  
    setLocalStorage() {
      localStorage.setItem("product", JSON.stringify(this.productArray));
      localStorage.setItem("current-id", JSON.stringify(this.currentID));
    }
  
    getLocalStorage() {
      this.productArray = JSON.parse(localStorage.getItem("product")) || [];
      this.currentID = JSON.parse(localStorage.getItem("current-id")) || 0;
      return this.productArray;
    }
  }
  