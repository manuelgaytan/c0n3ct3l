package components
{
	import flash.display.InteractiveObject;
	import flash.events.FocusEvent;
	import flash.geom.Point;
	import flash.geom.Rectangle;
	
	import mx.core.Application;
	import mx.core.Container;
	import mx.core.EdgeMetrics;
	import mx.core.UIComponent;
	
	public class AMClsFocusViewportWatcher
	{
		private var componente:UIComponent;
		private var padre:UIComponent;
		
		public function AMClsFocusViewportWatcher(componente:UIComponent, padre:UIComponent=null)
		{
			padre = (padre == null) ? (Application.application as UIComponent) : padre;
			this.componente = componente;
			this.setupFocusViewportWatcher();
		}

		public function setupFocusViewportWatcher():void {
			this.componente.addEventListener("focusIn", makeFocusedItemVisible);
        }
    
        public function makeFocusedItemVisible(event:FocusEvent):void {
            // Target is the actual object that has focus.
            var target:InteractiveObject = InteractiveObject(event.target);
            
            // OriginalTarget is the component that has focus as some
            // component actually delegate true focus to an internal object.
            var originalTarget:InteractiveObject = 
       			 InteractiveObject(this.componente.focusManager.findFocusManagerComponent(target));
    
    		//MANUELG: Fallaba con componentes que no estaban en el estado incial y despues aparecen
    		if( originalTarget == null ){
    			return;
    		}
    
            // The viewable portion of a container
            var viewport:Rectangle = new Rectangle();
            
            do {
                // Cycle through all parents looking for containers.
                if (target.parent is Container) {
                    var viewportChanged:Boolean = false;
                    var c:Container = target.parent as Container;

                    // Get the viewable area in the container.
                    var vm:EdgeMetrics = c.viewMetrics;
                    viewport.x = vm.left;
                    viewport.y = vm.top;
                    viewport.width = 
                        c.width / c.scaleX - vm.left - vm.right;
                    viewport.height = 
                        c.height / c.scaleY - vm.top - vm.bottom;
                    
                    // Calculate the position of the target in the container.
                    var topLeft:Point = new Point(0, 0);
                    var bottomRight:Point = 
                new Point(originalTarget.width, originalTarget.height);
                    topLeft = originalTarget.localToGlobal(topLeft);
                    topLeft = c.globalToLocal(topLeft);
                    bottomRight = originalTarget.localToGlobal(bottomRight);
                    bottomRight = c.globalToLocal(bottomRight);
    
                    // Figure out if we have to move the scroll bars.
                    // If the scroll bar moves, the position of the component
                    // moves as well. This algorithm makes sure the top
                    // left of the component is visible if the component is
                    // bigger than the viewport.
                    var delta:Number;

                    if (bottomRight.x > viewport.right) {
                        delta = bottomRight.x - viewport.right;
                        c.horizontalScrollPosition += delta;
                        topLeft.x -= delta;
                        viewportChanged = true;
                    }

                    if (topLeft.x < viewport.left) {
                        // leave it a few pixels in from the left
                        c.horizontalScrollPosition -= 
                            viewport.left - topLeft.x + 2;
                        viewportChanged = true;
                    }
                    
                    if (bottomRight.y > viewport.bottom) {
                        delta = bottomRight.y - viewport.bottom;
                        c.verticalScrollPosition += delta;
                        topLeft.y -= delta;
                        viewportChanged = true;
                    }
                    
                    if (topLeft.y < viewport.top) {
                        // leave it a few pixels down from the top
                        c.verticalScrollPosition -= 
                            viewport.top - topLeft.y + 2;
                        viewportChanged = true;
                    }
                    
                    // You must the validateNow() method to get the 
                    // container to move the component before working 
                    // on the next parent.
                    // Otherwise, your calculations will be incorrect.
                    if (viewportChanged) {
                        c.validateNow();
                    }
                }
                
                target = target.parent;
            }
            
            while (target != padre);
		}
	}
}