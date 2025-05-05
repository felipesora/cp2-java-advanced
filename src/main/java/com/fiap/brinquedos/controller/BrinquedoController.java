package com.fiap.brinquedos.controller;

import com.fiap.brinquedos.model.Brinquedo;
import com.fiap.brinquedos.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService service;

    @GetMapping
    public List<Brinquedo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Brinquedo listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping
    public Brinquedo salvar(@RequestBody Brinquedo brinquedo) {
        return service.salvar(brinquedo);
    }

    @PutMapping("/{id}")
    public Brinquedo editar(@PathVariable Long id,@RequestBody Brinquedo brinquedo) {
        return service.editar(id, brinquedo);
    }
}
