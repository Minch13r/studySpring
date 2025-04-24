package com.example.biz.member.impl;

import com.example.biz.member.MemberService;
import com.example.biz.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public boolean insert(MemberVO vo) {
        return memberDAO.insert(vo);
    }

    @Override
    public boolean update(MemberVO vo) {
        return memberDAO.update(vo);
    }

    @Override
    public boolean delete(MemberVO vo) {
        return memberDAO.delete(vo);
    }

    @Override
    public MemberVO getMember(MemberVO vo) {
        return memberDAO.getMember(vo);
    }

    @Override
    public List<MemberVO> getMemberList(MemberVO vo) {
        return memberDAO.getMemberList(vo);
    }
}
