
create sequence sec_departamento;
CREATE TABLE departamento(
    id_departamento INT default nextval('sec_departamento'),
    nombre_departamento VARCHAR(50) NOT NULL,
    num_candidatos INT,
    CONSTRAINT pk_departamento PRIMARY KEY (id_departamento)
);

create sequence sec_municipio;
CREATE TABLE municipio (
    id_municipio INT default nextval('sec_municipio'),
    id_departamento INT NOT NULL,
    nombre_municipio VARCHAR(50) NOT NULL,
    CONSTRAINT pk_municipio PRIMARY KEY (id_municipio)
);

create sequence sec_centrovotacion;
CREATE TABLE centroVotacion (
    id_centro_votacion INT default nextval('sec_centrovotacion'),
    id_municipio INT NOT NULL,
    direccion_especifica VARCHAR(60) NOT NULL,
    num_dui VARCHAR(10) NOT NULL UNIQUE,/*dui del encargado del centro de votacion*/
    nombre_centro VARCHAR(50) NOT NULL,
    num_jrv_disponibles INT NOT NULL,
    CONSTRAINT pk_centroVotacion PRIMARY KEY (id_centro_votacion)
);

create sequence sec_tipousuario;
CREATE TABLE tipoUsuario (
    id_tipo_usuario INT default nextval('sec_tipousuario'),
    tipo_usuario VARCHAR(30) NOT NULL,
    CONSTRAINT pk_tipoUsuario PRIMARY KEY (id_tipo_usuario)
);

create sequence sec_pregunta;
CREATE TABLE pregunta (
    id_pregunta INT default nextval('sec_pregunta'),
    pregunta VARCHAR(60) NOT NULL,
    CONSTRAINT pk_pregunta PRIMARY KEY (id_pregunta)
);

CREATE TABLE padronElectoral (
    num_dui VARCHAR(10) NOT NULL UNIQUE,
    nombre VARCHAR(60) NOT NULL,
    apellido VARCHAR(60) NOT NULL,
    fecha_nac date NOT NULL,
    sexo VARCHAR(2) NOT NULL,
    direccion_especifica VARCHAR(80) NOT NULL,
    id_municipio INT NOT NULL,
    CONSTRAINT pk_padron PRIMARY KEY (num_dui)
);

create sequence sec_usuario;
CREATE TABLE usuario (
    id_usuario INT default nextval('sec_usuario'),
    id_tipo_usuario INT NOT NULL,
    contrasenia VARCHAR(15) NOT NULL,
    confirmacion INT NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);

CREATE TABLE usuarioPadron (
    id_usuario INT NOT NULL,
    num_dui VARCHAR(10) NOT NULL UNIQUE,
    CONSTRAINT pk_usuarioPadron PRIMARY KEY (id_usuario)
);

CREATE TABLE infoSupExt (
    id_usuario INT NOT NULL,
    identificacion VARCHAR(15) NOT NULL UNIQUE,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    sexo VARCHAR(2) NOT NULL,
    pais VARCHAR(15) NOT NULL,
    organizacion VARCHAR(15),
    CONSTRAINT pk_infoSupExt PRIMARY KEY (id_usuario)
);

CREATE TABLE respuesta (
    id_usuario INT NOT NULL,
    id_pregunta INT NOT NULL,
    respuesta VARCHAR(25) NOT NULL,
    CONSTRAINT pk_respuesta PRIMARY KEY (id_usuario)
);

CREATE TABLE excepcionUsuario (
    id_usuario INT NOT NULL,
    num_dui VARCHAR(10) NOT NULL UNIQUE,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    fecha_nac VARCHAR(10) NOT NULL,
    sexo VARCHAR(2) NOT NULL,
    direccion_especifica VARCHAR(60) NOT NULL,
    id_municipio INT NOT NULL,
    CONSTRAINT pk_excepcionUsuario PRIMARY KEY (id_usuario)
);

create sequence sec_partido;
CREATE TABLE partido (
    id_partido INT default nextval('sec_partido'),
    nombre VARCHAR(60) NOT NULL,
    acronimo VARCHAR(10) NOT NULL,
    num_dui VARCHAR(10) NOT NULL UNIQUE,/*dui del presidente del partido*/
    imagen VARCHAR(60) NOT NULL,
    CONSTRAINT pk_partido PRIMARY KEY (id_partido)
);


