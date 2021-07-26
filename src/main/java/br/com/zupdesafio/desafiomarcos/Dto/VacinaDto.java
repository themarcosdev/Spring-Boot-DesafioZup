package br.com.zupdesafio.desafiomarcos.Dto;


import br.com.zupdesafio.desafiomarcos.entidades.Usuario;
import br.com.zupdesafio.desafiomarcos.entidades.Vacina;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


public class VacinaDto {

    @NotBlank
    private String nome;

    @NotNull
    private Usuario usuario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataDaVacina;

    public String getNome() {
        return nome;
    }

    public Long getUsuario() {
        return usuario.getId();
    }

    public LocalDate getDataDaVacina() {
        return dataDaVacina;
    }

    public Vacina toModel() {
        return new Vacina(nome, usuario, dataDaVacina);
    }
}
