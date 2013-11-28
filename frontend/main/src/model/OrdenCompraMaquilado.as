package model
{
	import model.Proyecto;
	
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO")]
	public class OrdenCompraMaquilado
	{
		public var id:*;
		public var fecha:Date;
		public var solicitudServicioMaquilado:SolicitudServicioMaquilado;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var claveValidacion:String;
		public var leyenda:String;
		public var subtotal:Number;
		public var iva:Number;
		public var ieps:*;
		public var retencionIsr:*;
		public var retencionIva:*;
		public var otrosImpuestos:*;
		public var total:Number;
		public var importeLetra:String;
		public var anticipo:*;
		public var finiquito:*;
		
		public static const OC_QUANTITY:Number = 0.5;
		public static const OC_UNIT:String = "PROYECTO";
		public static const OC_SITE:String = "SITIO";
		public static const OC_ADVANCE:String = "ANTICIPO";
		public static const OC_SETTLEMENT:String = "FINIQUITO";
		
		public function OrdenCompraMaquilado()
		{
		}
		
		public function get subtotalCalculado():Number{
			var subtotal:Number = 0;
			for each (var item:PartidaOrdenCompraSolicitudServicioMaquilado in this.partidas) {
				subtotal += item.importe;
			}
			return subtotal;
		}
		
		public function get ivaCalculado():Number{
			var iva:Number = this.subtotalCalculado * Constants.IVA;
			return iva;
		}
		
		public function get totalCalculado():Number{
			var total:Number = this.subtotalCalculado + this.ivaCalculado;
			return total;
		}
		
		public function get partidas():ArrayCollection{
			var partidasOrdenCompraMaquilado:ArrayCollection = new ArrayCollection();
			var i:Number = 1;
			if( this.solicitudServicioMaquilado.proyectoPadre == null ){
				this.dividirProyecto(partidasOrdenCompraMaquilado, i, this.solicitudServicioMaquilado.proyecto);
			}else{
				for each (var proyectoPadreHijo:ProyectoPadreHijo in this.solicitudServicioMaquilado.proyectoPadre.proyectoPadreHijos ) {
					this.dividirProyecto(partidasOrdenCompraMaquilado, i, proyectoPadreHijo.proyecto);
					i+=2;
				}
			}
			return partidasOrdenCompraMaquilado;
		}
		
		private function dividirProyecto(partidasOrdenCompraMaquilado:ArrayCollection, i:Number, proyecto:Proyecto){
			if( proyecto == null ){
				return;
			}
			var entry:PartidaOrdenCompraSolicitudServicioMaquilado = null;
			entry = new PartidaOrdenCompraSolicitudServicioMaquilado();
			entry.partida = i;
			entry.cantidad = OC_QUANTITY;
			entry.unidad = OC_UNIT;
			entry.descripcion = OC_ADVANCE + " " + proyecto.producto.modelo + 
				"\n" + proyecto.producto.actividadRealizar + ", " + proyecto.producto.equipo + 
				"\n" + proyecto.producto.tipoServicio + " " + OC_SITE + " " + proyecto.centralSitio;
			if( proyecto.producto.tipoServicio == Producto.TIPO_SERVICIO_LOCAL == 0 ){
				entry.costo = proyecto.producto.costoLocalProveedor;
			}
			if( proyecto.producto.tipoServicio == Producto.TIPO_SERVICIO_FORANEO == 0 ){
				entry.costo = proyecto.producto.costoForaneoProveedor;
			}
			entry.importe = entry.cantidad * entry.costo;
			partidasOrdenCompraMaquilado.addItem( entry );
			i++;
			entry = new PartidaOrdenCompraSolicitudServicioMaquilado();
			entry.partida = i;
			entry.cantidad = OC_QUANTITY;
			entry.unidad = OC_UNIT;
			entry.descripcion = OC_SETTLEMENT + " " + proyecto.producto.modelo + 
				"\n" + proyecto.producto.actividadRealizar + ", " + proyecto.producto.equipo + 
				"\n" + proyecto.producto.tipoServicio + " " + OC_SITE + " " + proyecto.centralSitio;
			if( proyecto.producto.tipoServicio == Producto.TIPO_SERVICIO_LOCAL == 0 ){
				entry.costo = proyecto.producto.costoLocalProveedor;
			}
			if( proyecto.producto.tipoServicio == Producto.TIPO_SERVICIO_FORANEO == 0 ){
				entry.costo = proyecto.producto.costoForaneoProveedor;
			}
			entry.importe = entry.cantidad * entry.costo;
			partidasOrdenCompraMaquilado.addItem( entry );
		}
	}
}