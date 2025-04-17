package com.example.view.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class LogoutController implements Controller {
    @Autowired
    HttpSession session;
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 세션 비우기
        session.invalidate();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
