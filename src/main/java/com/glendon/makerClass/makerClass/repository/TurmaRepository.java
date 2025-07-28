package com.glendon.makerClass.makerClass.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.glendon.makerClass.makerClass.model.entity.Turma;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
