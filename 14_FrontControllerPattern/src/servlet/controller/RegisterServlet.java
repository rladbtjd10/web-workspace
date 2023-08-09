package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	<%-- 로그인이 되어 있지 않은 경우 --%>
//	<li><a href="views/register.html">회원가입</a></li>
//	<%-- 회원가입 : 아이디, 비밀번호, 이름, 주소 입력 받아서 
//			-> RegisterServlet / post 방식
//			-> session에 데이터 바인딩
//			-> session에 값이 있는 경우 -> AllMemberServlet
//			->			값이 없는 경우 -> index.jsp
//	--%>
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// 2. 객체 생성 - 폼 값 담기
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setAddress(address);
		
		// 3. DAO와 연결
//		MemberDAO dao = new MemberDAO();
		try {
//			dto.registerMember(vo);
			MemberDAO.getInstance().registerMember(vo);
			
			// 4. 데이터 바인딩 - session
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			
			// 5. 네비게이션
			response.sendRedirect("AllMemberServlet");
			
		} catch (SQLException e) {
			
			System.out.println("회원가입 실패!");
			response.sendRedirect("../index.jsp");
		}
	
        
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
