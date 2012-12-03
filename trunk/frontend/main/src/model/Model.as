package model
{
	public class Model
	{
		public static var _model:Model = null;
		
		public var user:Usuario = null;
		
		public static function getInstance():Model{
			if( _model == null ){
				_model = new Model();
			}
			return _model;
		}
		
	}
}