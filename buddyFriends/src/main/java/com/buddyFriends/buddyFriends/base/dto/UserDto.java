package com.buddyFriends.buddyFriends.base.dto;

import com.buddyFriends.buddyFriends.entity.UserEntity;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Nullable
    private String userId;

    @Nullable
    private String userName;

    @Nullable
    private String password;

    @Nullable
    private String nickName;

    @Nullable
    private String address;

    @Nullable
    private boolean sex;

    @Nullable
    private Integer age;

    @Nullable
    private String intro;

    @Nullable
    private String chat;

//    @Nullable
//    private Integer smell;

    @Nullable
    private String grade;

/*
    public static UserDto toUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setUserName(userEntity.getPassword());
        userDto.setNickName(userEntity.getNickName());
        userDto.setAddress(userEntity.getNickName());
        userDto.setSex(userEntity.isSex());
        userDto.setAge(userEntity.getAge());
        userDto.setIntro(userEntity.getIntro());
        userDto.setChat(userEntity.getChat());
        userDto.setSmell(userEntity.getSmell());
        userDto.setGrade(userEntity.getGrade());
        return userDto;
    }
    */
}
