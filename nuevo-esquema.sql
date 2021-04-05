CREATE TABLE USUARIO (ID BIGINT NOT NULL, TELEFONO BIGINT, PRIMARY KEY (ID))
CREATE TABLE GRUPO (ID BIGINT NOT NULL, ASIGNAR BIGINT, CURSO BIGINT, INGLES VARCHAR(255), LETRA VARCHAR(255), PLAZAS BIGINT, TURNO_MAÑANA_TARDE VARCHAR(255), VISIBLE BIGINT, GG_ID BIGINT, TG_CÓDIGO BIGINT, PRIMARY KEY (ID))
CREATE TABLE ALUMNO (ID BIGINT NOT NULL, DNI VARCHAR(255), EMAIL_INSTITUCIONAL VARCHAR(255), EMAIL_PERSONAL VARCHAR(255), MÓVIL BIGINT, NOMBRE_COMPLETO VARCHAR(255), TELEFONO BIGINT, PRIMARY KEY (ID))
CREATE TABLE ASIGNATURA (REFERENCIA BIGINT NOT NULL, CARACTER BIGINT, CODIGO BIGINT, CRÉDITOS BIGINT, CURSO BIGINT, DURACIÓN BIGINT, IDIOMA_DE_IMPARTICION VARCHAR(255), NOMBRE BIGINT, OFERTADA VARCHAR(255), UNIDAD_TEMPORAL_CUATRIMESTRE BIGINT, TA_CÓDIGO BIGINT, PRIMARY KEY (REFERENCIA))
CREATE TABLE ASIGNATURAS_MATRÍCULA (G_AM_ID BIGINT, ASIGNATURA_REFERENCIA BIGINT NOT NULL, Curso_Academico VARCHAR(255) NOT NULL, EM VARCHAR(255) NOT NULL, PRIMARY KEY (ASIGNATURA_REFERENCIA, Curso_Academico, EM))
CREATE TABLE CENTRO (ID BIGINT NOT NULL, DIRECCION VARCHAR(255), NOMBRE VARCHAR(255), TLF_CONSERJERIA BIGINT, PRIMARY KEY (ID))
CREATE TABLE CLASE (HORAINICIO BIGINT NOT NULL, DIA DATE NOT NULL, HORAFIN BIGINT, AC_REFERENCIA BIGINT, GC_ID BIGINT NOT NULL, PRIMARY KEY (HORAINICIO, DIA, GC_ID))
CREATE TABLE ENCUESTA (FECHA_DE_ENVÍO BIGINT NOT NULL, EE_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (FECHA_DE_ENVÍO, EE_NUM_EXPEDIENTE))
CREATE TABLE EXPEDIENTE (NUM_EXPEDIENTE BIGINT NOT NULL, ACTIVO VARCHAR(255), NOTA_MEDIA_PROVISIONAL FLOAT, AE_ID BIGINT, TE_CÓDIGO BIGINT, PRIMARY KEY (NUM_EXPEDIENTE))
CREATE TABLE GRUPOSPORASIGNATURA (CURSO_ACADEMICO BIGINT NOT NULL, OFERTA BIGINT, A_GPA_REFERENCIA BIGINT NOT NULL, G_GPA_ID BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, A_GPA_REFERENCIA, G_GPA_ID))
CREATE TABLE MATRÍCULA (CURSO_ACADEMICO VARCHAR(255) NOT NULL, ESTADO VARCHAR(255), FECHA_DE_MATRÍCULA DATE, LISTADO_ASIGNATURAS VARCHAR(255), NUEVO_INGRESO VARCHAR(255), NUM_ARCHIVO BIGINT, TURNO_PREFERENTE VARCHAR(255), EM_NUM_EXPEDIENTE BIGINT NOT NULL, PRIMARY KEY (CURSO_ACADEMICO, EM_NUM_EXPEDIENTE))
CREATE TABLE OPTATIVA (REFERENCIA BIGINT NOT NULL, CARACTER BIGINT, CODIGO BIGINT, CRÉDITOS BIGINT, CURSO BIGINT, DURACIÓN BIGINT, IDIOMA_DE_IMPARTICION VARCHAR(255), MENCIÓN VARCHAR(255), NOMBRE BIGINT, OFERTADA VARCHAR(255), PLAZAS BIGINT, UNIDAD_TEMPORAL_CUATRIMESTRE BIGINT, TA_CÓDIGO BIGINT, PRIMARY KEY (REFERENCIA))
CREATE TABLE PERSONAL_DE_SECRETARIA (ID BIGINT NOT NULL, RANGO VARCHAR(255), TELEFONO BIGINT, PRIMARY KEY (ID))
CREATE TABLE TITULACION (CÓDIGO BIGINT NOT NULL, CRÉDITOS BIGINT, NOMBRE VARCHAR(255), PRIMARY KEY (CÓDIGO))
CREATE TABLE CENTRO_TITULACION (centros_ID BIGINT NOT NULL, TC_CÓDIGO BIGINT NOT NULL, PRIMARY KEY (centros_ID, TC_CÓDIGO))
CREATE TABLE GRUPOSPORASIGNATURA_ENCUESTA (FECHA_DE_ENVÍO BIGINT NOT NULL, EE_NUM_EXPEDIENTE BIGINT NOT NULL, CURSO_ACADEMICO BIGINT NOT NULL, G_GPA_ID BIGINT NOT NULL, A_GPA_REFERENCIA BIGINT NOT NULL, PRIMARY KEY (FECHA_DE_ENVÍO, EE_NUM_EXPEDIENTE, CURSO_ACADEMICO, G_GPA_ID, A_GPA_REFERENCIA))
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_TG_CÓDIGO FOREIGN KEY (TG_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE GRUPO ADD CONSTRAINT FK_GRUPO_GG_ID FOREIGN KEY (GG_ID) REFERENCES GRUPO (ID)
ALTER TABLE ASIGNATURA ADD CONSTRAINT FK_ASIGNATURA_TA_CÓDIGO FOREIGN KEY (TA_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE ASIGNATURAS_MATRÍCULA ADD CONSTRAINT FK_ASIGNATURAS_MATRÍCULA_EM FOREIGN KEY (EM, Curso_Academico) REFERENCES MATRÍCULA (EM, CURSO_ACADEMICO)
ALTER TABLE ASIGNATURAS_MATRÍCULA ADD CONSTRAINT FK_ASIGNATURAS_MATRÍCULA_G_AM_ID FOREIGN KEY (G_AM_ID) REFERENCES GRUPO (ID)
ALTER TABLE CLASE ADD CONSTRAINT FK_CLASE_GC_ID FOREIGN KEY (GC_ID) REFERENCES GRUPO (ID)
ALTER TABLE ENCUESTA ADD CONSTRAINT FK_ENCUESTA_EE_NUM_EXPEDIENTE FOREIGN KEY (EE_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_AE_ID FOREIGN KEY (AE_ID) REFERENCES ALUMNO (ID)
ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_EXPEDIENTE_TE_CÓDIGO FOREIGN KEY (TE_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE GRUPOSPORASIGNATURA ADD CONSTRAINT FK_GRUPOSPORASIGNATURA_G_GPA_ID FOREIGN KEY (G_GPA_ID) REFERENCES GRUPO (ID)
ALTER TABLE MATRÍCULA ADD CONSTRAINT FK_MATRÍCULA_EM_NUM_EXPEDIENTE FOREIGN KEY (EM_NUM_EXPEDIENTE) REFERENCES EXPEDIENTE (NUM_EXPEDIENTE)
ALTER TABLE OPTATIVA ADD CONSTRAINT FK_OPTATIVA_TA_CÓDIGO FOREIGN KEY (TA_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE CENTRO_TITULACION ADD CONSTRAINT FK_CENTRO_TITULACION_TC_CÓDIGO FOREIGN KEY (TC_CÓDIGO) REFERENCES TITULACION (CÓDIGO)
ALTER TABLE CENTRO_TITULACION ADD CONSTRAINT FK_CENTRO_TITULACION_centros_ID FOREIGN KEY (centros_ID) REFERENCES CENTRO (ID)
ALTER TABLE GRUPOSPORASIGNATURA_ENCUESTA ADD CONSTRAINT FK_GRUPOSPORASIGNATURA_ENCUESTA_FECHA_DE_ENVÍO FOREIGN KEY (FECHA_DE_ENVÍO, EE_NUM_EXPEDIENTE) REFERENCES ENCUESTA (FECHA_DE_ENVÍO, EE_NUM_EXPEDIENTE)
ALTER TABLE GRUPOSPORASIGNATURA_ENCUESTA ADD CONSTRAINT FK_GRUPOSPORASIGNATURA_ENCUESTA_CURSO_ACADEMICO FOREIGN KEY (CURSO_ACADEMICO, A_GPA_REFERENCIA, G_GPA_ID) REFERENCES GRUPOSPORASIGNATURA (CURSO_ACADEMICO, A_GPA_REFERENCIA, G_GPA_ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
