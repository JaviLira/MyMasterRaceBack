package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Opiniones;

@Repository
public interface OpinionesRepo extends JpaRepository<Opiniones, Long>{

}
