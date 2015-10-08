--20151006
alter table SolicitudViaticos add column combustible_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column casetas_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column pasajes_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column hospedaje_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column alimentos_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column materiales_herramienta_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column otros_autorizado DECIMAL(11,2);
alter table SolicitudViaticos add column total_autorizado DECIMAL(11,2);

alter table FacturaPorPagar add column fecha_pago1 DATE;
alter table FacturaPorPagar add column porcentaje_pago1 VARCHAR(20);
alter table FacturaPorPagar add column fecha_pago2 DATE;
alter table FacturaPorPagar add column porcentaje_pago2 VARCHAR(20);

alter table PagoMovimientoPagoContableServicio add column cuentas_destino VARCHAR(255) NOT NULL;
alter table PagoOtraOperacionFinanciera add column cuentas_destino VARCHAR(255) NOT NULL;

alter table PagoMovimientoPagoContableServicio add column fk_tipo_pago INT(11) UNSIGNED NOT NULL;
alter table PagoOtraOperacionFinanciera add column fk_tipo_pago INT(11) UNSIGNED NOT NULL;

ALTER TABLE PagoMovimientoPagoContableServicio ADD FOREIGN KEY fk_tipo_pago_idxfk_2 (fk_tipo_pago) REFERENCES TipoPago (id);
ALTER TABLE PagoOtraOperacionFinanciera ADD FOREIGN KEY fk_tipo_pago_idxfk_3 (fk_tipo_pago) REFERENCES TipoPago (id);

alter table SolicitudPermiso add column fecha_registro DATE NOT NULL;
alter table SolicitudVacaciones add column fecha_registro DATE NOT NULL;