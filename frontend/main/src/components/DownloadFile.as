package components
{
	import flash.events.Event;
	import flash.events.HTTPStatusEvent;
	import flash.events.IOErrorEvent;
	import flash.events.ProgressEvent;
	import flash.events.SecurityErrorEvent;
	import flash.net.FileReference;
	import flash.net.URLRequest;

	public class DownloadFile
	{
		public function DownloadFile(FILE_URL:String)
		{
			this.FILE_URL = FILE_URL;
			this.init();
		}
		
		/* URL of the file to download. */
		private var FILE_URL:String = null;
		
		private var fileRef:FileReference;
		private var urlReq:URLRequest;
		
		private function init():void {
			/* Set up the URL request to download the file specified by the FILE_URL variable. */
			urlReq = new URLRequest(FILE_URL);
			
			/* Define file reference object and add a bunch of event listeners. */
			fileRef = new FileReference();
			fileRef.addEventListener(Event.CANCEL, doEvent);
			fileRef.addEventListener(Event.COMPLETE, doEvent);
			fileRef.addEventListener(Event.OPEN, doEvent);
			fileRef.addEventListener(Event.SELECT, doEvent);
			fileRef.addEventListener(HTTPStatusEvent.HTTP_STATUS, doEvent);
			fileRef.addEventListener(IOErrorEvent.IO_ERROR, doEvent);
			fileRef.addEventListener(ProgressEvent.PROGRESS, doEvent);
			fileRef.addEventListener(SecurityErrorEvent.SECURITY_ERROR, doEvent);
		}
		
		private function doEvent(evt:Event):void {
			/* Create shortcut to the FileReference object. */
			var fr:FileReference = evt.currentTarget as FileReference;
			
			/* Add event order and type to the DataGrid control. */
			//arrColl.addItem({data:arrColl.length+1, type:evt.type, eventString:evt.toString()});
			
			try {
				/* Update the Model. */
			} catch (err:*) {
				/* uh oh, an error of sorts. */
			}
		}
		
		public function download():void {
			/* Begin download. */
			fileRef.download(urlReq);
		}
	}
}