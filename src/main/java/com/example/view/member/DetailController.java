package com.example.view.member;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import com.example.view.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailController implements Controller {
    @Autowired
    private BoardService boardService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Detail Controller executed");

        BoardVO boardVO = new BoardVO();
        boardVO.setBid(Integer.parseInt(request.getParameter("bid")));
        if(boardService.getBoard(boardVO) != null){
            request.setAttribute("boardVO", boardVO);
            return "detail.do";
        }
        else {
            return "main.do";
        }
    }
}
