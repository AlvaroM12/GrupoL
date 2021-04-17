-- Generado por Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   en:        2021-04-08 15:20:01 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE alumno (
    id                   NUMBER NOT NULL,
    dni                  VARCHAR2(128) NOT NULL,
    nombre_completo      VARCHAR2(128) NOT NULL,
    email_institucional  VARCHAR2(128) NOT NULL,
    email_personal       VARCHAR2(128) NOT NULL,
    móvil                NUMBER NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id );

ALTER TABLE alumno ADD CONSTRAINT alumno_dni_un UNIQUE ( dni );

CREATE TABLE asignatura (
    referencia                       NUMBER NOT NULL,
    codigo                           NUMBER NOT NULL,
    créditos                         NUMBER NOT NULL,
    ofertada                         CHAR(1) NOT NULL,
    nombre                           VARCHAR2(128) NOT NULL,
    curso                            NUMBER,
    caracter                         VARCHAR2(128),
    duración                         NUMBER,
    "Unidad_Temporal(Cuatrimestre)"  NUMBER,
    idiomas_de_imparticion           VARCHAR2(128),
    titulación_código                NUMBER NOT NULL
);

ALTER TABLE asignatura ADD CONSTRAINT asignatura_pk PRIMARY KEY ( referencia );

CREATE TABLE asignaturas_matricula (
    asignatura_referencia                NUMBER NOT NULL,
    grupo_id                             NUMBER NOT NULL,
    matricula_curso_academico            VARCHAR2(128) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    matricula_expediente_num_expediente  NUMBER NOT NULL
);

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_pk PRIMARY KEY ( asignatura_referencia,
                                                          matricula_curso_academico,
                                                          matricula_expediente_num_expediente );

CREATE TABLE centro (
    id               NUMBER NOT NULL,
    nombre           VARCHAR2(128) NOT NULL,
    direccion        VARCHAR2(128) NOT NULL,
    tlf_consergeria  NUMBER
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id );

ALTER TABLE centro ADD CONSTRAINT centro_nombre_un UNIQUE ( nombre );

CREATE TABLE clase (
    dia                    DATE NOT NULL,
    horainicio             NUMBER NOT NULL,
    hora_fin               NUMBER,
    grupo_id               NUMBER NOT NULL,
    asignatura_referencia  NUMBER NOT NULL
);

ALTER TABLE clase
    ADD CONSTRAINT clase_pk PRIMARY KEY ( dia,
                                          horainicio,
                                          grupo_id );

CREATE TABLE e_gpa ( 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_curso_académico        NUMBER NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    grupos_por_asignatura_asignatura_referencia  NUMBER NOT NULL,
    grupos_por_asignatura_id                     NUMBER NOT NULL,
    encuesta_fecha_de_envio                      DATE NOT NULL,
    encuesta_num_expediente                      NUMBER NOT NULL
);

ALTER TABLE e_gpa
    ADD CONSTRAINT e_gpa_pk PRIMARY KEY ( grupos_por_asignatura_curso_académico,
                                          grupos_por_asignatura_asignatura_referencia,
                                          grupos_por_asignatura_id,
                                          encuesta_fecha_de_envio,
                                          encuesta_num_expediente );

