package pattern.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); //html에서 command로 받는거
		String path = "index.jsp";
		
		// Factory Pattern
		Controller controller = ControllerFactory.getInstance().createController(command); //new해자고 안만드는 이유는 command에 따라서 컨드롤러를 만들기위함 공장에서 틀에 찍어내는거 같은것
		try {
			path = controller.exexute(request, response);
		} catch (Exception e) {}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
