package com.buddyFriends.buddyFriends.base.dto;

import com.buddyFriends.buddyFriends.entity.PictureEntity;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureDto {

    @Nullable
    private Integer petId;

    @Nullable
    private String pictureAdd;

//    public static PictureDto toPictureDto(PictureEntity pictureEntity) {
//        PictureDto pictureDto = new PictureDto();
//        pictureDto.setPetId(pictureEntity.getPetId());
//        pictureDto.setUserId(pictureEntity.getUserId().toString());
//        pictureDto.setPictureAdd(pictureEntity.getPictureAdd());
//        return pictureDto;
//    }

}
