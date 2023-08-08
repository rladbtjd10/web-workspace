package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 폼값 가져온다.
		String id = request.getParameter("id");
//		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberDTO updatedMember = new MemberDTO(id, name, address);

        MemberDAO memberDAO = new MemberDAO();
        boolean updateResult = memberDAO.updateMember(updatedMember);

        if (updateResult) {
            HttpSession session = request.getSession();
            session.setAttribute("dto", updatedMember);
            
            response.sendRedirect("views/update_result.jsp");
        } else {
            response.getWriter().println("회원 정보 업데이트에 실패하였습니다.");
        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
