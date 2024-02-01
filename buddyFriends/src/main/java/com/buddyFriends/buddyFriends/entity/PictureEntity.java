package com.buddyFriends.buddyFriends.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pic")
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pictureid", nullable = false)
    private Integer pictureId;

    @ManyToOne
    private PetEntity petId;

    @ManyToOne
    private UserEntity userId;

    @Column(name="pictureadd", nullable = false, length = 500)
    private String pictureAdd;


}
