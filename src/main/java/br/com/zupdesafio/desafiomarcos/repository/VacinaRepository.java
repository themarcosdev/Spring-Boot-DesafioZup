package br.com.zupdesafio.desafiomarcos.repository;

import br.com.zupdesafio.desafiomarcos.entidades.Usuario;
import br.com.zupdesafio.desafiomarcos.entidades.Vacina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacinaRepository extends CrudRepository<Vacina, Long> {

        @Query("Select u From Usuario u WHERE u.id = :id")
        Optional<Usuario>  buscarUsuario(Long id);
}