create sequence sec_candidato;
CREATE TABLE candidato (
    id_candidato INT default nextval('sec_candidato'),
    num_dui VARCHAR(10) NOT NULL UNIQUE,
    foto VARCHAR(60) NOT NULL,
    id_departamento int not null,
    tipo INT NOT NULL,/*existen dos tipos de candidatos 1 es afiliado a partdio y 2 es independiente*/
    /*id_partido int not null,  este campo fue eliminado, en lugar cree la tabla detallePartido*/ 
    CONSTRAINT pk_candidato PRIMARY KEY (id_candidato)
);

create table detallePartido(
    id_candidato int not null,
    id_partido int not null,
    constraint pk_detalleCandidato primary key (id_candidato)
);
create sequence sec_jrv;
CREATE TABLE JRV (
    id_jrv INT default nextval('sec_jrv'),
    id_centro_votacion INT NOT NULL,
    correlativo_jrv VARCHAR(10) NOT NULL UNIQUE,
    CONSTRAINT pk_jrv PRIMARY KEY (id_jrv)
);

create sequence sec_cargodirectiva;
CREATE TABLE cargoDirectiva (
    id_cargo_directiva INT default nextval('sec_cargodirectiva'),
    cargo VARCHAR(20) NOT NULL,
    CONSTRAINT pk_cargoDirectiva PRIMARY KEY (id_cargo_directiva)
);

CREATE TABLE directivaJRV (
    num_dui VARCHAR(10) NOT NULL,
    id_jrv INT NOT NULL,
    id_partido INT NOT NULL,
    id_cargo_directiva INT NOT NULL,
    tipo INT NOT NULL,/*existen dos tipos de miembro 1 es propietario 2 es suplente*/
    CONSTRAINT pk_directivaJRV PRIMARY KEY (num_dui)
);

CREATE TABLE aperturaJRV(
    id_jrv INT,
    fecha VARCHAR(10) NOT NULL,
    hora varchar(8) not null,
    CONSTRAINT pk_aperturaJRV PRIMARY KEY (id_jrv)
);

CREATE TABLE cierreJRV(
    id_jrv INT,
    fecha VARCHAR(10) NOT NULL,
    hora varchar(8) not null,
    CONSTRAINT pk_cierreJRV PRIMARY KEY (id_jrv)
);

CREATE TABLE votantePorJRV (
    num_dui VARCHAR(10) NOT NULL,
    id_jrv INT NOT NULL,
    estado INT NOT NULL, /*es para verificar si el votante asistio a votar 0 es que no y 1 es que si*/
    CONSTRAINT pk_votantePorJRV PRIMARY KEY (num_dui)
);


create sequence sec_voto;
CREATE TABLE voto (
    id_voto INT default nextval('sec_voto'),
    id_jrv INT NOT NULL,
    CONSTRAINT pk_voto PRIMARY KEY (id_voto)
);

create sequence sec_votoabstenido;
CREATE TABLE votoAbstenido (
    id_voto_abstenido INT default nextval('sec_votoabstenido'),
    id_voto INT NOT NULL UNIQUE,
    CONSTRAINT pk_votoAbstenido PRIMARY KEY (id_voto_abstenido)
);

create sequence sec_votobandera;
CREATE TABLE votoBandera (
    id_voto_bandera INT default nextval('sec_votobandera'),
    id_voto INT NOT NULL UNIQUE,
    id_partido INT NOT NULL,
    CONSTRAINT pk_votoBandera PRIMARY KEY (id_voto_bandera)
);

create sequence sec_votomarca;
CREATE TABLE votoMarca (
    id_voto_marca INT default nextval('sec_votomarca'),
    id_voto INT NOT NULL,
    id_candidato INT NOT NULL,
    valor_porcentual decimal(10,2) NOT NULL,
    CONSTRAINT pk_votoMarca PRIMARY KEY (id_voto_marca)
);

create sequence sec_votoindependiente;
CREATE TABLE votoIndependiente (
    id_voto_independiente INT default nextval('sec_votoindependiente'),
    id_voto INT NOT NULL,
    id_candidato INT NOT NULL,
    valor_porcentual decimal(10,2) NOT NULL,
    CONSTRAINT pk_votoIndependiente PRIMARY KEY (id_voto_independiente)
);

/*tablas agregadas por carlos*/
CREATE TABLE credencialTemporal (
    id_usuario int,
    num_dui varchar(10) UNIQUE not null,
    CONSTRAINT pk_credencialTemporal PRIMARY KEY (id_usuario)
);

create sequence sec_bitacoraacciones;
CREATE TABLE bitacoraAcciones (
    id_bitacora int default nextval('sec_bitacoraacciones'),
    fecha VARCHAR(10) not null,  				
    hora varchar(8) not null,
    accion varchar(60) not null,
    CONSTRAINT pk_bitacoraAcciones PRIMARY KEY (id_bitacora)
);

