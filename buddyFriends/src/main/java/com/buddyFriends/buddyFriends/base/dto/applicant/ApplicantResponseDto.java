package com.buddyFriends.buddyFriends.base.dto.applicant;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantResponseDto {
    @Nullable
    private Long id;
    @Nullable
    private Long postId;
    @Nullable
    private String userId;
    @Nullable
    private String nickName;
    @Nullable
    private boolean sex;
    @Nullable
    private Integer age;
    @Nullable
    private String address;
    @Nullable
    private Float smell;
    @Nullable
    private String grade;
    @Nullable
    private String intro;
}