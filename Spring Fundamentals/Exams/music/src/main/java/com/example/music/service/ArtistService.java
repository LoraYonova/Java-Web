package com.example.music.service;

import com.example.music.model.entity.ArtistEntity;
import com.example.music.model.entity.enums.ArtistNameEnum;

public interface ArtistService {
    void initializeArtists();

    ArtistEntity findByArtistNameEnum(ArtistNameEnum artist);
}
