package events
{
	import flash.events.Event;
	
	public class GenericEvent extends Event
	{
		public var information:Object;
		
		public function GenericEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		override public function clone():Event{
			return new GenericEvent(type, bubbles, cancelable);
		}
	}
}