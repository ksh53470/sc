package kr.co.seoulit.member.controller;

import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MemberAjax2DetailController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        MemberServiceFacade sf = MemberServiceFacadeImpl.getInstance();
        MemberBean dto = sf.getMember(id);
        Map<String , Object> map=new HashMap<>();
        map.put("member", dto);
        JSONObject json = JSONObject.fromObject(map);
        out.print(json);
        return null;
    }
}
