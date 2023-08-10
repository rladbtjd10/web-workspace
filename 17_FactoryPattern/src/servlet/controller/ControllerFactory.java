package servlet.controller;

import servlet.controller.component.FindController;

public class ControllerFactory {
	
	//하나만 만드니깐 싱글톤 패턴
	private static ControllerFactory factory = new ControllerFactory(); //여기서 딱한번 객체 생성을함
	private ControllerFactory() {} 
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
			
		if(command.equals("find")) {
			controller = new FindController();
		} else if 
		
		return controller;
	}
	
}
