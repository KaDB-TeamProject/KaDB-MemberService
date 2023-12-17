package com.example.memberservice.exception;

import org.springframework.http.HttpStatus;

public enum MemberExceptionType implements BaseExceptionType{
    // 회원가입, 로그인시
    NOT_HAS_EMAIL(600, HttpStatus.OK, "이메일란이 비어있습니다."),
    NOT_HAS_PASSWORD(601, HttpStatus.OK, "비밀번호란이 비어있습니다."),
    NOT_HAS_NAME(602, HttpStatus.OK, "이름란이 비어있습니다."),
    ALREADY_EXIST_EMAIL(603, HttpStatus.OK, "이미 존재하는 이메일입니다."),
    ALREADY_EXIST_USERNAME(604, HttpStatus.OK, "이미 존재하는 아이디입니다."),
    FORMAT_WRONG_EMAIL(605, HttpStatus.OK, "이메일 형식이 맞지 않습니다."),
    FORMAT_WRONG_PASSWORD(606, HttpStatus.OK, "비밀번호 형식이 맞지 않습니다."),
    WRONG_PASSWORD(607, HttpStatus.OK, "비밀번호가 잘못되었습니다."),
    NOT_FOUND_MEMBER(608, HttpStatus.OK, "회원 정보가 없습니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    MemberExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
