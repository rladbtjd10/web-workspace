package pattern.controller;

import pattern.controller.component.FindController;


//위에 Action 팩토리랑 같음 공장
public class ControllerFactory {

	// 싱글톤 패턴
	private static ControllerFactory factory = new ControllerFactory(); //여기서 딱한번 객체 생성을함
	private ControllerFactory() {} //다른데서 생성하지 못하게 private로 걸어주기
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// createController : 컨트롤러 생성하는 기능
	public Controller createController(String command) { //html command 에서 value="findModel" 받음
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
		}
		
		return controller;
		
	}
}
