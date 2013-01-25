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
	costo_local_cliente DECIMAL,
	costo_foraneo_cliente DECIMAL,
	costo_local_proveedor DECIMAL,
	costo_foraneo_proveedor DECIMAL,
	dias_implementacion INT(11),
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
	fk_estatus_validacion_operativa INT(11) UNSIGNED NOT NULL,
	fecha_validacion_operativa DATE,
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
	recibe VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Software
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	descripcion VARCHAR(255),
	no_serie VARCHAR(255),
	existencia DECIMAL,
	unidad VARCHAR(255),
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	licenciamiento_inicial DATE,
	licenciamiento_final DATE,
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
	existencia DECIMAL,
	fk_unidad_a INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_a INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_a INT(11) UNSIGNED NOT NULL,
	no_certificado VARCHAR(255),
	fecha_calibracion DATE,
	fecha_proxima_calibracion DATE,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
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
	existencia DECIMAL,
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_b INT(11) UNSIGNED NOT NULL,
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
	PRIMARY KEY (id)
	);

	CREATE TABLE Material
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_c INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	existencia DECIMAL,
	fk_unidad_b INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_c INT(11) UNSIGNED NOT NULL,
	PRIMARY KEY (id)
	);

	CREATE TABLE Consumible
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	codigo VARCHAR(255),
	fk_grupo_familia_d INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255),
	existencia DECIMAL,
	fk_unidad_b INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_c INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_c INT(11) UNSIGNED NOT NULL,
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
	existencia DECIMAL,
	fk_unidad_c INT(11) UNSIGNED NOT NULL,
	fk_ubicacion_b INT(11) UNSIGNED NOT NULL,
	fk_responsable INT(11) UNSIGNED NOT NULL,
	fk_estatus_b INT(11) UNSIGNED NOT NULL,
	fk_tipo_mantenimiento INT(11) UNSIGNED NOT NULL,
	fecha_mantenimiento DATE,
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
	fk_almacen INT(11) UNSIGNED NOT NULL,
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
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_tipo_almacen INT(11) UNSIGNED NOT NULL,
	fk_almacen INT(11) NOT NULL,
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
	fecha DATE NOT NULL,
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
	limite_credito DECIMAL NOT NULL,
	dias_credito INT NOT NULL,
	descuentos DECIMAL NOT NULL,
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
	fecha_contrato DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoProveedorMaquilador
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
	rfc VARCHAR(255) NOT NULL,
	curp VARCHAR(255) NOT NULL,
	nss VARCHAR(255) NOT NULL,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE DocumentoLiderProveedorMaquilador
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_proveedor_maquilador INT(11) UNSIGNED NOT NULL,
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
	unidad VARCHAR(255) NOT NULL,
	validacion VARCHAR(255) NOT NULL,
	fk_estatus INT(11) UNSIGNED NOT NULL,
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
	nombre_archivo VARCHAR(255) NOT NULL,
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
	CREATE TABLE UnidadOrdenCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	unidad VARCHAR(255) NOT NULL UNIQUE,
	PRIMARY KEY (id)
	);

	CREATE TABLE OrdenCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cotizacion INT(11) UNSIGNED,
	fecha VARCHAR(255) NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED NOT NULL,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	fk_requisicion_compra INT(11) UNSIGNED NOT NULL,
	cantidad DECIMAL NOT NULL,
	fk_unidad INT(11) UNSIGNED NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	costo_unitario DECIMAL NOT NULL,
	importe DECIMAL NOT NULL,
	subtotal DECIMAL NOT NULL,
	iva DECIMAL NOT NULL,
	ieps DECIMAL,
	retencion_isr DECIMAL,
	retencion_iva DECIMAL,
	otros_impuestos DECIMAL,
	total DECIMAL NOT NULL,
	fecha_entrega_almacen DATE NOT NULL,
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
	PRIMARY KEY (id)
	);

	CREATE TABLE OrdenCompraMaquilado
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_servicio_maquilado INT(11) UNSIGNED NOT NULL,
	fecha DATE NOT NULL,
	fk_proveedor_maquilador INT(11) UNSIGNED NOT NULL,
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
	PRIMARY KEY (id)
	);

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

	ALTER TABLE Comentarios ADD FOREIGN KEY fk_almacen_idxfk (fk_almacen) REFERENCES Herramienta (id);

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

	ALTER TABLE DocumentoProveedorMaquilador ADD FOREIGN KEY fk_proveedor_maquilador_idxfk (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE Ayudante ADD FOREIGN KEY fk_proveedor_maquilador_idxfk_1 (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	ALTER TABLE DocumentoLiderProveedorMaquilador ADD FOREIGN KEY fk_proveedor_maquilador_idxfk_2 (fk_proveedor_maquilador) REFERENCES ProveedorMaquilador (id);

	/* Fin Compras */

	/* Requisicion Compras */
	ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_prioridad_idxfk (fk_prioridad) REFERENCES Prioridad (id);

	ALTER TABLE RequisicionCompra ADD FOREIGN KEY fk_area_solicitante_idxfk (fk_area_solicitante) REFERENCES AreaSolicitante (id);

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

	ALTER TABLE OrdenCompra ADD FOREIGN KEY fk_unidad_idxfk (fk_unidad) REFERENCES UnidadOrdenCompra (id);

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
	VALUES (23, 'ValidacionesCostos');
	INSERT INTO Pantalla
	VALUES (24, 'ValidacionesAdministrativas');
	INSERT INTO Pantalla
	VALUES (25, 'ConcentradoOrdenesCompra');
	INSERT INTO Pantalla
	VALUES (26, 'SolicitudAlmacenModule');	

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
	VALUES (44, 5, 21);
	INSERT INTO PerfilPantalla
	VALUES (45, 5, 22);
	INSERT INTO PerfilPantalla
	VALUES (46, 5, 23);
	INSERT INTO PerfilPantalla
	VALUES (47, 5, 24);
	INSERT INTO PerfilPantalla
	VALUES (48, 5, 25);
	INSERT INTO PerfilPantalla
	VALUES (49, 1, 26);
	INSERT INTO PerfilPantalla
	VALUES (50, 1, 26);
	INSERT INTO PerfilPantalla
	VALUES (51, 2, 26);
	INSERT INTO PerfilPantalla
	VALUES (52, 3, 26);
	INSERT INTO PerfilPantalla
	VALUES (53, 4, 26);
	INSERT INTO PerfilPantalla
	VALUES (54, 5, 26);
	INSERT INTO PerfilPantalla
	VALUES (55, 6, 26);
	INSERT INTO PerfilPantalla
	VALUES (56, 7, 26);
	INSERT INTO PerfilPantalla
	VALUES (57, 8, 26);

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
	INSERT INTO Usuario
	VALUES (7, 'COMPRAS', 'NOTIENE', 'COMPRAS', 7, 1);
	
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

	/* Aplica */
	INSERT INTO Aplica
	VALUES (1, 'Sí');
	INSERT INTO Aplica
	VALUES (2, 'No');
	
	/* EstadoProyecto */
	INSERT INTO EstadoProyecto
	VALUES (1, 'Alta');
	INSERT INTO EstadoProyecto
	VALUES (2, 'Datos Generales');
	INSERT INTO EstadoProyecto
	VALUES (3, 'Desarrollo Proyecto A y B');
	INSERT INTO EstadoProyecto
	VALUES (4, 'Configuración Prueba y Entrega');
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
	VALUES (8, 'Telefonía Móvil');
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
	VALUES (3, 'Equipo de medición');
	INSERT INTO ServicioSolicitado
	VALUES (4, 'Equipo de cómputo');
	INSERT INTO ServicioSolicitado
	VALUES (5, 'Hardware');
	INSERT INTO ServicioSolicitado
	VALUES (6, 'Software');
	INSERT INTO ServicioSolicitado
	VALUES (7, 'Telefonía móvil');
	INSERT INTO ServicioSolicitado
	VALUES (8, 'Equipo de transporte');
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
	VALUES (1, 'Al contado');
	INSERT INTO FormaPago
	VALUES (2, 'Anticipos');
	
	INSERT INTO TipoPago
	VALUES (1, 'Cheque');
	INSERT INTO TipoPago
	VALUES (2, 'Efectivo');
	INSERT INTO TipoPago
	VALUES (3, 'Transferencia');
	
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
	INSERT INTO UnidadOrdenCompra
	VALUES (1, 'Bolsa');
	INSERT INTO UnidadOrdenCompra
	VALUES (2, 'Caja');
	INSERT INTO UnidadOrdenCompra
	VALUES (3, 'Juego');
	INSERT INTO UnidadOrdenCompra
	VALUES (4, 'Kilo');
	INSERT INTO UnidadOrdenCompra
	VALUES (5, 'Kit');
	INSERT INTO UnidadOrdenCompra
	VALUES (6, 'Litro');
	INSERT INTO UnidadOrdenCompra
	VALUES (7, 'Metro');
	INSERT INTO UnidadOrdenCompra
	VALUES (8, 'Paquete');
	INSERT INTO UnidadOrdenCompra
	VALUES (9, 'Pieza');
	INSERT INTO UnidadOrdenCompra
	VALUES (10, 'Otros');
	/* Fin Orden de Compra */

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

/*
	INSERT INTO Proveedor
	VALUES (1, 1, 'ACME', 'ALMEIRA CASTAÑEDA MELIA', 'ALCM900622DF7', 'REFORMA 34, COL. JUÁREZ, DELG. CUAUHTEMOC', 'REFORMA 34, COL. JUÁREZ, DELG. CUAUHTEMOC', '57115887','MELIA ALMEIRA','melia347@yahoo.com','','');
	INSERT INTO Proveedor
	VALUES (2, 2, 'ALMEX', 'ALMEX SA DE CV', 'ALM830214347', 'PLAZA DE LA REPÚBLICA 43, COL. INDUSTRIAL, DELG. AZCAPOTZALCO', 'PLAZA DE LA REPÚBLICA 43, COL. INDUSTRIAL, DELG. AZCAPOTZALCO', '55674356','JUAN RULFO','jrulfo@amex.com.mx','www.amex.com.mx','');

	INSERT INTO ProveedorSeleccionado 
	VALUES (1, 1);
	INSERT INTO ProveedorSeleccionado
	VALUES (2, 2);

	INSERT INTO ProveedorCalificado
	VALUES (1, 1, 1, 1, 'PESO MEXICANO', 347000, 12, 0, null);
	*/
/*
	INSERT INTO RequisicionCompra
	VALUES (1, '2013-01-11', 'Material',1,1,'Sitio 347',1);

	INSERT INTO OrdenCompra
	VALUES (1, 1, '2013-01-11', 1, 1, 1, 123, 1, 'COMPRA DE MATERIAL PARA EL PROYECTO', 1, 1, 1, 1, 1, 1, 1, 1, 1, '2013-01-30');
*/
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