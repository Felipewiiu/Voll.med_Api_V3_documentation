package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;

public interface ValidadorDeAgendamentoDeConsultas {
    void validar(DadosAgendamentoConsulta dados);
}
