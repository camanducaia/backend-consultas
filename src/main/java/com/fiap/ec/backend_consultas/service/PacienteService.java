package com.fiap.ec.backend_consultas.service;
import com.fiap.ec.backend_consultas.model.Paciente;
import com.fiap.ec.backend_consultas.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PacienteService {
    private final PacienteRepository repository;
    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }
    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }
    public List<Paciente> listar() {
        return repository.findAll();
    }
    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
    public Paciente atualizar(Long id, Paciente pacienteAtualizado) {
        Paciente paciente = buscarPorId(id);
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
        paciente.setAtivo(pacienteAtualizado.getAtivo());
        return repository.save(paciente);
    }
    public void deletar(Long id) {
        Paciente paciente = buscarPorId(id);
        repository.delete(paciente);
    }
}
