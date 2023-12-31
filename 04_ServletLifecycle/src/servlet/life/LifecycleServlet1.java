package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifecycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int count = 0;
       
    public LifecycleServlet1() {
        System.out.println("1. LifecycleServlet 생성자..");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init... 호출..");
	}

	public void destroy() {
		//서버에서 종료가 되는 순간에 나타나는 메서드
		System.out.println("4. destory... 호출..");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿=컨트롤러   비지니스 로직이 작성되는 부분
		System.out.println("3. service... 호출..");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>LifeCycle CallBack Method...</h2>");
		out.println("<p>Count :: " + ++count + "</p>");
		
		out.close();
	}

}
