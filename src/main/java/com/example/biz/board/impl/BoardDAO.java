package com.example.biz.board.impl;

import com.example.biz.board.BoardVO;
import com.example.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("BoardDAO")
public class BoardDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    private final String INSERT = "INSERT INTO BOARD (BID, TITLE, CONTENT, WRITER) VALUES ((SELECT NVL(MAX(BID)+1, 1) FROM BOARD), ?, ?, ?)";
    private final String UPDATE = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE BID = ?";
    private final String DELETE = "DELETE FROM BOARD WHERE BID = ?";
    private final String GETONE = "SELECT * FROM BOARD WHERE BID = ?";
    private final String GETALL = "SELECT * FROM BOARD";

    public boolean insert(BoardVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());
            int result = pstmt.executeUpdate();
            if (result > 0){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public boolean delete(BoardVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, vo.getBid());
            int result = pstmt.executeUpdate();
            if (result > 0){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public boolean update(BoardVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());
            pstmt.setInt(4, vo.getBid());
            int result = pstmt.executeUpdate();
            if (result > 0){
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public BoardVO getBoard(BoardVO vo) {
        BoardVO datas = null;
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(GETONE);
            pstmt.setInt(1, vo.getBid());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                datas = new BoardVO();
                datas.setBid(rs.getInt("BID"));
                datas.setTitle(rs.getString("TITLE"));
                datas.setContent(rs.getString("CONTENT"));
                datas.setWriter(rs.getString("WRITER"));
                datas.setCnt(rs.getInt("CNT"));
            }
            return datas;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public List<BoardVO> getBoardList(BoardVO vo){
        List<BoardVO> datas = new ArrayList<BoardVO>();
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(GETALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardVO board = new BoardVO();
                board.setBid(rs.getInt("BID"));
                board.setTitle(rs.getString("TITLE"));
                board.setContent(rs.getString("CONTENT"));
                board.setWriter(rs.getString("WRITER"));
                datas.add(board);
            }
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
}
