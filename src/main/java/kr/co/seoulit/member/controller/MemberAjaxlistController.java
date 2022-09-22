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
import java.util.List;
import java.util.Map;

public class MemberAjaxlistController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        MemberServiceFacade sf = MemberServiceFacadeImpl.getInstance();
        List<MemberBean> list = sf.getMemberList();
        Map<String, Object> map = new HashMap<>();
        map.put("memberlist", list);
        JSONObject json=JSONObject.fromObject(map);
        out.print(json);
        return null;
    }
}
