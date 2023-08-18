package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class loginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 데이터 바인딩 - request, session, context : 3개의 차이점 범위의차이!!
		// setAttribute
		// request <--- 범위가 가장 좁음! (요청들어오면 응답하기것까지가 데이터 범위 그래서 일회성임)
		// session <--- 로그인하는 순간부터 로그아웃(인발리데이터하는데)까지!가 데이터 범위! 
		// context <--- 범위가 가장 넓음~~ 거의 사용X : WHY? 계속 가지고 있으면 문제가 많이 생기기 때문에
		
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPassword(password);
		
		MemberVO vo = new MemberService().login(m);
		
		HttpSession session = request.getSession(); // session으로 담아준 이유: 로그인은 계속 불러서 써야되니깐!
		if(vo!=null) {
			session.setAttribute("vo", vo);
		}
		
		return new ModelAndView("views/login_result.jsp", true); // true일때 Redirect 방식 -- 페이지경로가 다나옴 
		
		
		//return new ModelAndView(path)- request로 넘길때 forward 방식(false거나 아무것도 안했을때) -- allshow.do 이런식으로 페이지 경로가 안나옴
	}

}
