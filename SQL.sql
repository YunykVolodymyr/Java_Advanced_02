DROP DATABASE databaseforjdbc;

CREATE DATABASE databaseforjdbc
CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;

USE databaseforjdbc;

CREATE TABLE commodity (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  price_for_one float NOT NULL,
  quantity int NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(25) NOT NULL,
  last_name varchar(25) NOT NULL,
  amount_of_money float NOT NULL,
  PRIMARY KEY (id)
);
