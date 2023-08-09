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

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼 값 받는다.
		String id = request.getParameter("id");
		
	    try {
	    	// 3. DAO 연결
//			MemberDAO dao = new MemberDAO();
//			MemberDTO dto = dao.findByIdMember(id);
			MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
			
			if(vo!=null) {
				//4. 데이터 바인딩
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			} else {
				response.sendRedirect("views/find_fail.jsp");
			}
		} catch (SQLException e) {}
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
