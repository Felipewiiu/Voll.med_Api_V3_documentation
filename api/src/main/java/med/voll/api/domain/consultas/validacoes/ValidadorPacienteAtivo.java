package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoExeceptional;
import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorDeAgendamentoDeConsultas{
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findByAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo){
            throw new ValidacaoExeceptional("A consulta não pode ser agendada por um paciente excluído");
        }
    }
}
