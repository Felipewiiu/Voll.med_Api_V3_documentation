package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoExeceptional;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorDeAgendamentoDeConsultas {
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if(dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo){
            throw new ValidacaoExeceptional("Consulta não pode ser agendada por um médico ativo");
        }


    }
}
