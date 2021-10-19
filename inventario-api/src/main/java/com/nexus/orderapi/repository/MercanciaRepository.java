package com.nexus.orderapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.orderapi.entity.Mercancia;

@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long>{

}
