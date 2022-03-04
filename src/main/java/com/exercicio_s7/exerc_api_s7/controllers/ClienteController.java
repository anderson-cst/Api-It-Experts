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

import com.exercicio_s7.exerc_api_s7.dtos.ClienteDto;
import com.exercicio_s7.exerc_api_s7.models.Cliente;
import com.exercicio_s7.exerc_api_s7.services.ClienteService;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	
	@PostMapping
	public ResponseEntity<Cliente> postCliente(@RequestBody ClienteDto clienteDto){
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(clienteDto, cliente);
		clienteService.post(cliente);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(location).build();				
	}
		
	@GetMapping
	public ResponseEntity<Page<Cliente>> getAll(Pageable pageable){
		return ResponseEntity.ok().body(clienteService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable(value = "id") Long id){
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
}
