package com.buddyFriends.buddyFriends.base.dto.post;

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
    private float smell;
    private String grade;
    private Integer petId;
    private String petName;
    private String petImage;
    private String title;
    private String content;
    private String periodStart;
    private String periodEnd;
    private String helperSex;
    private boolean done;
    private String pickId;
    private boolean careDone;
    private boolean smellDone;
}
