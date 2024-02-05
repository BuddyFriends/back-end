package com.buddyFriends.buddyFriends.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
public class UserEntity {


    @Id
    @Column(name="userid", nullable = false, length = 100)
    private String userId;

    @Column(name="username", nullable = false, length = 50)
    private String userName;

    @Column(name="password", nullable = false, length = 100)
    private String password;

    @Column(name="nickname", nullable = false, length = 100)
    private String nickName;

    @Column(name="address", nullable = false, length = 100)
    private String address;

    @Column(name="sex", nullable = false)
    private boolean sex;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="intro", nullable = false, length = 200)
    private String intro;

    @Column(name="chat", nullable = false, length = 500)
    private String chat;

    @Column(name="smell", nullable = false)
    private float smell;

    @Column(name="grade", nullable = false, length = 100)
    private String grade;

    @Column(name="userimage", length = 100)
    private String userImage;
}
