package com.glendon.makerClass.makerClass.pli;

import lombok.Data;
import java.util.List;

@Data
public class PliResponse {

    private List<AlocacaoDetalhe> alocacoes;
    private double satisfacaoTotal;
    private String status;

    @Data
    public static class AlocacaoDetalhe {
        private Long professorId;
        private Long disciplinaId;
        private Long turmaId;
        private Long horarioId;
    }
}