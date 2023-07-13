const products = [
    {
        name: 'Macbook Pro Charger',
        image: 'https://m.media-amazon.com/images/I/51ldiGHC0JL._AC_SX679_.jpg',
        description: 'MacBook Pro Charger for MacBook Air Charger 96W USB C Laptop Charger for MacBook Pro USB C Charger, Ipad Charger Included Type C Cable',
        price: 39.99
    },
    {
        name: 'Dell Laptop Charger',
        image: 'https://m.media-amazon.com/images/I/61Aiy6YOkOL._AC_SX679_.jpg',
        description: 'Dell USB-C 65 W AC Adapter with 1 meter Power Cord',
        price: 47.99
    },
    {
        name: 'Tech MousePad',
        image: 'https://m.media-amazon.com/images/I/71diPhCgzcL._AC_SX679_.jpg',
        description: 'Nicokee Gaming Mouse Pad Circuit Board Electronic Computer Hardware Technology Motherboard Digital Chip Tech Science Integrated Non-Slip Rubber Mouse Pad ',
        price: 8.99

    },
    {
        name: 'Wireless Mouse',
        image: 'https://media.officedepot.com/images/f_auto,q_auto,e_sharpen,h_450/products/604723/604723_o01_021323/604723',
        description: 'Logitech® M325 Wireless Mouse, Blue',
        price: 14.99   
    },
    {
        name: 'Lenova Laptop Charger',
        image: 'https://m.media-amazon.com/images/I/51GUA9KKIPL._AC_SX679_.jpg',
        description: 'Lenovo 65W Computer Charger - Round Tip AC Wall Adapter (GX20L29355),black',
        price: 22.00     
    },
    {
        name: 'USB Computer Speakers',
        image: 'https://m.media-amazon.com/images/I/71GPSjiqUDL._AC_SX679_.jpg',
        description: 'USB Computer Speakers, Wired Computer Soundbar Powered by USB',
        price: 14.99
    },
    {
        name: 'Webcam',
        image: 'https://m.media-amazon.com/images/I/61ju3NY5ksS._AC_SX679_.jpg',
        description: 'Webcam with Microphone, 110-Degree View Angle',
        price: 15.99
    },
    {
        name: 'Headphones w/Microphone',
        image: 'https://m.media-amazon.com/images/I/616Q22O4lEL._AC_SX679_.jpg',
        description: 'Kensington Hi-Fi Headphones with Microphone (K97603WW), Black, Universal',
        price: 19.99
    },
    {
        name: 'Wireless Keyboard',
        image: 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/9613/9613864_sd.jpg;maxHeight=400;maxWidth=600',
        description: 'Logitech - K350 Ergonomic Full-size Membrane Wireless Keyboard - Black',
        price: 38.99
    },
    {
        name: 'Apple Keyboard',
        image: 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MQ052?wid=4000&hei=1800&fmt=jpeg&qlt=95&.v=1495129815011',
        description: 'Apple - Magic Keyboard with Numeric Keypad - Silver',
        price: 129.99 
    },
    {
        name: 'Apple Mouse',
        image: 'https://m.media-amazon.com/images/I/61BZ5N9n4IL._AC_SX679_.jpg',
        description: 'Apple - Magic Mouse - White',
        price: 79.99 
    },
    {
        name: 'Monitor Cable',
        image: 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6473/6473494ld.jpg;maxHeight=400;maxWidth=600',
        description: 'Insignia™ - 6inch VGA Monitor Cable - Black',
        price: 14.99 
    },
]

function generateProductCards() {
    const productsContainer = document.getElementById('products');

    products.forEach((product) => {
        const card = document.createElement('div');
        card.className = 'col-12 col-md-6 col-lg-4 col-xl-3 pb-3';

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
                        <input type="number" class="ps-3" value="0" min="1" max="10">
                    </div>
                    <div class="d-flex justify-content-between">
                        <button type='button' class='btn btn-green mt-1'>Buy Now</button>
                        <button type='button' class='btn btn-yellow mt-1'>Add to cart</button>
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
