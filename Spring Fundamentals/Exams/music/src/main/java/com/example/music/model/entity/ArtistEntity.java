package com.example.music.model.entity;

import com.example.music.model.entity.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArtistNameEnum name;

    @Column(name = "career_information", columnDefinition = "TEXT")
    private String careerInformation;

    public ArtistEntity() {
    }


    public ArtistNameEnum getName() {
        return name;
    }

    public ArtistEntity setName(ArtistNameEnum name) {
        this.name = name;
        return this;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }
}
