package med.voll.api.domain.consultas;

import med.voll.api.domain.ValidacaoExeceptional;
import med.voll.api.domain.consultas.validacoes.ValidadorDeAgendamentoDeConsultas;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorDeAgendamentoDeConsultas> validadores;
    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados){

        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoExeceptional("Id do paciente informado não existe");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoExeceptional("Id do médico informado não existe");
        }

        validadores.forEach(v -> v.validar(dados)); // essa linha chama todos os validadores criados de uma única vez

        var paciente = pacienteRepository.findById(dados.idPaciente()).get();//Se um valor estiver presente, retorna o valor, caso contrário, lança NoSuchElementException.
        var medico = escolherMedico(dados);

        if(medico == null){
            throw new ValidacaoExeceptional("Não existe médico disponível nesta data");
        }
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoExeceptional("Especialidade obrigatória quando um médico não foi escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidacaoExeceptional("O ID da consulta informado não existe");
        }

        var consulta = consultaRepository.getReferenceById(dados.idConsulta());

        consulta.cancelar(dados.motivoCancelamento());
    }
}
