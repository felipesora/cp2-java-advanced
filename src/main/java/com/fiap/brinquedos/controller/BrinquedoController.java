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
}
