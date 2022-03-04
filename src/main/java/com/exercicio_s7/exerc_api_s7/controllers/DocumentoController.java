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

import com.exercicio_s7.exerc_api_s7.dtos.DocumentoDto;
import com.exercicio_s7.exerc_api_s7.models.Cliente;
import com.exercicio_s7.exerc_api_s7.models.Documento;
import com.exercicio_s7.exerc_api_s7.services.DocumentoService;

@RestController
@RequestMapping("/api/v1/clientes/{clienteId}/documentos")
public class DocumentoController{

	@Autowired
	private DocumentoService documentoService;
	
	@PostMapping
	public ResponseEntity<Documento> postDocumentoCliente(
			@RequestBody DocumentoDto documentoDto, 
			@PathVariable(value= "clienteId") Cliente clienteId){
		Documento documento = new Documento();
		BeanUtils.copyProperties(documentoDto, documento);
		documentoService.postDocumentoCliente(documento, clienteId);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(documento.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Documento>> getAll(Pageable pageable){
		return ResponseEntity.ok().body(documentoService.findAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Documento> getById(@PathVariable(value = "id") Long id){
		Documento documento = documentoService.findById(id);
		return ResponseEntity.ok().body(documento);
	}

}
