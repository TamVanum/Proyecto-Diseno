DROP DATABASE library;
CREATE DATABASE library;
USE library;

-- Usuarios
CREATE TABLE user (
    uuid VARCHAR(36) NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    password VARCHAR(128) NOT NULL,
    permission ENUM('Client', 'Admin'),

    PRIMARY KEY(uuid)
);

INSERT INTO user
VALUES (UUID(), 'ElWazy', SHA2('1324', 512), 'Admin'),
(UUID(), 'admin', SHA2('admin', 512), 'Admin'),
(UUID(), 'Manuel', SHA2('manuel', 512), 'Client');

-- Libros
CREATE TABLE category(
    id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(60),

    PRIMARY KEY(id)
);

CREATE TABLE book (
    id int AUTO_INCREMENT,
    isbn VARCHAR(15) NOT NULL,
    title VARCHAR(180) NOT NULL,
    description TEXT NOT NULL,
    price INT NOT NULL,
    author VARCHAR(200) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    release_date DATE,

    PRIMARY KEY(id)

);

CREATE TABLE category_book(
    id int AUTO_INCREMENT,
    category_id_fk int,
    book_id_fk int,

    PRIMARY KEY(id),
    FOREIGN KEY(category_id_fk) REFERENCES category(id),
    FOREIGN KEY(book_id_fk) REFERENCES book(id)

);

INSERT INTO category (name) VALUES
('Magia'),
('Suspenso'),
('Terror'),
('Fantasia'),
('Romance');

INSERT INTO book (title, isbn, description, price, author, stock, release_date) VALUES
('Harry Potter',               '956-125-234-x', 'Un mago muy mago',       20000, 'J. K. Rowling',  30,  CURRENT_DATE()),
('Harry el sucio',             '956-15-2734-x', 'Un mago muy sucio',      2000,  'Samuel Murillo', 5,   CURRENT_DATE()),
('Farenheigth',                '956-1-22334-x', 'jaja salu2 compa tomás', 40000, 'Ray Bradbury',   50,  CURRENT_DATE()),
('Papelucho y el marciano',    '956-12-2335-x', 'Lo leí a los 5 años',    5000,  'Marcela Paz',    100, CURRENT_DATE()),
('Papelucho y el historiador', '956-12-2334-x', 'Lo leí a los 18 años',   5000,  'Marcela Paz',    100, CURRENT_DATE());

INSERT INTO category_book (category_id_fk, book_id_fk) VALUES
( 1 , 1 ), ( 4 , 1 ), ( 5 , 1 ), ( 3 , 2 ), ( 4 , 3 ), ( 4 , 4 ), ( 4 , 5 );