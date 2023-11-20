package com.example.memberservice.service;

import com.example.memberservice.entity.Member;
import com.example.memberservice.feign.PostServiceFeignClient;
import com.example.memberservice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public Member create(String email, String password, String name) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        member.setName(name);
        this.memberRepository.save(member);
        return member;
    }

//    private final PostServiceFeignClient postServiceFeignClient;
//    @Autowired
//    public MemberService(PostServiceFeignClient postServiceFeignClient) {
//        this.postServiceFeignClient = postServiceFeignClient;
//    }
//
//    public void someMethod() {
//        // 사용 예시: post-service의 Tag 엔터티에 접근
//        Long tagId = 1L; // 실제 사용하려는 Tag의 ID
//        Tag tag = postServiceFeignClient.getTagById(tagId);
//        // 여기서 tag를 활용하여 원하는 작업 수행
//    }
}
