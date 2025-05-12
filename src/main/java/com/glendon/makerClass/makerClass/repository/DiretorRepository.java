package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    // Exemplo de consulta personalizada (opcional)
    Diretor findByNome(String nome);

}
