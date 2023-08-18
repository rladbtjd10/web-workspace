package member.controller;

import member.controller.component.FindController;
import member.controller.component.LogoutController;
import member.controller.component.UpdateController;
import member.controller.component.allShowController;
import member.controller.component.loginController;
import member.controller.component.registerController;

// 공장역할 17번에 ControllerFactory랑 같음
public class HandlerMapping {
	
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
		} else if (command.equals("login.do")) {
			controller = new loginController();
		} else if (command.equals("front.do")) {
			controller = new registerController();
		} else if (command.equals("allShow.do")) {
			controller = new allShowController();
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
		} else if (command.equals("update.do")) {
			controller = new UpdateController();
		}
		
		return controller;
	}
}
