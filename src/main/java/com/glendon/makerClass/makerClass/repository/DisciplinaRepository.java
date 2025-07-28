package com.glendon.makerClass.makerClass.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.glendon.makerClass.makerClass.model.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
