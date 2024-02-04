package com.buddyFriends.buddyFriends.base.dto.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantResponseDto {
    private Long id;
    private Long postId;
    private String userId;
    private String nickName;
    private boolean sex;
    private Integer age;
    private String address;
    private Float smell;
    private String grade;
    private String intro;
}