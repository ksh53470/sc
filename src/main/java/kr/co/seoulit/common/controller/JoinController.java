package kr.co.seoulit.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;

public class JoinController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 HashMap<String,Object> map=new HashMap<String,Object>();
		ModelAndView mav=null;
	 	try {		
			MemberServiceFacade sf=MemberServiceFacadeImpl.getInstance();
			MemberBean bean=new MemberBean();
			List<MemberBean> list = sf.getMemberList();
			List<String> list2 = new ArrayList<>();
			System.out.println(list);
			System.out.println(request.getParameter("id"));
			for(MemberBean member : list){
				String id2= member.getId();
				list2.add(id2);
			}
			System.out.println(list2);
			if(list2.contains(request.getParameter("id"))){
				System.out.println("Id arleady exist!");//자바에서 JS문법 사용하기
				out.println("<script language='javascript'>");
						out.println("alert('Id arleady exist!')");
						out.println("window.close()");
						out.println("history.back()");
				out.println("</script>");
				out.flush();
			}
			else {
				bean.setId(request.getParameter("id"));
				bean.setPw(request.getParameter("pw"));
				bean.setAddr(request.getParameter("addr"));
				bean.setTel(request.getParameter("tel"));
				sf.addMember(bean);

				mav = new ModelAndView("menu", null);
				map.put("errorCode", 0);
				map.put("errorMsg", "success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
	 		 map.put("errorCode", -1);
	 		 map.put("errorMsg", e.getMessage());
	 		 mav=new ModelAndView("error",map);
		}	
		return mav;
	}
}
