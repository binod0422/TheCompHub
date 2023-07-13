const products = [
    {
        name: 'Microsoft - Surface Laptop Go 2',
        image: './images/MS Surface Pro 2.jpg',
        description: '12.4" Touch-Screen - Intel Core i5 - 8GB Memory - 128GB SSD - Sandstone',
        price: 384.99
    },
    {
        name: 'Samsung - Galaxy Book Go',
        image: './images/Samsung Galaxy Book Go.jpg',
        description: '14.0" LED Screen - Qualcomm Snapdragon 7C Gen 2 Processor - 4GB Memory - 128GB eMMC - Silver',
        price: 131.99
    },
    {
        name: 'ASUS Vivobook',
        image: './images/ASUS VivoBook.jpg',
        description: '16" - AMD Ryzen 7 5800HS - 12GB Memory - 512GB SSD - Quiet Blue',
        price: 529.99
    },
    {
        name: 'Lenovo - IdeaPad Flex 5 2-in-1',
        image: './images/Lenovo Ideapad.jpg',
        description: '15.6" - Intel Core i5 - 8GB Memory - 256 GB SSD - Graphite Grey',
        price: 449.99
    },
    {
        name: 'Apple - MacBook Pro',
        image: './images/Macbook Pro.jpg',
        description: '14" - M2 Pro chip - 16GB Memory - 215GB SSD - Space Grey',
        price: 1999.00
    },
    {
        name: 'Microsoft - Surface Pro 9',
        image: './images/Surface Pro 9.jpg',
        description: '13" Touch Screen - Intel Evo Platform Core i5 - 8GB Memory - 256GB SSD - Graphite',
        price: 999.99
    },
   
];


function generateProductCards() {
    const productsContainer = document.getElementById('products');

    products.forEach((product) => {
        const card = document.createElement('div');
        card.className = 'col-12 col-md-6 col-lg-4 col-xl-3 pb-3';

        const cardContent = `
            <div class='card m-3' style="height: 40rem; width: 20rem">
                <img src='${product.image}' class='card-img-top p-5' alt='card-img-top'>
                <div class='card-body px-4 d-flex flex-column justify-content-between'>
                    <div>
                        <h5 class='card-title'>${product.name}</h5>
                        <p class='card-text'>${product.description}</p>
                    </div>
                    <div class="d-flex mt-1 justify-content-between">
                        <p class='card-text fs-5 fw-bold'>$${product.price}</p>
                        <input type="number" class="ps-3" value="1" min="1" max="10">
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type='button' class='btn btn-yellow  mt-1' id="btn">Add to cart</button>
                        <button type='button' class='btn btn-green btn-outline btn-outline-primary mt-1' id="btn-2">Buy Now</button>
                        
                    </div>
                </div>
            </div>
        `;

        card.innerHTML = cardContent;
        productsContainer.appendChild(card);

        const addToCartButton = card.querySelector('.btn-yellow');
        addToCartButton.addEventListener('click', () => {
            addToCartButton.innerHTML = `<p>Added to cart</p>`;
            // Add your logic here to add the product to the cart
        });

        const buyNowButton = card.querySelector('.btn-green');
        buyNowButton.addEventListener('click', () => {
            buyNowButton.innerHTML = 'Thank you';
        });
    });
}

generateProductCards();
