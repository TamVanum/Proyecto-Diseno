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
('Adultos'),
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
('956-125-234-x', 'Harry Potter', 'Un mago muy mago', 25000, 3, 'J. K. Rowling', 30, CURRENT_DATE()),
('956-15-2734-x', 'Harry el sucio', 'Un mago muy sucio uwu', 2000, 5, 'Samuel Murillo', 7, CURRENT_DATE()),
('956-1-22334-x', 'Farenheigth', 'jaja salu2 compa tomás', 30000, 4, 'Ray Bradbury', 50, CURRENT_DATE()),
('956-12-2335-x', 'Papelucho y el marciano', 'Lo leí a los 5 años', 12000, 1, 'Marcela Paz', 100, CURRENT_DATE()),
('956-12-2334-x', 'Papelucho y el historiador', 'Lo leí a los 18 años', 12000, 1, 'Marcela Paz', 100, CURRENT_DATE()),
('956-841-685-8', 'El Castillo Andante', 'En el país de Ingary, donde existen cosas como las botas de siete leguas o las capas de invisibilidad, que una bruja te maldiga no es algo inusual. Cuando la Bruja del Páramo convierte a Sophie Hatter en una anciana, la joven abandona la sombrerería familiar para pedir ayuda en el único lugar mágico que se le ocurre: el castillo ambulante que atemoriza a los habitantes de Market Chipping.',20000, 3, 'Diana Wynne Jones', 70, CURRENT_DATE()),
('956-95-6258-3', 'Cincuenta Sombras De Grey (Libro 1)', 'La romántica, sensual, erótica y totalmente adictiva historia de la apasionada relación entre una estudiante universitaria y un joven multimillonario. Cuando la estudiante de Literatura Anastasia Steele recibe el encargo de entrevistar al exitoso y joven empresario Christian Grey, queda impresionada al encontrarse ante un hombre atractivo, seductor y también muy intimidante. ',10000, 5, 'E. L. James', 110, CURRENT_DATE()),
('956-841-743-x', 'Tao te Ching', 'Pese a su aparente sencillez, el Tao Te Ching de Lao-Tse es uno de los libros más completos y exigentes que se han escrito. Es, además, la base del taoísmo, lo que lo convierte en uno de los textos de referencia de la historia del pensamiento mundial, que primero impregnó todo el pensamiento oriental y luego ha penetrado poco a poco en el occidental. Los conceptos de tao, te o wuwei son, pues, universales. Dejarse llevar por la sabiduría y la capacidad de sugerencia de estos aforismos es la mejor manera de reflexionar (con serenidad) acerca de nosotros y de nuestro lugar en el mundo.', 20000, 4, 'Marcela Paz', 45, CURRENT_DATE()),
('956-95-8426-x', 'Fortaleza Digital', 'Cuando el sofisticado superordenador de la NSA —la agencia de Inteligencia más poderosa del mundo— intercepta un código que es incapaz de descifrar, ésta debe recurrir a su mejor criptógrafa, Susan Fletcher. Fletcher descubrirá algo que hará tambalear las más altas esferas de poder: un intrincado código que, si llegara a hacerse público, podría provocar el mayor desastre de la historia de los servicios de inteligencia de Estados Unidos.Atrapada en una espiral de secretos y mentiras, Fletcher quiere salvar la agencia en la que cree pero, traicionada por todos, pronto se da cuenta de que debe luchar no sólo por su país, sino también por su vida. ', 16000, 3, 'Dan Brown', 130, CURRENT_DATE()),
('956-777-230-x', 'El Caballero de la Armadura Oxidada', 'El Caballero de la armadura oxidada no es un libro... es una experiencia que expande nuestra mente, que nos llega al corazón y alimenta nuestra alma. Sus profundas enseñanzas éticas son de una sencillez y humildad tal que se consiguen interiorizar naturalmente y la riqueza de su prosa nos inunda de belleza. El protagonista, un caballero deslumbrado por el brillo de su propia armadura, a pesar de ser bueno, generoso y amoroso, no consigue comprender y valorar con profundidad lo que tiene, descuidando sin querer las cosas y las personas que le rodean. Su armadura se va oxidando hasta que deja de brillar y, cuando se da cuenta, ya no puede quitársela. Prisionero de sí mismo, emprende entonces un viaje al final del cual, gracias a la ayuda de diversos personajes, logra deshacerse de la armadura que le ha imposibilitado abrirse al mundo. Este libro nos enseña, con un sutil sentido del humor, que debemos liberarnos de las barreras que nos impiden conocernos y amarnos a nosotros mismos para poder ser capaces de dar y recibir amor en abundancia.', 14000, 2, 'Robert Fisher', 76, CURRENT_DATE());