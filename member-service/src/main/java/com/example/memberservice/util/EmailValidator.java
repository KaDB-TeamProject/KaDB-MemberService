package com.example.memberservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    // 이메일 정규표현식
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    // 패턴 컴파일
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValid(String email) {
        if(email == null) {
            return false;
        }
        // 문자열과 매칭
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
