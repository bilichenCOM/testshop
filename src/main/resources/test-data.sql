--some insertions scripts for testing
INSERT INTO categories (id, name, description) VALUES (1, 'Category1', 'a interesting category with items of high quality');
INSERT INTO categories (id, name, description) VALUES (2, 'Category2', 'value for money');
INSERT INTO categories (id, name, description) VALUES (3, 'Category3', 'do buy this products. it worth...');

INSERT INTO products (id, name, description, image_url, price, category_id)
VALUES (1, 'Product1', 'do by this thing', '/resources/images/product.png', 100.0, 1);
INSERT INTO products (id, name, description, image_url, price, category_id)
VALUES (2, 'Product2', 'very good product', '/resources/images/product.png', 150.0, 2);
INSERT INTO products (id, name, description, image_url, price, category_id)
VALUES (3, 'Product3', 'best quality in all eastern part of zhmerynka', '/resources/images/product.png', 160.0, 3);

INSERT INTO roles (id, name) VALUES (1, 'USER');
INSERT INTO roles (id, name) VALUES (2, 'ADMIN');