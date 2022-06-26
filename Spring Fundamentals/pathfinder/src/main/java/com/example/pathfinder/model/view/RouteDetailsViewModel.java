package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.PictureEntity;
import com.example.pathfinder.model.entity.enums.LevelEnum;

import java.util.Set;

public class RouteDetailsViewModel {

    private String gpxCoordinates;
    private String description;
    private LevelEnum level;
    private String name;
    private Set<PictureEntity> pictures;
    private String videoUrl;

    public RouteDetailsViewModel() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteDetailsViewModel setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteDetailsViewModel setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public RouteDetailsViewModel setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteDetailsViewModel setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
