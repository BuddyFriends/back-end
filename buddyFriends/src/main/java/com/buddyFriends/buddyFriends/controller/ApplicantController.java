package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.applicant.ApplicantDto;
import com.buddyFriends.buddyFriends.base.dto.applicant.ApplicantResponseDto;
import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    @PostMapping("/apply")
    public String apply(@RequestBody ApplicantDto applicantDto) {
        String res = applicantService.apply(applicantDto);

        return res;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ApplicantResponseDto>> getApplicantsByPostId(@RequestParam("postId") Long postId) {
        List<ApplicantEntity> applicants = applicantService.getApplicantsByPostId(postId);
        List<ApplicantResponseDto> responseDtos = applicants.stream().map(applicant -> {
            ApplicantResponseDto dto = new ApplicantResponseDto();
            dto.setId(applicant.getId());
            dto.setPostId(applicant.getPostId().getPostId());
            dto.setUserId(applicant.getUserId().getUserId());
            dto.setNickName(applicant.getUserId().getNickName());
            dto.setSex(applicant.getUserId().isSex());
            dto.setAge(applicant.getUserId().getAge());
            dto.setAddress(applicant.getUserId().getAddress());
            dto.setSmell(applicant.getUserId().getSmell());
            dto.setGrade(applicant.getUserId().getGrade());
            dto.setIntro(applicant.getUserId().getIntro());
            dto.setUserImage(applicant.getUserId().getUserImage());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(responseDtos);
    }


}
