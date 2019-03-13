package com.ecommerce.member.service;

import com.ecommerce.member.model.Member;
import com.ecommerce.member.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member getByEmail(String email) {
        if (email != null && email.endsWith("@gmail.com")) {
            Optional<Member> optional = memberRepository.findById(email);
            return optional.orElse(null);
        }
        return null;
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member insertMember(Member member) {
        if (member != null)
            return memberRepository.save(member);
        return null;
    }

    @Override
    public Member updateMember(Member member) {
        if (member != null) {
            Member actual = this.getByEmail(member.getEmail());
            if (actual != null)
                BeanUtils.copyProperties(member, actual);
            memberRepository.save(actual);
            return member;
        }
        return null;
    }

    @Override
    public Member deleteByEmail(String email) {
        if (email != null && email.endsWith("@gmail.com")) {
            Member member = this.getByEmail(email);
            memberRepository.deleteById(email);
            return member;
        }
        return null;
    }
}
