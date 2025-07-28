package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
