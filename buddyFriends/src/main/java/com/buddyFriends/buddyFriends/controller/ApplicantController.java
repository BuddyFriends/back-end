package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.ApplicantDto;
import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import com.buddyFriends.buddyFriends.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<ApplicantEntity>> getApplicantsByPost(@PathVariable Long postId) {
        List<ApplicantEntity> applicants = applicantService.getApplicantsByPost(postId);
        return ResponseEntity.ok(applicants);
    }

    @PostMapping("/{postId}/confirm/{userId}")
    public ResponseEntity<Void> confirmApplicant(@PathVariable Long postId, @PathVariable Long userId) {
        applicantService.confirmApplicant(postId, userId);
        return ResponseEntity.ok().build();
    }

    /*
    @PostMapping("/post/{postId}/confirm/{userId}")
    public ResponseEntity<ApplicantEntity> confirmApplicant(@PathVariable Long postId, @PathVariable Long userId) {
        ApplicantEntity confirmedApplicant = applicantService.confirmApplicant(postId, userId);
        return ResponseEntity.ok(confirmedApplicant);
    }

     */

}
