	/* SQLEditor (MySQL (2))*/

	DROP DATABASE conectel;

	CREATE DATABASE conectel DEFAULT CHARACTER SET latin1;

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
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosComerciales
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	condiciones_comerciales VARCHAR(255),
	no_vendor VARCHAR(255),
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
	fecha_captura DATE NOT NULL,
	fk_estado_solicitud_servicio_maquilado INT(11) UNSIGNED,
	clave_auditoria VARCHAR(255),
	fk_tipo_auditoria INT(11) UNSIGNED,
	fk_tipo_servicio INT(11) UNSIGNED NOT NULL,
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
	parametro VARCHAR(255) NOT NULL,
	valor VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoEntregable
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL,
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
	nombre_comercial VARCHAR(255),
	razon_social VARCHAR(255),
	rfc VARCHAR(20),
	domiciio_fiscal VARCHAR(255),
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
	costo_local_cliente DECIMAL(11,2),
	costo_foraneo_cliente DECIMAL(11,2),
	costo_local_proveedor DECIMAL(11,2),
	costo_foraneo_proveedor DECIMAL(11,2),
	dias_implementacion INT(11),
	alcances VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Contacto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	nombre_completo VARCHAR(255),
	correo_electronico VARCHAR(255),
	telefono VARCHAR(255),
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
	numero_requisicion_cliente VARCHAR(255),
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
	entregables_completos BOOLEAN,
	fk_estatus_validacion_operativa INT(11) UNSIGNED,
	fecha_validacion_operativa DATE,
	cierre_coordinacion DATE,
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
	id_material INT(11) NOT NULL,
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
	estatus INT(11) UNSIGNED NOT NULL,
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
	fk_tipo_desarrollo_proyecto INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE UnidadC
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	unidad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ServicioSolicitado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	servicio_solicitado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaE
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Compania
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	compania VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaF
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE UbicacionA
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	ubicacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Prioridad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	prioridad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	fecha_solicitud DATE NOT NULL,
	motivo VARCHAR(255),
	fk_prioridad INT(11) UNSIGNED NOT NULL,
	fk_area_solicitante INT(11) UNSIGNED NOT NULL,
	central_sitio VARCHAR(255),
	fk_estado_solicitud_almacen INTEGER UNSIGNED NOT NULL,
	nombre_solicitante VARCHAR(255) NOT NULL,
	fk_autoriza INT(11) UNSIGNED NOT NULL,
	fk_entrega INT(11) UNSIGNED NOT NULL,
	recibe VARCHAR(255),
	fk_autoriza_final INT(11) UNSIGNED,
	leyenda TEXT,
	fecha_retorno DATE,
    fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Software
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	existencia DECIMAL(12,5),
	unidad VARCHAR(255),
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	licenciamiento_inicial DATE,
	licenciamiento_final DATE,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE AreaSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	area_solicitante VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoMantenimiento
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo_mantenimiento VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Herramienta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_a INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	marca VARCHAR(255),
	modelo VARCHAR(255),
	existencia DECIMAL(12,5),
	fk_unidad_a INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_a INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_a INT(11) UNSIGNED NOT NULL,
	no_certificado VARCHAR(255),
	fecha_calibracion DATE,
	fecha_proxima_calibracion DATE,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE NombreSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE UbicacionC
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	ubicacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstatusB
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstatusC
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaA
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaD
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TelefoniaMovil
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_f INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	marca VARCHAR(255),
	modelo VARCHAR(255),
	imei VARCHAR(255),
	fk_compania INT(11) UNSIGNED NOT NULL,
	no_telefono VARCHAR(255),
	tipo_plan_contratado VARCHAR(255),
	existencia DECIMAL(12,5),
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_b INT(11) UNSIGNED NOT NULL,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE UnidadB
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	unidad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EquipoTransporte
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_b INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	marca VARCHAR(255),
	modelo VARCHAR(255),
	no_placas VARCHAR(255),
	no_tarjeta_circulacion VARCHAR(255),
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_b INT(11) UNSIGNED NOT NULL,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
	costo DECIMAL(11,2),
	fk_mantenimiento_servicio INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE Material
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_c INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	existencia DECIMAL(12,5),
	fk_unidad_b INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_c INT(11) UNSIGNED NOT NULL,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE Consumible
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_d INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	existencia DECIMAL(12,5),
	fk_unidad_b INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_c INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_c INT(11) UNSIGNED NOT NULL,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaC
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE GrupoFamiliaB
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	grupo_familia VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE UbicacionB
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	ubicacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Hardware
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_e INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	marca VARCHAR(255),
	modelo VARCHAR(255),
	existencia DECIMAL(12,5),
	fk_unidad_c INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_b INT(11) UNSIGNED NOT NULL,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
	costo DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE UnidadA
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	unidad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoDocumentoAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstatusA
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Comentarios
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	almacen INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	fecha_captura DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EquipoMedicion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	grupo_familia VARCHAR(255),
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	marca VARCHAR(255),
	modelo VARCHAR(255),
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_a INT(11) UNSIGNED NOT NULL,
	no_certificado VARCHAR(255),
	fecha_calibracion DATE,
	fecha_proxima_calibracion DATE,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
	costo DECIMAL(11,2),
	fk_calibracion INT(11) UNSIGNED,
	fk_mantenimiento_servicio INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	almacen INT(11) UNSIGNED NOT NULL,
	fk_tipo_entregable INT(11) UNSIGNED NOT NULL,
	nombre_archivo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

    /* Compras */

	CREATE TABLE TipoPago
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Pago
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	pago VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoContrato
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoPersona
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Proveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_persona INT(11) UNSIGNED NOT NULL,
	nombre_comercial VARCHAR(255) NOT NULL,
	razon_social VARCHAR(255) NOT NULL,
	rfc VARCHAR(255) NOT NULL,
	direccion_fisica VARCHAR(255) NOT NULL,
	direccion_fiscal VARCHAR(255) NOT NULL,
	telefonos VARCHAR(255) NOT NULL,
	contacto VARCHAR(255),
	correo VARCHAR(255),
	pagina_web VARCHAR(255),
	type_Proveedor VARCHAR(31),
	PRIMARY KEY (id)
	);

	CREATE TABLE ProveedorSeleccionado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FormaPago
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	forma VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioCompras
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_captura DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatoBancario
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	clabe_interbancaria VARCHAR(255) NOT NULL,
	banco VARCHAR(255) NOT NULL,
	cuenta_bancaria VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ProveedorCalificado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor_seleccionado INT(11) UNSIGNED NOT NULL,
	fk_forma_pago INT(11) UNSIGNED NOT NULL,
	fk_tipo_pago INT(11) UNSIGNED NOT NULL,
	moneda VARCHAR(255),
	limite_credito DECIMAL(11,2) NOT NULL,
	dias_credito INT NOT NULL,
	descuentos DECIMAL(11,2) NOT NULL,
	fk_dato_bancario INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor_calificado INT(11) UNSIGNED NOT NULL,
	fk_comentario_compras INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ProveedorMaquilador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor INT(11) UNSIGNED NOT NULL,
	fk_pago INT(11) UNSIGNED,
	fk_dato_bancario INT(11) UNSIGNED,
	nss VARCHAR(255) NOT NULL,
	curp VARCHAR(255) NOT NULL,
	fk_categoria_proyecto INT(11) UNSIGNED,
	fk_tipo_contrato INT(11) UNSIGNED,
	vigencia_contrato VARCHAR(255),
	fecha_contrato DATE,
	fk_forma_pago_maquilador INT(11) UNSIGNED,
	fk_tecnologia INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoLiderProveedorMaquilador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor_maquilador INT(11) UNSIGNED NOT NULL,
	documento VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Ayudante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	nombre VARCHAR(255) NOT NULL,
	rfc VARCHAR(255) NULL,
	curp VARCHAR(255) NULL,
	nss VARCHAR(255) NULL,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoAyudante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_ayudante INT(11) UNSIGNED NOT NULL,
	documento VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	/* Fin Compras */

	/* Requisicion Compras */
	CREATE TABLE EstatusRequisicionCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE RequisicionCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_solicitud DATE NOT NULL,
	motivo VARCHAR(255) NOT NULL,
	fk_prioridad INT(11) UNSIGNED NOT NULL,
	fk_area_solicitante INT(11) UNSIGNED NOT NULL,
	central_sitio VARCHAR(255) NOT NULL,
	fk_estatus INT(11) UNSIGNED NOT NULL,
	fecha_estatus_requisicion DATE,
    fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PartidaRequisicionCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_requisicion_compra INT(11) UNSIGNED,
	codigo VARCHAR(255),
	grupo_familia VARCHAR(255),
	descripcion VARCHAR(255) NOT NULL,
	cantidad VARCHAR(255) NOT NULL,
	unidad VARCHAR(255) NULL,
	fk_validacion INT(11) UNSIGNED,
	fk_estatus INT(11) UNSIGNED,
	costo DECIMAL(11,2),
	importe DECIMAL(11,2),
	fk_orden_compra INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitanteRequisicion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_requisicion_compra INT(11) UNSIGNED NOT NULL,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioRequisicion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_requisicion_compra INT(11) UNSIGNED NOT NULL,
	fk_comentario_compras INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);
	/* Fin Requisicion Compras */

	/* Cotizacion Compras */
	CREATE TABLE Cotizacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	descripcion VARCHAR(255) NOT NULL,
	emisor VARCHAR(255) NOT NULL,
	fecha DATE NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioCotizacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cotizacion INT(11) UNSIGNED NOT NULL,
	fk_comentario_compras INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);
	/* Fin Cotizacion Compras */

	/* Orden de Compra */
	CREATE TABLE OrdenCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cotizacion INT(11) UNSIGNED,
	fecha DATE NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED NOT NULL,
	fk_proyecto INT(11) UNSIGNED,
	fk_requisicion_compra INT(11) UNSIGNED,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2) NOT NULL,
	ieps DECIMAL(11,2),
	retencion_isr DECIMAL(11,2),
	retencion_iva DECIMAL(11,2),
	otros_impuestos DECIMAL(11,2),
	total DECIMAL(11,2) NOT NULL,
	fecha_entrega_almacen DATE NOT NULL,
	leyenda VARCHAR(255),
	importe_letra VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE ProyectoPadre
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	descripcion VARCHAR(255) NOT NULL,
	fecha_creacion DATE NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ProyectoPadreHijo
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proyecto_padre INT(11) UNSIGNED,
	fk_proyecto INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);
	/* Fin Orden de Compra */

	CREATE TABLE FacturaPorPagar
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_orden_compra INT(11) UNSIGNED,
	fk_orden_compra_maquilado INT(11) UNSIGNED,
	folio VARCHAR(255) NOT NULL,
	fecha DATE NOT NULL,
	fecha_pago DATE,
    fecha_pago1 DATE,
    porcentaje_pago1 VARCHAR(20),
    fecha_pago2 DATE,
    porcentaje_pago2 VARCHAR(20),
	PRIMARY KEY (id)
	);

	CREATE TABLE OrdenCompraMaquilado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_servicio_maquilado INT(11) UNSIGNED NOT NULL,
	fecha DATE NOT NULL,
	fk_proveedor_maquilador INT(11) UNSIGNED NOT NULL,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2) NOT NULL,
	ieps DECIMAL(11,2),
	retencion_isr DECIMAL(11,2),
	retencion_iva DECIMAL(11,2),
	otros_impuestos DECIMAL(11,2),
	total DECIMAL(11,2) NOT NULL,
	clave_validacion VARCHAR(255),
	leyenda VARCHAR(255),
	importe_letra VARCHAR(255),
	anticipo DECIMAL(11,2),
	finiquito DECIMAL(11,2),
	anticipo_facturado BOOLEAN,
	finiquito_facturado BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitudServicioMaquilado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_proyecto_padre INT(11) UNSIGNED,
	fk_proyecto INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoSolicitudServicioMaquilado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoValidacionOperativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ValidacionProyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_estado_validacion_operativa INT(11) UNSIGNED NOT NULL,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE HerramientaSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_herramienta INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE MaterialSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_material INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE ConsumibleSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_consumible INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE TelefoniaMovilSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_telefonia_movil INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE EquipoMedicionSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_equipo_medicion INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE EquipoTransporteSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_equipo_transporte INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE HardwareSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_hardware INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE SoftwareSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_software INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
	cantidad_devuelta DECIMAL(12,5),
	fk_estatus_devolucion INT(11) UNSIGNED,
	fecha_devolucion DATE,
	devuelto BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoValidacionCosto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);


	CREATE TABLE ComentarioValidacionAdministrativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_captura DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoOrdenCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE OrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	orden_compra BOOLEAN,
	numero_orden_compra VARCHAR(255),
	fecha_orden_compra DATE,
	oferta VARCHAR(255),
	ordenesVenta VARCHAR(255),
	pr VARCHAR(255),
	mr VARCHAR(255),
	peticion VARCHAR(255),
	red VARCHAR(255),
	cotizacion VARCHAR(255),
	costo_orden_compra DECIMAL(11,2),
	fk_validacion_costo INT(11) UNSIGNED,
	fk_estado_orden_compra INT(11) UNSIGNED,
	leyenda VARCHAR(255),
	item VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioValidacionCostoOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_orden_compra_cliente INT(11) UNSIGNED NOT NULL,
	fk_comentario_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_orden_compra_cliente INT(11) UNSIGNED NOT NULL,
	fk_comentario_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ConcentradoOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cliente INT(11) UNSIGNED NOT NULL,
	orden_compra VARCHAR(255) NOT NULL,
	fecha_orden_compra DATE NOT NULL,
	num_requisicion VARCHAR(255),	
	PRIMARY KEY (id)
	);

	CREATE TABLE PartidaConcentradoOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_concentrado_orden_compra_cliente INT(11) UNSIGNED NOT NULL,
	item INT(11) NOT NULL,
	codigo VARCHAR(255) NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	precio_unitario DECIMAL(11,2) NOT NULL,
	central_sitio VARCHAR(255),
	id_sitio VARCHAR(255),
	local_foraneo VARCHAR(255),
	condicion_pago VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioConcentradoOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_concentrado_orden_compra_cliente INT(11) UNSIGNED NOT NULL,
	fk_comentario_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ValidacionAdministrativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_estado_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	fk_tipo_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	porcentaje_1 DECIMAL(12,5),
	clave_validacion_1 VARCHAR(255),
	fecha_validacion_1 DATE,
	fk_estado_validacion_cobro_1 INT(11) UNSIGNED,
	porcentaje_2 DECIMAL(12,5),
	clave_validacion_2 VARCHAR(255),
	fecha_validacion_2 DATE,
	fk_estado_validacion_cobro_2 INT(11) UNSIGNED,
	porcentaje_3 DECIMAL(12,5),
	clave_validacion_3 VARCHAR(255),
	fecha_validacion_3 DATE,
	fk_estado_validacion_cobro_3 INT(11) UNSIGNED,
	porcentaje_total_cobro DECIMAL(12,5),
	fk_estado_final_validacion INT(11) UNSIGNED NOT NULL,
	fk_imputable INT(11) UNSIGNED,
	fk_proyecto INT(11) UNSIGNED,
	fk_proyecto_padre INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoValidacionAdministrativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoValidacionAdministrativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoValidacionCobro
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoFinalValidacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioPantallaValidacionAdministrativa
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	fk_comentario_validacion_administrativa INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioCuentasPagarFacturacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoTesoreria
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoInvestigacionCalidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FacturaProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_factura DATE,
	fk_estado_investigacion_calidad INT(11) UNSIGNED NOT NULL,
	fk_estado_tesoreria INT(11) UNSIGNED,
	semana DECIMAL(11,2),
	fk_proveedor_calificado INT(11) UNSIGNED,
	fk_orden_compra INT(11) UNSIGNED,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	fk_orden_compra_maquilado INT(11) UNSIGNED,
	cantidad DECIMAL(11,2) NOT NULL,
	numero_factura VARCHAR(255),
	fecha_revision DATE,
	fecha_pago DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioFacturaProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_factura_proveedor INT(11) UNSIGNED NOT NULL,
	fk_comentario_cuentas_pagar_facturacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE NotaCreditoProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	folio VARCHAR(255) NOT NULL,
	factura VARCHAR(255),
	fecha DATE NOT NULL,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2),
	total DECIMAL(11,2) NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE InformacionFacturacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_validacion_administrativa INT(11) UNSIGNED,
	folio_factura_1 VARCHAR(255),
	subtotal_1 DECIMAL(11,2),
	iva_1 DECIMAL(11,2),
	total_1 DECIMAL(11,2),
	fecha_emision_1 DATE,
	fecha_ingreso_1 DATE,
	dias_credito_1 DECIMAL,
	fecha_programada_1 DATE,
	estado_pago_1 VARCHAR(255),
	folio_factura_2 VARCHAR(255),
	subtotal_2 DECIMAL(11,2),
	iva_2 DECIMAL(11,2),
	total_2 DECIMAL(11,2),
	fecha_emision_2 DATE,
	fecha_ingreso_2 DATE,
	dias_credito_2 DECIMAL(11,2),
	fecha_programada_2 DATE,
	estado_pago_2 VARCHAR(255),
	folio_factura_3 VARCHAR(255),
	subtotal_3 DECIMAL(11,2),
	iva_3 DECIMAL(11,2),
	total_3 DECIMAL(11,2),
	fecha_emision_3 DATE,
	fecha_ingreso_3 DATE,
	dias_credito_3 DECIMAL,
	fecha_programada_3 DATE,
	estado_pago_3 VARCHAR(255),
	estado_factura VARCHAR(255) NOT NULL,
	fecha_estado_factura DATE NOT NULL,
	fk_imputable INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioInformacionFacturacion_3
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_informacion_facturacion INT(11) UNSIGNED NOT NULL,
	fk_comentario_cuentas_pagar_facturacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioInformacionFacturacion_2
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_informacion_facturacion INT(11) UNSIGNED NOT NULL,
	fk_comentario_cuentas_pagar_facturacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioInformacionFacturacion_1
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_informacion_facturacion INT(11) UNSIGNED NOT NULL,
	fk_comentario_cuentas_pagar_facturacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE NotaCreditoCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	folio VARCHAR(255) NOT NULL,
	factura VARCHAR(255) NOT NULL,
	item VARCHAR(255),
	fecha DATE NOT NULL,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2),
	total DECIMAL(11,2) NOT NULL,
	fk_cliente INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioNotaCreditoCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_nota_credito_cliente INT(11) UNSIGNED NOT NULL,
	fk_comentario_cuentas_pagar_facturacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitudViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	fk_medio_transporte INT(11) UNSIGNED NOT NULL,
	numero_vehiculo VARCHAR(255),
	kilometraje_inicial VARCHAR(255),
	combustible DECIMAL(11,2),
    combustible_autorizado DECIMAL(11,2),
	casetas DECIMAL(11,2),
    casetas_autorizado DECIMAL(11,2),
	pasajes DECIMAL(11,2),
    pasajes_autorizado DECIMAL(11,2),
	hospedaje DECIMAL(11,2),
    hospedaje_autorizado DECIMAL(11,2),
	alimentos DECIMAL(11,2),
    alimentos_autorizado DECIMAL(11,2),
	materiales_herramienta DECIMAL(11,2),
    materiales_herramienta_autorizado DECIMAL(11,2),
	otros DECIMAL(11,2),
    otros_autorizado DECIMAL(11,2),
	total_solicitado DECIMAL(11,2),
    total_autorizado DECIMAL(11,2),
    fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE MedioTransporte
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	transporte VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComprobacionViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_viaticos INT(11) UNSIGNED NOT NULL,
	total_autorizado DECIMAL(11,2) NOT NULL,
	fecha_subida_documentos DATE,
	documento_formato VARCHAR(255),
	fk_estado_comprobacion_viaticos INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoComprobacionViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_comprobacion_viaticos INT(11) UNSIGNED NOT NULL,
	documento VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoComprobacionViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioContabilidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DescripcionFondoFijoCajaChica
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	descripcion VARCHAR(255) NOT NULL,
	fk_tipo_operacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE MoviemientoFondoFijoCajaChica
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE,
	fk_descripcion_fondo_fijo_caja_chica INT(11) UNSIGNED,
	fk_entrega INT(11) UNSIGNED NOT NULL,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	ingreso DECIMAL(11,2),
	egreso DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioMoviemientoFondoFijoCajaChica
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_moviemiento_fondo_fijo_caja_chica INT(11) UNSIGNED NOT NULL,
	fk_comentario_contabilidad INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE MovimientoPagoContableServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_descripcion_pago_contable_servicio INT(11) UNSIGNED NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	ingreso DECIMAL(11,2),
	egreso DECIMAL(11,2),
	folio_documento VARCHAR(255),
	importe DECIMAL(11,2) NOT NULL,
	descuentos DECIMAL(11,2),
	iva DECIMAL(11,2),
	redondeo DECIMAL(11,2),
	isr_retencion DECIMAL(11,2),
	iva_retencion DECIMAL(11,2),
	otros_impuestos DECIMAL(11,2),
	total_pagar DECIMAL(11,2),
	fecha_limite_pago DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioMovimientoPagoContableServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_movimiento_pago_contable_servicio INT(11) UNSIGNED NOT NULL,
	fk_comentario_contabilidad INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DescripcionPagoContableServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	descripcion VARCHAR(255) NOT NULL,
	fk_tipo_operacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoOperacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo_operacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioTesoreria
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE BancoConectel
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	clabe_interbancaria VARCHAR(255) NOT NULL,
	banco VARCHAR(255) NOT NULL,
	cuenta_bancaria VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Cobranza
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_informacion_facturacion INT(11) UNSIGNED NOT NULL,
	folio_factura VARCHAR(255),
	fk_nota_credito_cliente INT(11) UNSIGNED,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2) NOT NULL,
	total DECIMAL(11,2) NOT NULL,
	fk_banco_conectel INTEGER UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL(11,2) NOT NULL,
	referencia_abono INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioCobranza
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cobranza INT(11) UNSIGNED NOT NULL,
	fk_comentario_tesoreria INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PagoProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,	
	folio_factura VARCHAR(255),
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2) NOT NULL,
	total DECIMAL(11,2) NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL(11,2) NOT NULL,
	referencia_abono INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioPagoProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_proveedor INT(11) UNSIGNED NOT NULL,
	fk_comentario_tesoreria INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PagoViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_viaticos INT(11) UNSIGNED NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL(11,2) NOT NULL,
	referencia_abono INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioPagoViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_viaticos INT(11) UNSIGNED NOT NULL,
	fk_comentario_tesoreria INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ConceptoOtraOperacionFinanciera
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	concepto VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PagoMovimientoPagoContableServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_movimiento_pago_contable_servicio INT(11) UNSIGNED NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL(11,2) NOT NULL,
	referencia_abono VARCHAR(255),
    cuentas_destino VARCHAR(255) NOT NULL,
    fk_tipo_pago INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PagoOtraOperacionFinanciera
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_concepto_otra_operacion_financiera INT(11) UNSIGNED NOT NULL,
	razon_social VARCHAR(255) NOT NULL,
	subtotal DECIMAL(11,2) NOT NULL,
	iva DECIMAL(11,2) NOT NULL,
	total DECIMAL(11,2) NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL(11,2) NOT NULL,
	referencia_abono INT(11) UNSIGNED,
    cuentas_destino VARCHAR(255) NOT NULL,
    fk_tipo_pago INT(11) UNSIGNED NOT NULL,
	observaciones VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioPagoOtraOperacionFinanciera
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_otra_operacion_financiera INT(11) UNSIGNED NOT NULL,
	fk_comentario_tesoreria INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioPagoMovimientoPagoContableServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_movimiento_pago_contable_servicio INT(11) UNSIGNED NOT NULL,
	fk_comentario_tesoreria INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	/* Recursos Humanos */

	CREATE TABLE EstadoColaborador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE MotivoTerminoContrato
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	motivo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Suspension
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	suspension VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoContratacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FaseContratacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fase VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoCandidato
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FaseSeleccion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fase VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FuenteReclutamiento
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fuente VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoAcademico
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE UltimoGradoEstudios
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estudios VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Dependientes
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	dependientes VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ViveCon
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	relacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Nacionalidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	nacionalidad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoSalud
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoLicencia
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ActividadTiempoLibre
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	actividad VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Sexo
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	sexo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Prestaciones
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	seguro_social BOOLEAN,
	vacaciones BOOLEAN,
	aguinaldo BOOLEAN,
	utilidades BOOLEAN,
	fonacot BOOLEAN,
	infonavit BOOLEAN,
	prima_vacacional BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE DireccionSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	calle_numero VARCHAR(255) NOT NULL,
	colonia VARCHAR(255) NOT NULL,
	codigo_postal VARCHAR(5),
	delegacion_municipio VARCHAR(255) NOT NULL,
	entidad_federativa VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE CartaAntecedentesPenales
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tiene_carta VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ReclutamientoSolicitudEmpleo
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	descripcion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Contratacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_seleccion_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_colaborador INTEGER UNSIGNED NOT NULL,
	sueldo_inicial DECIMAL(11,2) NOT NULL,
	fecha_expedicion_certificado_medico DATE NOT NULL,
	fecha_vencimiento_certificado_medico DATE NOT NULL,
	fk_tipo_contratacion INT(11) UNSIGNED NOT NULL,
	fk_tipo_contrato INT(11) UNSIGNED NOT NULL,
	vencimiento_contrato_eventual VARCHAR(255),
	fecha_inicio_contrato DATE NOT NULL,
	fk_suspension INT(11) UNSIGNED,
	motivo_suspension VARCHAR(255),
	fecha_termino_contrato DATE,
	fk_motivo_termino_contrato INTEGER UNSIGNED,
	finiquito BOOLEAN,
	indemnizacion BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentosContratacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	ife BOOLEAN,
	acta_nacimiento BOOLEAN,
	comprobante_domicilio BOOLEAN,
	curp BOOLEAN,
	rfc BOOLEAN,
	nss BOOLEAN,
	comprobante_estudios_certificacion BOOLEAN,
	carta_militar BOOLEAN,
	licencia BOOLEAN,
	carta_antecedentes_no_penales BOOLEAN,
	certificado_medico BOOLEAN,
	cartas_recomendacion BOOLEAN,
	curriculum BOOLEAN,
	fm2_fm3 BOOLEAN,
	fotografia BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosEscolaresHabilidades
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_ultimo_grado_estudios INT(11) UNSIGNED NOT NULL,
	escuela_procedencia VARCHAR(255),
	fk_estado_academico INT(11) UNSIGNED NOT NULL,
	idiomas VARCHAR(255),
	porcentaje_idiomas VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE Paqueteria
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_datos_escolares_habilidades INT(11) UNSIGNED NOT NULL,
	word BOOLEAN,
	power_point BOOLEAN,
	excel BOOLEAN,
	publisher BOOLEAN,
	access BOOLEAN,
	outlook BOOLEAN,
	acrobat BOOLEAN,
	coi BOOLEAN,
	noi BOOLEAN,
	sae BOOLEAN,
	otros BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE EquipoOficinaDomina
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_datos_escolares_habilidades INT(11) UNSIGNED NOT NULL,
	pc BOOLEAN,
	calculadora BOOLEAN,
	impresora BOOLEAN,
	fax BOOLEAN,
	telefono BOOLEAN,
	scanner BOOLEAN,
	tablet BOOLEAN,
	laptop BOOLEAN,
	otros BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosUltimoEmpleoSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	nombre_empresa VARCHAR(255),
	domicilio VARCHAR(255),
	telefonos VARCHAR(255),
	puesto_inicial VARCHAR(255),
	puesto_final VARCHAR(255),
	sueldo_inicial DECIMAL(11,2),
	sueldo_final DECIMAL(11,2),
	motivo_separacion VARCHAR(255),
	nombre_jefe_inmediato VARCHAR(255),
	actividades_desempenadas VARCHAR(255),
	nombre_empresa_anterior VARCHAR(255),
	domicilio_anterior VARCHAR(255),
	telefonos_anterior VARCHAR(255),
	puesto_inicial_anterior VARCHAR(255),
	puesto_final_anterior VARCHAR(255),
	sueldo_inicial_anterior DECIMAL(11,2),
	sueldo_final_anterior DECIMAL(11,2),
	motivo_separacion_anterior VARCHAR(255),
	nombre_jefe_inmediato_anterior VARCHAR(255),
	actividades_desempenadas_anterior VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE Identificacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	identificacion VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoCivil
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentacionExtranjeros
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	documento VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosFamiliaresSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_vive_con INT(11) UNSIGNED NOT NULL,
	fk_dependientes INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosSobreConectelSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_fuente_reclutamiento INT(11) UNSIGNED NOT NULL,
	conocidos_conectel BOOLEAN NOT NULL,
	puede_viajar BOOLEAN NOT NULL,
	fecha_presentarse DATE NOT NULL,
	fk_fase_seleccion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosPrincipalesSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fecha_solicitud DATE NOT NULL,
	puesto_solicitado VARCHAR(255) NOT NULL,
	sueldo_solicitado DECIMAL(11,2) NOT NULL,
	objetivo_laboral VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Licencia
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	vigencia DATE NOT NULL,
	numero_licencia VARCHAR(50) NOT NULL,
	fk_tipo_licencia INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE DatosGeneralesSolicitante
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	apellido_paterno VARCHAR(255) NOT NULL,
	apellido_materno VARCHAR(255) NOT NULL,
	nombres VARCHAR(255) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
	lugar_nacimiento VARCHAR(255),
	edad INT(2),
	fk_nacionalidad INT(11) UNSIGNED NOT NULL,
	fk_identificacion INT(11) UNSIGNED NOT NULL,
	fk_documentacion_extranjeros INT(11) UNSIGNED,
	fk_estado_civil INT(11) UNSIGNED NOT NULL,
	fk_sexo INT(11) UNSIGNED NOT NULL,
	fk_direccion_solicitante INT(11) UNSIGNED,
	telefono VARCHAR(50) NOT NULL,
	celular VARCHAR(50) NOT NULL,
	correo_electronico VARCHAR(255),
	rfc VARCHAR(15),
	nss VARCHAR(255),
	curp VARCHAR(20),
	fk_licencia INT(11) UNSIGNED,
	fk_carta_antecedentes_penales INT(11) UNSIGNED NOT NULL,
	fk_estado_salud INT(11) UNSIGNED NOT NULL,
	enfermedad_cronica VARCHAR(255),
	fk_tiempo_libre INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE SeleccionReclutamiento
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_tipo_candidato INT(11) UNSIGNED NOT NULL,
	examen_tecnico INT(2) NOT NULL,
	fk_fase_contratacion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PerfilEscala
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_seleccion_reclutamiento INT(11) UNSIGNED NOT NULL,
	inteligencia INT(1) NOT NULL,
	sociable INT(1) NOT NULL,
	metodos_procedimientos INT(1) NOT NULL,
	aspecto_fisico INT(1) NOT NULL,
	desenvolvimiento INT(1) NOT NULL,
	concentracion INT(1) NOT NULL,
	entusiasmo INT(1) NOT NULL,
	amabilidad INT(1) NOT NULL,
	agresivo INT(1) NOT NULL,
	audaz INT(1) NOT NULL,
	lenguaje INT(1) NOT NULL,
	respecto_autoridad INT(1) NOT NULL,
	orden INT(1) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ExamenPsicometrico
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_seleccion_reclutamiento INT(11) UNSIGNED NOT NULL,
	raven_army_beta BOOLEAN,
	figura_humana BOOLEAN,
	arbol BOOLEAN,
	casa BOOLEAN,
	grafologia BOOLEAN,
	cleaver BOOLEAN,
	frases_incompletas BOOLEAN,
	therman BOOLEAN,
	dominos BOOLEAN,
	PRIMARY KEY (id)
	);

	CREATE TABLE InformacionConfidencialColaborador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	foto VARCHAR(255),
	sueldo DECIMAL(11,2),
	tiene_imss BOOLEAN NOT NULL,
	nss VARCHAR(255),
	alta_imss DATE,
	baja_imss DATE,
	modificacion_imss DATE,
	fk_estado_colaborador INT(11) UNSIGNED NOT NULL,
	en_caso_accidente_avisar VARCHAR(255) NOT NULL,
	telefono_emergencia VARCHAR(50) NOT NULL,
	bajo_tratamiento BOOLEAN NOT NULL,
	medicamento VARCHAR(255),
	alergias VARCHAR(255),
	tipo_sangre VARCHAR(255),
	numero_tarjeta_nomina VARCHAR(50),
	correo_electronico VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Variacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Percepcion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	percepcion VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE FormaPagoPrenomina
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoSancion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ClasificacionPermiso
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Deduccion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	deduccion VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoIncapacidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ClaseIncidencia
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	incidencia VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ClasificacionFalta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Curso
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	induccion1 BOOLEAN,
	induccion2 BOOLEAN,
	induccion3 BOOLEAN,
	induccion4 BOOLEAN,
	fecha_enc DATE,
	resultado_enc DECIMAL(12,5),
	enc BOOLEAN,
	curso_tecnico VARCHAR(255),
	capacitador_interno_ct VARCHAR(255),
	capacitador_externo_ct VARCHAR(255),
	autorizacion_ct BOOLEAN,
	fecha_ct DATE,
	resultado_ct DECIMAL(12,5),
	curso_general VARCHAR(255),
	capacitador_interno_cg VARCHAR(255),
	capacitador_externo_cg VARCHAR(255),
	autorizacion_cg BOOLEAN,
	fecha_cg DATE,
	resultado_cg DECIMAL(12,5),
	PRIMARY KEY (id)
	);

	CREATE TABLE RegistroPercepcion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fk_percepcion INT(11) UNSIGNED NOT NULL,
	monto_aportacion DECIMAL(11,2),
	fk_variaciones INT(11) UNSIGNED,
	dias_correspondientes INTEGER(5),
	fecha_inicio DATE,
	fecha_termino DATE,
	prima_vacacional BOOLEAN NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE InformacionPrenomina
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fecha_incidencia_inicial DATE NOT NULL,
	fecha_incidencia_final DATE NOT NULL,
	fk_clase_incidencia INT(11) UNSIGNED,
	fk_tipo_incapacidad INT(11) UNSIGNED,
	monto_imss DECIMAL(11,2),
	monto_conectel DECIMAL(11,2),
	PRIMARY KEY (id)
	);

	CREATE TABLE RegistroDeduccion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fk_deduccion INT(11) UNSIGNED NOT NULL,
	retardos INTEGER(5),
	fecha_retardo DATE,
	faltas INTEGER(5),
	fecha_falta DATE,
	fk_clasificacion_falta INT(11) UNSIGNED,
	fecha_permiso DATE,
	fk_clasificacion_permiso INT(11) UNSIGNED,
	fk_tipo_sancion INT(11) UNSIGNED,
	fk_forma_pago_prenomina INT(11) UNSIGNED,
	monto_total_descuento DECIMAL(11,2),
	descuento_parcial DECIMAL(11,2),
	fecha_inicio DATE,
	fecha_termino DATE,
	PRIMARY KEY (id)
	);

	/* Sistema de Gestion */
	CREATE TABLE EstadoSistemaGestion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE FormaAuditoria
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	forma VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoAuditoria
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoCapacitacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoFormacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE AreaLevantaNoConformidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	area VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE FuenteNoConformidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fuente VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoAccion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	accion VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE SistemaGestion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	aplicacion_auditoria BOOLEAN NOT NULL,
	fk_tipo_auditoria INT(11) UNSIGNED,
	fk_forma_auditoria INT(11) UNSIGNED,
	fecha_auditoria DATE,
	indice_calidad VARCHAR(255),
	fecha_envio DATE,
	fecha_recepcion DATE,
	formato_auditoria VARCHAR(255),
	nombre_auditor VARCHAR(255),
	fecha_recepcion_correcciones_auditorias_internas DATE,
	fecha_envio_correcciones DATE,
	fk_estado_sistema_gestion INT(11) UNSIGNED NOT NULL,
	correcciones VARCHAR(255),
	fecha_cierre_auditoria DATE,
	observaciones VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadoAccionPreventivaCorrectiva
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ResultadoImplementacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	resultado VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ConcentradoCapacitacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
        fk_tipo_formacion INT(11) UNSIGNED NOT NULL,
        fk_estado_concentrado_capacitacion INT(11) UNSIGNED NULL,
	fk_tipo_capacitacion INT(11) UNSIGNED NOT NULL,
	nombre_capacitacion VARCHAR(255) NOT NULL,
	fecha_inicio_capacitacion DATE NOT NULL,
	fecha_termino_capacitacion DATE NOT NULL,
	lugar_capacitacion VARCHAR(255),
	nombre_instructor VARCHAR(255),
	calificacion DECIMAL(12,5),
	constancia VARCHAR(255),
	fk_estatus_concentrado_capacitacion INT(11) UNSIGNED NOT NULL,
	resultado_seguimiento VARCHAR(255),
	fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);
	
	CREATE TABLE Sugerencia
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE NOT NULL,
	fk_colaborador INT(11) UNSIGNED,
	nombre VARCHAR(255),
	correo_electronico VARCHAR(100),
	telefono VARCHAR(50),
	sugerencia VARCHAR(255) NOT NULL,
	requiere_accion_inmediata BOOLEAN NOT NULL,
	requiere_accion_correctiva BOOLEAN NOT NULL,
	accion_inmediata VARCHAR(255),
	fecha_implementacion DATE NOT NULL,
	responsable_implementacion VARCHAR(255) NOT NULL,
	fk_resultado_implementacion INT(11) UNSIGNED NOT NULL,
	fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE NoConformidad
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_area_levanta_no_conformidad INT(11) UNSIGNED NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	fecha_suceso DATE NOT NULL,
	area_nombre_se_levanta VARCHAR(255) NOT NULL,
	suceso_evento VARCHAR(255) NOT NULL,
	donde_ocurrio VARCHAR(255) NOT NULL,
	cuanto_afecto VARCHAR(255) NOT NULL,
	causas VARCHAR(255) NOT NULL,
	correccion VARCHAR(255) NOT NULL,
	observaciones VARCHAR(255) NOT NULL,
	requiere_accion_correctiva BOOLEAN NOT NULL,
	fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE AccionPreventivaCorrectiva
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_no_conformidad INT(11) UNSIGNED,
	fk_sugerencia INT(11) UNSIGNED,
	fecha_apertura DATE NOT NULL,
	fk_tipo_accion INT(11) UNSIGNED NOT NULL,
	fk_fuente_no_conformidad INT(11) UNSIGNED NOT NULL,
	especificar VARCHAR(255) NOT NULL,
	participantes_analisis VARCHAR(255) NOT NULL,
	determinacion_causas VARCHAR(255) NOT NULL,
	responsable_seguimiento VARCHAR(150) NOT NULL,
	acciones_seguimiento VARCHAR(255) NOT NULL,
	accion_tomada_eficaz BOOLEAN NOT NULL,
	fk_estado_accion_preventiva_correctiva INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ResponsableMinuta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	responsable VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Minuta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_hora DATETIME,
	lugar VARCHAR(255) NOT NULL,
	asunto VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE AcuerdoMinuta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_minuta INT(11) UNSIGNED NOT NULL,
	fk_responsable_minuta INT(11) UNSIGNED,
	responsable VARCHAR(255) NOT NULL,
	acuerdo VARCHAR(255) NOT NULL,
	fecha_compromiso DATE,
	responsable_elaboracion VARCHAR(255),
	fecha_cumplimiento DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE ParticipanteMinuta
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_minuta INT(11) UNSIGNED NOT NULL,
	fk_colaborador INT(11) UNSIGNED,
	participante VARCHAR(255) NOT NULL,
	empresa VARCHAR(255) NOT NULL,
	puesto VARCHAR(255),
	PRIMARY KEY (id)
	);

	/* Notificaciones */
	CREATE TABLE EstadoNotificacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Notificacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_perfil INT(11) UNSIGNED NOT NULL,
	fecha_hora_creacion DATETIME NOT NULL,
	fecha_hora_modificacion DATETIME,
	notificacion VARCHAR(255) NOT NULL,
	fk_estado INT(11) UNSIGNED NOT NULL,
	fk_usuario_creacion INT(11) UNSIGNED NOT NULL,
	fk_usuario_modificacion INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	/* Cambios */
	CREATE TABLE TipoDesarrolloProyecto
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE VIEW NumeroFoliosFactura
	AS
	SELECT DISTINCT folio_factura_1 AS 'numero_folios_factura'
	FROM InformacionFacturacion
	WHERE folio_factura_1 IS NOT NULL
	UNION
	SELECT DISTINCT folio_factura_2 AS 'numero_folios_factura'
	FROM InformacionFacturacion
	WHERE folio_factura_2 IS NOT NULL
	UNION
	SELECT DISTINCT folio_factura_3 AS 'numero_folios_factura'
	FROM InformacionFacturacion
	WHERE folio_factura_3 IS NOT NULL;

	CREATE VIEW NumeroFoliosFacturaFacturados
	AS
	SELECT 1 AS 'ID', 'Facturados' AS 'Tipo', count(*) AS 'Cantidad' FROM NumeroFoliosFactura;

	CREATE VIEW NumeroInformacionFacturacionEnCobranza
	AS
	SELECT fk_informacion_facturacion 
	FROM Cobranza 
	GROUP BY fk_informacion_facturacion;

	CREATE VIEW NumeroProyectosCobrados
	AS
	SELECT 1 AS 'ID', 'Cobrados' AS 'Tipo', count(*) AS 'Cantidad' FROM NumeroInformacionFacturacionEnCobranza;

	CREATE TABLE Calibracion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE MantenimientoServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(25) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FormaPagoMaquilador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	forma VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitanteSolicitudViaticos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_viaticos INT(11) UNSIGNED NOT NULL,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioSistemasGestion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_captura DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioSugerencia
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_sugerencia INT(11) UNSIGNED NOT NULL,
	fk_comentario_sistemas_gestion INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE TipoServicio
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	tipo VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE FacturaProveedorPagoProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_proveedor INT(11) UNSIGNED NOT NULL,
	fk_factura_proveedor INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE NotaCreditoProveedorPagoProveedor
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_pago_proveedor INT(11) UNSIGNED NOT NULL,
	fk_nota_credito_proveedor INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitudPermiso
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    fecha_registro DATE NOT NULL,
    fecha_permiso DATE NOT NULL,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fecha DATE NOT NULL,
	fk_forma_pago_prenomina INT(11) UNSIGNED NOT NULL,
	fecha_hora_salida DATETIME,
	fecha_hora_retorno DATETIME,
	fk_permiso_sin_goce_sueldo INT(11) UNSIGNED NOT NULL,
	fk_permiso_con_goce_sueldo INT(11) UNSIGNED NOT NULL,
	visto_bueno_jefe_inmediato BOOLEAN NOT NULL,
	autorizacion BOOLEAN NOT NULL,
    fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioRecursosHumanos
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha_captura DATE NOT NULL,
	fk_usuario INT(11) UNSIGNED NOT NULL,
	comentario VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioSolicitudPermiso
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_permiso INT(11) UNSIGNED NOT NULL,
	fk_comentario_recursos_humanos INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PermisoSinGoceSueldo
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	permiso VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE PermisoConGoceSueldo
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	permiso VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE SolicitudVacaciones
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    fecha_registro DATE NOT NULL,
    fecha_permiso DATE NOT NULL,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fecha DATE NOT NULL,
	fk_variacion INT(11) UNSIGNED NOT NULL,
	dias_correspondientes INTEGER(5),
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE NOT NULL,
	visto_bueno_jefe_inmediato BOOLEAN NOT NULL,
	autorizacion BOOLEAN NOT NULL,
    fk_perfil INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE ComentarioSolicitudVacaciones
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_vacaciones INT(11) UNSIGNED NOT NULL,
	fk_comentario_recursos_humanos INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstadisticaPersonal
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_trimestre INT(11) UNSIGNED NOT NULL,
	fk_ano INT(11) UNSIGNED NOT NULL,
	fk_rango_estadistica_personal_ausencia INT(11) UNSIGNED NOT NULL,
	fk_rango_estadistica_personal_puntualidad INT(11) UNSIGNED NOT NULL,
	fk_rango_estadistica_personal_rotacion INT(11) UNSIGNED NOT NULL,
	fk_rango_estadistica_personal_retardo INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Trimestre
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	trimestre VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Ano
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	ano VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE RangoEstadisticaPersonal
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	rango VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
	);

	/*************************************************************************************************************************************
	CAMBIOS
	/************************************************************************************************************************************/

	CREATE TABLE ArchivoCotizacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cotizacion INT(11) UNSIGNED NOT NULL,
	nombre_archivo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstatusDevolucion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

    CREATE TABLE EstadoConcentradoCapacitacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estado VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE EstatusConcentradoCapacitacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	estatus VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);
	/*************************************************************************************************************************************
	FIN CAMBIOS
	/************************************************************************************************************************************/

	ALTER TABLE Cliente ADD FOREIGN KEY id_contacto_idxfk (id_contacto) REFERENCES Contacto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_categoria_proyecto_idxfk (id_categoria_proyecto) REFERENCES CategoriaProyecto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_producto_idxfk (id_producto) REFERENCES Producto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY id_estato_idxfk (id_estato) REFERENCES EstadoProyecto (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY fk_estado_solicitud_servicio_maquilado_idxfk (fk_estado_solicitud_servicio_maquilado) REFERENCES EstadoSolicitudServicioMaquilado (id);

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

	ALTER TABLE ConfiguracionPruebaEntrega ADD FOREIGN KEY fk_estatus_validacion_operativa_idxfk (fk_estatus_validacion_operativa) REFERENCES EstadoValidacionOperativa (id);

	ALTER TABLE Colaborador ADD FOREIGN KEY id_tipo_colaborador_idxfk (id_tipo_colaborador) REFERENCES TipoColaborador (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_proyecto_idxfk_3 (id_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE DatosGeneralesProyecto ADD FOREIGN KEY id_responsable_conectel_idxfk (id_responsable_conectel) REFERENCES Colaborador (id);	

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

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_usuario_idxfk_1 (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_prioridad_idxfk (fk_prioridad) REFERENCES Prioridad (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_area_solicitante_idxfk (fk_area_solicitante) REFERENCES AreaSolicitante (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_estado_solicitud_almacen_idxfk (fk_estado_solicitud_almacen) REFERENCES EstadoSolicitudAlmacen (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_autoriza_idxfk (fk_autoriza) REFERENCES Colaborador (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_entrega_idxfk (fk_entrega) REFERENCES Colaborador (id);

	ALTER TABLE Software ADD FOREIGN KEY fk_tipo_almacen_idxfk_1 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Software ADD FOREIGN KEY fk_ubicacion_b_idxfk (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE Software ADD FOREIGN KEY fk_responsable_idxfk (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_tipo_almacen_idxfk_2 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_grupo_familia_a_idxfk (fk_grupo_familia_a) REFERENCES GrupoFamiliaA (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_unidad_a_idxfk (fk_unidad_a) REFERENCES UnidadA (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_ubicacion_a_idxfk (fk_ubicacion_a) REFERENCES UbicacionA (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_responsable_idxfk_1 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_estatus_a_idxfk (fk_estatus_a) REFERENCES EstatusA (id);

	ALTER TABLE Herramienta ADD FOREIGN KEY fk_tipo_mantenimiento_idxfk (fk_tipo_mantenimiento) REFERENCES TipoMantenimiento (id);

	ALTER TABLE NombreSolicitante ADD FOREIGN KEY fk_solicitud_almacen_idxfk (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE NombreSolicitante ADD FOREIGN KEY fk_colaborador_idxfk (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_tipo_almacen_idxfk_3 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_grupo_familia_f_idxfk (fk_grupo_familia_f) REFERENCES GrupoFamiliaF (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_compania_idxfk (fk_compania) REFERENCES Compania (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_ubicacion_b_idxfk_1 (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_responsable_idxfk_2 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE TelefoniaMovil ADD FOREIGN KEY fk_estatus_b_idxfk (fk_estatus_b) REFERENCES EstatusB (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_tipo_almacen_idxfk_4 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_grupo_familia_b_idxfk (fk_grupo_familia_b) REFERENCES GrupoFamiliaB (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_ubicacion_b_idxfk_2 (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_responsable_idxfk_3 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_estatus_b_idxfk_1 (fk_estatus_b) REFERENCES EstatusB (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_tipo_mantenimiento_idxfk_1 (fk_tipo_mantenimiento) REFERENCES TipoMantenimiento (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_tipo_almacen_idxfk_5 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_grupo_familia_c_idxfk (fk_grupo_familia_c) REFERENCES GrupoFamiliaC (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_unidad_b_idxfk_1 (fk_unidad_b) REFERENCES UnidadB (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_ubicacion_b_idxfk_3 (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_responsable_idxfk_4 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE Material ADD FOREIGN KEY fk_estatus_c_idxfk (fk_estatus_c) REFERENCES EstatusC (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_tipo_almacen_idxfk_6 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_grupo_familia_d_idxfk (fk_grupo_familia_d) REFERENCES GrupoFamiliaD (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_unidad_b_idxfk_2 (fk_unidad_b) REFERENCES UnidadB (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_ubicacion_c_idxfk (fk_ubicacion_c) REFERENCES UbicacionC (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_responsable_idxfk_5 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE Consumible ADD FOREIGN KEY fk_estatus_c_idxfk_1 (fk_estatus_c) REFERENCES EstatusC (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_tipo_almacen_idxfk_7 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_grupo_familia_e_idxfk (fk_grupo_familia_e) REFERENCES GrupoFamiliaE (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_unidad_c_idxfk (fk_unidad_c) REFERENCES UnidadC (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_ubicacion_b_idxfk_4 (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_responsable_idxfk_6 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_estatus_b_idxfk_2 (fk_estatus_b) REFERENCES EstatusB (id);

	ALTER TABLE Hardware ADD FOREIGN KEY fk_tipo_mantenimiento_idxfk_2 (fk_tipo_mantenimiento) REFERENCES TipoMantenimiento (id);

	ALTER TABLE Comentarios ADD FOREIGN KEY fk_tipo_almacen_idxfk_8 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE Comentarios ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_tipo_almacen_idxfk_9 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_ubicacion_b_idxfk_5 (fk_ubicacion_b) REFERENCES UbicacionB (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_responsable_idxfk_7 (fk_responsable) REFERENCES Colaborador (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_estatus_a_idxfk_1 (fk_estatus_a) REFERENCES EstatusA (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_tipo_mantenimiento_idxfk_3 (fk_tipo_mantenimiento) REFERENCES TipoMantenimiento (id);

	ALTER TABLE DocumentoAlmacen ADD FOREIGN KEY fk_tipo_almacen_idxfk_10 (fk_tipo_almacen) REFERENCES TipoAlmacen (id);

	ALTER TABLE DocumentoAlmacen ADD FOREIGN KEY fk_tipo_entregable_idxfk (fk_tipo_entregable) REFERENCES TipoDocumentoAlmacen (id);

	/* Compras */

	ALTER TABLE Proveedor ADD FOREIGN KEY fk_tipo_persona_idxfk (fk_tipo_persona) REFERENCES TipoPersona (id);

	ALTER TABLE ProveedorSeleccionado ADD FOREIGN KEY fk_proveedor_idxfk (fk_proveedor) REFERENCES Proveedor (id);

	ALTER TABLE ComentarioCompras ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE ProveedorCalificado ADD FOREIGN KEY fk_proveedor_seleccionado_idxfk (fk_proveedor_seleccionado) REFERENCES ProveedorSeleccionado (id);

	ALTER TABLE ProveedorCalificado ADD FOREIGN KEY fk_forma_pago_idxfk (fk_forma_pago) REFERENCES FormaPago (id);

	ALTER TABLE ProveedorCalificado ADD FOREIGN KEY fk_tipo_pago_idxfk (fk_tipo_pago) REFERENCES TipoPago (id);

	ALTER TABLE ProveedorCalificado ADD FOREIGN KEY fk_dato_bancario_idxfk (fk_dato_bancario) REFERENCES DatoBancario (id);

	ALTER TABLE ComentarioProveedor ADD FOREIGN KEY fk_proveedor_calificado_idxfk (fk_proveedor_calificado) REFERENCES ProveedorCalificado (id);

	ALTER TABLE ComentarioProveedor ADD FOREIGN KEY fk_comentario_compras_idxfk (fk_comentario_compras) REFERENCES ComentarioCompras (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_proveedor_idxfk_1 (fk_proveedor) REFERENCES Proveedor (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_pago_idxfk (fk_pago) REFERENCES Pago (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_dato_bancario_idxfk_1 (fk_dato_bancario) REFERENCES DatoBancario (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_categoria_proyecto_idxfk (fk_categoria_proyecto) REFERENCES CategoriaProyecto (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_tipo_contrato_idxfk (fk_tipo_contrato) REFERENCES TipoContrato (id);

	ALTER TABLE DocumentoAyudante ADD FOREIGN KEY fk_ayudante_idxfk (fk_ayudante) REFERENCES Ayudante (id);

	ALTER TABLE Ayudante ADD FOREIGN KEY fk_proveedor_maquilador_idxfk_1 (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE DocumentoLiderProveedorMaquilador ADD FOREIGN KEY fk_proveedor_maquilador_idxfk_2 (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	/* Fin Compras */

	/* Requisicion Compras */
	ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_prioridad_idxfk (fk_prioridad) REFERENCES Prioridad (id);

	ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_area_solicitante_idxfk (fk_area_solicitante) REFERENCES Perfil (id);

	ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_estatus_idxfk (fk_estatus) REFERENCES EstatusRequisicionCompra (id);

	ALTER TABLE SolicitanteRequisicion ADD FOREIGN KEY fk_requisicion_compra_idxfk (fk_requisicion_compra) REFERENCES RequisicionCompra (id);

	ALTER TABLE SolicitanteRequisicion ADD FOREIGN KEY fk_colaborador_idxfk (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE ComentarioRequisicion ADD FOREIGN KEY fk_requisicion_compra_idxfk_1 (fk_requisicion_compra) REFERENCES RequisicionCompra (id);

	ALTER TABLE ComentarioRequisicion ADD FOREIGN KEY fk_comentario_compras_idxfk (fk_comentario_compras) REFERENCES ComentarioCompras (id);

	ALTER TABLE PartidaRequisicionCompra ADD FOREIGN KEY fk_requisicion_compra_idxfk_3 (fk_requisicion_compra) REFERENCES RequisicionCompra (id);

	ALTER TABLE PartidaRequisicionCompra ADD FOREIGN KEY fk_estatus_idxfk_1 (fk_estatus) REFERENCES EstatusRequisicionCompra (id);
	/* Fin Requisicion Compras */

	/* Cotizacion Compras */
	ALTER TABLE ComentarioCotizacion ADD FOREIGN KEY fk_cotizacion_idxfk (fk_cotizacion) REFERENCES Cotizacion (id);

	ALTER TABLE ComentarioCotizacion ADD FOREIGN KEY fk_comentario_compras_idxfk_1 (fk_comentario_compras) REFERENCES ComentarioCompras (id);
	/* Fin Cotizacion Compras */

	/* Orden de Compra */
	ALTER TABLE OrdenCompra ADD FOREIGN KEY fk_cotizacion_idxfk_1 (fk_cotizacion) REFERENCES Cotizacion (id);

	ALTER TABLE OrdenCompra ADD FOREIGN KEY fk_proveedor_calificado_idxfk (fk_proveedor_calificado) REFERENCES ProveedorCalificado (id);

	ALTER TABLE OrdenCompra ADD FOREIGN KEY fk_proyecto_idxfk (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE OrdenCompra ADD FOREIGN KEY fk_requisicion_compra_idxfk_1 (fk_requisicion_compra) REFERENCES RequisicionCompra (id);

	ALTER TABLE ProyectoPadreHijo ADD FOREIGN KEY fk_proyecto_padre_idxfk (fk_proyecto_padre) REFERENCES ProyectoPadre (id);

	ALTER TABLE ProyectoPadreHijo ADD FOREIGN KEY fk_proyecto_idxfk_1 (fk_proyecto) REFERENCES Proyecto (id);
	/* Fin Orden de Compra */

	ALTER TABLE FacturaPorPagar ADD FOREIGN KEY fk_orden_compra_idxfk (fk_orden_compra) REFERENCES OrdenCompra (id);

	ALTER TABLE FacturaPorPagar ADD FOREIGN KEY fk_orden_compra_maquilado_idxfk (fk_orden_compra_maquilado) REFERENCES OrdenCompraMaquilado (id);

	ALTER TABLE SolicitudServicioMaquilado ADD FOREIGN KEY fk_proyecto_padre_idxfk (fk_proyecto_padre) REFERENCES ProyectoPadre (id);

	ALTER TABLE SolicitudServicioMaquilado ADD FOREIGN KEY fk_proyecto_idxfk (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE ValidacionProyecto ADD FOREIGN KEY fk_estado_validacion_operativa_idxfk (fk_estado_validacion_operativa) REFERENCES EstadoValidacionOperativa (id);

	ALTER TABLE ValidacionProyecto ADD FOREIGN KEY fk_proyecto_idxfk (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE HerramientaSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_1 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE HerramientaSolicitudAlmacen ADD FOREIGN KEY fk_herramienta_idxfk (fk_herramienta) REFERENCES Herramienta (id);

	ALTER TABLE MaterialSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_7 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE MaterialSolicitudAlmacen ADD FOREIGN KEY fk_material_idxfk (fk_material) REFERENCES Material (id);

	ALTER TABLE ConsumibleSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE ConsumibleSolicitudAlmacen ADD FOREIGN KEY fk_consumible_idxfk (fk_consumible) REFERENCES Consumible (id);

	ALTER TABLE TelefoniaMovilSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_1 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE TelefoniaMovilSolicitudAlmacen ADD FOREIGN KEY fk_telefonia_movil_idxfk (fk_telefonia_movil) REFERENCES TelefoniaMovil (id);

	ALTER TABLE EquipoMedicionSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_2 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE EquipoMedicionSolicitudAlmacen ADD FOREIGN KEY fk_equipo_medicion_idxfk (fk_equipo_medicion) REFERENCES EquipoMedicion (id);

	ALTER TABLE EquipoTransporteSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_3 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE EquipoTransporteSolicitudAlmacen ADD FOREIGN KEY fk_equipo_transporte_idxfk (fk_equipo_transporte) REFERENCES EquipoTransporte (id);

	ALTER TABLE HardwareSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_4 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE HardwareSolicitudAlmacen ADD FOREIGN KEY fk_hardware_idxfk (fk_hardware) REFERENCES Hardware (id);

	ALTER TABLE SoftwareSolicitudAlmacen ADD FOREIGN KEY fk_solicitud_almacen_idxfk_5 (fk_solicitud_almacen) REFERENCES SolicitudAlmacen (id);

	ALTER TABLE SoftwareSolicitudAlmacen ADD FOREIGN KEY fk_software_idxfk (fk_software) REFERENCES Software (id);

	ALTER TABLE ComentarioValidacionAdministrativa ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE OrdenCompraCliente ADD FOREIGN KEY fk_proyecto_idxfk (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE OrdenCompraCliente ADD FOREIGN KEY fk_validacion_costo_idxfk (fk_validacion_costo) REFERENCES EstadoValidacionCosto (id);

	ALTER TABLE OrdenCompraCliente ADD FOREIGN KEY fk_estado_orden_compra_idxfk (fk_estado_orden_compra) REFERENCES EstadoOrdenCompra (id);

	ALTER TABLE ConcentradoOrdenCompraCliente ADD FOREIGN KEY fk_cliente_idxfk (fk_cliente) REFERENCES Cliente (id);

	ALTER TABLE PartidaConcentradoOrdenCompraCliente ADD FOREIGN KEY fk_concentrado_orden_compra_cliente_idxfk (fk_concentrado_orden_compra_cliente) REFERENCES ConcentradoOrdenCompraCliente (id);

	ALTER TABLE ComentarioOrdenCompraCliente ADD FOREIGN KEY fk_orden_compra_cliente_idxfk (fk_orden_compra_cliente) REFERENCES OrdenCompraCliente (id);

	ALTER TABLE ComentarioOrdenCompraCliente ADD FOREIGN KEY fk_comentario_validacion_administrativa_idxfk (fk_comentario_validacion_administrativa) REFERENCES ComentarioValidacionAdministrativa (id);

	ALTER TABLE ComentarioValidacionCostoOrdenCompraCliente ADD FOREIGN KEY fk_orden_compra_cliente_idxfk_1 (fk_orden_compra_cliente) REFERENCES OrdenCompraCliente (id);

	ALTER TABLE ComentarioValidacionCostoOrdenCompraCliente ADD FOREIGN KEY fk_comentario_validacion_administrativa_idxfk_1 (fk_comentario_validacion_administrativa) REFERENCES ComentarioValidacionAdministrativa (id);

	ALTER TABLE ComentarioConcentradoOrdenCompraCliente ADD FOREIGN KEY fk_concentrado_orden_compra_cliente_idxfk_1 (fk_concentrado_orden_compra_cliente) REFERENCES ConcentradoOrdenCompraCliente (id);

	ALTER TABLE ComentarioConcentradoOrdenCompraCliente ADD FOREIGN KEY fk_comentario_validacion_administrativa_idxfk (fk_comentario_validacion_administrativa) REFERENCES ComentarioValidacionAdministrativa (id);

	ALTER TABLE ComentarioPantallaValidacionAdministrativa ADD FOREIGN KEY fk_validacion_administrativa_idxfk (fk_validacion_administrativa) REFERENCES ValidacionAdministrativa (id);

	ALTER TABLE ComentarioPantallaValidacionAdministrativa ADD FOREIGN KEY fk_comentario_validacion_administrativa_idxfk_2 (fk_comentario_validacion_administrativa) REFERENCES ComentarioValidacionAdministrativa (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_estado_validacion_administrativa_idxfk (fk_estado_validacion_administrativa) REFERENCES EstadoValidacionAdministrativa (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_tipo_validacion_administrativa_idxfk (fk_tipo_validacion_administrativa) REFERENCES TipoValidacionAdministrativa (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_estado_validacion_cobro_1_idxfk (fk_estado_validacion_cobro_1) REFERENCES EstadoValidacionCobro (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_estado_validacion_cobro_2_idxfk (fk_estado_validacion_cobro_2) REFERENCES EstadoValidacionCobro (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_estado_validacion_cobro_3_idxfk (fk_estado_validacion_cobro_3) REFERENCES EstadoValidacionCobro (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_estado_final_validacion_idxfk (fk_estado_final_validacion) REFERENCES EstadoFinalValidacion (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_imputable_idxfk (fk_imputable) REFERENCES Imputable (id);

	ALTER TABLE ComentarioCuentasPagarFacturacion ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_estado_investigacion_calidad_idxfk (fk_estado_investigacion_calidad) REFERENCES EstadoInvestigacionCalidad (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_estado_tesoreria_idxfk (fk_estado_tesoreria) REFERENCES EstadoTesoreria (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_proveedor_calificado_idxfk (fk_proveedor_calificado) REFERENCES ProveedorCalificado (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_orden_compra_idxfk (fk_orden_compra) REFERENCES OrdenCompra (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_proveedor_maquilador_idxfk (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE FacturaProveedor ADD FOREIGN KEY fk_orden_compra_maquilado_idxfk (fk_orden_compra_maquilado) REFERENCES OrdenCompraMaquilado (id);

	ALTER TABLE ComentarioFacturaProveedor ADD FOREIGN KEY fk_factura_proveedor_idxfk (fk_factura_proveedor) REFERENCES FacturaProveedor (id);

	ALTER TABLE ComentarioFacturaProveedor ADD FOREIGN KEY fk_comentario_cuentas_pagar_facturacion_idxfk (fk_comentario_cuentas_pagar_facturacion) REFERENCES ComentarioCuentasPagarFacturacion (id);

	ALTER TABLE NotaCreditoProveedor ADD FOREIGN KEY fk_proveedor_calificado_idxfk_1 (fk_proveedor_calificado) REFERENCES ProveedorCalificado (id);

	ALTER TABLE NotaCreditoProveedor ADD FOREIGN KEY fk_proveedor_maquilador_idxfk_1 (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_proyecto_idxfk_2 (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE ValidacionAdministrativa ADD FOREIGN KEY fk_proyecto_padre_idxfk (fk_proyecto_padre) REFERENCES ProyectoPadre (id);

	ALTER TABLE InformacionFacturacion ADD FOREIGN KEY fk_validacion_administrativa_idxfk (fk_validacion_administrativa) REFERENCES ValidacionAdministrativa (id);

	ALTER TABLE ComentarioInformacionFacturacion_3 ADD FOREIGN KEY fk_informacion_facturacion_idxfk (fk_informacion_facturacion) REFERENCES InformacionFacturacion (id);

	ALTER TABLE ComentarioInformacionFacturacion_3 ADD FOREIGN KEY fk_comentario_cuentas_pagar_facturacion_idxfk_1 (fk_comentario_cuentas_pagar_facturacion) REFERENCES ComentarioCuentasPagarFacturacion (id);

	ALTER TABLE ComentarioInformacionFacturacion_2 ADD FOREIGN KEY fk_informacion_facturacion_idxfk_1 (fk_informacion_facturacion) REFERENCES InformacionFacturacion (id);

	ALTER TABLE ComentarioInformacionFacturacion_2 ADD FOREIGN KEY fk_comentario_cuentas_pagar_facturacion_idxfk_2 (fk_comentario_cuentas_pagar_facturacion) REFERENCES ComentarioCuentasPagarFacturacion (id);

	ALTER TABLE ComentarioInformacionFacturacion_1 ADD FOREIGN KEY fk_informacion_facturacion_idxfk_2 (fk_informacion_facturacion) REFERENCES InformacionFacturacion (id);

	ALTER TABLE ComentarioInformacionFacturacion_1 ADD FOREIGN KEY fk_comentario_cuentas_pagar_facturacion_idxfk_3 (fk_comentario_cuentas_pagar_facturacion) REFERENCES ComentarioCuentasPagarFacturacion (id);

	ALTER TABLE NotaCreditoCliente ADD FOREIGN KEY fk_cliente_idxfk (fk_cliente) REFERENCES Cliente (id);

	ALTER TABLE ComentarioNotaCreditoCliente ADD FOREIGN KEY fk_nota_credito_cliente_idxfk (fk_nota_credito_cliente) REFERENCES NotaCreditoCliente (id);

	ALTER TABLE ComentarioNotaCreditoCliente ADD FOREIGN KEY fk_comentario_cuentas_pagar_facturacion_idxfk_4 (fk_comentario_cuentas_pagar_facturacion) REFERENCES ComentarioCuentasPagarFacturacion (id);

	ALTER TABLE SolicitudViaticos ADD FOREIGN KEY fk_proyecto_idxfk (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE SolicitudViaticos ADD FOREIGN KEY fk_medio_transporte_idxfk (fk_medio_transporte) REFERENCES MedioTransporte (id);
	
	ALTER TABLE ComprobacionViaticos ADD FOREIGN KEY fk_pago_viaticos_idxfk_2 (fk_pago_viaticos) REFERENCES PagoViaticos (id);

	ALTER TABLE ComprobacionViaticos ADD FOREIGN KEY fk_estado_comprobacion_viaticos_idxfk (fk_estado_comprobacion_viaticos) REFERENCES EstadoComprobacionViaticos (id);

	ALTER TABLE DocumentoComprobacionViaticos ADD FOREIGN KEY fk_comprobacion_viaticos_idxfk (fk_comprobacion_viaticos) REFERENCES ComprobacionViaticos (id);

	ALTER TABLE ComentarioContabilidad ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE MoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_descripcion_fondo_fijo_caja_chica_idxfk (fk_descripcion_fondo_fijo_caja_chica) REFERENCES DescripcionFondoFijoCajaChica (id);

	ALTER TABLE MoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_colaborador_idxfk_1 (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE MoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_entrega_idxfk_1 (fk_entrega) REFERENCES Colaborador (id);

	ALTER TABLE ComentarioMoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_moviemiento_fondo_fijo_caja_chica_idxfk (fk_moviemiento_fondo_fijo_caja_chica) REFERENCES MoviemientoFondoFijoCajaChica (id);

	ALTER TABLE ComentarioMoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_comentario_contabilidad_idxfk (fk_comentario_contabilidad) REFERENCES ComentarioContabilidad (id);

	ALTER TABLE MovimientoPagoContableServicio ADD FOREIGN KEY fk_descripcion_pago_contable_servicio_idxfk (fk_descripcion_pago_contable_servicio) REFERENCES DescripcionPagoContableServicio (id);

	ALTER TABLE MovimientoPagoContableServicio ADD FOREIGN KEY fk_proveedor_calificado_idxfk (fk_proveedor_calificado) REFERENCES ProveedorCalificado (id);

	ALTER TABLE MovimientoPagoContableServicio ADD FOREIGN KEY fk_proveedor_maquilador_idxfk (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE ComentarioMovimientoPagoContableServicio ADD FOREIGN KEY fk_movimiento_pago_contable_servicio_idxfk (fk_movimiento_pago_contable_servicio) REFERENCES MovimientoPagoContableServicio (id);

	ALTER TABLE ComentarioMovimientoPagoContableServicio ADD FOREIGN KEY fk_comentario_contabilidad_idxfk (fk_comentario_contabilidad) REFERENCES ComentarioContabilidad (id);

	ALTER TABLE ComentarioTesoreria ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE Cobranza ADD FOREIGN KEY fk_informacion_facturacion_idxfk (fk_informacion_facturacion) REFERENCES InformacionFacturacion (id);

	ALTER TABLE Cobranza ADD FOREIGN KEY fk_nota_credito_cliente_idxfk (fk_nota_credito_cliente) REFERENCES NotaCreditoCliente (id);

	ALTER TABLE Cobranza ADD FOREIGN KEY fk_banco_conectel_idxfk (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE ComentarioCobranza ADD FOREIGN KEY fk_cobranza_idxfk (fk_cobranza) REFERENCES Cobranza (id);

	ALTER TABLE ComentarioCobranza ADD FOREIGN KEY fk_comentario_tesoreria_idxfk (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	ALTER TABLE PagoProveedor ADD FOREIGN KEY fk_banco_conectel_idxfk (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE ComentarioPagoProveedor ADD FOREIGN KEY fk_pago_proveedor_idxfk (fk_pago_proveedor) REFERENCES PagoProveedor (id);

	ALTER TABLE ComentarioPagoProveedor ADD FOREIGN KEY fk_comentario_tesoreria_idxfk (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	ALTER TABLE PagoViaticos ADD FOREIGN KEY fk_solicitud_viaticos_idxfk (fk_solicitud_viaticos) REFERENCES SolicitudViaticos (id);

	ALTER TABLE PagoViaticos ADD FOREIGN KEY fk_banco_conectel_idxfk_2 (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE ComentarioPagoViaticos ADD FOREIGN KEY fk_pago_viaticos_idxfk (fk_pago_viaticos) REFERENCES PagoViaticos (id);

	ALTER TABLE ComentarioPagoViaticos ADD FOREIGN KEY fk_comentario_tesoreria_idxfk_2 (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	ALTER TABLE PagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_movimiento_pago_contable_servicio_idxfk (fk_movimiento_pago_contable_servicio) REFERENCES MovimientoPagoContableServicio (id);

	ALTER TABLE PagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_banco_conectel_idxfk (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE PagoOtraOperacionFinanciera ADD FOREIGN KEY fk_concepto_otra_operacion_financiera_idxfk (fk_concepto_otra_operacion_financiera) REFERENCES ConceptoOtraOperacionFinanciera (id);

	ALTER TABLE PagoOtraOperacionFinanciera ADD FOREIGN KEY fk_banco_conectel_idxfk_2 (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE ComentarioPagoOtraOperacionFinanciera ADD FOREIGN KEY fk_pago_otra_operacion_financiera_idxfk (fk_pago_otra_operacion_financiera) REFERENCES PagoOtraOperacionFinanciera (id);

	ALTER TABLE ComentarioPagoOtraOperacionFinanciera ADD FOREIGN KEY fk_comentario_tesoreria_idxfk_2 (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	ALTER TABLE ComentarioPagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_pago_movimiento_pago_contable_servicio_idxfk (fk_pago_movimiento_pago_contable_servicio) REFERENCES PagoMovimientoPagoContableServicio (id);

	ALTER TABLE ComentarioPagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_comentario_tesoreria_idxfk_3 (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	/* Recursos Humanos */
	ALTER TABLE Prestaciones ADD FOREIGN KEY fk_contratacion_idxfk (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_seleccion_solicitud_empleo_idxfk (fk_seleccion_solicitud_empleo) REFERENCES SeleccionReclutamiento (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_colaborador_idxfk (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_tipo_contratacion_idxfk (fk_tipo_contratacion) REFERENCES TipoContratacion (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_tipo_contrato_idxfk (fk_tipo_contrato) REFERENCES TipoContrato (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_suspension_idxfk (fk_suspension) REFERENCES Suspension (id);

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_motivo_termino_contrato_idxfk (fk_motivo_termino_contrato) REFERENCES MotivoTerminoContrato (id);

	ALTER TABLE DocumentosContratacion ADD FOREIGN KEY fk_contratacion_idxfk_1 (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE DatosEscolaresHabilidades ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_1 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE DatosEscolaresHabilidades ADD FOREIGN KEY fk_ultimo_grado_estudios_idxfk (fk_ultimo_grado_estudios) REFERENCES UltimoGradoEstudios (id);

	ALTER TABLE DatosEscolaresHabilidades ADD FOREIGN KEY fk_estado_academico_idxfk (fk_estado_academico) REFERENCES EstadoAcademico (id);

	ALTER TABLE Paqueteria ADD FOREIGN KEY fk_datos_escolares_habilidades_idxfk (fk_datos_escolares_habilidades) REFERENCES DatosEscolaresHabilidades (id);

	ALTER TABLE EquipoOficinaDomina ADD FOREIGN KEY fk_datos_escolares_habilidades_idxfk_1 (fk_datos_escolares_habilidades) REFERENCES DatosEscolaresHabilidades (id);

	ALTER TABLE DatosUltimoEmpleoSolicitante ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_2 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE DatosFamiliaresSolicitante ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_3 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE DatosFamiliaresSolicitante ADD FOREIGN KEY fk_vive_con_idxfk (fk_vive_con) REFERENCES ViveCon (id);

	ALTER TABLE DatosFamiliaresSolicitante ADD FOREIGN KEY fk_dependientes_idxfk (fk_dependientes) REFERENCES Dependientes (id);

	ALTER TABLE DatosSobreConectelSolicitante ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_4 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE DatosSobreConectelSolicitante ADD FOREIGN KEY fk_fuente_reclutamiento_idxfk (fk_fuente_reclutamiento) REFERENCES FuenteReclutamiento (id);

	ALTER TABLE DatosSobreConectelSolicitante ADD FOREIGN KEY fk_fase_seleccion_idxfk (fk_fase_seleccion) REFERENCES FaseSeleccion (id);

	ALTER TABLE DatosPrincipalesSolicitante ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_5 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE Licencia ADD FOREIGN KEY fk_tipo_licencia_idxfk (fk_tipo_licencia) REFERENCES TipoLicencia (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_6 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_nacionalidad_idxfk (fk_nacionalidad) REFERENCES Nacionalidad (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_identificacion_idxfk (fk_identificacion) REFERENCES Identificacion (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_documentacion_extranjeros_idxfk (fk_documentacion_extranjeros) REFERENCES DocumentacionExtranjeros (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_estado_civil_idxfk (fk_estado_civil) REFERENCES EstadoCivil (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_sexo_idxfk (fk_sexo) REFERENCES Sexo (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_direccion_solicitante_idxfk (fk_direccion_solicitante) REFERENCES DireccionSolicitante (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_licencia_idxfk (fk_licencia) REFERENCES Licencia (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_carta_antecedentes_penales_idxfk (fk_carta_antecedentes_penales) REFERENCES CartaAntecedentesPenales (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_estado_salud_idxfk (fk_estado_salud) REFERENCES EstadoSalud (id);

	ALTER TABLE DatosGeneralesSolicitante ADD FOREIGN KEY fk_tiempo_libre_idxfk (fk_tiempo_libre) REFERENCES ActividadTiempoLibre (id);

	ALTER TABLE SeleccionReclutamiento ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk_7 (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

	ALTER TABLE SeleccionReclutamiento ADD FOREIGN KEY fk_tipo_candidato_idxfk (fk_tipo_candidato) REFERENCES TipoCandidato (id);

	ALTER TABLE SeleccionReclutamiento ADD FOREIGN KEY fk_fase_contratacion_idxfk (fk_fase_contratacion) REFERENCES FaseContratacion (id);

	ALTER TABLE PerfilEscala ADD FOREIGN KEY fk_seleccion_reclutamiento_idxfk (fk_seleccion_reclutamiento) REFERENCES SeleccionReclutamiento (id);

	ALTER TABLE ExamenPsicometrico ADD FOREIGN KEY fk_seleccion_reclutamiento_idxfk_1 (fk_seleccion_reclutamiento) REFERENCES SeleccionReclutamiento (id);

	ALTER TABLE InformacionConfidencialColaborador ADD FOREIGN KEY fk_contratacion_idxfk_2 (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE InformacionConfidencialColaborador ADD FOREIGN KEY fk_estado_colaborador_idxfk (fk_estado_colaborador) REFERENCES EstadoColaborador (id);

	ALTER TABLE Curso ADD FOREIGN KEY fk_contratacion_idxfk (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_contratacion_idxfk_1 (fk_contratacion) REFERENCES InformacionConfidencialColaborador (id);

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_percepcion_idxfk (fk_percepcion) REFERENCES Percepcion (id);

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_variaciones_idxfk (fk_variaciones) REFERENCES Variacion (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_contratacion_idxfk_4 (fk_contratacion) REFERENCES InformacionConfidencialColaborador (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_clase_incidencia_idxfk (fk_clase_incidencia) REFERENCES ClaseIncidencia (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_tipo_incapacidad_idxfk (fk_tipo_incapacidad) REFERENCES TipoIncapacidad (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_contratacion_idxfk_5 (fk_contratacion) REFERENCES InformacionConfidencialColaborador (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_deduccion_idxfk (fk_deduccion) REFERENCES Deduccion (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_clasificacion_falta_idxfk (fk_clasificacion_falta) REFERENCES ClasificacionFalta (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_clasificacion_permiso_idxfk (fk_clasificacion_permiso) REFERENCES ClasificacionPermiso (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_tipo_sancion_idxfk (fk_tipo_sancion) REFERENCES TipoSancion (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_forma_pago_prenomina_idxfk (fk_forma_pago_prenomina) REFERENCES FormaPagoPrenomina (id);

	/* Sistema de Gestion */
	ALTER TABLE SistemaGestion ADD FOREIGN KEY fk_proyecto_idxfk_2 (fk_proyecto) REFERENCES Proyecto (id);

	ALTER TABLE SistemaGestion ADD FOREIGN KEY fk_tipo_auditoria_idxfk (fk_tipo_auditoria) REFERENCES TipoAuditoria (id);

	ALTER TABLE SistemaGestion ADD FOREIGN KEY fk_forma_auditoria_idxfk (fk_forma_auditoria) REFERENCES FormaAuditoria (id);

	ALTER TABLE SistemaGestion ADD FOREIGN KEY fk_estado_sistema_gestion_idxfk (fk_estado_sistema_gestion) REFERENCES EstadoSistemaGestion (id);

	ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_colaborador_idxfk (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_estado_concentrado_capacitacion_idxfk (fk_estado_concentrado_capacitacion) REFERENCES EstadoConcentradoCapacitacion (id);

    ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_tipo_formacion_idxfk (fk_tipo_formacion) REFERENCES TipoFormacion (id);

	ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_tipo_capacitacion_idxfk (fk_tipo_capacitacion) REFERENCES TipoCapacitacion (id);

	ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_estatus_concentrado_capacitacion_idxfk (fk_estatus_concentrado_capacitacion) REFERENCES EstatusConcentradoCapacitacion (id);

	ALTER TABLE Sugerencia ADD FOREIGN KEY fk_colaborador_idxfk_1 (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE Sugerencia ADD FOREIGN KEY fk_resultado_implementacion_idxfk (fk_resultado_implementacion) REFERENCES ResultadoImplementacion (id);

	ALTER TABLE NoConformidad ADD FOREIGN KEY fk_area_levanta_no_conformidad_idxfk (fk_area_levanta_no_conformidad) REFERENCES AreaLevantaNoConformidad (id);

	ALTER TABLE NoConformidad ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE AccionPreventivaCorrectiva ADD FOREIGN KEY fk_no_conformidad_idxfk (fk_no_conformidad) REFERENCES NoConformidad (id);

	ALTER TABLE AccionPreventivaCorrectiva ADD FOREIGN KEY fk_tipo_accion_idxfk (fk_tipo_accion) REFERENCES TipoAccion (id);

	ALTER TABLE AccionPreventivaCorrectiva ADD FOREIGN KEY fk_fuente_no_conformidad_idxfk (fk_fuente_no_conformidad) REFERENCES FuenteNoConformidad (id);

	ALTER TABLE AccionPreventivaCorrectiva ADD FOREIGN KEY fk_estado_accion_preventiva_correctiva_idxfk (fk_estado_accion_preventiva_correctiva) REFERENCES EstadoAccionPreventivaCorrectiva (id);

	ALTER TABLE AcuerdoMinuta ADD FOREIGN KEY fk_minuta_idxfk (fk_minuta) REFERENCES Minuta (id);

	ALTER TABLE AcuerdoMinuta ADD FOREIGN KEY fk_responsable_minuta_idxfk (fk_responsable_minuta) REFERENCES ResponsableMinuta (id);

	ALTER TABLE ParticipanteMinuta ADD FOREIGN KEY fk_minuta_idxfk_1 (fk_minuta) REFERENCES Minuta (id);

	ALTER TABLE ParticipanteMinuta ADD FOREIGN KEY fk_colaborador_idxfk_2 (fk_colaborador) REFERENCES Colaborador (id);

	/* Notifiaciones */
	ALTER TABLE Notificacion ADD FOREIGN KEY fk_perfil_idxfk (fk_perfil) REFERENCES Perfil (id);

	ALTER TABLE Notificacion ADD FOREIGN KEY fk_estado_idxfk (fk_estado) REFERENCES EstadoNotificacion (id);

	ALTER TABLE Notificacion ADD FOREIGN KEY fk_usuario_creacion_idxfk (fk_usuario_creacion) REFERENCES Usuario (id);

	ALTER TABLE Notificacion ADD FOREIGN KEY fk_usuario_modificacion_idxfk (fk_usuario_modificacion) REFERENCES Usuario (id);

	/* Cambios */
	ALTER TABLE DesarrolloProyectoAyB ADD FOREIGN KEY fk_tipo_desarrollo_proyecto_idxfk (fk_tipo_desarrollo_proyecto) REFERENCES TipoDesarrolloProyecto (id);

	ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_autoriza_final_idxfk (fk_autoriza_final) REFERENCES Colaborador (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY fk_tipo_auditoria_idxfk (fk_tipo_auditoria) REFERENCES TipoAuditoria (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_calibracion_idxfk_1 (fk_calibracion) REFERENCES Calibracion (id);

	ALTER TABLE EquipoMedicion ADD FOREIGN KEY fk_mantenimiento_servicio_idxfk_1 (fk_mantenimiento_servicio) REFERENCES MantenimientoServicio (id);

	ALTER TABLE ProveedorMaquilador ADD FOREIGN KEY fk_forma_pago_maquilador_idxfk (fk_forma_pago_maquilador) REFERENCES FormaPagoMaquilador (id);

	ALTER TABLE PartidaRequisicionCompra ADD FOREIGN KEY fk_validacion_idxfk (fk_validacion) REFERENCES Colaborador (id);

	ALTER TABLE InformacionFacturacion ADD FOREIGN KEY fk_imputable_idxfk_2 (fk_imputable) REFERENCES Imputable (id);

	ALTER TABLE SolicitanteSolicitudViaticos ADD FOREIGN KEY fk_solicitud_viaticos_idxfk_2 (fk_solicitud_viaticos) REFERENCES SolicitudViaticos (id);

	ALTER TABLE SolicitanteSolicitudViaticos ADD FOREIGN KEY fk_colaborador_idxfk_3 (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE ComentarioSugerencia ADD FOREIGN KEY fk_sugerencia_idxfk (fk_sugerencia) REFERENCES Sugerencia (id);

	ALTER TABLE ComentarioSugerencia ADD FOREIGN KEY fk_comentario_sistemas_gestion_idxfk (fk_comentario_sistemas_gestion) REFERENCES ComentarioSistemasGestion (id);

	ALTER TABLE DescripcionFondoFijoCajaChica ADD FOREIGN KEY fk_tipo_operacion_idxfk (fk_tipo_operacion) REFERENCES TipoOperacion (id);

	ALTER TABLE Proyecto ADD FOREIGN KEY fk_tipo_servicio_idxfk (fk_tipo_servicio) REFERENCES TipoServicio (id);

	ALTER TABLE EquipoTransporte ADD FOREIGN KEY fk_mantenimiento_servicio_idxfk_2 (fk_mantenimiento_servicio) REFERENCES MantenimientoServicio (id);

	ALTER TABLE FacturaProveedorPagoProveedor ADD FOREIGN KEY fk_pago_proveedor_idxfk_2 (fk_pago_proveedor) REFERENCES PagoProveedor (id);

	ALTER TABLE FacturaProveedorPagoProveedor ADD FOREIGN KEY fk_factura_proveedor_idxfk_2 (fk_factura_proveedor) REFERENCES FacturaProveedor (id);

	ALTER TABLE NotaCreditoProveedorPagoProveedor ADD FOREIGN KEY fk_pago_proveedor_idxfk_3 (fk_pago_proveedor) REFERENCES PagoProveedor (id);

	ALTER TABLE NotaCreditoProveedorPagoProveedor ADD FOREIGN KEY fk_nota_credito_proveedor_idxfk_2 (fk_nota_credito_proveedor) REFERENCES NotaCreditoProveedor (id);

	ALTER TABLE AccionPreventivaCorrectiva ADD FOREIGN KEY fk_sugerencia_idxfk_2 (fk_sugerencia) REFERENCES Sugerencia (id);

	ALTER TABLE ComentarioSistemasGestion ADD FOREIGN KEY fk_usuario_idxfk_9 (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE ComentarioRecursosHumanos ADD FOREIGN KEY fk_usuario_idxfk_10 (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE ComentarioSolicitudPermiso ADD FOREIGN KEY fk_solicitud_permiso_idxfk (fk_solicitud_permiso) REFERENCES SolicitudPermiso (id);

	ALTER TABLE ComentarioSolicitudPermiso ADD FOREIGN KEY fk_comentario_recursos_humanos_idxfk (fk_comentario_recursos_humanos) REFERENCES ComentarioRecursosHumanos (id);

	ALTER TABLE SolicitudPermiso ADD FOREIGN KEY fk_contratacion_idxfk_6 (fk_contratacion) REFERENCES InformacionConfidencialColaborador (id);

	ALTER TABLE SolicitudPermiso ADD FOREIGN KEY fk_forma_pago_prenomina_idxfk_2 (fk_forma_pago_prenomina) REFERENCES FormaPagoPrenomina (id);

	ALTER TABLE SolicitudPermiso ADD FOREIGN KEY fk_permiso_sin_goce_sueldo_idxfk (fk_permiso_sin_goce_sueldo) REFERENCES PermisoSinGoceSueldo (id);

	ALTER TABLE SolicitudPermiso ADD FOREIGN KEY fk_permiso_con_goce_sueldo_idxfk (fk_permiso_con_goce_sueldo) REFERENCES PermisoConGoceSueldo (id);

	ALTER TABLE SolicitudVacaciones ADD FOREIGN KEY fk_contratacion_idxfk_7 (fk_contratacion) REFERENCES InformacionConfidencialColaborador (id);

	ALTER TABLE SolicitudVacaciones ADD FOREIGN KEY fk_variacion_idxfk (fk_variacion) REFERENCES Variacion (id);
	
	ALTER TABLE ComentarioSolicitudVacaciones ADD FOREIGN KEY fk_solicitud_vacaciones_idxfk (fk_solicitud_vacaciones) REFERENCES SolicitudVacaciones (id);

	ALTER TABLE ComentarioSolicitudVacaciones ADD FOREIGN KEY fk_comentario_recursos_humanos_idxfk_2 (fk_comentario_recursos_humanos) REFERENCES ComentarioRecursosHumanos (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_trimestre_idxfk (fk_trimestre) REFERENCES Trimestre (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_ano_idxfk (fk_ano) REFERENCES Ano (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_rango_estadistica_personal_ausencia_idxfk (fk_rango_estadistica_personal_ausencia) REFERENCES RangoEstadisticaPersonal (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_rango_estadistica_personal_puntualidad_idxfk (fk_rango_estadistica_personal_puntualidad) REFERENCES RangoEstadisticaPersonal (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_rango_estadistica_personal_rotacion_idxfk (fk_rango_estadistica_personal_rotacion) REFERENCES RangoEstadisticaPersonal (id);

	ALTER TABLE EstadisticaPersonal ADD FOREIGN KEY fk_rango_estadistica_personal_retardo_idxfk (fk_rango_estadistica_personal_retardo) REFERENCES RangoEstadisticaPersonal (id);

	ALTER TABLE ConsumibleSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE EquipoMedicionSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_2 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE EquipoTransporteSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_3 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE HardwareSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_4 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE HerramientaSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_5 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE MaterialSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_6 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE SoftwareSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_7 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	ALTER TABLE TelefoniaMovilSolicitudAlmacen ADD FOREIGN KEY fk_estatus_devolucion_idxfk_8 (fk_estatus_devolucion) REFERENCES EstatusDevolucion (id);

	/*************************************************************************************************************************************
	CAMBIOS
	/************************************************************************************************************************************/

	ALTER TABLE ArchivoCotizacion ADD FOREIGN KEY fk_cotizacion_idxfk_2 (fk_cotizacion) REFERENCES Cotizacion (id);

	ALTER TABLE PartidaRequisicionCompra ADD FOREIGN KEY fk_orden_compra_idxfk_3 (fk_orden_compra) REFERENCES OrdenCompra (id);	

    ALTER TABLE SolicitudAlmacen ADD FOREIGN KEY fk_perfil_idxfk_1 (fk_perfil) REFERENCES Perfil (id);

    ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_perfil_idxfk_2 (fk_perfil) REFERENCES Perfil (id);

    ALTER TABLE SolicitudViaticos ADD FOREIGN KEY fk_perfil_idxfk_3 (fk_perfil) REFERENCES Perfil (id);

    ALTER TABLE SolicitudPermiso ADD FOREIGN KEY fk_perfil_idxfk_4 (fk_perfil) REFERENCES Perfil (id);

    ALTER TABLE SolicitudVacaciones ADD FOREIGN KEY fk_perfil_idxfk_5 (fk_perfil) REFERENCES Perfil (id);
    
    ALTER TABLE NoConformidad ADD FOREIGN KEY fk_perfil_idxfk_6 (fk_perfil) REFERENCES Perfil (id);
    
    ALTER TABLE Sugerencia ADD FOREIGN KEY fk_perfil_idxfk_7 (fk_perfil) REFERENCES Perfil (id);
    
    ALTER TABLE ConcentradoCapacitacion ADD FOREIGN KEY fk_perfil_idxfk_8 (fk_perfil) REFERENCES Perfil (id);
    
    ALTER TABLE PagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_tipo_pago_idxfk_2 (fk_tipo_pago) REFERENCES TipoPago (id);

    ALTER TABLE PagoOtraOperacionFinanciera ADD FOREIGN KEY fk_tipo_pago_idxfk_3 (fk_tipo_pago) REFERENCES TipoPago (id);
	/*************************************************************************************************************************************
	FIN CAMBIOS
	/************************************************************************************************************************************/

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
	INSERT INTO Perfil
	VALUES (7, 'Compras');
	INSERT INTO Perfil
	VALUES (8, 'Público');
	INSERT INTO Perfil
	VALUES (9, 'Cuentas por Pagar');
	INSERT INTO Perfil
	VALUES (10, 'Facturación');
	INSERT INTO Perfil
	VALUES (11, 'Contabilidad');
	INSERT INTO Perfil
	VALUES (12, 'Tesorería');
	INSERT INTO Perfil
	VALUES (13, 'Recursos Humanos');
	INSERT INTO Perfil
	VALUES (14, 'Sistemas Gestión');
	INSERT INTO Perfil
	VALUES (15, 'Validación Administrativa');	

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
	INSERT INTO Pantalla
	VALUES (9, 'Almacen');
	INSERT INTO Pantalla
	VALUES (10, 'ProveedoresSeleccionados');
	INSERT INTO Pantalla
	VALUES (11, 'ProveedoresCalificados');
	INSERT INTO Pantalla
	VALUES (12, 'ProveedoresMaquiladores');
	INSERT INTO Pantalla
	VALUES (13, 'RequisicionesCompra');
	INSERT INTO Pantalla
	VALUES (14, 'SolicitudServicioMaquilado');
	INSERT INTO Pantalla
	VALUES (15, 'Cotizaciones');
	INSERT INTO Pantalla
	VALUES (16, 'OrdenesCompraAlmacen');
	INSERT INTO Pantalla
	VALUES (17, 'OrdenesCompraServicioMaquilado');
	INSERT INTO Pantalla
	VALUES (18, 'FacturacionCompra');
	INSERT INTO Pantalla
	VALUES (19, 'PreciariosMaquiladores');
	INSERT INTO Pantalla
	VALUES (20, 'ProyectosPadres');
	INSERT INTO Pantalla
	VALUES (21, 'ValidacionesProyectos');
	INSERT INTO Pantalla
	VALUES (22, 'OrdenesCompraClientes');
	INSERT INTO Pantalla
	VALUES (23, 'FacturacionProveedores');
	INSERT INTO Pantalla
	VALUES (24, 'ValidacionesAdministrativas');
	INSERT INTO Pantalla
	VALUES (25, 'ConcentradoOrdenesCompra');
	INSERT INTO Pantalla
	VALUES (26, 'SolicitudAlmacenModule');
	INSERT INTO Pantalla
	VALUES (27, 'NotasCreditoProveedores');
	INSERT INTO Pantalla
	VALUES (28, 'InformacionFacturas');
	INSERT INTO Pantalla
	VALUES (29, 'NotasCreditoClientes');
	INSERT INTO Pantalla
	VALUES (30, 'ComprobacionesViaticos');
	INSERT INTO Pantalla
	VALUES (31, 'FondosFijosCajaChica');
	INSERT INTO Pantalla
	VALUES (32, 'PagosContablesServicios');
	INSERT INTO Pantalla
	VALUES (33, 'SolicitudesViaticos');
	INSERT INTO Pantalla
	VALUES (34, 'Cobranza');
	INSERT INTO Pantalla
	VALUES (35, 'PagoProveedores');
	INSERT INTO Pantalla
	VALUES (36, 'PagoViaticos');
	INSERT INTO Pantalla
	VALUES (37, 'PagoPagosContablesServicios');
	INSERT INTO Pantalla
	VALUES (38, 'OtrasOperacionesFinancieras');
	INSERT INTO Pantalla
	VALUES (39, 'ReclutamientoSolicitudEmpleo');
	INSERT INTO Pantalla
	VALUES (40, 'Seleccion');
	INSERT INTO Pantalla
	VALUES (41, 'Contratacion');
	INSERT INTO Pantalla
	VALUES (42, 'AdministracionColaborador');
	INSERT INTO Pantalla
	VALUES (43, 'Prenomina');
	INSERT INTO Pantalla
	VALUES (44, 'EntrenamientoDesarrollo');
	INSERT INTO Pantalla
	VALUES (45, 'Deducciones');
	INSERT INTO Pantalla
	VALUES (46, 'Percepciones');
	INSERT INTO Pantalla
	VALUES (47, 'ComentariosSugerencias');
	INSERT INTO Pantalla
	VALUES (48, 'BitacoraProductoNoConformeNoConformidades');
	INSERT INTO Pantalla
	VALUES (49, 'AccionPreventivaCorrectiva');
	INSERT INTO Pantalla
	VALUES (50, 'ConcentradoCapacitacion');
	INSERT INTO Pantalla
	VALUES (51, 'SistemasGestion');
	INSERT INTO Pantalla
	VALUES (52, 'MinutaReunion');
	INSERT INTO Pantalla
	VALUES (53, 'GraficaEvaluacionFacturacionProyectosConectel');
	INSERT INTO Pantalla
	VALUES (54, 'SolicitudesPermiso');
	INSERT INTO Pantalla
	VALUES (55, 'SolicitudesVacaciones');
	INSERT INTO Pantalla
	VALUES (56, 'FichaPresentacion');
	INSERT INTO Pantalla
	VALUES (57, 'EstadisticaPersonal');
	INSERT INTO Pantalla
	VALUES (58, 'ConsultaGeneralOperacion');
	INSERT INTO Pantalla
	VALUES (59, 'ValesDevoluciones');
	
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
	INSERT INTO PerfilPantalla
	VALUES (15, 1, 9);
	INSERT INTO PerfilPantalla
	VALUES (16, 3, 9);
	INSERT INTO PerfilPantalla
	VALUES (17, 1, 10);
	INSERT INTO PerfilPantalla
	VALUES (18, 1, 11);
	INSERT INTO PerfilPantalla
	VALUES (19, 1, 12);
	INSERT INTO PerfilPantalla
	VALUES (20, 1, 13);
	INSERT INTO PerfilPantalla
	VALUES (21, 1, 14);
	INSERT INTO PerfilPantalla
	VALUES (22, 1, 15);
	INSERT INTO PerfilPantalla
	VALUES (23, 1, 16);
	INSERT INTO PerfilPantalla
	VALUES (24, 1, 17);
	INSERT INTO PerfilPantalla
	VALUES (25, 1, 18);
	INSERT INTO PerfilPantalla
	VALUES (26, 1, 19);
	INSERT INTO PerfilPantalla
	VALUES (27, 7, 10);
	INSERT INTO PerfilPantalla
	VALUES (28, 7, 11);
	INSERT INTO PerfilPantalla
	VALUES (29, 7, 12);
	INSERT INTO PerfilPantalla
	VALUES (30, 7, 13);
	INSERT INTO PerfilPantalla
	VALUES (31, 7, 14);
	INSERT INTO PerfilPantalla
	VALUES (32, 7, 15);
	INSERT INTO PerfilPantalla
	VALUES (33, 7, 16);
	INSERT INTO PerfilPantalla
	VALUES (34, 7, 17);
	INSERT INTO PerfilPantalla
	VALUES (35, 7, 18);
	INSERT INTO PerfilPantalla
	VALUES (36, 7, 19);
	INSERT INTO PerfilPantalla
	VALUES (37, 1, 20);
	INSERT INTO PerfilPantalla
	VALUES (38, 5, 20);
	INSERT INTO PerfilPantalla
	VALUES (39, 1, 21);
	INSERT INTO PerfilPantalla
	VALUES (40, 1, 22);
	INSERT INTO PerfilPantalla
	VALUES (41, 1, 23);
	INSERT INTO PerfilPantalla
	VALUES (42, 1, 24);
	INSERT INTO PerfilPantalla
	VALUES (43, 1, 25);
	INSERT INTO PerfilPantalla
	VALUES (44, 15, 21);
	INSERT INTO PerfilPantalla
	VALUES (45, 15, 22);
	INSERT INTO PerfilPantalla
	VALUES (46, 9, 23);
	INSERT INTO PerfilPantalla
	VALUES (47, 15, 24);
	INSERT INTO PerfilPantalla
	VALUES (48, 15, 25);
	INSERT INTO PerfilPantalla
	VALUES (49, 1, 26);
	INSERT INTO PerfilPantalla
	VALUES (50, 2, 26);
	INSERT INTO PerfilPantalla
	VALUES (51, 3, 26);
	INSERT INTO PerfilPantalla
	VALUES (52, 4, 26);
	INSERT INTO PerfilPantalla
	VALUES (53, 5, 26);
	INSERT INTO PerfilPantalla
	VALUES (54, 6, 26);
	INSERT INTO PerfilPantalla
	VALUES (55, 7, 26);
	INSERT INTO PerfilPantalla
	VALUES (56, 8, 26);
	INSERT INTO PerfilPantalla
	VALUES (57, 9, 26);
	INSERT INTO PerfilPantalla
	VALUES (58, 9, 23);
	INSERT INTO PerfilPantalla
	VALUES (59, 9, 27);
	INSERT INTO PerfilPantalla
	VALUES (60, 10, 28);
	INSERT INTO PerfilPantalla
	VALUES (61, 10, 29);
	INSERT INTO PerfilPantalla
	VALUES (62, 11, 30);
	INSERT INTO PerfilPantalla
	VALUES (63, 11, 31);
	INSERT INTO PerfilPantalla
	VALUES (64, 11, 32);
	INSERT INTO PerfilPantalla
	VALUES (65, 11, 33);
	INSERT INTO PerfilPantalla
	VALUES (66, 1, 28);
	INSERT INTO PerfilPantalla
	VALUES (67, 1, 29);
	INSERT INTO PerfilPantalla
	VALUES (68, 1, 30);
	INSERT INTO PerfilPantalla
	VALUES (69, 1, 31);
	INSERT INTO PerfilPantalla
	VALUES (70, 1, 32);
	INSERT INTO PerfilPantalla
	VALUES (71, 1, 33);
	INSERT INTO PerfilPantalla
	VALUES (72, 1, 27);
	INSERT INTO PerfilPantalla
	VALUES (73, 1, 23);
	INSERT INTO PerfilPantalla
	VALUES (74, 12, 34);
	INSERT INTO PerfilPantalla
	VALUES (75, 12, 35);
	INSERT INTO PerfilPantalla
	VALUES (76, 12, 36);
	INSERT INTO PerfilPantalla
	VALUES (77, 12, 37);
	INSERT INTO PerfilPantalla
	VALUES (78, 12, 38);
	INSERT INTO PerfilPantalla
	VALUES (79, 1, 34);
	INSERT INTO PerfilPantalla
	VALUES (80, 1, 35);
	INSERT INTO PerfilPantalla
	VALUES (81, 1, 36);
	INSERT INTO PerfilPantalla
	VALUES (82, 1, 37);
	INSERT INTO PerfilPantalla
	VALUES (83, 1, 38);
	INSERT INTO PerfilPantalla
	VALUES (84, 13, 39);
	INSERT INTO PerfilPantalla
	VALUES (85, 13, 40);
	INSERT INTO PerfilPantalla
	VALUES (86, 13, 41);
	INSERT INTO PerfilPantalla
	VALUES (87, 13, 42);
	INSERT INTO PerfilPantalla
	VALUES (88, 13, 43);
	INSERT INTO PerfilPantalla
	VALUES (89, 13, 44);
	INSERT INTO PerfilPantalla
	VALUES (90, 1, 39);
	INSERT INTO PerfilPantalla
	VALUES (91, 1, 40);
	INSERT INTO PerfilPantalla
	VALUES (92, 1, 41);
	INSERT INTO PerfilPantalla
	VALUES (93, 1, 42);
	INSERT INTO PerfilPantalla
	VALUES (94, 1, 43);
	INSERT INTO PerfilPantalla
	VALUES (95, 1, 44);
	INSERT INTO PerfilPantalla
	VALUES (96, 13, 45);
	INSERT INTO PerfilPantalla
	VALUES (97, 13, 46);
	INSERT INTO PerfilPantalla
	VALUES (98, 1, 45);
	INSERT INTO PerfilPantalla
	VALUES (99, 1, 46);
	INSERT INTO PerfilPantalla
	VALUES (100, 14, 47);
	INSERT INTO PerfilPantalla
	VALUES (101, 14, 48);
	INSERT INTO PerfilPantalla
	VALUES (102, 14, 49);
	INSERT INTO PerfilPantalla
	VALUES (103, 14, 50);
	INSERT INTO PerfilPantalla
	VALUES (104, 14, 51);
	INSERT INTO PerfilPantalla
	VALUES (105, 14, 52);
	INSERT INTO PerfilPantalla
	VALUES (106, 14, 53);
	INSERT INTO PerfilPantalla
	VALUES (107, 1, 47);
	INSERT INTO PerfilPantalla
	VALUES (108, 1, 48);
	INSERT INTO PerfilPantalla
	VALUES (109, 1, 49);
	INSERT INTO PerfilPantalla
	VALUES (110, 1, 50);
	INSERT INTO PerfilPantalla
	VALUES (111, 1, 51);
	INSERT INTO PerfilPantalla
	VALUES (112, 1, 52);
	INSERT INTO PerfilPantalla
	VALUES (113, 1, 53);
	INSERT INTO PerfilPantalla
	VALUES (114, 3, 8);
	INSERT INTO PerfilPantalla
	VALUES (115, 12, 8);
	INSERT INTO PerfilPantalla
	VALUES (116, 10, 8);
	INSERT INTO PerfilPantalla
	VALUES (117, 15, 8);
	INSERT INTO PerfilPantalla
	VALUES (118, 11, 8);
	INSERT INTO PerfilPantalla
	VALUES (119, 5, 8);
	INSERT INTO PerfilPantalla
	VALUES (120, 6, 8);
	INSERT INTO PerfilPantalla
	VALUES (121, 4, 8);
	INSERT INTO PerfilPantalla
	VALUES (122, 7, 8);
	INSERT INTO PerfilPantalla
	VALUES (123, 8, 8);
	INSERT INTO PerfilPantalla
	VALUES (124, 9, 8);
	INSERT INTO PerfilPantalla
	VALUES (125, 13, 8);
	INSERT INTO PerfilPantalla
	VALUES (126, 14, 8);
	INSERT INTO PerfilPantalla
	VALUES (127, 1, 54);
	INSERT INTO PerfilPantalla
	VALUES (128, 1, 55);
	INSERT INTO PerfilPantalla
	VALUES (129, 13, 54);
	INSERT INTO PerfilPantalla
	VALUES (130, 13, 55);
	INSERT INTO PerfilPantalla
	VALUES (131, 1, 56);
	INSERT INTO PerfilPantalla
	VALUES (132, 1, 57);
	INSERT INTO PerfilPantalla
	VALUES (133, 13, 56);
	INSERT INTO PerfilPantalla
	VALUES (134, 13, 57);
	INSERT INTO PerfilPantalla
	VALUES (135, 1, 58);
	INSERT INTO PerfilPantalla
	VALUES (136, 6, 58);
	INSERT INTO PerfilPantalla
	VALUES (137, 10, 26);
	INSERT INTO PerfilPantalla
	VALUES (138, 11, 26);
	INSERT INTO PerfilPantalla
	VALUES (139, 12, 26);
	INSERT INTO PerfilPantalla
	VALUES (140, 13, 26);
	INSERT INTO PerfilPantalla
	VALUES (141, 14, 26);
	INSERT INTO PerfilPantalla
	VALUES (142, 15, 26);
	INSERT INTO PerfilPantalla
	VALUES (143, 2, 8);
	INSERT INTO PerfilPantalla
	VALUES (144, 1, 59);
	INSERT INTO PerfilPantalla
	VALUES (145, 3, 59);
    INSERT INTO PerfilPantalla
	VALUES (146, 2, 13);
    INSERT INTO PerfilPantalla
	VALUES (147, 3, 13);
    INSERT INTO PerfilPantalla
	VALUES (148, 4, 13);
    INSERT INTO PerfilPantalla
	VALUES (149, 5, 13);
    INSERT INTO PerfilPantalla
	VALUES (150, 6, 13);
    INSERT INTO PerfilPantalla
	VALUES (151, 8, 13);
    INSERT INTO PerfilPantalla
	VALUES (152, 9, 13);
    INSERT INTO PerfilPantalla
	VALUES (153, 10, 13);
    INSERT INTO PerfilPantalla
	VALUES (154, 11, 13);
    INSERT INTO PerfilPantalla
	VALUES (155, 12, 13);
    INSERT INTO PerfilPantalla
	VALUES (156, 13, 13);
    INSERT INTO PerfilPantalla
	VALUES (157, 14, 13);
    INSERT INTO PerfilPantalla
	VALUES (158, 15, 13);
    INSERT INTO PerfilPantalla
	VALUES (159, 2, 33);
    INSERT INTO PerfilPantalla
	VALUES (160, 3, 33);
    INSERT INTO PerfilPantalla
	VALUES (161, 4, 33);
    INSERT INTO PerfilPantalla
	VALUES (162, 5, 33);
    INSERT INTO PerfilPantalla
	VALUES (163, 6, 33);
    INSERT INTO PerfilPantalla
	VALUES (164, 7, 33);
    INSERT INTO PerfilPantalla
	VALUES (165, 8, 33);
    INSERT INTO PerfilPantalla
	VALUES (166, 9, 33);
    INSERT INTO PerfilPantalla
	VALUES (167, 10, 33);
    INSERT INTO PerfilPantalla
	VALUES (168, 12, 33);
    INSERT INTO PerfilPantalla
	VALUES (169, 13, 33);
    INSERT INTO PerfilPantalla
	VALUES (170, 14, 33);
    INSERT INTO PerfilPantalla
	VALUES (171, 15, 33);
    INSERT INTO PerfilPantalla
	VALUES (172, 2, 54);
    INSERT INTO PerfilPantalla
	VALUES (173, 3, 54);
    INSERT INTO PerfilPantalla
	VALUES (174, 4, 54);
    INSERT INTO PerfilPantalla
	VALUES (175, 5, 54);
    INSERT INTO PerfilPantalla
	VALUES (176, 6, 54);
    INSERT INTO PerfilPantalla
	VALUES (177, 7, 54);
    INSERT INTO PerfilPantalla
	VALUES (178, 8, 54);
    INSERT INTO PerfilPantalla
	VALUES (179, 9, 54);
    INSERT INTO PerfilPantalla
	VALUES (180, 10, 54);
    INSERT INTO PerfilPantalla
	VALUES (181, 11, 54);
    INSERT INTO PerfilPantalla
	VALUES (182, 12, 54);
    INSERT INTO PerfilPantalla
	VALUES (183, 14, 54);
    INSERT INTO PerfilPantalla
	VALUES (184, 15, 54);
    INSERT INTO PerfilPantalla
	VALUES (185, 2, 55);
    INSERT INTO PerfilPantalla
	VALUES (186, 3, 55);
    INSERT INTO PerfilPantalla
	VALUES (187, 4, 55);
    INSERT INTO PerfilPantalla
	VALUES (188, 5, 55);
    INSERT INTO PerfilPantalla
	VALUES (189, 6, 55);
    INSERT INTO PerfilPantalla
	VALUES (190, 7, 55);
    INSERT INTO PerfilPantalla
	VALUES (191, 8, 55);
    INSERT INTO PerfilPantalla
	VALUES (192, 9, 55);
    INSERT INTO PerfilPantalla
	VALUES (193, 10, 55);
    INSERT INTO PerfilPantalla
	VALUES (194, 11, 55);
    INSERT INTO PerfilPantalla
	VALUES (195, 12, 55);
    INSERT INTO PerfilPantalla
	VALUES (196, 14, 55);
    INSERT INTO PerfilPantalla
	VALUES (197, 15, 55);
	INSERT INTO PerfilPantalla
	VALUES (198, 2, 48);
    INSERT INTO PerfilPantalla
	VALUES (199, 3, 48);
    INSERT INTO PerfilPantalla
	VALUES (200, 4, 48);
    INSERT INTO PerfilPantalla
	VALUES (201, 5, 48);
    INSERT INTO PerfilPantalla
	VALUES (202, 6, 48);
    INSERT INTO PerfilPantalla
	VALUES (203, 7, 48);
    INSERT INTO PerfilPantalla
	VALUES (204, 8, 48);
    INSERT INTO PerfilPantalla
	VALUES (205, 9, 48);
    INSERT INTO PerfilPantalla
	VALUES (206, 10, 48);
    INSERT INTO PerfilPantalla
	VALUES (207, 11, 48);
    INSERT INTO PerfilPantalla
	VALUES (208, 12, 48);
    INSERT INTO PerfilPantalla
	VALUES (209, 13, 48);
    INSERT INTO PerfilPantalla
	VALUES (210, 15, 48);
	INSERT INTO PerfilPantalla
	VALUES (211, 2, 47);
    INSERT INTO PerfilPantalla
	VALUES (212, 3, 47);
    INSERT INTO PerfilPantalla
	VALUES (213, 4, 47);
    INSERT INTO PerfilPantalla
	VALUES (214, 5, 47);
    INSERT INTO PerfilPantalla
	VALUES (215, 6, 47);
    INSERT INTO PerfilPantalla
	VALUES (216, 7, 47);
    INSERT INTO PerfilPantalla
	VALUES (217, 8, 47);
    INSERT INTO PerfilPantalla
	VALUES (218, 9, 47);
    INSERT INTO PerfilPantalla
	VALUES (219, 10, 47);
    INSERT INTO PerfilPantalla
	VALUES (220, 11, 47);
    INSERT INTO PerfilPantalla
	VALUES (221, 12, 47);
    INSERT INTO PerfilPantalla
	VALUES (222, 13, 47);
    INSERT INTO PerfilPantalla
	VALUES (223, 15, 47);
	INSERT INTO PerfilPantalla
	VALUES (224, 2, 50);
    INSERT INTO PerfilPantalla
	VALUES (225, 3, 50);
    INSERT INTO PerfilPantalla
	VALUES (226, 4, 50);
    INSERT INTO PerfilPantalla
	VALUES (227, 5, 50);
    INSERT INTO PerfilPantalla
	VALUES (228, 6, 50);
    INSERT INTO PerfilPantalla
	VALUES (229, 7, 50);
    INSERT INTO PerfilPantalla
	VALUES (230, 8, 50);
    INSERT INTO PerfilPantalla
	VALUES (231, 9, 50);
    INSERT INTO PerfilPantalla
	VALUES (232, 10, 50);
    INSERT INTO PerfilPantalla
	VALUES (233, 11, 50);
    INSERT INTO PerfilPantalla
	VALUES (234, 12, 50);
    INSERT INTO PerfilPantalla
	VALUES (235, 13, 50);
    INSERT INTO PerfilPantalla
	VALUES (236, 15, 50);

	/* Usuarios */
	INSERT INTO Usuario
	VALUES (1, 'DIRECTOR', 'af2ea44aa84bfc668f201811ddfd6d86', 'DIRECTOR GENERAL', 1, 1);
	INSERT INTO Usuario
	VALUES (2, 'CATALOGOS', 'af2ea44aa84bfc668f201811ddfd6d86', 'ADMINISTRADOR DE CATALOGOS', 2, 1);
	INSERT INTO Usuario
	VALUES (3, 'ALMACEN', 'af2ea44aa84bfc668f201811ddfd6d86', 'ALMACÉN', 3, 1);
	INSERT INTO Usuario
	VALUES (4, 'RECURSOS', 'af2ea44aa84bfc668f201811ddfd6d86', 'RECURSOS HUMANOS', 4, 1);
	INSERT INTO Usuario
	VALUES (5, 'GERENTE', 'af2ea44aa84bfc668f201811ddfd6d86', 'GERENTE OPERATIVO', 5, 1);
	INSERT INTO Usuario
	VALUES (6, 'COORDINADOR', 'af2ea44aa84bfc668f201811ddfd6d86', 'COORDINADOR OPERATIVO', 6, 1);
	INSERT INTO Usuario
	VALUES (7, 'COMPRAS', 'af2ea44aa84bfc668f201811ddfd6d86', 'COMPRAS', 7, 1);
	INSERT INTO Usuario
	VALUES (8, 'PUBLICO', 'af2ea44aa84bfc668f201811ddfd6d86', 'PÚBLICO', 8, 1);
	INSERT INTO Usuario
	VALUES (9, 'CUENTASPORPAGAR', 'af2ea44aa84bfc668f201811ddfd6d86', 'CUENTAS POR PAGAR', 9, 1);
	INSERT INTO Usuario
	VALUES (10, 'FACTURACION', 'af2ea44aa84bfc668f201811ddfd6d86', 'FACTURACIÓN', 10, 1);
	INSERT INTO Usuario
	VALUES (11, 'CONTABILIDAD', 'af2ea44aa84bfc668f201811ddfd6d86', 'CONTABILIDAD', 11, 1);
	INSERT INTO Usuario
	VALUES (12, 'TESORERIA', 'af2ea44aa84bfc668f201811ddfd6d86', 'TESORERIA', 12, 1);
	INSERT INTO Usuario
	VALUES (13, 'RECURSOSHUMANOS', 'af2ea44aa84bfc668f201811ddfd6d86', 'RECURSOS HUMANOS', 13, 1);
	INSERT INTO Usuario
	VALUES (14, 'AUTOMATICO', 'af2ea44aa84bfc668f201811ddfd6d86', 'AUTOMÁTICO', 8, 1);
	
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
	/*
	INSERT INTO TipoColaborador
	VALUES (3, 'Externos');
	*/
	
	/* Colaborador */
	/*
	INSERT INTO Colaborador
	VALUES (1, 'JOSÉ ANTONIO CRUZ', 2);
	INSERT INTO Colaborador
	VALUES (2, 'ANTONIO RAVIZE', 1);
	INSERT INTO Colaborador
	VALUES (3, 'FRANCISCO TAPIA', 2);
	INSERT INTO Colaborador
	VALUES (4, 'GUSTAVO RÍOS', 3);
	*/
	/* Aplica */
	INSERT INTO Aplica
	VALUES (1, 'Sí');
	INSERT INTO Aplica
	VALUES (2, 'No');
	
	/* EstadoProyecto */
	INSERT INTO EstadoProyecto
	VALUES (1, 'Registro de Servicios');
	INSERT INTO EstadoProyecto
	VALUES (2, 'Planeación y Datos del Proyecto');
	INSERT INTO EstadoProyecto
	VALUES (3, 'Ejecucción del Proyecto A y B');
	INSERT INTO EstadoProyecto
	VALUES (4, 'Entrega, Revisión y Validacion Operativa');
	INSERT INTO EstadoProyecto
	VALUES (5, 'Cerrado');
	INSERT INTO EstadoProyecto
	VALUES (6, 'Cancelado');

	/* Grupo Familia A */
	INSERT INTO GrupoFamiliaA
	VALUES (1, 'Manual');
	INSERT INTO GrupoFamiliaA
	VALUES (2, 'Eléctrica');
	INSERT INTO GrupoFamiliaA
	VALUES (3, 'Hidráulica');
	INSERT INTO GrupoFamiliaA
	VALUES (4, 'Mecánica');
	INSERT INTO GrupoFamiliaA
	VALUES (5, 'Equipo de protección');
	
	/* Grupo Familia B */
	INSERT INTO GrupoFamiliaB
	VALUES (1, 'Automóvil');
	INSERT INTO GrupoFamiliaB
	VALUES (2, 'Camioneta');
	INSERT INTO GrupoFamiliaB
	VALUES (3, 'Trailer');
	INSERT INTO GrupoFamiliaB
	VALUES (4, 'Camión');
	INSERT INTO GrupoFamiliaB
	VALUES (5, 'Motocicleta');
	
	/* Grupo Familia C */
	INSERT INTO GrupoFamiliaC
	VALUES (1, 'Construcción');
	INSERT INTO GrupoFamiliaC
	VALUES (2, 'Eléctrico');
	INSERT INTO GrupoFamiliaC
	VALUES (3, 'Telefónico');
	INSERT INTO GrupoFamiliaC
	VALUES (4, 'Mobiliario');
	INSERT INTO GrupoFamiliaC
	VALUES (5, 'Telecomunicaciones');
	
	/* Grupo Familia D */
	INSERT INTO GrupoFamiliaD
	VALUES (1, 'Papelería');
	INSERT INTO GrupoFamiliaD
	VALUES (2, 'Limpieza');
	INSERT INTO GrupoFamiliaD
	VALUES (3, 'Misceláneos');
	INSERT INTO GrupoFamiliaD
	VALUES (4, 'Accesorios');
	
	/* Grupo Familia E */
	INSERT INTO GrupoFamiliaE
	VALUES (1, 'Escritorio');
	INSERT INTO GrupoFamiliaE
	VALUES (2, 'Laptop');
	INSERT INTO GrupoFamiliaE
	VALUES (3, 'Servidor');
	INSERT INTO GrupoFamiliaE
	VALUES (4, 'Impresora');
	INSERT INTO GrupoFamiliaE
	VALUES (5, 'Scanner');
	INSERT INTO GrupoFamiliaE
	VALUES (6, 'Periférico');
	
	/* Grupo Familia F */	
	INSERT INTO GrupoFamiliaF
	VALUES (1, 'Celular');
	INSERT INTO GrupoFamiliaF
	VALUES (2, 'Radio');
	INSERT INTO GrupoFamiliaF
	VALUES (3, 'Fija');
	INSERT INTO GrupoFamiliaF
	VALUES (4, 'GPS');
	
	/* Unidad A */
	INSERT INTO UnidadA
	VALUES (1, 'Pieza');
	INSERT INTO UnidadA
	VALUES (2, 'Juego');
	INSERT INTO UnidadA
	VALUES (3, 'Kit');
	
	/* Unidad B */
	INSERT INTO UnidadB
	VALUES (1, 'Pieza');
	INSERT INTO UnidadB
	VALUES (2, 'Juego');
	INSERT INTO UnidadB
	VALUES (3, 'Kit');
	INSERT INTO UnidadB
	VALUES (4, 'Metros');
	INSERT INTO UnidadB
	VALUES (5, 'Litros');
	INSERT INTO UnidadB
	VALUES (6, 'Kilos');
	
	/* Unidad C */
	INSERT INTO UnidadC
	VALUES (1, 'Pieza');
	INSERT INTO UnidadC
	VALUES (2, 'Kit');
	
	/* Estatus A */
	INSERT INTO EstatusA
	VALUES (1, 'Calibrado');
	INSERT INTO EstatusA
	VALUES (2, 'No se calibra');
	INSERT INTO EstatusA
	VALUES (3, 'Uso limitado');
	INSERT INTO EstatusA
	VALUES (4, 'No conforme');
	INSERT INTO EstatusA
	VALUES (5, 'Baja');
	INSERT INTO EstatusA
	VALUES (6, 'Adecuado');
	
	/* Estatus B */
	INSERT INTO EstatusB
	VALUES (1, 'No conforme');
	INSERT INTO EstatusB
	VALUES (2, 'Baja');
	INSERT INTO EstatusB
	VALUES (3, 'Adecuado');
	
	/* Estatus C */
	INSERT INTO EstatusC
	VALUES (1, 'Completo');
	INSERT INTO EstatusC
	VALUES (2, 'Incompleto');
	INSERT INTO EstatusC
	VALUES (3, 'No conforme');
	INSERT INTO EstatusC
	VALUES (4, 'Adecuado');
	
	/* Ubicacion A */
	INSERT INTO UbicacionA
	VALUES (1, 'Proveedor');
	INSERT INTO UbicacionA
	VALUES (2, 'Texto');
	INSERT INTO UbicacionA
	VALUES (3, 'Mantenimiento');
	INSERT INTO UbicacionA
	VALUES (4, 'Administración');
	INSERT INTO UbicacionA
	VALUES (5, 'Renta');
	INSERT INTO UbicacionA
	VALUES (6, 'Calibración');
	INSERT INTO UbicacionA
	VALUES (7, 'Almacén');
	
	/* Ubicacion B */
	INSERT INTO UbicacionB
	VALUES (1, 'Acceso');
	INSERT INTO UbicacionB
	VALUES (2, 'Transmisión');
	INSERT INTO UbicacionB
	VALUES (3, 'Proveedor');
	INSERT INTO UbicacionB
	VALUES (4, 'Mantenimiento');
	INSERT INTO UbicacionB
	VALUES (5, 'Administración');
	INSERT INTO UbicacionB
	VALUES (6, 'Almacén');
	
	/* Ubicacion C */
	INSERT INTO UbicacionC
	VALUES (1, 'Acceso');
	INSERT INTO UbicacionC
	VALUES (2, 'Transmisión');
	INSERT INTO UbicacionC
	VALUES (3, 'Proveedor');
	INSERT INTO UbicacionC
	VALUES (4, 'Mantenimiento');
	INSERT INTO UbicacionC
	VALUES (5, 'Resguardo');
	INSERT INTO UbicacionC
	VALUES (6, 'Almacén');
	
	/* Tipo Almacen */
	INSERT INTO TipoAlmacen
	VALUES (1, 'Herramienta');
	INSERT INTO TipoAlmacen
	VALUES (2, 'Equipo de Medición');
	INSERT INTO TipoAlmacen
	VALUES (3, 'Equipo de Transporte');
	INSERT INTO TipoAlmacen
	VALUES (4, 'Materiales');
	INSERT INTO TipoAlmacen
	VALUES (5, 'Consumibles');
	INSERT INTO TipoAlmacen
	VALUES (6, 'Hardware');
	INSERT INTO TipoAlmacen
	VALUES (7, 'Software');
	INSERT INTO TipoAlmacen
	VALUES (8, 'Telefonía Móvil-Fija');
	INSERT INTO TipoAlmacen
	VALUES (9, 'Solicitudes de Almacén');
	
	/* Prioridad */
	INSERT INTO Prioridad
	VALUES (1, 'Normal');
	INSERT INTO Prioridad
	VALUES (2, 'Urgente');
	
	/* Area Solicitante */
	INSERT INTO AreaSolicitante
	VALUES (1, 'Acceso');
	INSERT INTO AreaSolicitante
	VALUES (2, 'Transmisión');
	INSERT INTO AreaSolicitante
	VALUES (3, 'Administrativo');
	INSERT INTO AreaSolicitante
	VALUES (4, 'Proveedor');
	
	/* ServicioSolicitado */
	INSERT INTO ServicioSolicitado
	VALUES (1, 'Herramienta');
	INSERT INTO ServicioSolicitado
	VALUES (2, 'Material');
	INSERT INTO ServicioSolicitado
	VALUES (3, 'Equipo de Medición');
	INSERT INTO ServicioSolicitado
	VALUES (4, 'Equipo de Cómputo');
	INSERT INTO ServicioSolicitado
	VALUES (5, 'Hardware');
	INSERT INTO ServicioSolicitado
	VALUES (6, 'Software');
	INSERT INTO ServicioSolicitado
	VALUES (7, 'Telefonía Móvil-Fija');
	INSERT INTO ServicioSolicitado
	VALUES (8, 'Equipo de Transporte');
	INSERT INTO ServicioSolicitado
	VALUES (9, 'Consumibles');
	
	/* Compania */
	INSERT INTO Compania
	VALUES (1, 'Telmex');
	INSERT INTO Compania
	VALUES (2, 'Telcel');
	INSERT INTO Compania
	VALUES (3, 'Iusacell');
	INSERT INTO Compania
	VALUES (4, 'Nextel');
	INSERT INTO Compania
	VALUES (5, 'Teléfonica');
	INSERT INTO Compania
	VALUES (6, 'Unefon');
	
	/* Tipo Mantenimiento */
	INSERT INTO TipoMantenimiento
	VALUES (1, 'Interno');
	INSERT INTO TipoMantenimiento
	VALUES (2, 'Externo');
	
	/* Tipo Documento Almacen */
	INSERT INTO TipoDocumentoAlmacen
	VALUES (1, 'Poliza de Garantía');
	INSERT INTO TipoDocumentoAlmacen
	VALUES (2, 'Poliza de Seguro');
	INSERT INTO TipoDocumentoAlmacen
	VALUES (3, 'Certificado de Calibración');
	INSERT INTO TipoDocumentoAlmacen
	VALUES (4, 'Orden de Mantenimiento o Servicio');
	INSERT INTO TipoDocumentoAlmacen
	VALUES (5, 'Tarjeta de Circulación');
	
	/* Tipo Entregable */
	INSERT INTO TipoEntregable
	VALUES (1, 'Entregable Ingeniería');
	INSERT INTO TipoEntregable
	VALUES (2, 'Site Survey');
	INSERT INTO TipoEntregable
	VALUES (3, 'Planos');
	INSERT INTO TipoEntregable
	VALUES (4, 'Ingeniería');
	INSERT INTO TipoEntregable
	VALUES (5, 'Visita Factibilidad');
	INSERT INTO TipoEntregable
	VALUES (6, 'Carpeta Administrativa');
	INSERT INTO TipoEntregable
	VALUES (7, 'Protocolo');
	INSERT INTO TipoEntregable
	VALUES (8, 'OT');
	INSERT INTO TipoEntregable
	VALUES (9, 'Cliente Satisfecho');
	INSERT INTO TipoEntregable
	VALUES (10, 'Checklist de Inspección');
	INSERT INTO TipoEntregable
	VALUES (11, 'Checklist Fotográfico');
	INSERT INTO TipoEntregable
	VALUES (12, 'ASBuild');
	INSERT INTO TipoEntregable
	VALUES (13, 'Entregable X');
	INSERT INTO TipoEntregable
	VALUES (14, 'Entregable Y');

	/* Seguimiento */
	INSERT INTO Seguimiento
	VALUES (1, 'Sí');
	INSERT INTO Seguimiento
	VALUES (2, 'No');
	INSERT INTO Seguimiento
	VALUES (3, 'Pendiente');
	INSERT INTO Seguimiento
	VALUES (4, 'No Aplica');
	INSERT INTO Seguimiento
	VALUES (5, 'En Proceso');

	/* Compras */
	
	INSERT INTO TipoPersona
	VALUES (1, 'Física');
	INSERT INTO TipoPersona
	VALUES (2, 'Moral');
	
	INSERT INTO FormaPago
	VALUES (1, 'Contado');
	INSERT INTO FormaPago
	VALUES (2, 'Anticipo');
	
	INSERT INTO TipoPago
	VALUES (1, 'Cheque');
	INSERT INTO TipoPago
	VALUES (2, 'Efectivo');
	INSERT INTO TipoPago
	VALUES (3, 'Transferencia');
	INSERT INTO TipoPago
	VALUES (4, 'Crédito');
	
	INSERT INTO Pago
	VALUES (1, '50% anticipo');
	INSERT INTO Pago
	VALUES (2, '50% finiquito');
	
	INSERT INTO TipoContrato
	VALUES (1, 'Eventual');
	INSERT INTO TipoContrato
	VALUES (2, 'Anual');
	INSERT INTO TipoContrato
	VALUES (3, 'Indefinido');

	/* Fin Compras */	

	/* Requisicion Compras */
	INSERT INTO EstatusRequisicionCompra
	VALUES (1, 'Autorizada');
	INSERT INTO EstatusRequisicionCompra
	VALUES (2, 'Rechazada');
	INSERT INTO EstatusRequisicionCompra
	VALUES (3, 'Pendiente');
	/* Fin Requisicion Compras */

	/* Orden de Compra */

	INSERT INTO EstadoSolicitudServicioMaquilado
	VALUES (1, 'Pendiente');
	INSERT INTO EstadoSolicitudServicioMaquilado
	VALUES (2, 'Aceptado');
	INSERT INTO EstadoSolicitudServicioMaquilado
	VALUES (3, 'Rechazado');

	INSERT INTO EstadoValidacionOperativa
	VALUES (1, 'No Validado');
	INSERT INTO EstadoValidacionOperativa
	VALUES (2, 'Validado');
	INSERT INTO EstadoValidacionOperativa
	VALUES (3, 'Parcial');

	INSERT INTO EstadoSolicitudAlmacen
	VALUES (1, 'Abierto');
	INSERT INTO EstadoSolicitudAlmacen
	VALUES (2, 'Pendiente');
	INSERT INTO EstadoSolicitudAlmacen
	VALUES (3, 'Cerrado');
	INSERT INTO EstadoSolicitudAlmacen
	VALUES (4, 'Autorizado');

	INSERT INTO EstadoValidacionAdministrativa
	VALUES (1, 'Validado');
	INSERT INTO EstadoValidacionAdministrativa
	VALUES (2, 'No Validado');
	
	INSERT INTO TipoValidacionAdministrativa
	VALUES (1, 'Parcial');
	INSERT INTO TipoValidacionAdministrativa
	VALUES (2, 'Total');

	INSERT INTO EstadoValidacionCobro
	VALUES (1, 'Realizar Cobro');
	INSERT INTO EstadoValidacionCobro
	VALUES (2, 'Cancelar Cobro');
	INSERT INTO EstadoValidacionCobro
	VALUES (3, 'Sustituir Cobro');

	INSERT INTO EstadoFinalValidacion
	VALUES (1, 'Terminado');
	INSERT INTO EstadoFinalValidacion
	VALUES (2, 'Parcial');

	INSERT INTO EstadoOrdenCompra
	VALUES (1, 'Aceptada');
	INSERT INTO EstadoOrdenCompra
	VALUES (2, 'Rechazada');
	INSERT INTO EstadoOrdenCompra
	VALUES (3, 'En Revisión');
	INSERT INTO EstadoOrdenCompra
	VALUES (4, 'Pendiente');

	INSERT INTO EstadoValidacionCosto
	VALUES (1, 'Correcto');
	INSERT INTO EstadoValidacionCosto
	VALUES (2, 'Incorrecto');
	INSERT INTO EstadoValidacionCosto
	VALUES (3, 'Sustitución');
	INSERT INTO EstadoValidacionCosto
	VALUES (4, 'Parcial');

	INSERT INTO EstadoInvestigacionCalidad
	VALUES (1, 'Con Desviaciones');
	INSERT INTO EstadoInvestigacionCalidad
	VALUES (2, 'Sin Desviaciones');
	INSERT INTO EstadoInvestigacionCalidad
	VALUES (3, 'En Revisión');
	INSERT INTO EstadoInvestigacionCalidad
	VALUES (4, 'Pendiente');

	INSERT INTO EstadoTesoreria
	VALUES (1, 'Pagado');
	INSERT INTO EstadoTesoreria
	VALUES (2, 'Falta Pago');
	INSERT INTO EstadoTesoreria
	VALUES (3, 'Bloqueados');

	INSERT INTO MedioTransporte
	VALUES (1, 'Aéreo');
	INSERT INTO MedioTransporte
	VALUES (2, 'Autobús');
	INSERT INTO MedioTransporte
	VALUES (3, 'Vehículo');
	INSERT INTO MedioTransporte
	VALUES (4, 'Otro');

	INSERT INTO EstadoComprobacionViaticos
	VALUES (1, 'Aprobado');
	INSERT INTO EstadoComprobacionViaticos
	VALUES (2, 'Rechazado');

	INSERT INTO TipoOperacion
	VALUES (1, 'Ingresos');
	INSERT INTO TipoOperacion
	VALUES (2, 'Egresos');

	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (1, 'Remanente Viáticos', 1);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (2, 'Reposición de Fondo Fijo', 1);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (3, 'Otros', 1);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (4, 'Pasajes Locales', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (5, 'Estacionamiento', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (6, 'Agua Embotellada', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (7, 'Servicio de Recolección de Basura', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (8, 'Complemento Viático', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (9, 'Papelería', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (10, 'Combustibles', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (11, 'Materiales', 2);
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (12, 'Otros', 2);

	INSERT INTO DescripcionPagoContableServicio
	VALUES (1, 'Nómina Conectel', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (2, 'Gratificaciones', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (3, 'Finiquitos', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (4, 'IMSS, SAR e INFONAVIT', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (5, 'Financiamiento Adq. Automóvil', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (6, 'Financiamiento Adq. Otros', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (7, 'Servicio de Internet', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (8, 'Servicio Telefónico', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (9, 'Impuestos Federales', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (10, 'Impuestos Locales', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (11, 'Suministro de Agua', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (12, 'Multas', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (13, 'Servicio de TV de Paga', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (14, 'Otros', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (15, 'Devolución de Cliente', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (16, 'Devolución de Impuestos', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (17, 'Venta Activo Fijo', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (18, 'Otros', 1);

	INSERT INTO BancoConectel
	VALUES (1, '012345678901234567', 'BBVA Bancomer', '1515870134');
	INSERT INTO BancoConectel
	VALUES (2, '098765432109876543', 'Santander', '6789012345');
	INSERT INTO BancoConectel
	VALUES (3, '123450987612345098', 'Banamex', '0984312345');
	INSERT INTO BancoConectel
	VALUES (4, '123456789012345678', 'Banorte', '1234567890');

	INSERT INTO ConceptoOtraOperacionFinanciera
	VALUES (1, 'Préstamo Obtenido');
	INSERT INTO ConceptoOtraOperacionFinanciera
	VALUES (2, 'Préstamo Otorgado');
	INSERT INTO ConceptoOtraOperacionFinanciera
	VALUES (3, 'Pago de Prestamos Obtenidos');
	INSERT INTO ConceptoOtraOperacionFinanciera
	VALUES (4, 'Otros Ingresos');
	INSERT INTO ConceptoOtraOperacionFinanciera
	VALUES (5, 'Otros Gastos');
	
	/* Recursos Humanos */
	INSERT INTO Nacionalidad
	VALUES (1, 'Mexicano');
	INSERT INTO Nacionalidad
	VALUES (2, 'Extranjero');

	INSERT INTO Identificacion
	VALUES (1, 'IFE');
	INSERT INTO Identificacion
	VALUES (2, 'Cartilla Militar');
	INSERT INTO Identificacion
	VALUES (3, 'Pasaporte');
	INSERT INTO Identificacion
	VALUES (4, 'Licencia');

	INSERT INTO DocumentacionExtranjeros
	VALUES (1, 'Pasaporte');
	INSERT INTO DocumentacionExtranjeros
	VALUES (2, 'Permisos');
	INSERT INTO DocumentacionExtranjeros
	VALUES (3, 'Acta o Partida');
	INSERT INTO DocumentacionExtranjeros
	VALUES (4, 'FM2');
	INSERT INTO DocumentacionExtranjeros
	VALUES (5, 'FM3');

	INSERT INTO EstadoCivil
	VALUES (1, 'Casado');
	INSERT INTO EstadoCivil
	VALUES (2, 'Soltero');
	INSERT INTO EstadoCivil
	VALUES (3, 'Viudo');
	INSERT INTO EstadoCivil
	VALUES (4, 'Divorciado');
	INSERT INTO EstadoCivil
	VALUES (5, 'Unión Libre');

	INSERT INTO Sexo
	VALUES (1, 'Masculino');
	INSERT INTO Sexo
	VALUES (2, 'Femenino');

	INSERT INTO TipoLicencia
	VALUES (1, 'A');
	INSERT INTO TipoLicencia
	VALUES (2, 'B');
	INSERT INTO TipoLicencia
	VALUES (3, 'C');
	INSERT INTO TipoLicencia
	VALUES (4, 'D');
	
	INSERT INTO CartaAntecedentesPenales
	VALUES (1, 'Si');
	INSERT INTO CartaAntecedentesPenales
	VALUES (2, 'No');
	INSERT INTO CartaAntecedentesPenales
	VALUES (3, 'N/A');

	INSERT INTO EstadoSalud
	VALUES (1, 'Bueno');
	INSERT INTO EstadoSalud
	VALUES (2, 'Regular');
	INSERT INTO EstadoSalud
	VALUES (3, 'Malo');

	INSERT INTO ActividadTiempoLibre
	VALUES (1, 'Hobbies');
	INSERT INTO ActividadTiempoLibre
	VALUES (2, 'Familia');
	INSERT INTO ActividadTiempoLibre
	VALUES (3, 'Estudio');

	INSERT INTO ViveCon
	VALUES (1, 'Familia');
	INSERT INTO ViveCon
	VALUES (2, 'Padres');
	INSERT INTO ViveCon
	VALUES (3, 'Parientes');
	INSERT INTO ViveCon
	VALUES (4, 'Solo');

	INSERT INTO Dependientes
	VALUES (1, 'Hijos');
	INSERT INTO Dependientes
	VALUES (2, 'Cónyugues');
	INSERT INTO Dependientes
	VALUES (3, 'Padres');
	INSERT INTO Dependientes
	VALUES (4, 'Otros');
	INSERT INTO Dependientes
	VALUES (5, 'Nadie');
	INSERT INTO Dependientes
	VALUES (6, 'Esposo (a)');

	INSERT INTO UltimoGradoEstudios
	VALUES (1, 'Primaria');
	INSERT INTO UltimoGradoEstudios
	VALUES (2, 'Secundaria');
	INSERT INTO UltimoGradoEstudios
	VALUES (3, 'Bachillerato');
	INSERT INTO UltimoGradoEstudios
	VALUES (4, 'Licenciatura');
	INSERT INTO UltimoGradoEstudios
	VALUES (5, 'Títulado');
	INSERT INTO UltimoGradoEstudios
	VALUES (6, 'Posgrado');
	INSERT INTO UltimoGradoEstudios
	VALUES (7, 'Maestría');
	INSERT INTO UltimoGradoEstudios
	VALUES (8, 'Técnico');
	INSERT INTO UltimoGradoEstudios
	VALUES (9, 'Sin Estudios');
	INSERT INTO UltimoGradoEstudios
	VALUES (10, 'Diplomado');
	INSERT INTO UltimoGradoEstudios
	VALUES (11, 'Ninguno');

	INSERT INTO EstadoAcademico
	VALUES (1, 'Títulado');
	INSERT INTO EstadoAcademico
	VALUES (2, 'Pasante');
	INSERT INTO EstadoAcademico
	VALUES (3, 'Trunco');

	INSERT INTO FaseSeleccion
	VALUES (1, 'Si');
	INSERT INTO FaseSeleccion
	VALUES (2, 'No');

	INSERT INTO FuenteReclutamiento
	VALUES (1, 'Anuncio');
	INSERT INTO FuenteReclutamiento
	VALUES (2, 'Bolsa Trabajo');
	INSERT INTO FuenteReclutamiento
	VALUES (3, 'Delegación');
	INSERT INTO FuenteReclutamiento
	VALUES (4, 'Feria');
	INSERT INTO FuenteReclutamiento
	VALUES (5, 'Trabajador o Empleado');
	INSERT INTO FuenteReclutamiento
	VALUES (6, 'Internet');
	INSERT INTO FuenteReclutamiento
	VALUES (7, 'Otros');

	INSERT INTO TipoCandidato
	VALUES (1, 'Personal Universitario');
	INSERT INTO TipoCandidato
	VALUES (2, 'Personal con Preparatoria');

	INSERT INTO FaseContratacion
	VALUES (1, 'Si');
	INSERT INTO FaseContratacion
	VALUES (2, 'No');

	INSERT INTO TipoContratacion
	VALUES (1, 'Nuevo');
	INSERT INTO TipoContratacion
	VALUES (2, 'Reingreso');

	INSERT INTO Suspension
	VALUES (1, 'Temporal');
	INSERT INTO Suspension
	VALUES (2, 'Definitiva');
	INSERT INTO Suspension
	VALUES (3, 'N/A');

	INSERT INTO MotivoTerminoContrato
	VALUES (1, 'Rescisión');
	INSERT INTO MotivoTerminoContrato
	VALUES (2, 'Renuncia Voluntaria');
	INSERT INTO MotivoTerminoContrato
	VALUES (3, 'Fallecimiento');
	INSERT INTO MotivoTerminoContrato
	VALUES (4, 'Incapacidad');
	INSERT INTO MotivoTerminoContrato
	VALUES (5, 'Promoción');
	INSERT INTO MotivoTerminoContrato
	VALUES (6, 'Jubilación');
	INSERT INTO MotivoTerminoContrato
	VALUES (7, 'Fin de Contrato');

	INSERT INTO EstadoColaborador
	VALUES (1, 'Activo');
	INSERT INTO EstadoColaborador
	VALUES (2, 'Inactivo');
	
	INSERT INTO ClaseIncidencia
	VALUES (1, 'Accidente Dentro del Horario de Trabajo');
	INSERT INTO ClaseIncidencia
	VALUES (2, 'Accidente Fuera del Horario de Trabajo');
	INSERT INTO ClaseIncidencia
	VALUES (3, 'Enfermedad Natural');
	INSERT INTO ClaseIncidencia
	VALUES (4, 'Enfermedad Laboral');
	INSERT INTO ClaseIncidencia
	VALUES (5, 'Enfermedad No Laboral');
	INSERT INTO ClaseIncidencia
	VALUES (6, 'Paternidad');
	
	INSERT INTO TipoIncapacidad
	VALUES (1, 'Temporal');
	INSERT INTO TipoIncapacidad
	VALUES (2, 'Definitiva');

	INSERT INTO Deduccion
	VALUES (1, 'Herramienta');
	INSERT INTO Deduccion
	VALUES (2, 'Equipo Telefónico');
	INSERT INTO Deduccion
	VALUES (3, 'Equipo de Cómputo');
	INSERT INTO Deduccion
	VALUES (4, 'Credencial');
	INSERT INTO Deduccion
	VALUES (5, 'Playeras');
	INSERT INTO Deduccion
	VALUES (6, 'Retardos');
	INSERT INTO Deduccion
	VALUES (7, 'Faltas');
	INSERT INTO Deduccion
	VALUES (8, 'Pensión Alimenticia');
	INSERT INTO Deduccion
	VALUES (9, 'Fonacot');
	INSERT INTO Deduccion
	VALUES (10, 'Fondo de Ahorro');
	INSERT INTO Deduccion
	VALUES (11, 'Infonavit');
	INSERT INTO Deduccion
	VALUES (12, 'Préstamo');
	INSERT INTO Deduccion
	VALUES (13, 'IMSS');
	INSERT INTO Deduccion
	VALUES (14, 'ISR');
	INSERT INTO Deduccion
	VALUES (15, 'Permisos');
	INSERT INTO Deduccion
	VALUES (16, 'Otros Impuestos');
	INSERT INTO Deduccion
	VALUES (17, 'N/A');

	INSERT INTO ClasificacionFalta
	VALUES (1, 'Con Goce de Sueldo');
	INSERT INTO ClasificacionFalta
	VALUES (2, 'Sin Goce de Sueldo');

	INSERT INTO ClasificacionPermiso
	VALUES (1, 'Con Goce de Sueldo');
	INSERT INTO ClasificacionPermiso
	VALUES (2, 'Sin Goce de Sueldo');

	INSERT INTO TipoSancion
	VALUES (1, 'Descuento 1 Día');
	INSERT INTO TipoSancion
	VALUES (2, 'Rescisión');
	INSERT INTO TipoSancion
	VALUES (3, 'Suspensión');
	INSERT INTO TipoSancion
	VALUES (4, 'Acta Administrativa');
	INSERT INTO TipoSancion
	VALUES (5, 'Castigo');
	INSERT INTO TipoSancion
	VALUES (6, 'N/A');	

	INSERT INTO FormaPagoPrenomina
	VALUES (1, 'Total');
	INSERT INTO FormaPagoPrenomina
	VALUES (2, 'Parcial');

	INSERT INTO Percepcion
	VALUES (1, 'Bono por Productividad');
	INSERT INTO Percepcion
	VALUES (2, 'Premio de Puntualidad');
	INSERT INTO Percepcion
	VALUES (3, 'Incentivos');
	INSERT INTO Percepcion
	VALUES (4, 'Ayuda por Matrimonio');
	INSERT INTO Percepcion
	VALUES (5, 'Ayuda por Fallecimiento');
	INSERT INTO Percepcion
	VALUES (6, 'Vacaciones');
	INSERT INTO Percepcion
	VALUES (7, 'Ayuda por Natalicio');

	INSERT INTO Variacion
	VALUES (1, 'Tomadas');
	INSERT INTO Variacion
	VALUES (2, 'Pagadas');

	/* Sistemas de Gestion */
	INSERT INTO AreaLevantaNoConformidad
	VALUES (1, 'Gerencia Administrativa');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (2, 'Compras');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (3, 'Contabilidad');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (4, 'Dirección General');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (5, 'Facturación');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (6, 'Intendencia y Vigilancia');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (7, 'Operación Acceso');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (8, 'Operación Transmisión');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (9, 'Recepción');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (10, 'Recursos Humanos');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (11, 'Sistemas de Gestión');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (12, 'Supervisión de Almacén y Servicios Generales');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (13, 'Supervisión de Sistemas y Comunicación');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (14, 'Ingeniería');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (15, 'Coordinador de Acceso');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (16, 'Coordinador de Transmisión');
	INSERT INTO AreaLevantaNoConformidad
	VALUES (17, 'Auditores de SG');
	
	INSERT INTO ResultadoImplementacion
	VALUES (1, 'Efectiva');
	INSERT INTO ResultadoImplementacion
	VALUES (2, 'No Efectiva');

	INSERT INTO TipoAccion
	VALUES (1, 'Preventiva');
	INSERT INTO TipoAccion
	VALUES (2, 'Correctiva');

	INSERT INTO FuenteNoConformidad
	VALUES (1, 'Auditoría Interna');
	INSERT INTO FuenteNoConformidad
	VALUES (2, 'Indicadores de Gestión');
	INSERT INTO FuenteNoConformidad
	VALUES (3, 'Encuestas de Satisfacción');
	INSERT INTO FuenteNoConformidad
	VALUES (4, 'Comentarios o Sugerencias');
	INSERT INTO FuenteNoConformidad
	VALUES (5, 'Bitácora de Producto No Conforme y/o No Conformidades');
	INSERT INTO FuenteNoConformidad
	VALUES (6, 'Incumplimiento de Objetivos');
	INSERT INTO FuenteNoConformidad
	VALUES (7, 'Otra');
	INSERT INTO FuenteNoConformidad
	VALUES (8, 'Auditoría Externa');
	INSERT INTO FuenteNoConformidad
	VALUES (9, 'Correo Electrónico');
	INSERT INTO FuenteNoConformidad
	VALUES (10, 'Accidente');
	INSERT INTO FuenteNoConformidad
	VALUES (11, 'Incidente');
	INSERT INTO FuenteNoConformidad
	VALUES (12, 'Negligencia');
	INSERT INTO FuenteNoConformidad
	VALUES (13, 'Desacato');
	INSERT INTO FuenteNoConformidad
	VALUES (14, 'Insubordinación');

	INSERT INTO EstadoAccionPreventivaCorrectiva
	VALUES (1, 'Cerrada');
	INSERT INTO EstadoAccionPreventivaCorrectiva
	VALUES (2, 'Pendiente');

    INSERT INTO EstadoConcentradoCapacitacion
	VALUES (1, 'Titulado');
	INSERT INTO EstadoConcentradoCapacitacion
	VALUES (2, 'En Proceso');
    INSERT INTO EstadoConcentradoCapacitacion
	VALUES (3, 'Trunco');
    INSERT INTO EstadoConcentradoCapacitacion
	VALUES (4, 'Pendiente');
    INSERT INTO EstadoConcentradoCapacitacion
	VALUES (5, 'N/A');

	INSERT INTO EstadoSistemaGestion
	VALUES (1, 'Con Desviaciones');
	INSERT INTO EstadoSistemaGestion
	VALUES (2, 'Sin Desviaciones');
	INSERT INTO EstadoSistemaGestion
	VALUES (3, 'En Revisión');
	INSERT INTO EstadoSistemaGestion
	VALUES (4, 'Pendiente');
	INSERT INTO EstadoSistemaGestion
	VALUES (5, 'Cerrada');

	INSERT INTO FormaAuditoria
	VALUES (1, 'En Sitio');
	INSERT INTO FormaAuditoria
	VALUES (2, 'Sobre Reporte Fotográfico');
	INSERT INTO FormaAuditoria
	VALUES (3, 'Check List de Proyecto');
	INSERT INTO FormaAuditoria
	VALUES (4, 'Reporte de Auditoría');
	INSERT INTO FormaAuditoria
	VALUES (5, 'Reporte de Supervisión');
	INSERT INTO FormaAuditoria
	VALUES (6, 'Reporte Informal');


	INSERT INTO TipoAuditoria
	VALUES (1, 'Interna');
	INSERT INTO TipoAuditoria
	VALUES (2, 'Externa');

	INSERT INTO TipoCapacitacion
	VALUES (1, 'Interna');
	INSERT INTO TipoCapacitacion
	VALUES (2, 'Externa');

	INSERT INTO TipoFormacion
	VALUES (1, 'Evaluación');
	INSERT INTO TipoFormacion
	VALUES (2, 'Capacitación');
	INSERT INTO TipoFormacion
	VALUES (3, 'Capacitación CV');
	INSERT INTO TipoFormacion
	VALUES (4, 'Primaria');
	INSERT INTO TipoFormacion
	VALUES (5, 'Secundaria');
	INSERT INTO TipoFormacion
	VALUES (6, 'Bachillerato');
	INSERT INTO TipoFormacion
	VALUES (7, 'Carrera Técnica');
	INSERT INTO TipoFormacion
	VALUES (8, 'Ingeniería');
	INSERT INTO TipoFormacion
	VALUES (9, 'Licenciatura');
	INSERT INTO TipoFormacion
	VALUES (10, 'Maestría');
	INSERT INTO TipoFormacion
	VALUES (11, 'Doctorado');
	INSERT INTO TipoFormacion
	VALUES (12, 'Diplomado');
	INSERT INTO TipoFormacion
	VALUES (13, 'Certificación');
	
	INSERT INTO ResponsableMinuta
	VALUES (1, 'Participantes');
	INSERT INTO ResponsableMinuta
	VALUES (2, 'Otro');

	/* Notifiaciones */
	INSERT INTO EstadoNotificacion
	VALUES (1, 'Pendiente');
	INSERT INTO EstadoNotificacion
	VALUES (2, 'Atendida');

	/* Cambio */
	INSERT INTO TipoDesarrolloProyecto
	VALUES (1, 'A');
	INSERT INTO TipoDesarrolloProyecto
	VALUES (2, 'B');
	INSERT INTO TipoDesarrolloProyecto
	VALUES (3, 'C');
	INSERT INTO TipoDesarrolloProyecto
	VALUES (4, 'D');

	INSERT INTO Calibracion
	VALUES (1, 'Aplica');
	INSERT INTO Calibracion
	VALUES (2, 'No Aplica');
	
	INSERT INTO MantenimientoServicio
	VALUES (1, 'Mantenimiento');
	INSERT INTO MantenimientoServicio
	VALUES (2, 'Servicio');

	INSERT INTO FormaPagoMaquilador
	VALUES (1, '50% Anticipo');
	INSERT INTO FormaPagoMaquilador
	VALUES (2, '50% Finiquito');

	/* Tipo Colaborador */
	INSERT INTO TipoServicio
	VALUES (1, 'LOCAL');
	INSERT INTO TipoServicio
	VALUES (2, 'FORANEO');

	INSERT INTO PermisoSinGoceSueldo
	VALUES (1, 'Particular');
	INSERT INTO PermisoSinGoceSueldo
	VALUES (2, 'Capacitación No Oficializada');
	INSERT INTO PermisoSinGoceSueldo
	VALUES (3, 'Sin Notificación');
	INSERT INTO PermisoSinGoceSueldo
	VALUES (4, 'Otros');
	INSERT INTO PermisoSinGoceSueldo
	VALUES (5, 'N/A');

	INSERT INTO PermisoConGoceSueldo
	VALUES (1, 'Fallecimiento');
	INSERT INTO PermisoConGoceSueldo
	VALUES (2, 'Enfermedad');
	INSERT INTO PermisoConGoceSueldo
	VALUES (3, 'Pre Natal');
	INSERT INTO PermisoConGoceSueldo
	VALUES (4, 'Post Natal');
	INSERT INTO PermisoConGoceSueldo
	VALUES (5, 'Capacitación Oficializada');
	INSERT INTO PermisoConGoceSueldo
	VALUES (6, 'Citación o Instrucción Militar');
	INSERT INTO PermisoConGoceSueldo
	VALUES (7, 'N/A');

	INSERT INTO Trimestre
	VALUES (1, 'Enero - Marzo');
	INSERT INTO Trimestre
	VALUES (2, 'Abril - Junio');
	INSERT INTO Trimestre
	VALUES (3, 'Julio - Septiembre');
	INSERT INTO Trimestre
	VALUES (4, 'Octubre - Noviembre');

	INSERT INTO Ano
	VALUES (1, '2013');
	INSERT INTO Ano
	VALUES (2, '2014');
	INSERT INTO Ano
	VALUES (3, '2015');
	INSERT INTO Ano
	VALUES (4, '2016');
	INSERT INTO Ano
	VALUES (5, '2017');
	INSERT INTO Ano
	VALUES (6, '2018');
	INSERT INTO Ano
	VALUES (7, '2019');
	INSERT INTO Ano
	VALUES (8, '2020');
	INSERT INTO Ano
	VALUES (9, '2021');
	INSERT INTO Ano
	VALUES (10, '2022');

	INSERT INTO RangoEstadisticaPersonal
	VALUES (1, '0 - 20');
	INSERT INTO RangoEstadisticaPersonal
	VALUES (2, '21 - 40');
	INSERT INTO RangoEstadisticaPersonal
	VALUES (3, '41 - 60');
	INSERT INTO RangoEstadisticaPersonal
	VALUES (4, '61 - 80');
	INSERT INTO RangoEstadisticaPersonal
	VALUES (5, '81 - 100');
	
	INSERT INTO EstatusDevolucion
	VALUES (1, 'Pendiente');
	INSERT INTO EstatusDevolucion
	VALUES (2, 'N/A');
	INSERT INTO EstatusDevolucion
	VALUES (3, 'Cerrado');

	INSERT INTO EstatusConcentradoCapacitacion
	VALUES (1, 'Pendiente');
	INSERT INTO EstatusConcentradoCapacitacion
	VALUES (2, 'No Aplica');
	INSERT INTO EstatusConcentradoCapacitacion
	VALUES (3, 'En Proceso');
	INSERT INTO EstatusConcentradoCapacitacion
	VALUES (4, 'Aprobado');
	INSERT INTO EstatusConcentradoCapacitacion
	VALUES (5, 'No Aprobado');
	
	/*
	INSERT INTO 
	VALUES (1, '');
	INSERT INTO 
	VALUES (2, '');
	INSERT INTO 
	VALUES (3, '');
	INSERT INTO 
	VALUES (4, '');
	INSERT INTO 
	VALUES (5, '');
	INSERT INTO 
	VALUES (6, '');
	INSERT INTO 
	VALUES (7, '');
	INSERT INTO 
	VALUES (8, '');
	INSERT INTO 
	VALUES (9, '');
	INSERT INTO 
	VALUES (10, '');
	*/