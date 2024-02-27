package med.voll.api.domain.consultas;

import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    public void agendar(DadosAgendamentoConsulta dados){
        var paciente = pacienteRepository.findById(dados.idPaciente()).get();//Se um valor estiver presente, retorna o valor, caso contrário, lança NoSuchElementException.
        var medico = medicoRepository.findById(dados.idMedico()).get();

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }
}
