package com.buddyFriends.buddyFriends.base.dto;

import com.buddyFriends.buddyFriends.entity.PostEntity;
import jakarta.annotation.Nullable;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @Nullable
    private Long postId;

    @Nullable
    private String title;

    @Nullable
    private String content;

    @Nullable
    private String userId;

    @Nullable
    private Integer petId;

    @Nullable
    private LocalDateTime periodStart;

    @Nullable
    private LocalDateTime periodEnd;

    @Nullable
    private boolean helperSex;

    @Nullable
    private boolean done;

    @Nullable
    private Long pickId;

    @Nullable
    private boolean careDone;

}
