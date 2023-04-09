package com.example.demo.service;

import com.example.demo.domain.Member;
//import com.example.demo.repository.JdbcMemberRepository;
//import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.JdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service // 비즈니스 로직을 처리
// 만약에 DB연동이 있다면
@Transactional
public class MemberService {
//    private final MemberRepository memberRepository;
//    @Autowired
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

//    private final JdbcMemberRepository memberRepository;
//    @Autowired
//    public MemberService(JdbcMemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    private final JdbcTemplateMemberRepository memberRepository;
    @Autowired
    public MemberService(JdbcTemplateMemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void create(Member member) throws SQLException {
        memberRepository.save(member);
    }

    public List<Member> findAll() throws SQLException {
        return memberRepository.findAll();
    }

    public Member findOne(Long id) throws SQLException {
        return memberRepository.findById(id);
    }

//    public List<Member> findByName(String name){
//        return memberRepository.findByName(name);
//    }

}
