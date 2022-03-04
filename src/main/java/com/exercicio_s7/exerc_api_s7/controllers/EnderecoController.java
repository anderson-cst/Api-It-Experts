package com.exercicio_s7.exerc_api_s7.controllers;

import java.net.URI;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exercicio_s7.exerc_api_s7.dtos.EnderecoDto;
import com.exercicio_s7.exerc_api_s7.models.Cliente;
import com.exercicio_s7.exerc_api_s7.models.Endereco;
import com.exercicio_s7.exerc_api_s7.services.EnderecoService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	
	@PostMapping
	public ResponseEntity<Endereco> postEnderecoCliente(
			@RequestBody EnderecoDto enderecoDto, 
			@PathVariable(value= "clienteId") Cliente clienteId){
		Endereco endereco = new Endereco();
		BeanUtils.copyProperties(enderecoDto, endereco);
		enderecoService.postEnderecoCliente(endereco, clienteId);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
		
	@GetMapping
	public ResponseEntity<Page<Endereco>> getAll(Pageable pageable){
		return ResponseEntity.ok().body(enderecoService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById(@PathVariable(value = "id") Long id){
		Endereco endereco = enderecoService.findById(id);
		return ResponseEntity.ok().body(endereco);
	}	
}
