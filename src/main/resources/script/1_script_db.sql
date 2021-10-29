DROP DATABASE IF EXISTS WebMarket;
CREATE DATABASE IF NOT EXISTS WebMarket;
USE WebMarket;

-- Create table--------------------------------------------
CREATE TABLE IF NOT EXISTS role
(
    id   BIGINT(20) AUTO_INCREMENT                 NOT NULL,
    name ENUM ('Admin','User','Moderator','Owner') NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(30)           NOT NULL,
    last_name  VARCHAR(30)           NOT NULL,
    gender     VARCHAR(6)            NOT NULL,
    email      VARCHAR(20)           NOT NULL,
    password   VARCHAR(30)           NOT NULL,
    role_id    BIGINT(20),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS product
(
    id              BIGINT(20) AUTO_INCREMENT NOT NULL,
    name            VARCHAR(20)               NOT NULL,
    price           FLOAT                     NOT NULL,
    manufacturer_id BIGINT(20),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS manufacturer
(
    id   BIGINT(20) AUTO_INCREMENT NOT NULL,
    name VARCHAR(20)               NOT NULL,
    PRIMARY KEY (id)
);

# CREATE TABLE IF NOT EXISTS manufacturer_product
# (
#     manufacturer_id BIGINT NOT NULL,
#     product_id      BIGINT NOT NULL,
#     PRIMARY KEY (manufacturer_id, product_id)
# );

# CREATE TABLE IF NOT EXISTS role_user
# (
#     role_id BIGINT NOT NULL,
#     user_id BIGINT NOT NULL,
#     PRIMARY KEY (role_id, user_id)
# );

-- Insert data: ---------------------------------------------------------------
INSERT INTO role (id, name)
VALUES (1, 'Admin'),
       (2, 'User');

INSERT INTO user (id, name, last_name, gender, email, password, role_id)
VALUES (1, 'Tom', 'TomCat', 'Male', 'tom@cat', 'password1', 1),
       (2, 'Jerry', 'JerryMouse', 'Female', 'jerry@mouse', 'password2', 2);

# INSERT INTO role_user(role_id, user_id)
# VALUES (1, 1),
#        (2, 2);

INSERT INTO product (id, name, price, manufacturer_id)
VALUES (1, 'Iphone', 800, 1),
       (2, 'TV-52', 1200, 2),
       (3, 'Mac', 1900, 3),
       (4, 'Microwave', 300, 1);

INSERT INTO manufacturer (id, name)
VALUES (1, 'Apple'),
       (2, 'Samsung'),
       (3, 'LG');

# INSERT INTO manufacturer_product(manufacturer_id, product_id)
# VALUES (1, 1),
#        (2, 2),
#        (3, 3),
#        (1, 4);

# INSERT INTO manufacturer_product (manufacturer_id, product_id)
# VALUES (1, 1),(2,2),(3,3),(4,1);
