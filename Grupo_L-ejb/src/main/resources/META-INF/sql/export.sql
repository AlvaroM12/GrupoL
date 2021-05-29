--------------------------------------------------------
-- Archivo creado  - viernes-mayo-21-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ALUMNO
--------------------------------------------------------

INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (1, 'alvaromm@uma.es', 664184557, '123');
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Blanco', 'Zambrano', 46132, '57400152B', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Isidre', 'MALAGA', 1);
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (2, 'rocio22@uma.es', 664184557, '123');
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Molero', 'Marquez', 46132, '57400152A', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Rocio', 'MALAGA', 2);
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (4, 'marta@uma.es', 664184557, '123');
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Lopez', 'Perez', 46132, '57400152C', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Marta', 'MALAGA', 4);
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (3, 'pepe@uma.es', 648152385, '123');
INSERT INTO Personal_de_secretaria (Rango, ID) VALUES ('Jefe', 3);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (1512, 101, 6, 6, '1', 1, 'español', 'Calculo', 'si', '100', 6, 1703, null, null);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (22895486, 'SI', 12, 12, 60, 6, 0, 92, 0, 5.5, 2, 1703);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (1, 60, 3, 'NO', 'A', 120, 'MAÑANA', null, null, 1703);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (2, 120, 2, 'NO', 'B', 120, 'MAÑANA', null, null, 1703);
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('3', 22895486, null, '2018-09-01', 'NO', 29547, 'MAÑANA');
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (1512, '3', 22895486, 1);
INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1703, 240, 'Informatica');
INSERT INTO Centro (ID, Direccion, Nombre, TLF_Conserjeria) VALUES (1, 'Bulevar Louis Pasteur 35', 'E.T.S Ingenieria Informatica', 952132700);
INSERT INTO Centro (ID, Direccion, Nombre, TLF_Conserjeria) VALUES (2, 'Peñalosa 6', 'Escuela de Ingenierías Industriales', 952649523);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (1, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (2, 1703);