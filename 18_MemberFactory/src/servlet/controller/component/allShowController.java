package servlet.controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class allShowController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<MemberVO> list = MemberDAO.getInstance().showAllMember(); // ArrayList<MemberVO> list 부분 MemberDAO의 리턴값 생각하기
		request.setAttribute("list", list);
		
		return new ModelAndView("views/allShow.jsp"); // forward방식으로!
	}

}
