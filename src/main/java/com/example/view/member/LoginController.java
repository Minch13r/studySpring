package com.example.view.member;

import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private HttpSession session;

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Login Controller executed");

        // DB 연동
        MemberVO memberVO = new MemberVO();

        // 아이디랑 이름 세션에 저장
        session.setAttribute("mid", memberVO.getMid());
        session.setAttribute("name", memberVO.getName());

        memberVO.setMid(request.getParameter("mid"));
        memberVO.setMpw(request.getParameter("mpw"));

        // 페이지 이동 처리
        ModelAndView mav = new ModelAndView();
        // 로그인 성공시 메인페이지 이동
        if(memberService.getMember(memberVO) != null) {
//            return "main.do";
            mav.setViewName("redirect:main.do"); // 아무설정도 안 하면 forward 형식으로 함
            // redirect 하고 싶으면 앞에 명시해줘야 함
        }
        // 로그인 실패시 로그인페이지 유지
        else {
//            return "login"; // .jsp 를 자동으로 붙여줌
            mav.addObject("member", memberVO);
            mav.setViewName("login");
        }
        return mav;
    }
}
