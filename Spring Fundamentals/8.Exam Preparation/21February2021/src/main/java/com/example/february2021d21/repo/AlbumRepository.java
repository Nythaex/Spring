package com.example.february2021d21.repo;

import com.example.february2021d21.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    @Query("select a FROM Album as a ORDER BY a.copies desc")
    List<Album> findAllByCopies();
}
