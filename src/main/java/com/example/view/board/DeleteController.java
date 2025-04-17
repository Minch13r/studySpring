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
public class DeleteController implements Controller {
    @Autowired
    private BoardService boardService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Delete Controller handleRequest");
        BoardVO boardVO = new BoardVO();

        boardVO.setBid(Integer.parseInt(request.getParameter("bid")));

        ModelAndView mav = new ModelAndView();
        if(boardService.delete(boardVO)){
            mav.setViewName("redirect:delete.do");
        }
        else {
            mav.setViewName("detail");
        }
        return mav;
    }
}
