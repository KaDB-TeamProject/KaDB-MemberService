package com.example.memberservice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    // 비밀번호 정규 표현식 (최소 8자 이상, 최소한 하나의 소문자 포함, 최소한 하나의 숫자 포함) -> 특수t문자 포함하려면 중간에 <(?=.*[@#$%^&+=])> 추가
    private static final String PASSWORD_PATTERN = "^(?=,*[a-z])(?=.*\\d).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValid(String password) {
        if(password == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
