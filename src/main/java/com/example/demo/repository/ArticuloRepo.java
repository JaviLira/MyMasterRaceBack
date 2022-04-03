package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AbsArticulo;

@Repository
public interface ArticuloRepo extends JpaRepository<AbsArticulo, Long>{

}
