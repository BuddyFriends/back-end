package com.buddyFriends.buddyFriends.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplifiedPostDto {
    private Long postId;
    private String userId;
    private Integer petId;
    private String title;
    private String content;
    private String periodStart;
    private String periodEnd;
    private boolean helperSex;
    private boolean done;
    private String pickId;
    private boolean careDone;
    private boolean smellDone;
}
