package br.com.ada.adaflix.service;

import br.com.ada.adaflix.model.Empresa;
import br.com.ada.adaflix.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa salvar(Empresa empresa) {
        // Implementa regras de validações, etc...
        return empresaRepository.save(empresa);
    }
}
