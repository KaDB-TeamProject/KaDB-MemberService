package com.example.memberservice.dto;

import lombok.Data;

@Data
public class MemberTagDTO {
    private int id;
    private int tagId;
    private int memberId;
}
