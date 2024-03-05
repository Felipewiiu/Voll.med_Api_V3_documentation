package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoExeceptional;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioAntedecencia implements ValidadorDeAgendamentoDeConsultas {
    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencasEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencasEmMinutos < 30){
            throw new ValidacaoExeceptional("A consulta deve ser agendada com antecedencia mínima de 30 minutis");
        }
    }
}
