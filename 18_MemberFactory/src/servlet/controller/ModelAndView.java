package servlet.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView() {}
	public ModelAndView(String path) { //forward 방식!
		super();
		this.path = path;
	}
	public ModelAndView(String path, boolean isRedirect) { //sendRedirect! 보낼땐 true 같이 넘겨서
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
