package com.example.biz.member.impl;

import com.example.biz.member.MemberVO;
import com.example.common.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("MemberDAO2")
public class MemberDAO2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT = "INSERT INTO MEMBER (MID, MPW, NAME) VALUES (?, ?, ?)";
    private final String UPDATE = "UPDATE MEMBER SET MPW = ?, NAME = ? WHERE MID = ?";
    private final String DELETE = "DELETE FROM MEMBER WHERE MID = ?";
    private final String GETONE = "SELECT * FROM MEMBER WHERE MID = ?";
    private final String GETALL = "SELECT * FROM MEMBER";

    public boolean insert(MemberVO vo) {
        int result = jdbcTemplate.update(INSERT, vo.getMid(), vo.getMpw(), vo.getName());
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean delete(MemberVO vo) {
        int result = jdbcTemplate.update(DELETE, vo.getMid());
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean update(MemberVO vo) {
        int result = jdbcTemplate.update(UPDATE, vo.getMpw(), vo.getName(), vo.getMid());
        if (result > 0) {
            return true;
        }
        return false;
    }

    public MemberVO getMember(MemberVO vo) {
        Object[] args = { vo.getMid() };
        return jdbcTemplate.queryForObject(GETONE, args, new MemberRowMapper());
    }

    public List<MemberVO> getMemberList(MemberVO vo) {
        return jdbcTemplate.query(GETALL, new MemberRowMapper());
    }
}

class MemberRowMapper implements RowMapper<MemberVO> {
    @Override
    public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        MemberVO data = new MemberVO();
        data.setMid(rs.getString("MID"));
        data.setMpw(rs.getString("MPW"));
        data.setMrole(rs.getString("MROLE"));
        data.setName(rs.getString("NAME"));
        return data;
    }
}

