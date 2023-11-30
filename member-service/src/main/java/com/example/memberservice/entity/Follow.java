package com.example.memberservice.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Table(
        name = "follow",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_follower_following",
                        columnNames = {"follower_id", "following_id"}
                ) // 두 키의 조합이 유니크 하도록 설정
        }
)
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id")
    private int no;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private Member follower;

    @ManyToOne
    @JoinColumn(name = "following_id", nullable = false)
    private Member following;
}
