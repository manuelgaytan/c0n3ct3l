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

