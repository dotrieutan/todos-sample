--liquibase formatted sql

 --changeset dotrieutan:0001
 CREATE TABLE IF NOT EXISTS customer (
     id INT AUTO_INCREMENT PRIMARY KEY,
     full_name VARCHAR(255) NOT NULL,
     address VARCHAR(255),
     phone VARCHAR(10)
 );

 CREATE TABLE IF NOT EXISTS to_do_item (
     id INT AUTO_INCREMENT PRIMARY KEY,
     customer_id INT NOT NULL,
     description VARCHAR(255),
     status VARCHAR(10),
     created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     FOREIGN KEY (customer_id) REFERENCES customer(id)
 );
