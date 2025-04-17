package com.example.view.board;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsertController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/insert.do")
    public String insert(BoardVO boardVO, HttpServletRequest request){
        System.out.println("Insert Controller executed");

        boardVO.setWriter(request.getParameter("writer"));
        boardVO.setTitle(request.getParameter("title"));
        boardVO.setContent(request.getParameter("content"));

        if(boardService.insert(boardVO)){
            return "redirect:main.do";
        }
        return "redirect:insert.do";
    }

    @GetMapping("/insert.do")
    public String insertPage(){
        return "insert.jsp";
    }
}
