package com.example.memberservice.entity;

import com.example.memberservice.dto.MemberTagDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Table(name = "member_tag")
public class MemberTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_tag_id")
    private int no;

    @Column(name = "tag_id")
    private int tagId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
