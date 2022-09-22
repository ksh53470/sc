package kr.co.seoulit.member.controller;

import kr.co.seoulit.common.dao.DataAccessException;
import kr.co.seoulit.common.servlet.ModelAndView;
import kr.co.seoulit.common.servlet.mvc.Controller;
import kr.co.seoulit.member.dao.MemberDAOImpl;
import kr.co.seoulit.member.sf.MemberServiceFacade;
import kr.co.seoulit.member.sf.MemberServiceFacadeImpl;
import kr.co.seoulit.member.to.MemberBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LoginController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("pw"));
        MemberServiceFacade sf = MemberServiceFacadeImpl.getInstance();
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        MemberBean bean = sf.getMember(id);
        System.out.println(bean);
        HashMap<String,Object> map=new HashMap<String,Object>();
        ModelAndView mav=null;
        try {
            if (bean != null) {
                if (bean.getPw().equals(pw)) {
                    System.out.println("successs");
                    request.getSession().setAttribute("id", bean.getId());
                    request.getSession().setAttribute("pw", bean.getId());
                    System.out.println(request.getSession().getId());
                } else {
                    System.out.println("pw pw pw pw");
                    throw new DataAccessException("존재하지 않는 비밀번호입니다.");
                }
            } else {
                System.out.println("asdfasdf");
                throw new DataAccessException("존재하지 않는 아이디입니다.");
            }
            map.put("errorCode", 0);
            map.put("errorMsg", "success");
            mav=new ModelAndView("menu2",map);
        }catch (Exception e){
            // TODO Auto-generated catch block
            map.put("errorCode", -1);
            map.put("errorMsg", e.getMessage());
            mav=new ModelAndView("error",map);
        }
        return mav;
    }
}
