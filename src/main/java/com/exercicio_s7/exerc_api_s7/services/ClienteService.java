package com.exercicio_s7.exerc_api_s7.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exercicio_s7.exerc_api_s7.models.Cliente;
import com.exercicio_s7.exerc_api_s7.repository.ClienteRepository;
import com.exercicio_s7.exerc_api_s7.services.exceptions.EntradaInvalidaException;
import com.exercicio_s7.exerc_api_s7.services.exceptions.NaoEncontradoException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@Transactional
	public Cliente post(Cliente cliente) {
		try {
			
			return clienteRepository.save(cliente);
					
		}catch (DataIntegrityViolationException e) {
			throw new EntradaInvalidaException("Insira valores válidos para entrada");
		}
	}
		
	
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
		
	
	public Cliente findById(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
			return clienteOptional.orElseThrow(()-> new NaoEncontradoException("Cliente não encontrado!"));				
	}	
}