CREATE TABLE detalleBitacora (
    id_bitacora int,
    num_dui varchar(10) not null
);


/*tabla agregada en el segundo sprint*/
create sequence sec_observacion;
CREATE TABLE observacion (
    id_observacion int default nextval('sec_observacion'),
	id_usuario int,
	observacion varchar(240) not null,
    constraint pk_observacion primary key (id_observacion)
);

/*tabla agregada para el 3er sprint*/

alter table usuario add constraint fk_usuario_tipo foreign key (id_tipo_usuario) references tipoUsuario(id_tipo_usuario);
alter table respuesta add constraint fk_respuesta_pregunta foreign key (id_pregunta) references pregunta(id_pregunta);

alter table directivaJRV add constraint fk_directivaJRV_jrv foreign key (id_jrv) references JRV(id_jrv);
alter table votantePorJRV add constraint fk_votantePorJRV_jrv foreign key (id_jrv) references JRV(id_jrv);
alter table voto add constraint fk_voto_JRV foreign key (id_jrv) references JRV(id_jrv);

alter table excepcionUsuario add constraint fk_excepcionUsuario_municipio foreign key (id_municipio) references municipio(id_municipio);
alter table centroVotacion add constraint fk_centro_municipio foreign key (id_municipio) references municipio(id_municipio);
alter table padronElectoral add constraint fk_padronElectoral_municipio foreign key (id_municipio) references municipio(id_municipio);

alter table votoMarca add constraint fk_vMarca_voto foreign key (id_voto) references voto(id_voto);
alter table votoBandera add constraint fk_vBandera_voto foreign key (id_voto) references voto(id_voto);
alter table votoAbstenido add constraint fk_vAbstenido_voto foreign key (id_voto) references voto(id_voto);
alter table votoIndependiente add constraint fk_vIndependiente_voto foreign key (id_voto) references voto(id_voto);

alter table respuesta add constraint fk_respuesta_usuario foreign key (id_usuario) references usuario(id_usuario);
alter table infoSupExt add constraint fk_infoSupExt_usuario foreign key (id_usuario) references usuario(id_usuario);
alter table usuarioPadron add constraint fk_usuarioPadron_usuario foreign key (id_usuario) references usuario(id_usuario);
alter table excepcionUsuario add constraint fk_excepcionUsuario_usuario foreign key (id_usuario) references usuario(id_usuario);

alter table usuarioPadron add constraint fk_usuarioPadron_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);
alter table centroVotacion add constraint fk_centroVotacion_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);
alter table partido add constraint fk_partido_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);
alter table directivaJRV add constraint fk_directivaJRV_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);
alter table candidato add constraint fk_candidato_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);
alter table votantePorJRV add constraint fk_votantePorJRV_padronElectoral foreign key (num_dui) references padronElectoral(num_dui);

alter table municipio add constraint fk_municipio_departamento foreign key (id_departamento) references departamento(id_departamento);

alter table JRV add constraint fk_JRV_centroVotacion foreign key (id_centro_votacion) references centroVotacion(id_centro_votacion);

/* alter table candidato add constraint fk_candidato_partido foreign key(id_partido) references partido(id_partido); */
/*modificacion - Octubre 31 -- 2016 */
alter table detallePartido add constraint fk_detallePartido_candidato foreign key(id_candidato) references candidato(id_candidato);
alter table detallePartido add constraint fk_detallePartido_partido foreign key(id_partido) references partido(id_partido);
/*fin de modificacion*/

alter table directivaJRV add constraint fk_directivaJRV_partido foreign key (id_partido) references partido(id_partido);

alter table votoMarca add constraint fk_vMarca_candidato foreign key (id_candidato) references candidato(id_candidato);
alter table votoIndependiente add constraint fk_vIndependiente_candidato foreign key (id_candidato) references candidato(id_candidato);

alter table directivaJRV add constraint fk_directivaJRV_cargoDirectiva foreign key (id_cargo_directiva) references cargoDirectiva(id_cargo_directiva);

alter table votoBandera add constraint fk_vBandera_partido foreign key (id_partido) references partido(id_partido);

/*
alter table partido add constraint fk_partido_excepcionUsuario foreign key (num_dui) references excepcionUsuario(num_dui);
*/

alter table aperturaJRV add constraint fk_aperturaJRV_jrv foreign key (id_jrv) references jrv(id_jrv);
alter table cierreJRV add constraint fk_cierreJRV_jrv foreign key (id_jrv) references jrv(id_jrv);

