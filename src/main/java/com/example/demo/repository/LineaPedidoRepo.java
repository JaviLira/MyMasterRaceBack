package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LineaPedido;

@Repository
public interface LineaPedidoRepo extends JpaRepository<LineaPedido, Long>{

}
