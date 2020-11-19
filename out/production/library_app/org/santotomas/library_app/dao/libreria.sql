
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
('Magia'),
('Suspenso'),
('Terror'),
('Fantasia'),
('Romance');


CREATE TABLE book (
    isbn VARCHAR(36) NOT NULL,
    title VARCHAR(180) NOT NULL,
    description TEXT  NULL,
    precio INT NOT NULL,
    category_id_fk INT NULL,
    author VARCHAR(200) NULL,
    estate ENUM('agotado', 'disponible'),
    stock INT NOT NULL DEFAULT 0,
    release_date DATE,

    PRIMARY KEY(isbn),
    FOREIGN KEY(category_id_fk) REFERENCES category(id)
);

INSERT INTO book VALUES 
(UUID(), 'Harry Potter', 'Un mago muy mago', 20000, 4, 'J. K. Rowling', 'disponible', 30, '1997-03-04');

