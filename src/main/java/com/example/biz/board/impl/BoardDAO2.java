package com.example.biz.board.impl;

import com.example.biz.board.BoardVO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("BoardDAO")
public class BoardDAO2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT = "INSERT INTO BOARD VALUES(NVL((SELECT MAX(BID)+1 FROM BOARD),1001),?,?,?,0)";
    private final String UPDATE = "";
    private final String DELETE = "";

    private final String GETONE = "SELECT * FROM BOARD WHERE BID=?";
    private final String GETALL = "SELECT * FROM BOARD";

    public boolean insert(BoardVO vo) {
        int result = jdbcTemplate.update(INSERT, vo.getTitle(), vo.getContent(), vo.getWriter());
        if(result <= 0) {
            return false;
        }
        return true;
    }
    public boolean update(BoardVO vo) {
        return false;
    }
    public boolean delete(BoardVO vo) {
        return false;
    }
    public BoardVO getBoard(BoardVO vo) {
        Object[] args = { vo.getBid() };
        return jdbcTemplate.queryForObject(GETONE, args, new BoardRowMapper());
    }
    public List<BoardVO> getBoardList(BoardVO vo) {
        return jdbcTemplate.query(GETALL, new BoardRowMapper());
    }

}

class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoardVO data = new BoardVO();
        data.setBid(rs.getInt("BID"));
        data.setTitle(rs.getString("TITLE"));
        data.setContent(rs.getString("CONTENT"));
        data.setWriter(rs.getString("WRITER"));
        data.setCnt(rs.getInt("CNT"));
        return data;
    }

}
