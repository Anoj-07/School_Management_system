package com.Spring_Boot_DataJPA.Data_JPA.repository;

import com.Spring_Boot_DataJPA.Data_JPA.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

    List<CourseMaterial> findByUrl(String url);

}
