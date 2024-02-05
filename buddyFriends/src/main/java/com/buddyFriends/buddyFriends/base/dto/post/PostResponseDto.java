package com.buddyFriends.buddyFriends.base.dto.post;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    @Nullable
    private Long postId;
    @Nullable
    private String userId;
    @Nullable
    private Integer petId;
    @Nullable
    private String title;
    @Nullable
    private String content;
    @Nullable
    private String periodStart;
    @Nullable
    private String periodEnd;
    @Nullable
    private String helperSex;
    @Nullable
    private boolean done;
    @Nullable
    private String pickId;
    @Nullable
    private boolean careDone;
    @Nullable
    private boolean smellDone;
}


