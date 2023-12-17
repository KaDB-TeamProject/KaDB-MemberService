package com.example.memberservice.controller;

import com.example.memberservice.repository.MemberRepository;
import com.example.memberservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/members")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

//    @PostMapping("/api/members/followers/follow")
//    public ResponseEntity<String> follow()

}
