package com.example.lab.repos;

import com.example.lab.models.entity.Brand;
import com.example.lab.models.entity.Models;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Models,Long> {
    List<Models> findAllByBrand(Brand brand);
}
