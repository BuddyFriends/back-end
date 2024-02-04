package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.ApplicantDto;
import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import com.buddyFriends.buddyFriends.service.ApplicantService;
import jakarta.persistence.EntityNotFoundException;
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicantEntity>> getApplicantsByUser(@PathVariable Long postId) {
        try {
            List<ApplicantEntity> applicants = applicantService.getApplicantsByUser(postId);
            return ResponseEntity.ok(applicants);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
