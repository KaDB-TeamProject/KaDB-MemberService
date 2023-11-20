package com.example.memberservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;

    @Column(name = "member_email", nullable = false, unique = true, length = 20)
    private String email;

    @Column(name = "member_password", nullable = false, length = 200)
    private String password;

    @Column(name = "name", nullable = false, length = 12)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT 'https://t1.daumcdn.net/cfile/tistory/2513B53E55DB206927'")
    private String PhotoUrl;

    @Column(columnDefinition = "DEFAULT NULL")
    private String Introduction;

    @Column(nullable = false, columnDefinition = "DEFAULT 0")
    private int FollowerNumber;

    @Column(nullable = false, columnDefinition = "DEFAULT 0")
    private int FollowingNumber;

    @Column(nullable = false, columnDefinition = "DEFAULT 1") // 0 -> 관리자, 1 -> 일반사용자
    private boolean Role;

    @OneToMany(mappedBy = "follower")
    private List<Follow> followers;

    @OneToMany(mappedBy = "following")
    private List<Follow> followings;
}