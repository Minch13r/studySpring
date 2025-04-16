package com.example.view.member;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import com.example.biz.board.impl.BoardDAO;
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
public class MainController implements Controller {
    @Autowired
    private MemberService memberService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private HttpSession session;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Main Controller executed");

        BoardVO boardVO = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();

        MemberVO memberVO = new MemberVO();
        MemberDAO memberDAO = new MemberDAO();


        memberVO.setMid(request.getParameter("mid"));
        memberVO.setMpw(request.getParameter("mpw"));

        // 상세페이지 보기
        boardVO.setBid(Integer.parseInt(request.getParameter("bid")));
        if(boardService.getBoard(boardVO) != null) {
            request.setAttribute("boardVO", boardVO);
            return "detail";
        } else {
            return "main.do";
        }


        // 글작성 페이지 보기
        if(memberService.getMember(memberVO) != null) {
            request.setAttribute("memberVO", memberVO);
            return "insert";
        } else {
            return "main.do";
        }

        // 로그아웃
        session.invalidate();
        return "login";
    }
}
