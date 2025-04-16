package com.example.view.member;

import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import com.example.biz.member.impl.MemberDAO;
import com.example.view.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController implements Controller {
    @Autowired
    private MemberService memberService;
    @Autowired
    private HttpSession session;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Login Controller executed");

        // DB 연동
        MemberVO memberVO = new MemberVO();

        // 아이디랑 이름 세션에 저장
        session.setAttribute("mid", memberVO.getMid());
        session.setAttribute("name", memberVO.getName());

        memberVO.setMid(request.getParameter("mid"));
        memberVO.setMpw(request.getParameter("mpw"));
        // 페이지 이동 처리
        if(memberService.getMember(memberVO) != null) {
            return "main.do";
        }
        else {
            return "login"; // .jsp 를 자동으로 붙여줌
        }

    }

}
