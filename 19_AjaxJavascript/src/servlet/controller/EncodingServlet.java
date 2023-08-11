package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); //PrintWriter 클래스는 텍스트 데이터를 출력하기 위해 사용되며, response.getWriter() 메서드는 응답의 출력 스트림을 얻기 위해 호출됩니다.이를 통해 서버에서 생성한 데이터를 클라이언트로 보낼 수 있습니다.
		
		String nick = request.getParameter("nick");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		out.print(nick);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
