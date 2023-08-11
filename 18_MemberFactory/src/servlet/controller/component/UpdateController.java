package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "views/update.jsp";
		
		MemberVO vo  = new MemberVO(id, password, name, address);
		MemberDAO.getInstance().updateMember(vo);
		
		HttpSession session = request.getSession(); //수정했으니깐 새로운 정보를 세션해줘야되서 하는거 
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		} 
		
		return new ModelAndView("views/update_result.jsp");
	}

}
