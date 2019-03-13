package com.ecommerce.member;

import com.ecommerce.member.model.Member;
import com.ecommerce.member.repository.MemberRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    private String email;

    @Before
    public void setUp() throws Exception {
        Member member = new Member();
        member.setEmail("abc@gmail.com");
        member.setName("Member 1");
        member.setPassword("abc");
        member = memberRepository.save(member);
        email = member.getEmail();
    }

    @Test
    public void testRepositoryInsertSuccess() {
        Member member = new Member();
        member.setEmail("oliversebastian@gmail.com");
        member.setName("Member 2");
        member.setPassword("bbb");
        member = memberRepository.save(member);
        Assert.assertNotNull(member);
        Assert.assertNotNull(member.getEmail());
    }

    @Test
    public void testRepositoryGetByIdSuccess() {
        Optional<Member> member = memberRepository.findById(email);
        Assert.assertTrue(member.isPresent());
        Assert.assertNotNull(member.get());
    }

    @Test
    public void testRepositoryGetAllSuccess() {
        List<Member> members = memberRepository.findAll();
        Assert.assertEquals(1, members.size());
    }

    @Test
    public void testRepositoryEditSuccess() {
        Member member = new Member();
        member.setName("Product 30");
        member.setEmail(email);
        member.setPassword("abcccc");

        Optional<Member> foundById = memberRepository.findById(email);
        Assert.assertTrue(foundById.isPresent());
        Assert.assertNotEquals(member, foundById.get());
        member = memberRepository.save(member);
        foundById = memberRepository.findById(email);
        Assert.assertTrue(foundById.isPresent());
        Assert.assertEquals(member, foundById.get());
    }

    @Test
    public void testRepositoryDeleteByIdSuccess() {
        memberRepository.deleteById(email);
        Optional<Member> optional = memberRepository.findById(email);
        Assert.assertFalse(optional.isPresent());
    }

    @After
    public void tearDown() throws Exception {
        memberRepository.deleteAll();
    }
}
