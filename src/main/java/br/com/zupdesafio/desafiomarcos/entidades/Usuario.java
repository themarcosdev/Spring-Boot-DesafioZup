
package br.com.zupdesafio.desafiomarcos.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Locale;

import javax.persistence.*;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nome;

 @Column(unique = true)
 private String email;

 @Column(unique = true)
 private String cpf;

 @JsonFormat(pattern = "dd/MM/yyyy")
 private LocalDate dataDeNascimento;

 	@Deprecated
 	public Usuario() {
	}


	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String nome, String email, String cpf, LocalDate dataDeNascimento) {
		this.nome = nome;
		this.email = email.toLowerCase(Locale.ROOT);
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}

	public Long getId() {
	return id;
}
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

 
}
