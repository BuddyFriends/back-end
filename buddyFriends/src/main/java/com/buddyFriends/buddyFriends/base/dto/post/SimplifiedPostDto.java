package com.buddyFriends.buddyFriends.base.dto.post;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplifiedPostDto {
    @Nullable
    private Long postId;
    @Nullable
    private String userId;
    @Nullable
    private String nickName;
    @Nullable
    private float smell;
    @Nullable
    private String grade;
    @Nullable
    private Integer petId;
    @Nullable
    private String petName;
    @Nullable
    private String petImage;
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
