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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		// 2. 객체 생성
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setAddress(address);

		try {
			//3. DAO
			MemberDAO.getInstance().updateMember(vo);
			
			//4. 데이터 바인딩 - session
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) {
				session.setAttribute("vo", vo);
			} 
			
			//5.네비게이션
			request.getRequestDispatcher("views/update_result.jsp").forward(request, response);
			
		} catch (SQLException e) {}
		
		} 
        

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
