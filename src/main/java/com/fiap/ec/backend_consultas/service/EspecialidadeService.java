package com.fiap.ec.backend_consultas.service;
import com.fiap.ec.backend_consultas.model.Especialidade;
import com.fiap.ec.backend_consultas.repository.EspecialidadeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EspecialidadeService {
    private final EspecialidadeRepository repository;
    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }
    public Especialidade salvar(Especialidade especialidade) {
        return repository.save(especialidade);
    }
    public List<Especialidade> listar() {
        return repository.findAll();
    }
    public Especialidade buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
    }
    public Especialidade atualizar(Long id, Especialidade especialidadeAtualizada) {
        Especialidade especialidade = buscarPorId(id);
        especialidade.setNome(especialidadeAtualizada.getNome());
        especialidade.setDescricao(especialidadeAtualizada.getDescricao());
        return repository.save(especialidade);
    }
    public void deletar(Long id) {
        Especialidade especialidade = buscarPorId(id);
        repository.delete(especialidade);
    }
}