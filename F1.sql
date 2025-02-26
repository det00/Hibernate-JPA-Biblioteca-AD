-- Usar la base de datos
USE f1_db;

-- 1. Insertar Motores
INSERT INTO f1_db.motores (nombre, cv, campeonatos) VALUES
('Mercedes', 1000, 10), -- Aproximado, incluye títulos con equipos como McLaren y Williams
('Ferrari', 990, 16),  -- Histórico como proveedor y equipo
('Honda RBPT', 980, 6), -- Incluye títulos recientes con Red Bull
('Renault', 970, 12);  -- Títulos con equipos como Williams y Red Bull en el pasado

-- 2. Insertar Equipos (con motor_id referenciando motores.id)
INSERT INTO f1_db.equipos (nombre, motor_id, jefe_equipo_id, pais, yearFundado, campeonatosDeEquipos, campeonatosDePilotos) VALUES
('Red Bull', 3, 1, 'Austria', 2005, 6, 7),         -- Honda RBPT, Horner
('Mercedes', 1, 2, 'Alemania', 1954, 8, 9),        -- Mercedes, Wolff
('Ferrari', 2, 3, 'Italia', 1950, 16, 15),         -- Ferrari, Vasseur
('McLaren', 1, 4, 'Reino Unido', 1966, 8, 12),     -- Mercedes, Stella
('Aston Martin', 1, 5, 'Reino Unido', 2018, 0, 0), -- Mercedes, Krack
('Alpine', 4, 6, 'Francia', 1977, 2, 2),           -- Renault, Oakes
('Williams', 1, 7, 'Reino Unido', 1977, 9, 7),     -- Mercedes, Vowles
('RB', 3, 8, 'Italia', 2006, 0, 0),               -- Honda RBPT, Mekies
('Sauber', 2, 9, 'Suiza', 1993, 0, 0),            -- Ferrari, Alunni Bravi
('Haas', 2, 10, 'Estados Unidos', 2016, 0, 0);     -- Ferrari, Komatsu

-- 3. Insertar Pilotos (con equipo_id referenciando equipos.id)
INSERT INTO f1_db.pilotos (nombre, apellidos, edad, campeonatos, pais, equipo_id) VALUES
('Max', 'Verstappen', 27, 3, 'Países Bajos', 1),      -- Red Bull
('Liam', 'Lawson', 23, 0, 'Nueva Zelanda', 1),        -- Red Bull
('George', 'Russell', 27, 0, 'Reino Unido', 2),       -- Mercedes
('Kimi', 'Antonelli', 18, 0, 'Italia', 2),            -- Mercedes
('Charles', 'Leclerc', 27, 0, 'Mónaco', 3),           -- Ferrari
('Lewis', 'Hamilton', 40, 7, 'Reino Unido', 3),       -- Ferrari
('Lando', 'Norris', 25, 0, 'Reino Unido', 4),         -- McLaren
('Oscar', 'Piastri', 23, 0, 'Australia', 4),          -- McLaren
('Fernando', 'Alonso', 43, 2, 'España', 5),           -- Aston Martin
('Lance', 'Stroll', 26, 0, 'Canadá', 5),             -- Aston Martin
('Pierre', 'Gasly', 29, 0, 'Francia', 6),            -- Alpine
('Jack', 'Doohan', 22, 0, 'Australia', 6),           -- Alpine
('Alex', 'Albon', 28, 0, 'Tailandia', 7),            -- Williams
('Carlos', 'Sainz', 30, 0, 'España', 7),             -- Williams
('Yuki', 'Tsunoda', 24, 0, 'Japón', 8),              -- RB
('Isack', 'Hadjar', 20, 0, 'Francia', 8),            -- RB
('Nico', 'Hulkenberg', 37, 0, 'Alemania', 9),        -- Sauber
('Gabriel', 'Bortoleto', 20, 0, 'Brasil', 9),        -- Sauber
('Oliver', 'Bearman', 19, 0, 'Reino Unido', 10),     -- Haas
('Esteban', 'Ocon', 28, 0, 'Francia', 10);           -- Haas

-- 4. Insertar Carreras
INSERT INTO f1_db.carreras (nombre, fecha, pais) VALUES
('GP de Australia', '2025-03-16', 'Australia'),
('GP de China', '2025-03-23', 'China'),
('GP de Japón', '2025-04-06', 'Japón'),
('GP de Bahréin', '2025-04-13', 'Bahréin'),
('GP de Arabia Saudí', '2025-04-20', 'Arabia Saudí'),
('GP de Miami', '2025-05-04', 'Estados Unidos'),
('GP de Emilia-Romaña', '2025-05-18', 'Italia'),
('GP de Mónaco', '2025-05-25', 'Mónaco'),
('GP de España', '2025-06-01', 'España'),
('GP de Canadá', '2025-06-15', 'Canadá'),
('GP de Austria', '2025-06-29', 'Austria'),
('GP de Gran Bretaña', '2025-07-06', 'Reino Unido'),
('GP de Hungría', '2025-07-27', 'Hungría'),
('GP de Bélgica', '2025-08-03', 'Bélgica'),
('GP de Países Bajos', '2025-08-31', 'Países Bajos'),
('GP de Italia', '2025-09-07', 'Italia'),
('GP de Azerbaiyán', '2025-09-21', 'Azerbaiyán'),
('GP de Singapur', '2025-10-05', 'Singapur'),
('GP de Estados Unidos', '2025-10-19', 'Estados Unidos'),
('GP de México', '2025-10-26', 'México'),
('GP de Brasil', '2025-11-09', 'Brasil'),
('GP de Las Vegas', '2025-11-22', 'Estados Unidos'),
('GP de Qatar', '2025-11-30', 'Qatar'),
('GP de Abu Dhabi', '2025-12-07', 'Emiratos Árabes Unidos');

-- 5. Insertar relación N:M en pilotos_carreras
INSERT INTO f1_db.pilotos_carreras (piloto_id, carrera_id) VALUES
(1, 1),  -- Verstappen en GP de Australia
(1, 2),  -- Verstappen en GP de Mónaco
(6, 1),  -- Hamilton en GP de Australia
(6, 3),  -- Hamilton en GP de Silverstone
(7, 2),  -- Norris en GP de Mónaco
(7, 3);  -- Norris en GP de Silverstone

INSERT INTO f1_db.jefes_equipo (nombre, apellido, pais, edad) VALUES
('Christian', 'Horner', 'Reino Unido', 51),
('Toto', 'Wolff', 'Austria', 53),
('Frédéric', 'Vasseur', 'Francia', 56),
('Andrea', 'Stella', 'Italia', 53),
('Mike', 'Krack', 'Luxemburgo', 53),
('Oliver', 'Oakes', 'Reino Unido', 36),
('James', 'Vowles', 'Reino Unido', 45),
('Laurent', 'Mekies', 'Francia', 47),
('Alessandro', 'Alunni Bravi', 'Italia', 50),
('Ayao', 'Komatsu', 'Japón', 48);

SHOW CREATE TABLE motores;
SHOW CREATE TABLE equipos;
SHOW CREATE TABLE pilotos;
SHOW CREATE TABLE carreras;
SHOW CREATE TABLE pilotos_carreras;