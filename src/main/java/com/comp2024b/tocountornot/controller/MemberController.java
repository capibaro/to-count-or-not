package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Member;
import com.comp2024b.tocountornot.service.MemberService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @TokenRequired
    @PostMapping("member")
    public Result insertMember(@Valid @RequestBody Member member, @RequestAttribute("uid") int uid) {
        member.setUser(uid);
        memberService.insertMember(member);
        return ResultFactory.getCreatedResult(member.getId());
    }

    @TokenRequired
    @PutMapping("member/{id}")
    public Result updateMember(@PathVariable("id") int id, @Valid @RequestBody Member member, @RequestAttribute("uid") int uid) {
        member.setId(id);
        memberService.updateMember(member, uid);
        return ResultFactory.getSuccessResult(member.getId());
    }

    @TokenRequired
    @DeleteMapping("member/{id}")
    public Result deleteMember(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        memberService.deleteMember(id, uid);
        return ResultFactory.getSuccessResult(id);
    }

    @TokenRequired
    @GetMapping("member/{id}")
    public Result getMemberById(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        Member member = memberService.getMemberById(id, uid);
        return ResultFactory.getSuccessResult(member);
    }

    @TokenRequired
    @GetMapping("members")
    public Result getAllMember(@RequestAttribute("uid") int uid) {
        List<Member> members = memberService.getAllMember(uid);
        return ResultFactory.getSuccessResult(members);
    }
}
