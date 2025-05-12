package com.glendon.makerClass.makerClass.model.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProfessorDto {
    private List<Long> disponibilidadeHorarioIds;
    private List<Long> preferenciaDisciplinaIds;
}

