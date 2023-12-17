package com.example.memberservice.service;

import com.example.memberservice.entity.Follow;
import com.example.memberservice.entity.Member;
import com.example.memberservice.exception.MemberException;
import com.example.memberservice.exception.MemberExceptionType;
//import com.example.memberservice.feign.PostServiceFeignClient;
import com.example.memberservice.repository.MemberRepository;
import com.example.memberservice.util.EmailValidator;
import com.example.memberservice.util.PasswordValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class MemberService {

    // 로그 찍기용
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    public Member create(String email, String password, String name) {
        Member member = new Member();

        // 입력 정보의 유효성 검사
        validateUserData(email, password, name);

        // 중복 사용자 검증
        if (memberRepository.existsByEmail(email)) {
            log.debug("Email duplication");
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_EMAIL);
        }
        if (memberRepository.existsByUsername(name)) {
            log.debug("Name duplication");
            throw new MemberException(MemberExceptionType.ALREADY_EXIST_USERNAME);
        }

        member.setEmail(email);
        member.setPassword(passwordEncoder.encode(password));
        member.setName(name);
        this.memberRepository.save(member);
        return member;
    }

    private void validateUserData(String email, String password, String name) {
        // 필수로 있는 필드 검증
        if(ObjectUtils.isEmpty(email)) {
            log.debug("Email empty");
            throw new MemberException(MemberExceptionType.NOT_HAS_EMAIL);
        }
        if(ObjectUtils.isEmpty(password)) {
            log.debug("Password empty");
            throw new MemberException(MemberExceptionType.NOT_HAS_PASSWORD);
        }
        if(ObjectUtils.isEmpty(name)) {
            log.debug("Name empty");
            throw new MemberException(MemberExceptionType.NOT_HAS_NAME);
        }

        // 이메일 및 비밀번호 형식 검증
        if(!EmailValidator.isValid(email)) {
            throw new MemberException(MemberExceptionType.FORMAT_WRONG_EMAIL);
        }
        if(!PasswordValidator.isValid(password)) {
            throw new MemberException(MemberExceptionType.FORMAT_WRONG_PASSWORD);
        }
    }

    // 로그인

    // 팔로우 신청
    @Transactional
    public void saveFollow(Long toMemberId, Long fromMemberId) {
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
