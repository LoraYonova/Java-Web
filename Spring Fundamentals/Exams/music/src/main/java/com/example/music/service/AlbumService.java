package com.example.music.service;

import com.example.music.model.service.AlbumAddServiceModel;
import com.example.music.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {
    void addAlbum(AlbumAddServiceModel albumAddServiceModel);

    List<AlbumViewModel> getAllAlbumsSortedByCopiesDesc();

    void deleteById(Long id);
}
