package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

@WebServlet(urlPatterns = "/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지.. command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";

		
		try {
			if (command.equals("register")) {
				path = register(request, response);
			} else if (command.equals("login")) {
				path = login(request, response);
			} else if (command.equals("allShow")) {
				path = allShow(request, response);
			} else if (command.equals("find")) {
				path = find(request, response);
			} else if (command.equals("update")) {
				path = update(request, response);}
		} catch (SQLException e) {}
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response); // 경로가 바껴서 path로 뺴놓음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected String register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = new MemberVO(id, password, name, address);

		// 3. DAO와 연결
		MemberDAO.getInstance().registerMember(vo);

		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("vo", vo);
		
		return "views/login_result.jsp";
		
	}
	
	protected String allShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		ArrayList<MemberVO> list = new ArrayList<>();
		list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);
		
		return "views/allShow.jsp";
	}
	
	
	
	protected String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		if(vo!=null) {
			request.setAttribute("vo", vo);
			return "views/find_ok.jsp";
		}
		return "views/find_fail.jsp";
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		MemberDAO.getInstance().registerMember(vo);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		} 
		
		return "views/update_result.jsp";
		
	}

}
