package com.example.view.member;

import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import com.example.biz.member.impl.MemberDAO;
import com.example.view.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController implements Controller {
    @Autowired
    private MemberService memberService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Login Controller executed");

        // DB 연동
        MemberDAO memberDAO = new MemberDAO();
        MemberVO memberVO = new MemberVO();

        memberVO.setMid(request.getParameter("mid"));
        memberVO.setMpw(request.getParameter("mpw"));
        memberVO = memberDAO.getBoard(memberVO);
        // 페이지 이동 처리
        if(memberService.getMember(memberVO) != null) {
            return "main.do";
        }
        else {
            return "login"; // .jsp 를 자동으로 붙여줌
        }

    }

}
