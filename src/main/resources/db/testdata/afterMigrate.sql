-- src/main/resources/db/testdata/afterMigrate.sql

DELETE FROM price;
DELETE FROM product;
DELETE FROM brand;

INSERT INTO brand (id, name) VALUES
(1, 'ZARA'),
(2, 'MANGO'),
(3, 'H&M'),
(4, 'UNIQLO');


INSERT INTO product (id, name, brand_id, creation_date) VALUES
(35455, 'Product A', 1, '2020-06-14T00:00:00'),
(35456, 'Product B', 1, '2020-06-15T10:00:00'),
(35457, 'Product C', 2, '2020-06-16T12:30:00'),
(35458, 'Product D', 3, '2020-06-17T14:00:00'),
(35459, 'Product E', 4, '2020-06-18T09:00:00'),
(35460, 'Product F', 2, '2020-06-19T11:45:00'),
(35461, 'Product G', 3, '2020-06-20T16:15:00'),
(35462, 'Product H', 4, '2020-06-21T08:30:00');



INSERT INTO price (brand_id, start_date, end_date, price_list, product_id, priority, price, currency) VALUES
-- ZARA (brand_id = 1)
(1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(1, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(1, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(1, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR'),

-- MANGO (brand_id = 2)
(2, '2020-06-01T00:00:00', '2020-06-30T23:59:59', 1, 35457, 0, 45.00, 'EUR'),
(2, '2020-07-01T00:00:00', '2020-07-31T23:59:59', 2, 35457, 1, 40.00, 'EUR'),
(2, '2020-08-01T00:00:00', '2020-12-31T23:59:59', 3, 35460, 1, 50.00, 'EUR'),

-- H&M (brand_id = 3)
(3, '2020-06-10T00:00:00', '2020-12-31T23:59:59', 1, 35458, 0, 55.00, 'EUR'),
(3, '2020-07-01T00:00:00', '2020-07-31T23:59:59', 2, 35461, 1, 52.00, 'EUR'),

-- UNIQLO (brand_id = 4)
(4, '2020-06-20T00:00:00', '2020-12-31T23:59:59', 1, 35459, 0, 60.00, 'EUR'),
(4, '2020-07-01T00:00:00', '2020-12-31T23:59:59', 2, 35462, 1, 58.00, 'EUR');
