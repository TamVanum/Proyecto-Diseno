
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

INSERT INTO category (name) VALUES 
('Niños'),
('Jovenes'),
('Jovenes Adultos'),
('Aultos'),
('Adultos +18');


CREATE TABLE book (
    isbn VARCHAR(36) NOT NULL,
    title VARCHAR(180) NOT NULL,
    description TEXT  NULL,
    price INT NOT NULL,
    category_id_fk INT NULL,
    author VARCHAR(200) NULL,
    stock INT NOT NULL DEFAULT 0,
    release_date DATE,

    PRIMARY KEY(isbn),
    FOREIGN KEY(category_id_fk) REFERENCES category(id)
);

INSERT INTO book VALUES 
('956-125-234-x', 'Harry Potter', 'Un mago muy mago', 20000, 4, 'J. K. Rowling', 30, CURRENT_DATE()),
('956-15-2734-x', 'Harry el sucio', 'Un mago muy sucio', 2000, 4, 'Samuel Murillo', 5, CURRENT_DATE()),
('956-1-22334-x', 'Farenheigth', 'jaja salu2 compa tomás', 40000, 4, 'Ray Bradbury', 50, CURRENT_DATE()),
('956-12-2335-x', 'Papelucho y el marciano', 'Lo leí a los 5 años', 5000, 4, 'Marcela Paz', 100, CURRENT_DATE()),
('956-12-2334-x', 'Papelucho y el historiador', 'Lo leí a los 18 años', 5000, 4, 'Marcela Paz', 100, CURRENT_DATE());

