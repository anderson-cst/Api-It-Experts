package com.exercicio_s7.exerc_api_s7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercicio_s7.exerc_api_s7.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
