package br.com.ada.adaflix.controller;

import br.com.ada.adaflix.model.Empresa;
import br.com.ada.adaflix.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    public Empresa salvar(@RequestBody Empresa empresa) {
        Empresa empresaSalva = null;

        try {
             empresaSalva = empresaService.salvar(empresa);
        } catch (IllegalArgumentException exception) {
            System.out.println("CNPJ Já existe!");
        }

        return empresaSalva;
    }

    @GetMapping
    public List<Empresa> buscar() {
        return empresaService.buscar();
    }

    @GetMapping("/{id}")
    public Empresa buscaPorId(@PathVariable Long id) {
        return null;
    }
}
