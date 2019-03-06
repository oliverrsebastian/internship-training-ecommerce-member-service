package com.ecommerce.member;

import com.ecommerce.member.model.Member;
import com.ecommerce.member.service.MemberServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MemberServiceTest {

    private MemberServiceImpl memberService;

    @Before
    public void setUp() throws Exception {
        memberService = new MemberServiceImpl();
    }

    @Test
    public void testGetMemberByEmailSuccess() {
        String email = "oliverrsebastian@gmail.com";
        Member member = memberService.getByEmail(email);
        Assert.assertNotNull(member);
        Assert.assertEquals(email, member.getEmail());
    }

    @Test
    public void testGetMemberByEmailNotFoundFailed() {
        String email = "aaa@gmail.com";
        Member member = memberService.getByEmail(email);
        Assert.assertNull(member);
    }

    @Test
    public void testGetMemberByEmailNullFailed() {
        Member member = memberService.getByEmail(null);
        Assert.assertNull(member);
    }

    @Test
    public void testGetMemberByEmailNotEndWithSuffixFailed() {
        String email = "aaa";
        Member member = memberService.getByEmail(email);
        Assert.assertNull(member);
    }

    @Test
    public void testGetAllMemberSuccess() {
        List<Member> returned = memberService.getAll();
        Assert.assertEquals(5, returned.size());
    }

    @Test
    public void testDeleteMemberByEmailSuccess() {
        String email = "oliverrsebastian@gmail.com";
        Member member = memberService.deleteByEmail(email);
        Assert.assertNotNull(member);
        Assert.assertEquals(email, member.getEmail());
    }

    @Test
    public void testDeleteMemberByEmailNotFoundFailed() {
        String email = "aaa@gmail.com";
        Member member = memberService.deleteByEmail(email);
        Assert.assertNull(member);
    }

    @Test
    public void testDeleteMemberByEmailNullFailed() {
        Member member = memberService.deleteByEmail(null);
        Assert.assertNull(member);
    }

    @Test
    public void testDeleteMemberByEmailNotEndWithSuffixFailed() {
        String email = "aaa";
        Member member = memberService.deleteByEmail(email);
        Assert.assertNull(member);
    }

    @Test
    public void testInsertMemberSuccess() {
        Member memberWantedToBeInsert = new Member("MEM12", "aaa", "ADF");
        Member inserted = memberService.insertMember(memberWantedToBeInsert);
        Assert.assertNotNull(inserted);
        Assert.assertEquals(memberWantedToBeInsert, inserted);
    }

    @Test
    public void testInsertMemberNullFailed() {
        Member memberWantedToBeInsert = null;
        Member inserted = memberService.insertMember(memberWantedToBeInsert);
        Assert.assertNull(inserted);
    }

    @Test
    public void testEditMemberSuccess() {
        String email = "oliverrsebastian@gmail.com";
        Member member = memberService.getByEmail(email);
        Member memberEdited = new Member(email, "aaa", "Oliver");
        Assert.assertNotEquals(member, memberEdited);
        member = memberService.updateMember(memberEdited);
        Assert.assertEquals(member, memberEdited);
    }

    @Test
    public void testEditMemberNotFoundFailed() {
        String email = "aaa@gmail.com";
        Member member = memberService.getByEmail(email);
        Assert.assertNull(member);
    }

    @Test
    public void testEditMemberNullFailed() {
        Member member = memberService.getByEmail("oliverrsebastian@gmail.com");
        Member memberEdited = null;
        Assert.assertNotEquals(member, memberEdited);
        member = memberService.updateMember(memberEdited);
        Assert.assertNull(member);
    }
}
