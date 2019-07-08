-- create table for products
CREATE TABLE products (
    id          BIGINT AUTO_INCREMENT,
    name        VARCHAR(255),
    description VARCHAR (255),
    price       NUMERIC,
    imageUrl    varchar(255),

    PRIMARY KEY (id)
);

-- create table for categories
CREATE TABLE categories (
    id          BIGINT AUTO_INCREMENT,
    name        VARCHAR(255),
    description varchar(1000),

    PRIMARY KEY (id)
);

-- create join table
CREATE TABLE categories_products (
    id BIGINT AUTO_INCREMENT,
    fk_category BIGINT,
    fk_product BIGINT,

    PRIMARY KEY (id),
    FOREIGN KEY (fk_category) REFERENCES categories,
    FOREIGN KEY (fk_product) REFERENCES products
);