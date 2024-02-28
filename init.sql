CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity INTEGER NOT NULL,
    inventory_status VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    rating INTEGER
);


INSERT INTO products (code, name, description, price, quantity, inventory_status, category, image, rating)
VALUES
    ('ABC123', 'Product 1', 'Description 1', 19.99, 50, 'In Stock', 'Electronics', 'image1.jpg', 4),
    ('DEF456', 'Product 2', 'Description 2', 29.99, 30, 'Out of Stock', 'Clothing', 'image2.jpg', 3),
    ('GHI789', 'Product 3', 'Description 3', 9.99, 75, 'In Stock', 'Home Goods', 'image3.jpg', 5),
    ('JKL012', 'Product 4', 'Description 4', 49.99, 20, 'Low Stock', 'Electronics', 'image4.jpg', 2);
