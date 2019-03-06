package com.ecommerce.member.service;

import com.ecommerce.member.model.Member;

import java.util.List;

public interface MemberService {
    Member getByEmail(String email);

    List<Member> getAll();

    Member insertMember(Member member);

    Member updateMember(Member member);

    Member deleteByEmail(String email);
}
