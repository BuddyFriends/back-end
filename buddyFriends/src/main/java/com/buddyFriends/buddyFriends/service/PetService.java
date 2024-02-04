package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.PetDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private  final PetRepository petRepository;
    private final UserRepository userRepository;

    // 반려동물 등록
    public String addPet(PetDto petDto) {
        UserEntity user = userRepository.findById(petDto.getUserId())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + petDto.getUserId()));

        PetEntity petEntity = PetEntity.builder()
                .userId(user)
                .petName(petDto.getPetName())
                .petAge(petDto.getPetAge())
                .species(petDto.getSpecies())
                .type(petDto.getType())
                .petLike(petDto.getPetLike())
                .petDislike(petDto.getPetDislike())
                .medicine(petDto.getMedicine())
                .tag(petDto.getTag())
                .petImage(petDto.getPetImage())
                .build();

        petRepository.save(petEntity);

        return "200";
    }

    // 반려동물 조회
    public List<PetDto> getAllPetsByUserId(String userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다: " + userId));

        return petRepository.findByUserId(user)
                .stream()
                .map(PetDto::toPetDto)
                .collect(Collectors.toList());
    }


    // 반려동물 상세 조회
    public PetDto getPetByUserIdAndPetId(String userId, Integer petId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();

            Optional<PetEntity> petOptional = petRepository.findByUserIdAndPetId(user, petId);
            if (petOptional.isPresent()) {
                PetEntity pet = petOptional.get();
                return PetDto.toPetDto(pet);
            } else {
                throw new RuntimeException("해당 펫을 찾을 수 없습니다: " + petId);
            }
        } else {
            throw new RuntimeException("사용자를 찾을 수 없습니다: " + userId);
        }
    }
}
