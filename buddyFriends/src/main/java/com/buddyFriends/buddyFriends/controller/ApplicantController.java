package com.buddyFriends.buddyFriends.controller;

import com.buddyFriends.buddyFriends.base.dto.ApplicantDto;
import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import com.buddyFriends.buddyFriends.service.ApplicantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

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
    public List<ApplicantEntity> getApplicantsByUser(@RequestParam("postId") Long postId) {

        List<ApplicantEntity> list = applicantService.getApplicantsList(postId);

        return list;
    }

}
