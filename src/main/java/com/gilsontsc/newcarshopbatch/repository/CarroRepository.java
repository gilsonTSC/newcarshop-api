package com.gilsontsc.newcarshopbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gilsontsc.newcarshopbatch.model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long>{

}