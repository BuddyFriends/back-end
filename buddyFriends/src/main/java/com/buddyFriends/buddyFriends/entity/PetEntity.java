package com.buddyFriends.buddyFriends.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="petid", nullable = false)
    private Long petId;

    @ManyToOne
    @JoinColumn(name="userId", nullable = false)
    private UserEntity userId;

    @Column(name="petname", nullable = false, length = 50)
    private String petName;

    @Column(name="petage", nullable = false)
    private Integer petAge;

    @Column(name="species", nullable = false, length = 100)
    private String species;

    @Column(name="type", nullable = false, length = 100)
    private String type;

    @Column(name="petlike", nullable = false, length = 100)
    private String petLike;

    @Column(name="petdislike", nullable = false, length = 100)
    private String petDislike;

    @Column(name="medicine", nullable = false, length = 100)
    private String medicine;

    @Column(name="tag", nullable = false, length = 100)
    private String tag;

    @Column(name="petimage", nullable = false, length = 100)
    private String petImage;
}
