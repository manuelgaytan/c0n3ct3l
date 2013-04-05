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
	CREATE TABLE OrdenCompra
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_cotizacion INT(11) UNSIGNED,
	fecha VARCHAR(255) NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED NOT NULL,
	fk_proyecto INT(11) UNSIGNED NOT NULL,
	fk_requisicion_compra INT(11) UNSIGNED NOT NULL,
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
	clave_validacion VARCHAR(255),
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

	CREATE TABLE MaterialSolicitudAlmacen
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_solicitud_almacen INT(11) UNSIGNED NOT NULL,
	fk_material INT(11) UNSIGNED NOT NULL,
	cantidad_solicitada DECIMAL(12,5) NOT NULL,
	regreso_almacen BOOLEAN,
	observacion VARCHAR(255),
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
	costo_orden_compra DECIMAL,
	fk_validacion_costo INT(11) UNSIGNED,
	fk_estado_orden_compra INT(11) UNSIGNED,
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
	central_sitio VARCHAR(255),
	id_sitio VARCHAR(255),
	local_foraneo VARCHAR(255),
	condicion_pago VARCHAR(255),
	PRIMARY KEY (id)
	);

	CREATE TABLE PartidaConcentradoOrdenCompraCliente
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_concentrado_orden_compra_cliente INT(11) UNSIGNED NOT NULL,
	item INT(11) NOT NULL,
	codigo VARCHAR(255) NOT NULL,
	descripcion VARCHAR(255) NOT NULL,
	precio_unitario DECIMAl NOT NULL,
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
	porcentaje_1 DECIMAL,
	clave_validacion_1 VARCHAR(255),
	fecha_validacion_1 DATE,
	fk_estado_validacion_cobro_1 INT(11) UNSIGNED,
	porcentaje_2 DECIMAL,
	clave_validacion_2 VARCHAR(255),
	fecha_validacion_2 DATE,
	fk_estado_validacion_cobro_2 INT(11) UNSIGNED,
	porcentaje_3 DECIMAL,
	clave_validacion_3 VARCHAR(255),
	fecha_validacion_3 DATE,
	fk_estado_validacion_cobro_3 INT(11) UNSIGNED,
	porcentaje_total_cobro DECIMAL,
	fk_estado_final_validacion INT(11) UNSIGNED NOT NULL,
	fk_imputable INT(11) UNSIGNED NOT NULL,
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
	fecha_factura DATE NOT NULL,
	fk_estado_investigacion_calidad INT(11) UNSIGNED NOT NULL,
	fk_estado_tesoreria INT(11) UNSIGNED NOT NULL,
	semana DECIMAL,
	fk_proveedor_calificado INT(11) UNSIGNED,
	fk_orden_compra INT(11) UNSIGNED,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	fk_orden_compra_maquilado INT(11) UNSIGNED,
	numero_factura VARCHAR(255) NOT NULL,
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
	fecha DATE NOT NULL,
	subtotal DECIMAL NOT NULL,
	iva DECIMAL,
	total DECIMAL NOT NULL,
	fk_proveedor_calificado INT(11) UNSIGNED,
	fk_proveedor_maquilador INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE InformacionFacturacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_validacion_administrativa INT(11) UNSIGNED,
	folio_factura_1 VARCHAR(255),
	subtotal_1 DECIMAL,
	iva_1 DECIMAL,
	total_1 DECIMAL,
	fecha_emision_1 DATE,
	fecha_ingreso_1 DATE,
	dias_credito_1 DECIMAL,
	fecha_programada_1 DATE,
	estado_pago_1 VARCHAR(255),
	folio_factura_2 VARCHAR(255),
	subtotal_2 DECIMAL,
	iva_2 DECIMAL,
	total_2 DECIMAL,
	fecha_emision_2 DATE,
	fecha_ingreso_2 DATE,
	dias_credito_2 DECIMAL,
	fecha_programada_2 DATE,
	estado_pago_2 VARCHAR(255),
	folio_factura_3 VARCHAR(255),
	subtotal_3 DECIMAL,
	iva_3 DECIMAL,
	total_3 DECIMAL,
	fecha_emision_3 DATE,
	fecha_ingreso_3 DATE,
	dias_credito_3 DECIMAL,
	fecha_programada_3 DATE,
	estado_pago_3 VARCHAR(255),
	estado_factura VARCHAR(255) NOT NULL,
	fecha_estado_factura DATE NOT NULL,
	imputabilidad VARCHAR(255),
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
	subtotal DECIMAL NOT NULL,
	iva DECIMAL,
	total DECIMAL NOT NULL,
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
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	fk_medio_transporte INT(11) UNSIGNED NOT NULL,
	numero_vehiculo VARCHAR(255) NOT NULL,
	kilometraje_inicial VARCHAR(255) NOT NULL,
	combustible DECIMAL,
	casetas DECIMAL,
	pasajes DECIMAL,
	hospedaje DECIMAL,
	alimentos DECIMAL,
	materiales_herramienta DECIMAL,
	otros DECIMAL,
	total_solicitado DECIMAL,
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
	fk_solicitud_viaticos INT(11) UNSIGNED NOT NULL,
	total_autorizado DECIMAL NOT NULL,
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
	PRIMARY KEY (id)
	);

	CREATE TABLE MoviemientoFondoFijoCajaChica
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fecha DATE,
	fk_descripcion_fondo_fijo_caja_chica INT(11) UNSIGNED,
	entrega VARCHAR(255) NOT NULL,
	fk_colaborador INT(11) UNSIGNED NOT NULL,
	ingreso DECIMAL,
	egreso DECIMAL,
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
	ingreso DECIMAL,
	egreso DECIMAL,
	folio_documento VARCHAR(255),
	importe DECIMAL NOT NULL,
	descuentos DECIMAL,
	iva DECIMAL,
	redondeo DECIMAL,
	isr_retencion DECIMAL,
	iva_retencion DECIMAL,
	otros_impuestos DECIMAL,
	total_pagar DECIMAL,
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
	subtotal DECIMAL NOT NULL,
	iva DECIMAL NOT NULL,
	total DECIMAL NOT NULL,
	fk_banco_conectel INTEGER UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL NOT NULL,
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
	fk_factura_proveedor INT(11) UNSIGNED NOT NULL,
	folio_factura VARCHAR(255),
	fk_nota_credito_proveedor INT(11) UNSIGNED,
	subtotal DECIMAL NOT NULL,
	iva DECIMAL NOT NULL,
	total DECIMAL NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL NOT NULL,
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
	fk_comprobacion_viaticos INT(11) UNSIGNED NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL NOT NULL,
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
	monto DECIMAL NOT NULL,
	referencia_abono INT(11) UNSIGNED,
	PRIMARY KEY (id)
	);

	CREATE TABLE PagoOtraOperacionFinanciera
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_concepto_otra_operacion_financiera INT(11) UNSIGNED NOT NULL,
	razon_social VARCHAR(255) NOT NULL,
	subtotal DECIMAL NOT NULL,
	iva DECIMAL NOT NULL,
	total DECIMAL NOT NULL,
	fk_banco_conectel INT(11) UNSIGNED NOT NULL,
	fecha_abono DATE NOT NULL,
	monto DECIMAL NOT NULL,
	referencia_abono INT(11) UNSIGNED,
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
	PRIMARY KEY (id)
	);

	CREATE TABLE Contratacion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_reclutamiento_solicitud_empleo INT(11) UNSIGNED NOT NULL,
	fk_colaborador INTEGER UNSIGNED NOT NULL,
	sueldo_inicial DECIMAL NOT NULL,
	fecha_expedicion_certificado_medico DATE NOT NULL,
	fecha_vencimiento_certificado_medico DATE NOT NULL,
	fk_tipo_contratacion INT(11) UNSIGNED NOT NULL,
	fk_tipo_contrato INT(11) UNSIGNED NOT NULL,
	vencimiento_contrato_eventual VARCHAR(255) NOT NULL,
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
	sueldo_inicial DECIMAL,
	sueldo_final DECIMAL,
	motivo_separacion VARCHAR(255),
	nombre_jefe_inmediato VARCHAR(255),
	actividades_desempenadas VARCHAR(255),
	nombre_empresa_anterior VARCHAR(255),
	domicilio_anterior VARCHAR(255),
	telefonos_anterior VARCHAR(255),
	puesto_inicial_anterior VARCHAR(255),
	puesto_final_anterior VARCHAR(255),
	sueldo_inicial_anterior DECIMAL,
	sueldo_final_anterior DECIMAL,
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
	sueldo_solicitado DECIMAL NOT NULL,
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
	sueldo DECIMAL NOT NULL,
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
	incidencia VARCHAR(100) NOT NULL UNIQUE,
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
	incidencia VARCHAR(100) NOT NULL UNIQUE,
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
	fecha_enc DATE,
	resultado_enc DECIMAL,
	enc BOOLEAN,
	curso_tecnico VARCHAR(255),
	capacitador_interno_ct VARCHAR(255),
	capacitador_externo_ct VARCHAR(255),
	autorizacion_ct BOOLEAN,
	fecha_ct DATE,
	resultado_ct DECIMAL,
	curso_general VARCHAR(255),
	capacitador_interno_cg VARCHAR(255),
	capacitador_externo_cg VARCHAR(255),
	autorizacion_cg BOOLEAN,
	fecha_cg DATE,
	resultado_cg DECIMAL,
	PRIMARY KEY (id)
	);

	CREATE TABLE RegistroPercepcion
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fk_percepcion INT(11) UNSIGNED NOT NULL,
	monto_aportacion DECIMAL NOT NULL,
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
	fk_clase_incidencia INT(11) UNSIGNED NOT NULL,
	fk_tipo_incapacidad INT(11) UNSIGNED NOT NULL,
	monto_imss DECIMAL NOT NULL,
	monto_conectel DECIMAL NOT NULL,
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
	fk_tipo_sancion INT(11) UNSIGNED NOT NULL,
	fk_forma_pago_prenomina INT(11) UNSIGNED NOT NULL,
	monto_total_descuento DECIMAL NOT NULL,
	descuento_parcial DECIMAL,
	fecha_inicio DATE,
	fecha_termino DATE,
	PRIMARY KEY (id)
	);

	CREATE TABLE Curso
	(
	id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
	fk_contratacion INT(11) UNSIGNED NOT NULL,
	fecha_enc DATE,
	resultado_enc DECIMAL,
	enc BOOLEAN,
	curso_tecnico VARCHAR(255),
	capacitador_interno_ct VARCHAR(255),
	capacitador_externo_ct VARCHAR(255),
	autorizacion_ct BOOLEAN,
	fecha_ct DATE,
	resultado_ct DECIMAL,
	curso_general VARCHAR(255),
	capacitador_interno_cg VARCHAR(255),
	capacitador_externo_cg VARCHAR(255),
	autorizacion_cg BOOLEAN,
	fecha_cg DATE,
	resultado_cg DECIMAL,
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

	ALTER TABLE SolicitudViaticos ADD FOREIGN KEY fk_colaborador_idxfk (fk_colaborador) REFERENCES Colaborador (id);

	ALTER TABLE SolicitudViaticos ADD FOREIGN KEY fk_medio_transporte_idxfk (fk_medio_transporte) REFERENCES MedioTransporte (id);
	
	ALTER TABLE ComprobacionViaticos ADD FOREIGN KEY fk_solicitud_viaticos_idxfk (fk_solicitud_viaticos) REFERENCES SolicitudViaticos (id);

	ALTER TABLE ComprobacionViaticos ADD FOREIGN KEY fk_estado_comprobacion_viaticos_idxfk (fk_estado_comprobacion_viaticos) REFERENCES EstadoComprobacionViaticos (id);

	ALTER TABLE DocumentoComprobacionViaticos ADD FOREIGN KEY fk_comprobacion_viaticos_idxfk (fk_comprobacion_viaticos) REFERENCES ComprobacionViaticos (id);

	ALTER TABLE ComentarioContabilidad ADD FOREIGN KEY fk_usuario_idxfk (fk_usuario) REFERENCES Usuario (id);

	ALTER TABLE MoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_descripcion_fondo_fijo_caja_chica_idxfk (fk_descripcion_fondo_fijo_caja_chica) REFERENCES DescripcionFondoFijoCajaChica (id);

	ALTER TABLE MoviemientoFondoFijoCajaChica ADD FOREIGN KEY fk_colaborador_idxfk_1 (fk_colaborador) REFERENCES Colaborador (id);

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

	ALTER TABLE PagoProveedor ADD FOREIGN KEY fk_nota_credito_proveedor_idxfk (fk_nota_credito_proveedor) REFERENCES NotaCreditoProveedor (id);

	ALTER TABLE PagoProveedor ADD FOREIGN KEY fk_banco_conectel_idxfk (fk_banco_conectel) REFERENCES BancoConectel (id);

	ALTER TABLE ComentarioPagoProveedor ADD FOREIGN KEY fk_pago_proveedor_idxfk (fk_pago_proveedor) REFERENCES PagoProveedor (id);

	ALTER TABLE ComentarioPagoProveedor ADD FOREIGN KEY fk_comentario_tesoreria_idxfk (fk_comentario_tesoreria) REFERENCES ComentarioTesoreria (id);

	ALTER TABLE PagoViaticos ADD FOREIGN KEY fk_comprobacion_viaticos_idxfk (fk_comprobacion_viaticos) REFERENCES ComprobacionViaticos (id);

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

	ALTER TABLE Contratacion ADD FOREIGN KEY fk_reclutamiento_solicitud_empleo_idxfk (fk_reclutamiento_solicitud_empleo) REFERENCES ReclutamientoSolicitudEmpleo (id);

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

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_contratacion_idxfk_1 (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_percepcion_idxfk (fk_percepcion) REFERENCES Percepcion (id);

	ALTER TABLE RegistroPercepcion ADD FOREIGN KEY fk_variaciones_idxfk (fk_variaciones) REFERENCES Variacion (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_contratacion_idxfk_3 (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_clase_incidencia_idxfk (fk_clase_incidencia) REFERENCES ClaseIncidencia (id);

	ALTER TABLE InformacionPrenomina ADD FOREIGN KEY fk_tipo_incapacidad_idxfk (fk_tipo_incapacidad) REFERENCES TipoIncapacidad (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_contratacion_idxfk_5 (fk_contratacion) REFERENCES Contratacion (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_deduccion_idxfk (fk_deduccion) REFERENCES Deduccion (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_clasificacion_falta_idxfk (fk_clasificacion_falta) REFERENCES ClasificacionFalta (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_clasificacion_permiso_idxfk (fk_clasificacion_permiso) REFERENCES ClasificacionPermiso (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_tipo_sancion_idxfk (fk_tipo_sancion) REFERENCES TipoSancion (id);

	ALTER TABLE RegistroDeduccion ADD FOREIGN KEY fk_forma_pago_prenomina_idxfk (fk_forma_pago_prenomina) REFERENCES FormaPagoPrenomina (id);

	ALTER TABLE Curso ADD FOREIGN KEY fk_contratacion_idxfk_1 (fk_contratacion) REFERENCES Contratacion (id);

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
	INSERT INTO Usuario
	VALUES (8, 'PUBLICO', 'NOTIENE', 'PÚBLICO', 8, 1);
	INSERT INTO Usuario
	VALUES (9, 'CUENTASPORPAGAR', 'NOTIENE', 'CUENTAS POR PAGAR', 9, 1);
	INSERT INTO Usuario
	VALUES (10, 'FACTURACION', 'NOTIENE', 'FACTURACIÓN', 10, 1);
	INSERT INTO Usuario
	VALUES (11, 'CONTABILIDAD', 'NOTIENE', 'CONTABILIDAD', 11, 1);
	INSERT INTO Usuario
	VALUES (12, 'TESORERIA', 'NOTIENE', 'TESORERIA', 12, 1);
	INSERT INTO Usuario
	VALUES (13, 'RECURSOSHUMANOS', 'NOTIENE', 'RECURSOS HUMANOS', 13, 1);
	
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
	VALUES (3, 'Equipo de Medición');
	INSERT INTO ServicioSolicitado
	VALUES (4, 'Equipo de Cómputo');
	INSERT INTO ServicioSolicitado
	VALUES (5, 'Hardware');
	INSERT INTO ServicioSolicitado
	VALUES (6, 'Software');
	INSERT INTO ServicioSolicitado
	VALUES (7, 'Telefonía Móvil');
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

	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (1, 'Remanente Viáticos');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (2, 'Reposición de Fondo Fijo');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (3, 'Otros');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (4, 'Pasajes Locales');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (5, 'Estacionamiento');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (6, 'Agua Embotellada');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (7, 'Servicio de Recolección de Basura');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (8, 'Complemento Viático');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (9, 'Papelería');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (10, 'Combustibles');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (11, 'Materiales');
	INSERT INTO DescripcionFondoFijoCajaChica
	VALUES (12, 'Otros');

	INSERT INTO TipoOperacion
	VALUES (1, 'Ingresos');
	INSERT INTO TipoOperacion
	VALUES (2, 'Egresos');

	INSERT INTO DescripcionPagoContableServicio
	VALUES (1, 'Nómina Conectel', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (2, 'Gratificaciones', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (3, 'Finiquitos', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (4, 'IMSS, SAR e INFONAVIT', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (5, 'Financiamiento Adq. Automóvil', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (6, 'Financiamiento Adq. Otros', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (7, 'Servicio de Internet', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (8, 'Servicio Telefónico', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (9, 'Impuestos Federales', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (10, 'Impuestos Locales', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (11, 'Suministro de Agua', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (12, 'Multas', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (13, 'Servicio de TV de Paga', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (14, 'Otros', 1);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (15, 'Devolución de Cliente', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (16, 'Devolución de Impuestos', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (17, 'Venta Activo Fijo', 2);
	INSERT INTO DescripcionPagoContableServicio
	VALUES (18, 'Otros', 2);

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
	VALUES (1, 'Recisión');
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
	VALUES (7, 'Renovación de Contrato');

	INSERT INTO EstadoColaborador
	VALUES (1, 'Activo');
	INSERT INTO EstadoColaborador
	VALUES (2, 'Inactivo');
	
	INSERT INTO ClaseIncidencia
	VALUES (1, 'Accidente');
	INSERT INTO ClaseIncidencia
	VALUES (2, 'Maternidad');
	INSERT INTO ClaseIncidencia
	VALUES (3, 'Enfermedad Profesional');
	
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
	VALUES (6, 'Texto');
	INSERT INTO Percepcion
	VALUES (7, 'Ayuda por Natalicio');

	INSERT INTO Variacion
	VALUES (1, 'Tomadas');
	INSERT INTO Variacion
	VALUES (2, 'Pagadas');

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