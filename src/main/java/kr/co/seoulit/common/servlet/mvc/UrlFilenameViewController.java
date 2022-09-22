package kr.co.seoulit.common.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.common.servlet.ModelAndView;

public class UrlFilenameViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		String contextPath=request.getContextPath();
		int sIndex=contextPath.length()+1;
		int eIndex=uri.lastIndexOf(".");
		System.out.println(eIndex);
		String viewName=uri.substring(sIndex,eIndex);
/*		System.out.println("qwer");
		System.out.println(viewName);*/
		ModelAndView modelAndView=new ModelAndView(viewName,null);
		return modelAndView;
	}
}
