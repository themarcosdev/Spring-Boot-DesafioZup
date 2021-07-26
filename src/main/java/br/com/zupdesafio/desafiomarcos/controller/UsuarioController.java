package br.com.zupdesafio.desafiomarcos.controller;

import br.com.zupdesafio.desafiomarcos.Dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zupdesafio.desafiomarcos.entidades.Usuario;
import br.com.zupdesafio.desafiomarcos.repository.UsuarioRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Locale;

@RestController

public class UsuarioController{

	@Autowired
	private UsuarioRepository usuarioRepository;

@PostMapping("/usuario")
 public ResponseEntity<UsuarioDto> cadastarUsuario (@RequestBody @Valid UsuarioDto usuarioDto, UriComponentsBuilder uriBuilder){

	if(usuarioRepository.existsByEmail(usuarioDto.getEmail().toLowerCase(Locale.ROOT)) || usuarioRepository.existsByCpf(usuarioDto.getCpf())){
		throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}

	Usuario usuario = usuarioDto.transformarParaUsuario();
	usuarioRepository.save(usuario);
	URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(usuario.getId()).toUri();
	return ResponseEntity.created(uri).body(usuarioDto);
}






}
