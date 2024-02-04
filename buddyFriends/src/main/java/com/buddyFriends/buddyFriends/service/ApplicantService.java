package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.entity.ApplicantEntity;
import com.buddyFriends.buddyFriends.repository.ApplicantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Transactional(readOnly = true)
    public List<ApplicantEntity> getApplicantsByPost(Long postId) {
        return applicantRepository.findByPostId(postId);
    }

    @Transactional
    public void confirmApplicant(Long postId, Long userId) {
        List<ApplicantEntity> applicants = applicantRepository.findByPostId(postId);

        applicants.forEach(applicant -> {
            applicant.setPick(false);
            applicantRepository.save(applicant);
        });

        ApplicantEntity confirmedApplicant = applicantRepository.findByPostIdAndUserId(postId, userId)
                .orElseThrow(() -> new EntityNotFoundException("해당 게시글과 사용자 ID에 대한 신청자가 없습니다."));

        confirmedApplicant.setPick(true);
        applicantRepository.save(confirmedApplicant);
    }

    /*
    @Transactional
    public ApplicantEntity confirmApplicant(Long postId, Long userId) {

    }
    */
}

