package com.example.music.service.impl;

import com.example.music.model.entity.AlbumEntity;
import com.example.music.model.service.AlbumAddServiceModel;
import com.example.music.model.view.AlbumViewModel;
import com.example.music.repository.AlbumRepository;
import com.example.music.service.AlbumService;
import com.example.music.service.ArtistService;
import com.example.music.service.UserService;
import com.example.music.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ArtistService artistService;
    private final UserService userService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, CurrentUser currentUser, ArtistService artistService, UserService userService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.artistService = artistService;
        this.userService = userService;
    }

    @Override
    public void addAlbum(AlbumAddServiceModel albumAddServiceModel) {
        AlbumEntity albumEntity = modelMapper.map(albumAddServiceModel, AlbumEntity.class);
        albumEntity.setAddedFrom(userService.findById(currentUser.getId()));
        albumEntity.setArtist(artistService.findByArtistNameEnum(albumAddServiceModel.getArtist()));

        albumRepository.save(albumEntity);
    }

    @Override
    public List<AlbumViewModel> getAllAlbumsSortedByCopiesDesc() {
        return albumRepository.getByOrderByCopiesDesc()
                .stream()
                .map(albumEntity -> {
                    AlbumViewModel albumViewModel = modelMapper.map(albumEntity, AlbumViewModel.class);
                    albumViewModel.setArtist(albumEntity.getArtist().getName());
                    return albumViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }


}
