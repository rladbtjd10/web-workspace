package servlet.controller.component;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class idCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id"); //방법2(강사님방식)
		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
		
		boolean flag = false;
		if(vo!=null) {
			flag = true;
		}
		
		//비동기방식
		PrintWriter out = response.getWriter();
		out.print(flag);
		
		return null;
		
		
		
		
		
		
		
		
		
		//		String id = request.getParameter("id"); --방법1
//		
//		PrintWriter out = response.getWriter();
//		
//		MemberVO vo = MemberDAO.getInstance().findByIdMember(id);
//		
//		if(vo!=null) {
//			out.print("ID 사용 불가!");
//		} else {
//			out.print("ID 사용 가능!!");
//		}
//		
//		return new ModelAndView();
}
}
