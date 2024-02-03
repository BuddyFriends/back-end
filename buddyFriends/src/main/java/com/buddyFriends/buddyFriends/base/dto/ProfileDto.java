package com.buddyFriends.buddyFriends.base.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    @Nullable
    private String userId;

    @Nullable
    private String nickName;

    @Nullable
    private String address;

    @Nullable
    private boolean sex;

    @Nullable
    private Integer age;

    @Nullable
    private String intro;
}
