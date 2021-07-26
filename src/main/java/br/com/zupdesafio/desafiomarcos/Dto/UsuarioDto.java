package br.com.zupdesafio.desafiomarcos.Dto;

import br.com.zupdesafio.desafiomarcos.entidades.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class UsuarioDto {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    //@CPF
    @NotBlank
    private String cpf;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Usuario transformarParaUsuario() {

        return new Usuario(nome, email, cpf, dataDeNascimento);
    }
}
