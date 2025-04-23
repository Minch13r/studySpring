package com.example.biz.board.impl;

import com.example.biz.board.BoardService;
import com.example.biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService") // Component를 상속받아 만들어진 어노테이션, Serivce 파일이라는 것을 명시
public class BoardServiceImpl implements BoardService {
    @Autowired // boardDAO 객체가 메모리에 new 되어있어야하는 상황!!
    private BoardDAO boardDAO;

    @Override
    public boolean insert(BoardVO vo) {
        return boardDAO.insert(vo);
    }

    @Override
    public boolean update(BoardVO vo) {
        return boardDAO.update(vo);
    }

    @Override
    public boolean delete(BoardVO vo) {
        return boardDAO.delete(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo){
        if(vo==null){
            throw new IllegalArgumentException("일부로 발생시킨 예외");
        }
        return boardDAO.getBoardList(vo);
    }
}
