package com.buddyFriends.buddyFriends.base.dto;

import com.buddyFriends.buddyFriends.entity.PetEntity;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    @Nullable
    private Long petId;

    @Nullable
    private String userId;

    @Nullable
    private String petName;

    @Nullable
    private Integer petAge;

    @Nullable
    private String species;

    @Nullable
    private String type;

    @Nullable
    private String petLike;

    @Nullable
    private String petDislike;

    @Nullable
    private String medicine;

    @Nullable
    private String tag;

    @Nullable
    private String petImage;

    public static PetDto toPetDto(PetEntity petEntity) {
        PetDto petDto = new PetDto();
        petDto.setPetId(petEntity.getPetId());
        petDto.setUserId(petEntity.getUserId().getUserId());
        petDto.setPetName(petEntity.getPetName());
        petDto.setPetAge(petEntity.getPetAge());
        petDto.setSpecies(petEntity.getSpecies());
        petDto.setType(petEntity.getType());
        petDto.setPetLike(petEntity.getPetLike());
        petDto.setPetDislike(petEntity.getPetDislike());
        petDto.setMedicine(petEntity.getMedicine());
        petDto.setTag(petEntity.getTag());
        petDto.setPetImage(petEntity.getPetImage());
        return petDto;
    }

}
