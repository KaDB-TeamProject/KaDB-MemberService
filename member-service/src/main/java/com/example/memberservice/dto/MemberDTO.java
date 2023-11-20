package com.example.memberservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class MemberDTO {
    private int id;
    private String email;
    private String password;
    private String name;
    private String PhotoUrl;
    private String Introduction;
    private int FollowerNumber;
    private int FollowingNumber;
    private boolean Role;
    private List<FollowDTO> followers;
    private List<FollowDTO> followings;
}