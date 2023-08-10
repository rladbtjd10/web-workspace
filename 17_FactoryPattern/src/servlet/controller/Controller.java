package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String exexute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
