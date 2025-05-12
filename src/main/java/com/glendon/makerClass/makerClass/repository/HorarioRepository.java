package com.glendon.makerClass.makerClass.repository;

import com.glendon.makerClass.makerClass.model.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
