package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Bill;
import com.comp2024b.tocountornot.bean.Member;
import com.comp2024b.tocountornot.dao.BillMapper;
import com.comp2024b.tocountornot.dao.MemberMapper;
import com.comp2024b.tocountornot.exception.ForbiddenException;
import com.comp2024b.tocountornot.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberMapper memberMapper;
    private final BillMapper billMapper;

    public MemberService(MemberMapper memberMapper, BillMapper billMapper) {
        this.memberMapper = memberMapper;
        this.billMapper = billMapper;
    }

    public void insertMember(Member member) {
        memberMapper.insertMember(member);
    }

    public void deleteMember(int id, int uid) {
        if (ExistMember(id, uid)) {
            if (!ExistBill(id)) {
                memberMapper.deleteMember(id);
            } else {
                throw new ForbiddenException("cannot delete member cause there is at least a bill under it");
            }
        } else {
            throw new NotFoundException("member not found");
        }
    }

    public void updateMember(Member member, int uid) {
        if (ExistMember(member.getId(), uid)) {
            memberMapper.updateMember(member);
        } else {
            throw new NotFoundException("member not found");
        }
    }

    public Member getMemberById(int id, int uid) {
        Member member = memberMapper.getMemberById(id, uid);
        if (member != null) {
            return member;
        } else {
            throw new NotFoundException("member not found");
        }
    }

    public List<Member> getAllMember(int uid) {
        return memberMapper.getAllMember(uid);
    }

    public boolean ExistMember(int id, int uid) {
        Member member = getMemberById(id, uid);
        return member != null;
    }

    public boolean ExistBill(int id) {
        Bill bill = billMapper.getBillByMember(id);
        return bill != null;
    }
}
