	/* SQLEditor (MySQL (2))*/

	DROP DATABASE conectel;

	CREATE DATABASE conectel;

	USE conectel;

	CREATE TABLE Seguimiento
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Pantalla
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	pantalla VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Aplica
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoColaborador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARBINARY(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosComerciales
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	condiciones_comerciales VARCHAR(255),
	no_vendor VARBINARY(255),
	ejecutivo_cuenta VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE Proyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_categoria_proyecto INT(11) UNSIGNED NOT NULL,
	id_producto INT(11) UNSIGNED NOT NULL,
	central_sitio VARCHAR(255),
	id_estato INT(11) UNSIGNED NOT NULL,
	fecha_captura INTEGER,
	PRIMARY KEY (id)
	);

	CREATE TABLE Usuario
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	usuario VARCHAR(40) NOT NULL,
	contrasena VARCHAR(40) NOT NULL,
	nombre_completo VARCHAR(100),
	fk_perfil INT(11) UNSIGNED NOT NULL,
	activo TINYINT(1) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoProyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Parametro
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	parametro VARBINARY(255) NOT NULL,
	valor VARBINARY(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoEntregable
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARBINARY(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE CategoriaProyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	categoria VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Cliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_contacto INT(11) UNSIGNED NOT NULL,
	id_datos INT(11) UNSIGNED NOT NULL,
	nombre_comercial VARBINARY(255),
	razon_social VARCHAR(255),
	rfc VARCHAR(20),
	domiciio_fiscal VARBINARY(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE Producto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_cliente INT(11) UNSIGNED NOT NULL,
	tipo_proyecto VARCHAR(255),
	teconologia VARCHAR(255),
	equipo VARCHAR(255),
	actividad_realizar VARCHAR(255),
	modelo VARCHAR(255),
	descripcion_servicio VARCHAR(255),
	tipo_servicio VARCHAR(255),
	costo DECIMAL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Contacto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	nombre_completo VARCHAR(255),
	correo_electronico VARCHAR(255),
	telefono VARBINARY(255),
	pagina_web VARCHAR(255),
	localidad VARCHAR(255),
	estado VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE Imputable
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Observacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	requisicion VARCHAR(255) NOT NULL,
	id_proyecto INT(11) UNSIGNED NOT NULL,
	id_imputable INT(11) UNSIGNED NOT NULL,
	fecha_captura DATE NOT NULL,
	usuario INT(11) UNSIGNED NOT NULL,
	id_estado_proyecto INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Perfil
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	perfil VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Entregable
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_tipo_entregable INT(11) UNSIGNED NOT NULL,
	nombre_archivo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Requisicion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	requisicion VARCHAR(50) NOT NULL,
	id_proyecto INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PerfilPantalla
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_perfil INT(11) UNSIGNED NOT NULL,
	id_pantalla INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ConfiguracionPruebaEntrega
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_proyecto INT(11) UNSIGNED NOT NULL,
	comisionado VARCHAR(255),
	puertos_entregados VARCHAR(255),
	alineacion VARCHAR(255),
	slot_entregado VARCHAR(255),
	tarjetas_entregadas VARCHAR(255),
	clave_aceptacion VARCHAR(255),
	fecha_entrega DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Colaborador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	nombre_completo VARCHAR(255) NOT NULL,
	id_tipo_colaborador INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosGeneralesProyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_proyecto INT(11) UNSIGNED,
	division_region VARCHAR(100),
	area_goa VARCHAR(100),
	cliente_final VARCHAR(255),
	cliente_id VARCHAR(100),
	nodo_id VARCHAR(100),
	grafo VARCHAR(255),
	pedido_cliente VARCHAR(255),
	elemento_pep VARCHAR(255),
	responsable_cliente VARCHAR(255),
	semana VARCHAR(255),
	fecha_asignacion_cliente DATE,
	fecha_inicio_programada DATE,
	fecha_termino_programada DATE,
	id_responsable_conectel INT(11) UNSIGNED,
	id_responsable_implementacion INT(11) UNSIGNED,
	id_material INT(11) UNSIGNED,
	id_herramienta INT(11) NOT NULL,
	id_equipo INT(11) NOT NULL,
	id_unidad INT(11) NOT NULL,
	id_viaticos INT(11) NOT NULL,
	fecha_inicio_real DATE,
	fecha_termino_real DATE,
	site_survey VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosGeneralesProyectoImplementacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_datos_generales INT(11) UNSIGNED NOT NULL,
	id_colaborador INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ProyectoEntregable
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_proyecto INT(11) UNSIGNED NOT NULL,
	id_entregable INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DesarrolloProyectoAyB
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	id_proyecto INT(11) UNSIGNED NOT NULL,
	bastidor_gabinete VARCHAR(255),
	repisa VARCHAR(255),
	version VARCHAR(255),
	controladora VARCHAR(255),
	tarjeta_1 VARCHAR(255),
	tarjeta_2 VARCHAR(255),
	tarjeta_3 VARCHAR(255),
	tarjeta_4 VARCHAR(255),
	tarjeta_5 VARCHAR(255),
	tarjeta_6 VARCHAR(255),
	puertos_ot VARCHAR(255),
	no_cables VARCHAR(255),
	no_pares VARCHAR(255),
	no_puertos VARCHAR(255),
	slots_cables VARCHAR(255),
	longitud_cable VARCHAR(255),
	champeado VARCHAR(255),
	timbrado VARCHAR(255),
	aterrizaje VARCHAR(255),
	alimentacion VARCHAR(255),
	pares_fo VARCHAR(255),
	cableado VARCHAR(255),
	rotulo VARCHAR(255),
	id_soportes INT(11) UNSIGNED,
	id_antena INT(11) UNSIGNED,
	id_radio INT(11) UNSIGNED,
	id_radio_cable INT UNSIGNED,
	id_aterrizaje_seguimiento INT(11) UNSIGNED,
	id_alimentacion_seguimiento INT(11) UNSIGNED,
	id_fibra_cliente_final INT(11) UNSIGNED,
	id_plancha_base INT(11),
	PRIMARY KEY (id)
	);

	ALTER TABLE Cliente ADD FOREIGN KEY id_contacto_idxfk (id_contacto) REFERENCES Contacto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_categoria_proyecto_idxfk (id_categoria_proyecto) REFERENCES CategoriaProyecto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_producto_idxfk (id_producto) REFERENCES Producto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_estato_idxfk (id_estato) REFERENCES EstadoProyecto (id);

	ALTER TABLE Usuario ADD FOREIGN KEY fk_perfil_idxfk (fk_perfil) REFERENCES Perfil (id);

	ALTER TABLE Producto ADD FOREIGN KEY id_cliente_idxfk_1 (id_cliente) REFERENCES Cliente (id);

	ALTER TABLE Cliente ADD FOREIGN KEY id_datos_idxfk (id_datos) REFERENCES DatosComerciales (id);

	ALTER TABLE Observacion ADD FOREIGN KEY id_proyecto_idxfk (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE Observacion ADD FOREIGN KEY id_imputable_idxfk (id_imputable) REFERENCES Imputable (id);

	ALTER TABLE Observacion ADD FOREIGN KEY usuario_idxfk (usuario) REFERENCES Usuario (id);

	ALTER TABLE Observacion ADD FOREIGN KEY id_estado_proyecto_idxfk (id_estado_proyecto) REFERENCES EstadoProyecto (id);

	ALTER TABLE Entregable ADD FOREIGN KEY id_tipo_entregable_idxfk (id_tipo_entregable) REFERENCES TipoEntregable (id);

	ALTER TABLE Requisicion ADD FOREIGN KEY id_proyecto_idxfk_1 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE PerfilPantalla ADD FOREIGN KEY id_perfil_idxfk (id_perfil) REFERENCES Perfil (id);

	ALTER TABLE PerfilPantalla ADD FOREIGN KEY id_pantalla_idxfk (id_pantalla) REFERENCES Pantalla (id);

	ALTER TABLE ConfiguracionPruebaEntrega ADD FOREIGN KEY id_proyecto_idxfk_2 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE Colaborador ADD FOREIGN KEY id_tipo_colaborador_idxfk (id_tipo_colaborador) REFERENCES TipoColaborador (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_proyecto_idxfk_3 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_responsable_conectel_idxfk (id_responsable_conectel) REFERENCES Colaborador (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_responsable_implementacion_idxfk (id_responsable_implementacion) REFERENCES Colaborador (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_material_idxfk (id_material) REFERENCES Aplica (id);

	ALTER TABLE DatosGeneralesProyectoImplementacion ADD FOREIGN KEY id_datos_generales_idxfk (id_datos_generales) REFERENCES DatosGeneralesProyecto (id);

	ALTER TABLE DatosGeneralesProyectoImplementacion ADD FOREIGN KEY id_colaborador_idxfk (id_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE ProyectoEntregable ADD FOREIGN KEY id_proyecto_idxfk_4 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE ProyectoEntregable ADD FOREIGN KEY id_entregable_idxfk (id_entregable) REFERENCES Entregable (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_proyecto_idxfk_5 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_soportes_idxfk (id_soportes) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_antena_idxfk (id_antena) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_radio_idxfk (id_radio) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_radio_cable_idxfk (id_radio_cable) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_aterrizaje_seguimiento_idxfk (id_aterrizaje_seguimiento) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_alimentacion_seguimiento_idxfk (id_alimentacion_seguimiento) REFERENCES Seguimiento (id);

	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY id_fibra_cliente_final_idxfk (id_fibra_cliente_final) REFERENCES Seguimiento (id);


	/* Perfiles */
	INSERT INTO Perfil
	VALUES (1, 'Director General');
	INSERT INTO Perfil
	VALUES (2, 'Administrador de Catálogos');
	INSERT INTO Perfil
	VALUES (3, 'Almacén');
	INSERT INTO Perfil
	VALUES (4, 'Recursos Humanos');
	INSERT INTO Perfil
	VALUES (5, 'Gerente Operativo');
	INSERT INTO Perfil
	VALUES (6, 'Coordinador Operativo');

	/* Pantallas */
	INSERT INTO Pantalla
	VALUES (1, 'Clientes');
	INSERT INTO Pantalla
	VALUES (2, 'Proyectos');
	INSERT INTO Pantalla
	VALUES (3, 'Productos');
	INSERT INTO Pantalla
	VALUES (4, 'Usuarios');
	INSERT INTO Pantalla
	VALUES (5, 'DatosGenerales');
	INSERT INTO Pantalla
	VALUES (6, 'DesarrolloProyectoAB');
	INSERT INTO Pantalla
	VALUES (7, 'ConfiguracionPruebaEntrega');
	INSERT INTO Pantalla
	VALUES (8, 'Notificaciones');

	/* Perfil-Pantalla */
	INSERT INTO PerfilPantalla
	VALUES (1, 1, 1);
	INSERT INTO PerfilPantalla
	VALUES (2, 1, 2);
	INSERT INTO PerfilPantalla
	VALUES (3, 1, 3);
	INSERT INTO PerfilPantalla
	VALUES (4, 1, 4);
	INSERT INTO PerfilPantalla
	VALUES (5, 1, 5);
	INSERT INTO PerfilPantalla
	VALUES (6, 1, 6);
	INSERT INTO PerfilPantalla
	VALUES (7, 1, 7);
	INSERT INTO PerfilPantalla
	VALUES (8, 1, 8);
	INSERT INTO PerfilPantalla
	VALUES (9, 2, 1);
	INSERT INTO PerfilPantalla
	VALUES (10, 2, 3);
	INSERT INTO PerfilPantalla
	VALUES (11, 5, 2);
	INSERT INTO PerfilPantalla
	VALUES (12, 6, 5);
	INSERT INTO PerfilPantalla
	VALUES (13, 6, 6);
	INSERT INTO PerfilPantalla
	VALUES (14, 6, 7);
	
	/* Usuarios */
	INSERT INTO Usuario
	VALUES (1, 'DIRECTOR', 'NOTIENE', 'DIRECTOR GENERAL', 1, 1);
	INSERT INTO Usuario
	VALUES (2, 'CATALOGOS', 'NOTIENE', 'ADMINISTRADOR DE CATALOGOS', 2, 1);
	INSERT INTO Usuario
	VALUES (3, 'ALMACEN', 'NOTIENE', 'ALMACÉN', 3, 1);
	INSERT INTO Usuario
	VALUES (4, 'RECURSOS', 'NOTIENE', 'RECURSOS HUMANOS', 4, 1);
	INSERT INTO Usuario
	VALUES (5, 'GERENTE', 'NOTIENE', 'GERENTE OPERATIVO', 5, 1);
	INSERT INTO Usuario
	VALUES (6, 'COORDINADOR', 'NOTIENE', 'COORDINADOR OPERATIVO', 6, 1);
	
	/* Categoria Proyecto */
	INSERT INTO CategoriaProyecto
	VALUES (1, 'Acceso');
	INSERT INTO CategoriaProyecto
	VALUES (2, 'Transmisión');
	
	/* Imputable */
	INSERT INTO Imputable
	VALUES (1, 'Conectel');
	INSERT INTO Imputable
	VALUES (2, 'Cliente Directo');
	INSERT INTO Imputable
	VALUES (3, 'Cliente Final');
	
	/* Tipo Colaborador */
	INSERT INTO TipoColaborador
	VALUES (1, 'Proveedores');
	INSERT INTO TipoColaborador
	VALUES (2, 'Nómina');
	INSERT INTO TipoColaborador
	VALUES (3, 'Externos');
	
	/* Colaborador */
	INSERT INTO Colaborador
	VALUES (1, 'JOSÉ ANTONIO CRUZ', 2);
	INSERT INTO Colaborador
	VALUES (2, 'ANTONIO RAVIZE', 1);
	INSERT INTO Colaborador
	VALUES (3, 'FRANCISCO TAPIA', 2);
	INSERT INTO Colaborador
	VALUES (4, 'GUSTAVO RÍOS', 3);