/*claves foraneas agregadas por carlos*/
alter table credencialTemporal add constraint fk_credencialTemporal_usuario foreign key (id_usuario) references usuario(id_usuario);
alter table detalleBitacora add constraint fk_detalleBitacora_bitacoraAcciones foreign key (id_bitacora) references bitacoraAcciones(id_bitacora);
alter table detalleBitacora add constraint fk_detalleBitacora_credencialTemporal foreign key (num_dui) references credencialTemporal(num_dui);
/**clave foranea agregada en el segundo sprint*/
alter table observacion add constraint fk_observacion_infosupext foreign key (id_usuario) references infosupext(id_usuario);
alter table candidato add constraint fk_candidato_departament foreign key (id_departamento) references departamento(id_departamento);

/*-----------------INSERCION DE REGISTROS DE PRUEBA----------------------*/
/** insercion departamento by roberto*/
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Ahuachapan', 4);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Santa Ana', 7);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Sonsonate', 6);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Chalatenango',3);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Cuscatlan', 3);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('San Salvador', 24);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('La Libertad', 10);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('San Vicente', 3);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Cabañas', 3);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('La Paz', 4);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Usulutan', 5);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('San Miguel', 6);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('Morazan', 3);
INSERT INTO departamento(nombre_departamento, num_candidatos) VALUES ('La Union', 3);

/**insercion municipio por departamento by roberto*/

/**Ahuachapan */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Ahuachapan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Apaneca');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Atiquizaya');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Concepcion de Ataco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'El Refugio');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Guaymango');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Jujutla');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'San Francisco Menendez');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'San Lorenzo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'San Pedro Puxtla');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Tacuba');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('1', 'Turin');

/**Santa ana */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Candelaria de la Frontera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Chalchuapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Coatepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'El Congo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'El Porvenir');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Masahuat');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Metapan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'San Antonio Pajonal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'San Sebastián Salitrillo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Santa Ana');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Santa Rosa Guachipilin');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Santiago de la Frontera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('2', 'Texistepeque');

/**Sonsonate */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Acajutla');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Armenia');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Caluco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Cuisnahuat');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Izalco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Juayua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Nahuizalco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Nahulingo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Salcoatitan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'San Antonio del Monte');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'San Julián');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Santa Catarina Masahuat');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Santa Isabel Ishuatán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Santo Domingo Guzman');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Sonsonate');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('3', 'Sonzacate');

/**Chalatenango */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Agua Caliente');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Arcatao');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Azacualpa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Chalatenango (ciudad)');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Comalapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Citala');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Concepción Quezaltepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Dulce Nombre de Maria');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'El Carrizal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'El Paraiso');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'La Laguna');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'La Palma');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'La Reina');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Las Vueltas');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Nueva Concepcion');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Nueva Trinidad');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Nombre de Jesus');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Ojos de Agua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Potonico');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Antonio de la Cruz');/*20*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Antonio Los Ranchos');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Fernando');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Francisco Lempa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Francisco Morazan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Ignacio');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Isidro Labrador');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Jose Cancasque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Jose Las Flores');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Luis del Carmen');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Miguel de Mercedes');/*30*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'San Rafael');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Santa Rita');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('4', 'Tejutla');

/**Cuscatlan */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Candelaria');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Cojutepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'El Carmen');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'El Rosario');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Monte San Juan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Oratorio de Concepcion');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San Bartolome Perulapia');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San Cristobal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San José Guayabal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San Pedro Perulapan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San Rafael Cedros');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'San Ramon');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Santa Cruz Analquito');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Santa Cruz Michapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Suchitoto');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('5', 'Tenancingo');

/**San salvador */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Aguilares');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Apopa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Ayutuxtepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Cuscatancingo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Ciudad Delgado');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'El Paisnal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Guazapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Ilopango');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Mejicanos');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Nejapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Panchimalco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Rosario de Mora');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'San Marcos');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'San Martín');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'San Salvador');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Santiago Texacuangos');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Santo Tomas');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Soyapango');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('6', 'Tonacatepeque');

/**La libertad */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Antiguo Cuscatlán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Chiltiupan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Ciudad Arce');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Colon');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Comasagua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Huizúcar');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Jayaque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Jicalapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'La Libertad');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Nueva San Salvador (Santa Tecla)');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Nuevo Cuscatlán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'San Juan Opico');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Quezaltepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Sacacoyo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'San José Villanueva');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'San Matías');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'San Pablo Tacachico');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Talnique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Tamanique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Teotepeque');/*20*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Tepecoyo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('7', 'Zaragoza');

