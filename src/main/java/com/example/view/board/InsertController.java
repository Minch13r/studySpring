package com.example.view.board;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class InsertController implements Controller {
    @Autowired
    private BoardService boardService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Insert Controller executed");

        BoardVO boardVO = new BoardVO();

        boardVO.setWriter(request.getParameter("writer"));
        boardVO.setTitle(request.getParameter("title"));
        boardVO.setContent(request.getParameter("content"));

        ModelAndView mav = new ModelAndView();
        if(boardService.insert(boardVO)){
//            return "insert.do";
            mav.setViewName("redirect:insert.do");
        }
        else {
//            return "main.do";
            mav.setViewName("redirect:main.do");
        }
        return mav;
    }
}
