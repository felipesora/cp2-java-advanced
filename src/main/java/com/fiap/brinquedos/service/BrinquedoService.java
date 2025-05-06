package com.fiap.brinquedos.service;

import com.fiap.brinquedos.exception.BrinquedoNaoEncontradoException;
import com.fiap.brinquedos.model.Brinquedo;
import com.fiap.brinquedos.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository repository;

    public List<Brinquedo> listarTodos() {
        return repository.findAll();
    }

    public Brinquedo listarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new BrinquedoNaoEncontradoException("Brinquedo com ID " + id + " não encontrado."));
    }

    public Brinquedo salvar(Brinquedo brinquedo) {
        return repository.save(brinquedo);
    }

    public Brinquedo editar(Long id, Brinquedo brinquedo) {
        if (repository.existsById(id)) {
            brinquedo.setId(id);
            return repository.save(brinquedo);
        }
        throw new BrinquedoNaoEncontradoException("Brinquedo com ID " + id + " não encontrado para edição.");
    }

    public String deletar(Long id) {
            if (repository.existsById(id)){
                repository.deleteById(id);
                return "Brinquedo removido com sucesso!";
            }
            return "Brinquedo não encontrado.";
    }
}
