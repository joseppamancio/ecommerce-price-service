-- src/main/resources/db/migration/V001__create_schema.sql
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand_id BIGINT NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS price (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT NOT NULL,
    start_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT NOT NULL,
    product_id BIGINT,
    priority INT DEFAULT 0,
    price DECIMAL(19, 2) NOT NULL,
    currency VARCHAR(255) DEFAULT 'EUR',
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product(id)
);