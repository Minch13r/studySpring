package com.example.view.board;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class MainController implements Controller {
    @Autowired
    private MemberService memberService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private HttpSession session;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Main Controller executed");

        BoardVO boardVO = new BoardVO();
        MemberVO memberVO = new MemberVO();

        memberVO.setMid(request.getParameter("mid"));
        memberVO.setMpw(request.getParameter("mpw"));

        ModelAndView mav = new ModelAndView();
        // 상세페이지 보기
        boardVO.setBid(Integer.parseInt(request.getParameter("bid")));
        if(boardService.getBoard(boardVO) != null) {
            request.setAttribute("boardVO", boardVO);
            // 상세페이지 보기
//            return "detail";
            mav.setViewName("board");
        }
        // 안되면 메인 유지
        else {
//            return "main.do";
            mav.setViewName("redirect:main.do");
        }


        // 글작성 페이지 보기
        if(memberService.getMember(memberVO) != null) {
            request.setAttribute("memberVO", memberVO);
            // 글 작성 페이지로 이동
//            return "insert";
            mav.setViewName("insert");
        }
        // 안되면 메인 유지
        else {
//            return "main.do";
            mav.setViewName("redirect:main.do");
        }
        return mav;
    }
}
