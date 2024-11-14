-- src/main/resources/db/migration/V001__create_schema.sql

CREATE TABLE IF NOT EXISTS brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand_id BIGINT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_brand_product FOREIGN KEY (brand_id) REFERENCES brand(id)
);

CREATE TABLE IF NOT EXISTS price (
    brand_id BIGINT NOT NULL,
    price_list INT NOT NULL,
    product_id BIGINT NOT NULL,
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_date TIMESTAMP,
    priority INT DEFAULT 0,
    price DECIMAL(19, 2) NOT NULL,
    currency VARCHAR(255) DEFAULT 'EUR',
    PRIMARY KEY (brand_id, price_list, product_id),
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id)
);