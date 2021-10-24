package com.example.february2021d21.service;

import com.example.february2021d21.model.entity.Album;
import com.example.february2021d21.model.view.AlbumView;

import java.util.List;

public interface AlbumService {
    void addAlbum(Album map);

    List<AlbumView> getAll();

    void deleteById(Long id);
}
