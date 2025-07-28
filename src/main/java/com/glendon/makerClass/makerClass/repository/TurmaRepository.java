package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}