package kr.co.seoulit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;
import net.sf.json.JSONObject;

public class DeleteController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        System.out.println(request.getParameter("senddata"));
        // TODO Auto-generated method stub
        String uri=request.getRequestURI();
        String contextPath=request.getContextPath();
        String viewName=uri.split("[.]")[0].substring(contextPath.length());
        HashMap<String,Object> map=new HashMap<String,Object>();
        ModelAndView mav=null;
        try {
            String id=request.getParameter("senddata");
            MemberServiceFacadeImpl.getInstance().removeMember(id);
/*            MemberServiceFacade sf=MemberServiceFacadeImpl.getInstance();
            MemberBean bean=sf.removeMember(id);*/
            //map.put("memberInfo",bean);
            //mav=new ModelAndView("menu",null);
            /*map.put("errorCode", 0);
            map.put("errorMsg", "success");*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            mav=new ModelAndView("error",map);
        }
        JSONObject json = JSONObject.fromObject(map);
        out.print(json);
        return null;
    }
}
