package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class allShowController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<MemberVO> list = new MemberService().showAllMember(); // ArrayList<MemberVO> list 부분 MemberDAO의 리턴값 생각하기
		request.setAttribute("list", list);
		
		return new ModelAndView("views/allShow.jsp"); // forward방식으로!
	}

}
