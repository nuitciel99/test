package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 회원가입
// 회원목록list
// 회원상세보기
// 스피링빈에 등록: 스피링빈이란? 스프링프레임워크가 미리 객체를 만들어 놓는것.

@Controller
// @Bean, @Component 어노테이션을 통해 선언돼 있는 것들은 Bean으로 등록
//
public class MemberController {
    private final MemberService memberService;
    // 생성자 주입 : Autowired 어노테이션을 사용하여 MemberService를 주입 받는다.
    // Autowired는 생략 가능
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String returnFormHtml(){
        return "members/createMemberForm";
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/members/list")
    public String membersList(Model model) throws SQLException {
        model.addAttribute("members", memberService.findAll());
        return "members/memberList";
    }


    @PostMapping("/members/new")
    public String createData(@RequestParam(value = "myName")String name) throws SQLException {
        Member member = new Member();
        member.setName(name);
        memberService.create(member);

        return "redirect:/"; // /로 가라
    }

    @GetMapping("/member/detail")
    public String memberDetail(@RequestParam(value = "id")Long my_id,Model model) throws SQLException {
        model.addAttribute("member", memberService.findOne(my_id));
        return "members/memberDetail";
    }

//    @GetMapping("/member/findbyname")
//    @ResponseBody
//    public List<Member> memberFindByName(@RequestParam(value = "name")String name){
//        return memberService.findByName(name);
//    }

//    @GetMapping("/member/findByIdAndName")
//    @ResponseBody
//    public Member findByIdAndName(@RequestParam(value = "name")String name, @RequestParam(value = "id")Long id){
//        return memberService.findByIdAndName(id, name);
//    }
}
