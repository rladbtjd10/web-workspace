package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리..양방향!
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId"); // form의 name에 있는거 키값 받아오기
		String password = request.getParameter("userPwd");
		String gender = request.getParameter("gender");
		
		String[] menuList = request.getParameterValues("menu"); //checkbox는 여러개 선택가능하기에 스트링배열로 값으로 불러오겠다 label에 name=menu
		
		PrintWriter out = response.getWriter();
		out.println("<h2>정보를 출력합니다...</h2>");
		out.println("<p> 당신의 아이디는 " + id + "</p>");
		out.println("<p> 당신의 비밀번호는 " + password + "</p>");
//		당신의 성별은 --> form.html 라디오 사용!
		System.out.println(gender.charAt(0) == 'M');
		out.println("<p> 당신의 성별은 " + (gender.charAt(0) == 'M' ? "남자" : "여자") + "</p>"); //삼항연산자써서 맞으면 남자 아니면 여자 뜨게 해줌
		out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>");
		}
		out.println("</ul>");
		out.close();
		
	}

}
