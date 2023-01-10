package br.com.ada.adaflix.service;

import br.com.ada.adaflix.model.Empresa;
import br.com.ada.adaflix.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa salvar(Empresa empresa) {
        // Implementa regras de validações, etc...

        // Empresa tem o CNPJ 123456789
        // Empresa B tem o CNPJ 123456789
        Empresa empresaEncontrada = empresaRepository.findByCnpj(empresa.getCnpj());
        if (empresaEncontrada != null) { // EMPRESA EXISTE
            throw new IllegalArgumentException();
        }

        return empresaRepository.save(empresa);
    }

    public List<Empresa> buscar() {
        return (List<Empresa>) empresaRepository.findAll();
    }
}
