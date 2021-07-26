package br.com.zupdesafio.desafiomarcos.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Usuario usuario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDaVacina;

    public Vacina(String nome, Usuario usuario, LocalDate dataDaVacina) {
        this.nome = nome;
        this.usuario = usuario;
        this.dataDaVacina = dataDaVacina;
    }

    public Long getId() {
        return id;
    }
}
