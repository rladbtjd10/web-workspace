package servlet.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class loginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "views/login_result.jsp";
		
		HttpSession session = request.getSession();
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		
		return new ModelAndView(path);
	}

}
