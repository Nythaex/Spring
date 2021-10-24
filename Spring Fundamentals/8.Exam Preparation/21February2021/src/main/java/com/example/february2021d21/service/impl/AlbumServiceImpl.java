package com.example.february2021d21.service.impl;

import com.example.february2021d21.model.entity.Album;
import com.example.february2021d21.model.view.AlbumView;
import com.example.february2021d21.repo.AlbumRepository;
import com.example.february2021d21.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private AlbumRepository albumRepository;
    private ModelMapper modelMapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAlbum(Album map) {
     albumRepository.save(map);
    }

    @Override
    public List<AlbumView> getAll() {
        List<Album> all = albumRepository.findAllByCopies();
        List<AlbumView> albumViewList=new ArrayList<>();

        for (Album a:all){
            AlbumView map = modelMapper.map(a, AlbumView.class);
            map.setArtist(a.getArtist().getName());
            albumViewList.add(map);
        }

        return albumViewList;
    }

    @Override
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
}
