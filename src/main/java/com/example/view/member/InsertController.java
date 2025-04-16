package com.example.view.member;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import com.example.biz.board.impl.BoardDAO;
import com.example.view.controller.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertController implements Controller {
    @Autowired
    private BoardService boardService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Insert Controller executed");

        BoardVO boardVO = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();

        boardVO.setWriter(request.getParameter("writer"));
        boardVO.setTitle(request.getParameter("title"));
        boardVO.setContent(request.getParameter("content"));

        if(boardService.insert(boardVO)){
            return "insert.do";
        }
        else {
            return "main.do";
        }
    }
}
