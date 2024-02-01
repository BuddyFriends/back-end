package com.buddyFriends.buddyFriends.service;

import com.buddyFriends.buddyFriends.base.dto.PictureDto;
import com.buddyFriends.buddyFriends.entity.PetEntity;
import com.buddyFriends.buddyFriends.entity.PictureEntity;
import com.buddyFriends.buddyFriends.entity.UserEntity;
import com.buddyFriends.buddyFriends.repository.PetRepository;
import com.buddyFriends.buddyFriends.repository.PictureRepository;
import com.buddyFriends.buddyFriends.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PictureService {

    private final UserRepository userRepository;
    private final PetRepository petRepository;
    private final PictureRepository pictureRepository;


    public String addPicture(PictureDto pictureDto){

        Optional<UserEntity> findUser = userRepository.findByUserId(pictureDto.getUserId());
        Optional<PetEntity> findPet = petRepository.findByPetId(pictureDto.getPetId());

        PictureEntity picture = PictureEntity.builder()
                .petId(findPet.get())
                .userId(findUser.get())
                .pictureAdd(pictureDto.getPictureAdd())
                .build();

         pictureRepository.save(picture);

        return "200";
    }

    public List<PictureEntity> pictureList(Integer petId) {

        Optional<PetEntity> findPet = petRepository.findByPetId(petId);

        List<PictureEntity> list = pictureRepository.findByPetId(findPet.get());

        return list;
    }

}
