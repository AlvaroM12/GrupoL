--------------------------------------------------------
-- Archivo creado  - Lunes 6 Junio 2021
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USUARIO
--------------------------------------------------------

INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (1, 'alvaromm@uma.es', 664184557, '123');
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (2, 'rocio22@uma.es', 664184557, '123');
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (3, 'pepe@uma.es', 648152385, 'QL0AFWMIX8NRZTKeof9cXsvbvu8=');
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (4, 'marta@uma.es', 664184557, '123');
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (5, 'caba@uma.es', 664184557, null);
INSERT INTO Usuario (ID, Email_Institucional, Telefono, contrasenia) VALUES (6, 'javi@uma.es', 664184557, null);

--------------------------------------------------------
--  DDL for Table ALUMNO
--------------------------------------------------------
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Blanco', 'Zambrano', 46132, '57400152B', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Isidre', 'MALAGA', 1);
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Molero', 'Marquez', 46132, '57400152A', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Rocio', 'MALAGA', 2);
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Lopez', 'Perez', 46132, '57400152C', 'Reisedor 77', 'IsidreBlancoZambrano@dayrep.com', 'Almassera', 760544184, 'Marta', 'MALAGA', 4);
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Caba', 'Carrillo', 29640, '47400152E', 'Cordoba Blanca 54', 'caba@dayrep.com', 'Teatinos', 513549841, 'Alvaro', 'MALAGA', 5);
INSERT INTO Alumno (Apellido1, Apellido2, CP, DNI, Direccion, Email_Personal, Localidad, Movil, Nombre, Provincia, ID) VALUES ('Garcia', 'Antolin', 46132, '57400152D', 'Reisedor 75', 'javierganto@dayrep.com', 'Alhaurin', 640551484, 'Javier', 'MALAGA', 6);

--------------------------------------------------------
--  DDL for Personal de secretaria
--------------------------------------------------------

INSERT INTO Personal_de_secretaria (Rango, ID) VALUES ('Jefe', 3);

--------------------------------------------------------
--  DDL for Table Centro
--------------------------------------------------------

INSERT INTO Centro (ID, Direccion, Nombre, TLF_Conserjeria) VALUES (1, 'Bulevar Louis Pasteur 35', 'E.T.S Ingenieria Informatica', 952132700);
INSERT INTO Centro (ID, Direccion, Nombre, TLF_Conserjeria) VALUES (2, 'Peñalosa 6', 'Escuela de Ingenierias Industriales', 952649523);

--------------------------------------------------------
--  DDL for Titulacion
--------------------------------------------------------

INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1041, 240, 'Grado en Ingenieria Informatica');
INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1042, 240, 'Grado en Ingenieria del Software');
INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1043, 240, 'Grado en Ingenieria de Computadores');
INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1056, 240, 'Grado en Ingenieria de la Salud');
INSERT INTO Titulacion (Codigo, Creditos, Nombre) VALUES (1073, 372, 'Doble Grado en Ingenieria Informatica y Matematicas');

--------------------------------------------------------
--  DDL for Table Centro_Titulacion
--------------------------------------------------------

INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (1, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (2, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (1, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (2, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (1, 1703);
INSERT INTO Centro_Titulacion (centros_ID, TC_Codigo) VALUES (2, 1703);

--------------------------------------------------------
--  DDL for Table Expediente
--------------------------------------------------------

INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (104100002, 'Si', 0, 60, 3, 0, 0, 40, 0, 5.45, 5, 1041);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (104195486, 'SI', 12, 12, 60, 6, 0, 92, 0, 5.5, 2, 1041);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (104200001, 'Si', 0, 60, 78, 12, 0, 150, 0, 6.32, 1, 1042);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (104300002, 'Si', 0, 24, 0, 0, 0, 24, 0, 6.28, 2, 1043);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (105600003, 'Si', 0, 60, 72, 51, 0, 183, 0, 6.47, 4, 1056);
INSERT INTO Expediente (Num_Expediente, Activo, Creditos_CF, Creditos_FB, Creditos_OB, Creditos_OP, Creditos_PE, Creditos_Superados, Creditos_TF, Nota_Media, AE_ID, TE_Codigo) VALUES (107300003, 'Si', 0, 32, 37, 0, 0, 75, 0, 8013, 6, 1073);

--------------------------------------------------------
--  DDL for Table Asignatura
--------------------------------------------------------

INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (40658, 101, 0, 6, '1 Semestre', 2, 'No', 'Analisis y disenio de Algoritmos', 'Si', '-', 6, 1042, null, null);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (40659, 102, 0, 6, '1 Semestre', 2, 'No', 'Bases de datos', 'Si', '-', 6, 1043, null, null);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (40660, 103, 0, 6, '1 Semestre', 3, 'No', 'EDA', 'Si', '-', 6, 1056, null, null);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (50658, 101, 0, 6, '1 Semestre', 1, 'No', 'Calculo para la Computacion', 'Si', '-', 6, 1041, null, null);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (50659, 102, 0, 6, '1 Semestre', 1, 'No', 'Fundamentos Fisicos de la Informatica', 'Si', '-', 6, 1041, null, null);
INSERT INTO Asignatura (Referencia, Codigo, Creditos_Practicos, Creditos_Teoricos, Cuatrimestre, Curso, Idioma_de_imparticion, Nombre, Ofertada, Plazas, Total_Creditos, TA_Codigo, matriculas_Curso_Academico, matriculas_EM) VALUES (50660, 103, 0, 6, '1 Semestre', 1, 'No', 'Electronica', 'Si', '-', 6, 1073, null, null);

--------------------------------------------------------
--  DDL for Optativa
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table Grupo
--------------------------------------------------------

INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (1, 60, 1, 'NO', 'A', 120, 'MANIANA', null, null, 1041);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (2, 120, 1, 'NO', 'B', 120, 'MANIANA', null, null, 1041);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (3, 35, 2, 'NO', 'C', 120, 'MANIANA', null, null, 1042);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (4, 60, 2, 'NO', 'D', 120, 'TARDE', null, null, 1043);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (5, 60, 3, 'NO', 'A', 120, 'MANIANA', null, null, 1056);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (6, 60, 1, 'NO', 'D', 120, 'TARDE', null, null, 1073);
INSERT INTO Grupo (ID, Asignar, Curso, Ingles, Letra, Plazas, Turno_Maniana_Tarde, Visible, GG_ID, TG_Codigo) VALUES (7, 60, 1, 'NO', 'B', 120, 'MANIANA', null, null, 1042);

--------------------------------------------------------
--  DDL for Table Clase
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table Matricula
--------------------------------------------------------

INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 104100002, null, '2019-12-29', null, 306000005, 'Mañana');
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 104195486, null, '2019-12-29', null, 306000002, 'Mañana');
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 104200001, null, '2019-12-29', null, 306000001, 'Mañana');
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 104300002, null, '2019-12-29', null, 306000003, 'Mañana');
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 105600003, null, '2019-12-29', null, 306000004, 'Mañana');
INSERT INTO Matricula (Curso_Academico, EM, Estado, Fecha_De_Matricula, Nuevo_Ingreso, Num_Archivo, Turno_Preferente) VALUES ('2020/2021', 107300003, null, '2019-12-29', null, 306000006, 'Mañana');

--------------------------------------------------------
--  DDL for Table Asignaturas_Matricula
--------------------------------------------------------

INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (50658, '2020/2021', 104195486, 1);
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (50659, '2020/2021', 104100002, 2);
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (40658, '2020/2021', 104200001, 3);
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (40659, '2020/2021', 104300002, 4);
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (40660, '2020/2021', 105600003, 5);
INSERT INTO Asignaturas_Matricula (asignatura_Referencia, Curso_Academico, EM, G_AM_ID) VALUES (50660, '2020/2021', 107300003, 6);

--------------------------------------------------------
--  DDL for Table Encuesta
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table Grupos_Por_Asignatura
--------------------------------------------------------

INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (1, null, 40658, 3);
INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (4, null, 40659, 4);
INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (2, null, 40660, 5);
INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (3, null, 50658, 1);
INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (2, null, 50659, 2);
INSERT INTO GruposPorAsignatura (Curso_Academico, Oferta, A_GPA_Referencia, G_GPA_ID) VALUES (3, null, 50660, 6);

--------------------------------------------------------
--  DDL for Table Grupos_Por_Asignatura_Encuesta
--------------------------------------------------------


