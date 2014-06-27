package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DocumentoAyudanteDO")]
	public class DocumentoAyudante
	{
		public var id:*;
		public var ayudante:Ayudante;
		public var documento:String;
		
		public function DocumentoAyudante()
		{
		}
	}
}