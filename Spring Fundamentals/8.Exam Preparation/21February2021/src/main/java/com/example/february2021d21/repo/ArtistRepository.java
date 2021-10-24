package com.example.february2021d21.repo;

import com.example.february2021d21.model.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    @Query("SELECT a.name FROM Artist AS a")
    List<String> findAllBy();

    Artist findByName(String name);


}
