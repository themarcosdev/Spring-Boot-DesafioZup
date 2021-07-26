package br.com.zupdesafio.desafiomarcos.controller;

import br.com.zupdesafio.desafiomarcos.Dto.VacinaDto;
import br.com.zupdesafio.desafiomarcos.entidades.Vacina;
import br.com.zupdesafio.desafiomarcos.repository.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
public class VacinaController {

    @Autowired
    private VacinaRepository vacinaRepository;

    @PostMapping("/vacina")
    public ResponseEntity<VacinaDto> cadastrarVacina(@RequestBody @Valid VacinaDto vacinaDto, UriComponentsBuilder uriBuilder) {

        Optional usuario = vacinaRepository.buscarUsuario(vacinaDto.getUsuario());

        if(usuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
        }

        Vacina vacina = vacinaDto.toModel();
        vacinaRepository.save(vacina);
        URI uri = uriBuilder.path("/vacina/{id}").buildAndExpand(vacina.getId()).toUri();
        return  ResponseEntity.created(uri).body(vacinaDto);
    }
}
