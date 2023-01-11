package br.com.ada.adaflix.service;

import br.com.ada.adaflix.dto.EmpresaRequestDTO;
import br.com.ada.adaflix.dto.EnderecoViaCepDTO;
import br.com.ada.adaflix.model.Empresa;
import br.com.ada.adaflix.model.Endereco;
import br.com.ada.adaflix.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final ViaCepService viaCepService;

    public EmpresaService(EmpresaRepository empresaRepository, ViaCepService viaCepService) {
        this.empresaRepository = empresaRepository;
        this.viaCepService = viaCepService;
    }

    public Empresa salvar(EmpresaRequestDTO empresaDTO) {
        // Implementa regras de validações, etc...

        // Empresa tem o CNPJ 123456789
        // Empresa B tem o CNPJ 123456789
        Empresa empresaEncontrada = empresaRepository.findByCnpj(empresaDTO.getCnpj());
        if (empresaEncontrada != null) { // EMPRESA EXISTE
            throw new IllegalArgumentException();
        }

        // Consultar CEP...
        // GET
        EnderecoViaCepDTO endereco = viaCepService.getEndereco(empresaDTO.getEndereco().getCep());

        Endereco enderecoAtualizado = new Endereco();
        enderecoAtualizado.setLogradouro(endereco.getLogradouro());
        enderecoAtualizado.setCep(endereco.getCep());
        enderecoAtualizado.setCidade(endereco.getLocalidade());
        enderecoAtualizado.setEstado(endereco.getUf());
        enderecoAtualizado.setNumero(empresaDTO.getEndereco().getNumero());

        // empresa.setEndereco(enderecoAtualizado);
        Empresa empresa = new Empresa();
        empresa.setNome(empresaDTO.getNome());
        empresa.setEndereco(enderecoAtualizado);
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setEmail(empresaDTO.getEmail());
        empresa.setTelefone(empresaDTO.getTelefone());

        return empresaRepository.save(empresa);
    }

    public List<Empresa> buscar() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    public EnderecoViaCepDTO buscarEndereco(String cep) {
        return viaCepService.getEndereco(cep);
    }
}
