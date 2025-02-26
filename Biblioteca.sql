
--Dar de alta 3 autores
INSERT INTO biblioteca.autores (nombre, apellidos, fecha_nacimiento) VALUES
('Gabriel', 'García Márquez', '1927-03-06'),
('Isabel', 'Allende', '1942-08-02'),
('Julio', 'Cortázar', '1914-08-26');

--Dar de alta 2 editoriales
INSERT INTO biblioteca.editorial (nombre, direccion) VALUES
('Penguin Random House', 'Av. Siempre Viva 123, Ciudad de México'),
('Planeta', 'Calle Gran Vía 45, Madrid');

--Dar de alta 8 libros, cada libro será escrito por uno de los autores dados de alta previamente y pertenecerá a uno de los editoriales dados de alta previamente.
INSERT INTO biblioteca.libros (titulo, precio, editorial, autor) VALUES
('Cien años de soledad', 299.99, 1, 1),
('El amor en los tiempos del cólera', 249.99, 2, 1),
('La casa de los espíritus', 199.99, 1, 2),
('Eva Luna', 189.99, 2, 2),
('Rayuela', 219.99, 1, 3),
('Bestiario', 159.99, 2, 3),
('El otoño del patriarca', 269.99, 1, 1),
('Paula', 179.99, 2, 2);

--2 librerías, cada librería tendrá 4 libros dados de alta previamente
-- Insertar librerías
INSERT INTO biblioteca.librerias (nombre, nombre_propietario, direccion) VALUES
('Librería El Ateneo', 'Carlos Mendoza', 'Av. Corrientes 1234, Buenos Aires'),
('Librería Gandhi', 'Mariana López', 'Miguel Ángel de Quevedo 121, Ciudad de México');

-- Relacionar libros con librerías
INSERT INTO biblioteca.libro_libreria (id_libreria, id_libro) VALUES
(1, 1), (1, 3), (1, 5), (1, 7), 
(2, 2), (2, 4), (2, 6), (2, 8); 


--Mostrar todos los libros dados de alta, con su editorial y su autor
SELECT l.titulo, l.precio, e.nombre AS editorial, CONCAT(a.nombre, ' ', a.apellidos) AS autor
FROM biblioteca.libros l
JOIN biblioteca.editorial e ON l.id = e.id
JOIN biblioteca.autores a ON l.id = a.id;

--Mostrar todos los autores dados de alta, con sus libros asociados
SELECT a.nombre, a.apellidos, l.titulo AS libro
FROM biblioteca.autores a
LEFT JOIN biblioteca.libros l ON a.id = l.id
ORDER BY a.apellidos, l.titulo;

--Mostrar todas las librerías, con solamente sus libros asociados
SELECT lb.nombre AS libreria, lb.direccion, l.titulo AS libro
FROM biblioteca.librerias lb
JOIN biblioteca.libro_libreria ll ON lb.id = ll.id_libreria
JOIN biblioteca.libros l ON ll.id_libro = l.id
ORDER BY lb.nombre, l.titulo;

--Mostrar todos los libros dados de alta, y en la librería en la que están.
SELECT l.titulo, lb.nombre AS libreria
FROM biblioteca.libros l
JOIN biblioteca.libro_libreria ll ON l.id = ll.id_libro
JOIN biblioteca.librerias lb ON ll.id_libreria = lb.id
ORDER BY l.titulo, lb.nombre;
