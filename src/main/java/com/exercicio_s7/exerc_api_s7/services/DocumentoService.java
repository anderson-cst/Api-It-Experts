package com.exercicio_s7.exerc_api_s7.services;

import java.io.Serializable;
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
import com.exercicio_s7.exerc_api_s7.models.Documento;
import com.exercicio_s7.exerc_api_s7.repository.ClienteRepository;
import com.exercicio_s7.exerc_api_s7.repository.DocumentoRepository;
import com.exercicio_s7.exerc_api_s7.services.exceptions.EntradaInvalidaException;
import com.exercicio_s7.exerc_api_s7.services.exceptions.NaoEncontradoException;

@Service
public class DocumentoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Documento postDocumentoCliente(Documento documento, Cliente clienteId) {
		Cliente cliente = clienteId;
		List<Documento> documentoList = new ArrayList<>();
		Optional<Cliente> clienteOpt = clienteRepository.findById(cliente.getId());
		try {
			
		documento.setClienteId(clienteOpt.get());
		documentoList.add(documento);
		clienteOpt.get().setDocumentos(documentoList);
				
		return documentoRepository.save(documento);
				
		}catch (NoSuchElementException e) {
			throw new NaoEncontradoException("Cliente não encontrado para inserir endereço!");			
		}catch (DataIntegrityViolationException e) {
			throw new EntradaInvalidaException("Insira valores válidos para entrada");
		}
	}
	
	public Page<Documento> findAll(Pageable pageable) {
		return documentoRepository.findAll(pageable);
	}
	
	public Documento findById(Long id) {
		Optional<Documento> documentoOptional = documentoRepository.findById(id);
			return documentoOptional.orElseThrow(()-> new NaoEncontradoException("Endereco não encontrado!"));
	}
}
