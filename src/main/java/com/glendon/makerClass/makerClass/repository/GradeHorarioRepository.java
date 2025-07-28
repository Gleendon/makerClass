package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.GradeDeHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeHorarioRepository extends JpaRepository<GradeDeHorario, Long> {

}
