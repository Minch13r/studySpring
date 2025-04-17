package com.example.view.board;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component
public class InsertPageController implements Controller {
    @Autowired
    private BoardService boardService;
    @Autowired
    private HttpSession session;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BoardVO boardVO = new BoardVO();

        int boardId = Integer.parseInt(request.getParameter("bid"));
        boardVO.setBid(boardId);

        ModelAndView mav = new ModelAndView();
        if(boardService.getBoard(boardVO) != null){
            mav.setViewName("deatil");
        }
        else {
            mav.setViewName("redirect:main.do");
        }
        return mav;
    }
}

