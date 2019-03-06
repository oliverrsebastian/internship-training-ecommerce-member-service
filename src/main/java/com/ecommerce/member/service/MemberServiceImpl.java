package com.ecommerce.member.service;

import com.ecommerce.member.model.Member;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private List<Member> members;

    public MemberServiceImpl() {
        this.members = setData();
    }

    private ArrayList<Member> setData() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("oliverrsebastian@gmail.com", "123", "Oliver"));
        members.add(new Member("oliver@gmail.com", "123", "ABC"));
        members.add(new Member("abc@gmail.com", "123", "DEF"));
        members.add(new Member("def@gmail.com", "123", "GHI"));
        members.add(new Member("ghi@gmail.com", "123", "OPQ"));
        return members;
    }

    @Override
    public Member getByEmail(String email) {
        if (email != null && email.endsWith("@gmail.com"))
            for (Member member : members)
                if (member.getEmail().equals(email))
                    return member;
        return null;
    }

    @Override
    public List<Member> getAll() {
        return members;
    }

    @Override
    public Member insertMember(Member member) {
        if (member != null)
            members.add(member);
        return member;
    }

    @Override
    public Member updateMember(Member member) {
        if (member != null) {
            Member actual = this.getByEmail(member.getEmail());
            if (actual != null)
                BeanUtils.copyProperties(member, actual);
            members.add(actual);
            return member;
        }
        return null;
    }

    @Override
    public Member deleteByEmail(String email) {
        if (email != null && email.endsWith("@gmail.com"))
            for (Member member : members) {
                if (member.getEmail().equals(email)) {
                    members.remove(member);
                    return member;
                }
            }
        return null;
    }
}
