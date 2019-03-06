package com.ecommerce.member.controller;

import com.ecommerce.member.model.Member;
import com.ecommerce.member.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(path = "/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> getAllMember() {
        return memberService.getAll();
    }

    @GetMapping(path = "/members/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member getMemberByEmail(@PathVariable String email) {
        return memberService.getByEmail(email);
    }

    @PostMapping(path = "/members/_insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    @PutMapping(path = "/members/_update", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @DeleteMapping(path = "/members/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member deleteMemberByEmail(@PathVariable String email) {
        return memberService.deleteByEmail(email);
    }
}
