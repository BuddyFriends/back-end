package com.buddyFriends.buddyFriends.base.dto;

import com.buddyFriends.buddyFriends.entity.PostEntity;
import jakarta.annotation.Nullable;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDto {
    @Nullable
    private Long postId;

    @Nullable
    private String userId;

    @Nullable
    private boolean pick;
}
