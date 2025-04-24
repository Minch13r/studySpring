package com.example.biz.member.impl;

import com.example.biz.member.MemberVO;
import com.example.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("MemberDAO")
public class MemberDAO {
    private Connection conn;
    private PreparedStatement pstmt;

    private final String INSERT = "INSERT INTO MEMBER (MID, MPW, NAME) VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE MEMBER SET MPW = ?, NAME = ? WHERE MID = ?";
    private final String DELETE = "DELETE FROM MEMBER WHERE MID = ?";
    private final String GETONE = "SELECT * FROM MEMBER WHERE MID = ?";
    private final String GETALL = "SELECT * FROM MEMBER";

    public boolean insert(MemberVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, vo.getMid());
            pstmt.setString(2, vo.getMpw());
            pstmt.setString(3, vo.getName());
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

    public boolean delete(MemberVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setString(1, vo.getMid());
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

    public boolean update(MemberVO vo) {
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, vo.getMpw());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getMid());
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

    public MemberVO getMember(MemberVO vo) {
        MemberVO datas = null;
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(GETONE);
            pstmt.setString(1, vo.getMid());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                datas = new MemberVO();
                datas.setMid(rs.getString("MID"));
                datas.setMpw(rs.getString("MPW"));
                datas.setMrole(rs.getString("MROLE"));
                datas.setName(rs.getString("NAME"));
            }
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public List<MemberVO> getMemberList(MemberVO vo){
        List<MemberVO> datas = new ArrayList<MemberVO>();
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(GETALL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                MemberVO memberVO = new MemberVO();
                memberVO.setMid(rs.getString("MID"));
                memberVO.setMpw(rs.getString("MPW"));
                memberVO.setName(rs.getString("NAME"));
                memberVO.setMrole(rs.getString("MROLE"));
                datas.add(memberVO);
            }
            return datas;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
}
