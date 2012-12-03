package components
{
	import flash.events.Event;
	import flash.events.EventDispatcher;
	import flash.events.MouseEvent;
	import flash.net.FileFilter;
	import flash.net.FileReference;
	import flash.net.URLRequest;
	
	import model.Model;
	import model.Util;

	public class LoadFile extends EventDispatcher
	{
		private var textTypes:FileFilter = null;
		private var allTypes:Array = null;
		private var fileRef:FileReference = null;
		public var type:String;
		public var fileName:String;
		
		public function LoadFile(type:String, extensionTypes:String, extensionFilters:String)
		{
			this.type = type;
			this.textTypes = new FileFilter(extensionTypes, extensionFilters);
			this.allTypes = new Array(textTypes);
		}
		
		public function show(event:MouseEvent = null):void
		{
			fileRef = new FileReference();
			fileRef.addEventListener(Event.SELECT, selectHandler);
			fileRef.addEventListener(Event.COMPLETE, completeHandler);
			fileRef.browse(allTypes);
		}
		
		private function selectHandler(event:Event):void
		{
			var prefix:String = Util.createPrefix( type, Model.getInstance().user.usuario );
			var urlRequest:String = "http://localhost:8080/serviciosWeb/file_upload.jsp";
			urlRequest += "?prefix=" + prefix;
			urlRequest += "&type=" + type;
			var request:URLRequest = new URLRequest( urlRequest );
			
			if( !sizeValidation( event.currentTarget as FileReference ) ){
				Util.showErrorMessage( "Archivo mayor a 5 MB no se puede cargar" );
				trace("Unable to upload file for sizing greater than 5 MB.");
				return;
			}
			
			try
			{
				this.fileName = prefix + event.currentTarget.name;
				fileRef.upload(request);
			}
			catch (error:Error)
			{
				trace("Unable to upload file.");
			}
		}
		
		protected function completeHandler(event:Event):void
		{
			this.dispatchEvent( event );
		}

		private function sizeValidation(currentTarget:FileReference):Boolean
		{
			if( currentTarget == null ){
				return false;
			}
			return currentTarget.size <= 5120000;
		}
	}
}