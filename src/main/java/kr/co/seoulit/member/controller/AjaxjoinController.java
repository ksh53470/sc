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

public class AjaxjoinController implements Controller {

    ModelAndView handleRequest(){
// str="{"member": {"id":"id7","pw":"pw7" ... } }"

        return null;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();
        MemberServiceFacade sf = MemberServiceFacadeImpl.getInstance();
        String str=request.getParameter("senddata");
        JSONObject json1=JSONObject.fromObject(str);
        JSONObject json2=json1.getJSONObject("member");
        MemberBean dto=(MemberBean)JSONObject.toBean(json2,MemberBean.class);
        sf.addMember(dto);

        List<MemberBean> list=sf.getMemberList();
        Map<String,Object> map=new HashMap<>();
        map.put("memberlist",list);
        JSONObject json3=JSONObject.fromObject(map);
        out.print(json3);

        return null;
    }
}
