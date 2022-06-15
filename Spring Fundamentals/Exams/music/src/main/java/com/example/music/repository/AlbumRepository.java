package com.example.music.repository;

import com.example.music.model.entity.AlbumEntity;
import com.example.music.model.entity.enums.GenreEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
   GenreEnum findByGenre(GenreEnum genre);

   List<AlbumEntity> getByOrderByCopiesDesc();
}