/**San vicente */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Apastepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Guadalupe');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Cayetano Istepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Esteban Catarina');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Ildefonso');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Lorenzo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Sebastián');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'San Vicente');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Santa Clara');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Santo Domingo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Tecoluca');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Tepetitán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('8', 'Verapaz');

/**cabañas */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Cinquera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Dolores');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Guacotecti');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Ilobasco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Jutiapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'San Isidro');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Sensuntepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Tejutepeque');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('9', 'Victoria');

/**La paz */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Cuyultitán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'El Rosario');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Jerusalén');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Mercedes La Ceiba');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Olocuilta');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Paraíso de Osorio');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Antonio Masahuat');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Emigdio');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Francisco Chinameca');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Juan Nonualco');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Juan Talpa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Juan Tepezontes');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Luis Talpa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Luis La Herradura');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Miguel Tepezontes');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Pedro Masahuat');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Pedro Nonualco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'San Rafael Obrajuelo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Santa María Ostuma');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Santiago Nonualco');/*20*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Tapalhuaca');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('10', 'Zacatecoluca');

/**usulutan */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Alegría');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Berlín');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'California');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Concepción Batres');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'El Triunfo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Ereguayquín');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Estanzuelas');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Jiquilisco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Jucuapa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Jucuarán');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Mercedes Umaña');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Nueva Granada');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Ozatlán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Puerto El Triunfo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'San Agustín');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'San Buenaventura');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'San Dionisio');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'San Francisco Javier');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Santa Elena');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Santa María');/*20*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Santiago de María');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Tecapán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('11', 'Usulután');

/**San miguel */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Carolina');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Chapeltique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Chinameca');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Chirilagua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Ciudad Barrios');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Comacarán');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'El Tránsito');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Lolotique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Moncagua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Nueva Guadalupe');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Nuevo Edén de San Juan');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Quelepa');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Antonio del Mosco');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Gerardo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Jorge');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Luis de la Reina');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Miguel');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'San Rafael Oriente');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Sesori');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('12', 'Uluazapa');/*20*/

/**Morazan */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Arambala');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Cacaopera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Chilanga');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Corinto');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Delicias de Concepción');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'El Divisadero');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'El Rosario');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Gualococti');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Guatajiagua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Joateca');/*10*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Jocoaitique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Jocoro');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Lolotiquillo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Meanguera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Osicala');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Perquín');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'San Carlos');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'San Fernando');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'San Francisco Gotera');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'San Isidro');/*20*/
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'San Simón');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Sensembra');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Sociedad');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Torola');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Yamabal');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('13', 'Yoloaiquín');

/**La union */
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Anamorós');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Bolivar');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Concepción de Oriente');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Conchagua');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'El Carmen');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'El Sauce');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Intipucá');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'La Unión');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Lislique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Meanguera del Golfo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Nueva Esparta');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Pasaquina');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Polorós');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'San Alejo');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'San José');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Santa Rosa de Lima');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Yayantique');
INSERT INTO municipio (id_departamento , nombre_municipio) VALUES ('14', 'Yucuaiquín');


insert into tipousuario (tipo_usuario ) values ('Administrador');   
insert into tipousuario (tipo_usuario ) values ('Magistrado');  
insert into tipousuario (tipo_usuario ) values ('Representante CNR');
insert into tipousuario (tipo_usuario ) values ('Supervisor externo');
insert into tipousuario (tipo_usuario ) values ('Representante de Partido');
insert into tipousuario (tipo_usuario ) values ('Director TSE');
insert into tipousuario (tipo_usuario ) values ('Gestor JRV');
insert into tipousuario (tipo_usuario ) values ('Director centro de votacion');
insert into tipousuario (tipo_usuario ) values ('Publicista');  
insert into tipousuario (tipo_usuario ) values ('Presidente JRV');
insert into tipousuario (tipo_usuario ) values ('Votante'); 

insert into pregunta (pregunta) values ('¿Cual es tu cancion favorita?');
insert into pregunta (pregunta) values ('¿Cuantos hermanos tienes?');
insert into pregunta (pregunta) values ('¿Cual es tu materia favorita?');
insert into pregunta (pregunta) values ('¿Como se llama tu mejor amig@?');
insert into pregunta (pregunta) values ('¿Cual es el nombre de tu profesor favorito?');
insert into pregunta (pregunta) values ('¿Cual el tu libro favorito?');
insert into pregunta (pregunta) values ('¿Que haces en tu tiempo libre?');

insert into cargodirectiva (cargo) values('Presidente');
insert into cargodirectiva (cargo) values('Vice Presidente');
insert into cargodirectiva (cargo) values('Secretario');
insert into cargodirectiva (cargo) values('Vocal');

