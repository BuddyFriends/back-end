package com.buddyFriends.buddyFriends.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Applicant")
public class ApplicantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="postid",nullable=false)
    private PostEntity postId;

    @ManyToOne
    @JoinColumn(name="userid",nullable=false)
    private UserEntity userId;
}
