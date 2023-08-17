package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;


public class ItemViewController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int itemId = Integer.parseInt(request.getParameter("id"));
		
		ItemDAO.getInstance().updateRecordCount(itemId);
		
		Item item = ItemDAO.getInstance().getItem(itemId);
		request.setAttribute("item", item);
		
		System.out.println("item :: " + item);
		
//		if(item!=null) {
//			request.setAttribute("item", item);
//		}
		
		// 오늘 본 상품정보를 저장하는 쿠키 로직
		// 1) 쿠키 생성
		Cookie cookie = new Cookie("fruit-" + itemId, item.getPictureUrl()); //("키(key)", "값(value)") 키는 문자열
		cookie.setMaxAge(24*60*60); //오늘하루본상품이니깐 24시간 60분 60초
		
		// 2) 생성한 쿠키를 웹브라우저로 보냄
		response.addCookie(cookie);
		
		return new ModelAndView("itemView.jsp");
	}
	
}
