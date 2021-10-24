package com.example.thymeleafandvalidations.repos;

import com.example.thymeleafandvalidations.models.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company findByName(String name);

}
