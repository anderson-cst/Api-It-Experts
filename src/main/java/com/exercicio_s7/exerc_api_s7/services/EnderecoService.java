package com.exercicio_s7.exerc_api_s7.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exercicio_s7.exerc_api_s7.models.Cliente;
import com.exercicio_s7.exerc_api_s7.models.Endereco;
import com.exercicio_s7.exerc_api_s7.repository.ClienteRepository;
import com.exercicio_s7.exerc_api_s7.repository.EnderecoRepository;
import com.exercicio_s7.exerc_api_s7.services.exceptions.EntradaInvalidaException;
import com.exercicio_s7.exerc_api_s7.services.exceptions.NaoEncontradoException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
		
	@Transactional
	public Endereco postEnderecoCliente(Endereco endereco, Cliente clienteId) {
		Cliente cliente = clienteId;
		List<Endereco> enderecoList = new ArrayList<>();
		Optional<Cliente> clienteOpt = clienteRepository.findById(cliente.getId());
		
		try {
			
		endereco.setClienteId(clienteOpt.get());
		enderecoList.add(endereco);
		clienteOpt.get().setEnderecos(enderecoList);
				
		return enderecoRepository.save(endereco);
		
		}catch (NoSuchElementException e) {
			throw new NaoEncontradoException("Cliente não encontrado para inserir endereço!");			
		}catch (DataIntegrityViolationException e) {
			throw new EntradaInvalidaException("Insira valores válidos para entrada");
		}
	}
	
	
	public Page<Endereco> findAll(Pageable pageable) {
		return enderecoRepository.findAll(pageable);
	}
	
	
	
	public Endereco findById(Long id) {		
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
			return enderecoOptional.orElseThrow(()-> new NaoEncontradoException("Endereco não encontrado!"));
	}
}
