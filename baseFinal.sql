CREATE TABLE departamento
(
    id_departamento serial,
    nombre character varying(150) COLLATE pg_catalog."default",
    CONSTRAINT id_departamento_pkey PRIMARY KEY (id_departamento)
);

CREATE TABLE municipio
(
    id_municipio serial,
    nombre character varying(150) COLLATE pg_catalog."default",
    id_departamento integer,
    CONSTRAINT id_municipio_pkey PRIMARY KEY (id_municipio),
    CONSTRAINT fk_id_departamento FOREIGN KEY (id_departamento)
        REFERENCES departamento (id_departamento) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE catalogo_CE
(
    id_catce serial,
    nombre character varying(150) COLLATE pg_catalog."default",
    estado boolean,
    id_municipio integer,
    CONSTRAINT id_catce_pkey PRIMARY KEY (id_catce),
    CONSTRAINT fk_id_municipio FOREIGN KEY (id_municipio)
        REFERENCES municipio (id_municipio) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE rol
(
    id_rol serial,
    nombre character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT id_rol_pkey PRIMARY KEY (id_rol)
)

CREATE TABLE catalogo_materias
(
    id_catmateria serial,
    nombre character varying(150) COLLATE pg_catalog."default",
    estado boolean,
    CONSTRAINT id_catmateria_pkey PRIMARY KEY (id_catmateria)
)

CREATE TABLE usuario
(
    id_usuario serial,
    nombre character varying(150) COLLATE pg_catalog."default",
    apellido character varying(150) COLLATE pg_catalog."default",
    fecha_nacimiento date,
    edad integer, 
    direccion character varying(200) COLLATE pg_catalog."default",
    estado boolean,
    nombre_usuario character varying(30) COLLATE pg_catalog."default",
    contrasenia character varying(30) COLLATE pg_catalog."default",
    id_municipio integer,
    id_rol integer,
    CONSTRAINT id_usuario_pkey PRIMARY KEY (id_usuario),
    CONSTRAINT fk_id_municipio FOREIGN KEY (id_municipio)
        REFERENCES municipio (id_municipio) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_id_rol FOREIGN KEY (id_rol)
        REFERENCES rol (id_rol) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE expediente
(
    id_estudiante serial,
    nombres character varying(250) COLLATE pg_catalog."default",
    apellidos character varying(250) COLLATE pg_catalog."default",
    carne_min character varying(9) COLLATE pg_catalog."default",
    fecha_nacimiento date,
    edad integer, 
    direccion character varying(200) COLLATE pg_catalog."default",
    tel_fijo character varying(9) COLLATE pg_catalog."default",
    tel_movil character varying(9) COLLATE pg_catalog."default",
    nombre_padre character varying(100) COLLATE pg_catalog."default",
    nombre_madre character varying(100) COLLATE pg_catalog."default",
    id_catce integer,
    CONSTRAINT id_estudiante_pkey PRIMARY KEY (id_estudiante),
    CONSTRAINT fk_id_catce FOREIGN KEY (id_catce)
        REFERENCES catalogo_CE (id_catce) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE materia
(
    id_materia serial,
    id_catmateria integer,
    anio integer,
    ciclo integer,
    nota real,
    id_estudiante integer,
    resultado character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT id_materia_pkey PRIMARY KEY (id_materia),
    CONSTRAINT fk_id_estudiante FOREIGN KEY (id_estudiante)
        REFERENCES expediente (id_estudiante) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_id_catmateria FOREIGN KEY (id_catmateria)
        REFERENCES catalogo_materias (id_catmateria) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)


-- INSERT DEPARTAMENTO 

INSERT INTO departamento(id_departamento, nombre) VALUES (1, 'Ahuachapán');
INSERT INTO departamento(id_departamento, nombre) VALUES (2, 'Cabañas');
INSERT INTO departamento(id_departamento, nombre) VALUES (3, 'Chalatenango');
INSERT INTO departamento(id_departamento, nombre) VALUES (4, 'Cuscatlán');
INSERT INTO departamento(id_departamento, nombre) VALUES (5, 'La Libertad');
INSERT INTO departamento(id_departamento, nombre) VALUES (6, 'La Paz');
INSERT INTO departamento(id_departamento, nombre) VALUES (7, 'La Unión');
INSERT INTO departamento(id_departamento, nombre) VALUES (8, 'Morazán');
INSERT INTO departamento(id_departamento, nombre) VALUES (9, 'San Miguel');
INSERT INTO departamento(id_departamento, nombre) VALUES (10, 'San Salvador');
INSERT INTO departamento(id_departamento, nombre) VALUES (11, 'San Vicente');
INSERT INTO departamento(id_departamento, nombre) VALUES (12, 'Santa Ana');
INSERT INTO departamento(id_departamento, nombre) VALUES (13, 'Sonsonate');
INSERT INTO departamento(id_departamento, nombre) VALUES (14, 'Usulután');

-- INSERT MUNICIPIOS

-- Ahuachapan
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (1, 'Ahuachapán', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (2, 'Apaneca', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (3, 'Atiquizaya', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (4, 'Concepción de Ataco', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (5, 'El Refugio', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (6, 'Guaymango', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (7, 'Jujutla', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (8, 'San Francisco Menéndez', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (9, 'San Lorenzo', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (10, 'San Pedro Puxtla', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (11, 'Tacuba', 1);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (12, 'Turin', 1);

-- Cabañas
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (13, 'Cinquera', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (14, 'Dolores', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (15, 'Guacotecti', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (16, 'Ilobasco', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (17, 'Jutiapa', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (18, 'San Isidro', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (19, 'Sensutepeque', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (20, 'Tejutepeque', 2);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (21, 'Victoria', 2);

-- Chalatenango
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (22, 'Agua Caliente', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (23, 'Arcatao', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (24, 'Azacualpa', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (25, 'Chalatenango', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (26, 'Comalapa', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (27, 'Citalá', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (28, 'Concepción Quezaltepeque', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (29, 'Dulce Nombre de María', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (30, 'El Carrizal', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (31, 'El Paraíso', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (32, 'La Laguna', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (33, 'La Palma', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (34, 'La Reina', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (35, 'Las Vueltas', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (36, 'Nueva Concepción', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (37, 'Nueva Trinidad', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (38, 'Nombre de Jesús', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (39, 'Ojos de Agua', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (40, 'Potonico', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (41, 'San Antonio de la Cruz', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (42, 'San Antonio Los Ranchos', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (43, 'San Fernando', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (44, 'San Francisco Lempa', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (45, 'San Francisco Morazán', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (46, 'San Ignacio', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (47, 'San Isidro Labrador', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (48, 'San José Cancasque', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (49, 'San José Las Flores', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (50, 'San Luis del Carmen', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (51, 'San Miguel de Mercedes', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (52, 'San Rafael', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (53, 'santa Rita', 3);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (54, 'Tejutla', 3);

-- Cuscatlán

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (55, 'Candelaria', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (56, 'Cojutepeque', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (57, 'El Carmen', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (58, 'El Rosario', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (59, 'Monte San Juan', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (60, 'Oratorio de Concepción', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (61, 'San Bartolomé Perulapia', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (62, 'San Cristóbal', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (63, 'San José Guayabal', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (64, 'San Pedro Perulapán', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (65, 'San Rafael Cedros', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (66, 'San Ramón', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (67, 'Santa Cruz Analquito', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (68, 'Santa Cruz Michapa', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (69, 'Suchitoto', 4);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (70, 'Tenancingo', 4);

-- La Libertad

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (71, 'Antiguo Cuscatlán', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (72, 'Chiltiupán', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (73, 'Ciudad Arce', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (74, 'Colón', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (75, 'Comasagua', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (76, 'Huizúcar', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (77, 'Jayaque', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (78, 'Jicalapa', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (79, 'La Libertad', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (80, 'Santa Tecla', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (81, 'Nuevo Cuscatlán', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (82, 'San Juan Opico', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (83, 'Quezaltepeque', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (84, 'Sacacoyo', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (85, 'San José Villanueva', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (86, 'San Matías', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (87, 'San Pablo Tacachico', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (88, 'Talnique', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (89, 'Tamanique', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (90, 'Teotepeque', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (91, 'Tepecoyo', 5);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (92, 'Zaragoza', 5);

-- La Paz

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (93, 'Cuyultitán', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (94, 'El Rosario', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (95, 'Jerusalén', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (96, 'Mercedes La Ceiba', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (97, 'Olocuilta', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (98, 'Paraíso de Osorio', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (99, 'San Antonio Masahuat', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (100, 'San Emigdio', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (101, 'San Francisco Chinameca', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (102, 'San Juan Nonualco', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (103, 'San Juan Talpa', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (104, 'San Juan Tepezontes', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (105, 'San Luis Talpa', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (106, 'San Luis La Herradura', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (107, 'San Miguel Tepezontes', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (108, 'San Pedro Masahuat', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (109, 'San Pedro Nonualco', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (110, 'San Rafael Obrajuelo', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (111, 'Santa María Ostuma', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (112, 'Santiago Nonualco', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (113, 'Tapalhuaca', 6);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (114, 'Zacatecoluca', 6);

-- La Union

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (115, 'Anamorós', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (116, 'Bolivar', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (117, 'Concepción de Oriente', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (118, 'Conchagua', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (119, 'El Carmen', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (120, 'El Sauce', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (121, 'Intipucá', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (122, 'La Unión', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (123, 'Lislique', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (124, 'Meanguera del Golfo', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (125, 'Nueva Esparta', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (126, 'Pasaquina', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (127, 'Polorós', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (128, 'San Alejo', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (129, 'San José', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (130, 'Santa Rosa de Lima', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (131, 'Yayantique', 7);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (132, 'Yucuaiquín', 7);

-- Morazan

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (133, 'Arambala', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (134, 'Cacaopera', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (135, 'Chilanga', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (136, 'Corinto', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (137, 'Delicias de Concepción', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (138, 'El Divisadero', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (139, 'El Rosario', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (140, 'Gualococti',8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (141, 'Guatajiagua', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (142, 'Joateca', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (143, 'Jocoaitique', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (144, 'Jocoro', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (145, 'Lolotiquillo', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (146, 'Meanguera', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (147, 'Osicala', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (148, 'Perquín', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (149, 'San Carlos', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (150, 'San Fernando', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (151, 'San Francisco Gotera', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (152, 'San Isidro', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (153, 'San Simón', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (154, 'Sensembra', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (155, 'Sociedad', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (156, 'Torola', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (157, 'Yamabal', 8);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (158, 'Yoloaiquín', 8);

-- San Miguel

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (159, 'Carolina', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (160, 'Chapeltique', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (161, 'Chinameca', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (162, 'Chirilagua', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (163, 'Ciudad Barrios', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (164, 'Comacarán', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (165, 'El Tránsito', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (166, 'Lolotique',9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (167, 'Moncagua', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (168, 'Nueva Guadalupe', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (169, 'Nuevo Edén de San Juan', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (170, 'Quelepa', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (171, 'San Antonio del Mosco', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (172, 'San Gerardo', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (173, 'San Jorge', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (174, 'San Luis de la Reina', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (175, 'San Miguel', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (176, 'San Rafael Oriente', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (177, 'Sesori', 9);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (178, 'Uluazapa', 9);

-- San Salvador

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (179, 'Aguilares', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (180, 'Apopa', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (181, 'Ayutuxtepeque', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (182, 'Cuscatancingo', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (183, 'Ciudad Delgado', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (184, 'El Paisnal', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (185, 'Guazapa', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (186, 'Ilopango',10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (187, 'Mejicanos', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (188, 'Nejapa', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (189, 'Panchimalco', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (190, 'Rosario de Mora', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (191, 'San Marcos', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (192, 'San Martín', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (193, 'San Salvador', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (194, 'Santiago Texacuangos', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (195, 'Santo Tomás', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (196, 'Soyapango', 10);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (197, 'Tonacatepeque', 10);

-- San Vicente

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (198, 'Apastepeque', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (199, 'Guadalupe', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (200, 'San Cayetano Istepeque', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (201, 'San Esteban Catarina', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (202, 'San Ildefonso', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (203, 'San Lorenzo', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (204, 'San Sebastián', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (205, 'San Vicente',11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (206, 'Santa Clara', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (207, 'Santo Domingo', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (208, 'Tecoluca', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (209, 'Tepetitán', 11);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (210, 'Verapaz', 11);

-- Santa Ana

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (211, 'Candelaria de la Frontera', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (212, 'Chalchuapa', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (213, 'Coatepeque', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (214, 'El Congo', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (215, 'El Porvenir', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (216, 'Masahuat', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (217, 'Metapán', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (218, 'San Antonio Pajonal',12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (219, 'San Sebastián Salitrillo', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (220, 'Santa Ana', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (221, 'Santa Rosa Guachipilín', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (222, 'Santiago de la Frontera', 12);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (223, 'Texistepeque', 12);

-- Sonsonate

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (224, 'Acajutla', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (225, 'Armenia', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (226, 'Caluco', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (227, 'Cuisnahuat', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (228, 'Izalco', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (229, 'Juayúa', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (230, 'Nahuizalco', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (231, 'Nahulingo',13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (232, 'Salcoatitlán', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (233, 'San Antonio del Monte', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (234, 'San Julián', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (235, 'Santa Catarina Masahuat', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (236, 'Santa Isable Ishuatán', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (237, 'Santo Domingo Guzmán', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (238, 'Sonsonate', 13);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (239, 'Sonzacate', 13);

-- Usulutan

INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (240, 'Alegría', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (241, 'Berlín', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (242, 'California', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (243, 'Concepción Batres', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (244, 'El Triunfo', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (245, 'Ereguayquín', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (246, 'Estanzuelas', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (247, 'Jiquilisco', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (248, 'Jucuapa', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (249, 'Jucuarán', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (250, 'Mercedes Umaña',14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (251, 'Nueva Granada', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (252, 'Ozatlán', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (253, 'Puerto El Triunfo', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (254, 'San Agustín', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (255, 'San Buenaventura', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (256, 'San Dionisio', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (257, 'San Francisco Javier', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (258, 'Santa Elena', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (259, 'Santa María', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (260, 'Santiago de María', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (261, 'Tecapán', 14);
INSERT INTO municipio(id_municipio, nombre, id_departamento) VALUES (262, 'Usulután', 14);

-- Roles
INSERT INTO rol(id_rol, nombre) VALUES (1, 'Administrador')
INSERT INTO rol(id_rol, nombre) VALUES (2, 'Coordinador')

-- Usuario admin de prueba (ya esta activado)
-- username: admon ; contrasenia : admin

INSERT INTO usuario(id_usuario, nombre, apellido, fecha_nacimiento, edad, direccion, estado, nombre_usuario, contrasenia, id_municipio, id_rol) 
VALUES (4, 'admin', 'Prueba', '2000-09-03', 2020, 'Pinares De Suiza', true, 'admon', '$2a$04$8Fw39Lis0MO02Tx/KjUAduuEeaGTz1tMOBRUI2FwTep9MUYyWnUeK', 80 ,1)