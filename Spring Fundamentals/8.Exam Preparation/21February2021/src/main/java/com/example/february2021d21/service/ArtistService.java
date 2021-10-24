package com.example.february2021d21.service;

import com.example.february2021d21.model.entity.Artist;

import java.util.List;

public interface ArtistService {
    void init();

    List<String> getAll();

    Artist getByName(String artist);
}
