package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoExeceptional;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaNomesmoHorario implements ValidadorDeAgendamentoDeConsultas {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if(medicoPossuiConsultaNoMesmoHorario){
            throw  new ValidacaoExeceptional("Médico ja possui outra consulta agendada nesse mesmo horário");
        }
    }

}
