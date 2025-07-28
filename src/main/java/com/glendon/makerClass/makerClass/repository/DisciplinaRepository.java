package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}