CREATE TABLE encuesta (
    fecha_de_envio             DATE NOT NULL,
    expediente_num_expediente  NUMBER NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( fecha_de_envio,
                                                              expediente_num_expediente );

CREATE TABLE expediente (
    num_expediente          NUMBER NOT NULL,
    activo                  CHAR(1),
    nota_media_provisional  NUMBER,
    titulación_código       NUMBER NOT NULL,
    alumno_id               NUMBER NOT NULL
);

ALTER TABLE expediente ADD CONSTRAINT expediente_pk PRIMARY KEY ( num_expediente );

CREATE TABLE grupo (
    id                  NUMBER NOT NULL,
    curso               NUMBER NOT NULL,
    letra               VARCHAR2(128) NOT NULL,
    turno_mañana_tarde  VARCHAR2(128) NOT NULL,
    ingles              VARCHAR2(128) NOT NULL,
    visible             VARCHAR2(128),
    asignar             VARCHAR2(128),
    plazas              VARCHAR2(128),
    grupo_id            NUMBER,
    titulación_código   NUMBER NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id );

ALTER TABLE grupo ADD CONSTRAINT grupo_letra_curso_un UNIQUE ( letra,
                                                               curso );

CREATE TABLE grupos_por_asignatura (
    curso_académico        NUMBER NOT NULL,
    oferta                 VARCHAR2(128),
    asignatura_referencia  NUMBER NOT NULL,
    grupo_id               NUMBER NOT NULL
);

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_pk PRIMARY KEY ( curso_académico,
                                                          asignatura_referencia,
                                                          grupo_id );

CREATE TABLE matricula (
    curso_academico            VARCHAR2(128) NOT NULL,
    estado                     VARCHAR2(128) NOT NULL,
    num_archivo                NUMBER,
    turno_preferente           VARCHAR2(128),
    fecha_de_matricula         DATE NOT NULL,
    nuevo_ingreso              VARCHAR2(128),
    listado_asignaturas        VARCHAR2(128),
    expediente_num_expediente  NUMBER NOT NULL
);

ALTER TABLE matricula ADD CONSTRAINT matricula_pk PRIMARY KEY ( curso_academico,
                                                                expediente_num_expediente );

CREATE TABLE optativa (
    referencia  NUMBER NOT NULL,
    plazas      NUMBER NOT NULL,
    mencion     VARCHAR2(128)
);

ALTER TABLE optativa ADD CONSTRAINT optativa_pk PRIMARY KEY ( referencia );

CREATE TABLE personal_de_secretaria (
    id     NUMBER NOT NULL,
    rango  VARCHAR2(128) NOT NULL
);

ALTER TABLE personal_de_secretaria ADD CONSTRAINT personal_de_secretaria_pk PRIMARY KEY ( id );

CREATE TABLE tc (
    titulación_código  NUMBER NOT NULL,
    centro_id          NUMBER NOT NULL
);

ALTER TABLE tc ADD CONSTRAINT tc_pk PRIMARY KEY ( titulación_código,
                                                  centro_id );

CREATE TABLE titulación (
    código    NUMBER NOT NULL,
    nombre    VARCHAR2(128) NOT NULL,
    créditos  NUMBER NOT NULL
);

ALTER TABLE titulación ADD CONSTRAINT titulación_pk PRIMARY KEY ( código );

CREATE TABLE usuario (
    id        NUMBER NOT NULL,
    telefono  NUMBER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id );

ALTER TABLE alumno
    ADD CONSTRAINT alumno_usuario_fk FOREIGN KEY ( id )
        REFERENCES usuario ( id );

ALTER TABLE asignatura
    ADD CONSTRAINT asignatura_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE asignaturas_matricula
    ADD CONSTRAINT asignaturas_matricula_matricula_fk FOREIGN KEY ( matricula_curso_academico,
                                                                    matricula_expediente_num_expediente )
        REFERENCES matricula ( curso_academico,
                               expediente_num_expediente );

ALTER TABLE clase
    ADD CONSTRAINT clase_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE e_gpa
    ADD CONSTRAINT e_gpa_encuesta_fk FOREIGN KEY ( encuesta_fecha_de_envio,
                                                   encuesta_num_expediente )
        REFERENCES encuesta ( fecha_de_envio,
                              expediente_num_expediente );

ALTER TABLE e_gpa
    ADD CONSTRAINT e_gpa_grupos_por_asignatura_fk FOREIGN KEY ( grupos_por_asignatura_curso_académico,
                                                                grupos_por_asignatura_asignatura_referencia,
                                                                grupos_por_asignatura_id )
        REFERENCES grupos_por_asignatura ( curso_académico,
                                           asignatura_referencia,
                                           grupo_id );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_expediente_fk FOREIGN KEY ( expediente_num_expediente )
        REFERENCES expediente ( num_expediente );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE expediente
    ADD CONSTRAINT expediente_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_asignatura_fk FOREIGN KEY ( asignatura_referencia )
        REFERENCES asignatura ( referencia );

ALTER TABLE grupos_por_asignatura
    ADD CONSTRAINT grupos_por_asignatura_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE matricula
    ADD CONSTRAINT matricula_expediente_fk FOREIGN KEY ( expediente_num_expediente )
        REFERENCES expediente ( num_expediente );

ALTER TABLE optativa
    ADD CONSTRAINT optativa_asignatura_fk FOREIGN KEY ( referencia )
        REFERENCES asignatura ( referencia );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE personal_de_secretaria
    ADD CONSTRAINT personal_de_secretaria_usuario_fk FOREIGN KEY ( id )
        REFERENCES usuario ( id );

ALTER TABLE tc
    ADD CONSTRAINT tc_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

ALTER TABLE tc
    ADD CONSTRAINT tc_titulación_fk FOREIGN KEY ( titulación_código )
        REFERENCES titulación ( código );

--  ERROR: No Discriminator Column found in Arc FKArc_2 - constraint trigger for Arc cannot be generated 

--  ERROR: No Discriminator Column found in Arc FKArc_2 - constraint trigger for Arc cannot be generated



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            16
-- CREATE INDEX                             0
-- ALTER TABLE                             40
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   9
-- WARNINGS                                 0
