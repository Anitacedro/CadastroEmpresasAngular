package com.cadastro.empresas.services;

import com.cadastro.empresas.dto.EmpresaDto;
import com.cadastro.empresas.models.Empresa;
import com.cadastro.empresas.repository.EmpresaRepository;
import com.cadastro.empresas.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa findById(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrada!"));
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Optional<Empresa> retorno = this.empresaRepository.findById(id);

        if (!retorno.isPresent()) {
            throw new Exception("Empresa não existe no banco de dados com o id: " + id);
        }
        empresaRepository.deleteById(id);
    }

    @Override
    public Empresa fromDTO(EmpresaDto empresaDto) {
        return new Empresa(empresaDto);
    }

    @Transactional
    @Override
    public Empresa update(Empresa empresa) {
        Optional<Empresa> updateEmpresa = empresaRepository.findById(empresa.getId());
        return updateEmpresa.map(u -> empresaRepository.save(new Empresa(u.getId(), empresa.getCnpj(), empresa.getNome(), empresa.getRazaoSocial(),
                empresa.getContato(), empresa.getEmail(), empresa.getLogradouro(), empresa.getCep(),empresa.getCidade(), empresa.getEstado(), empresa.getBairro(), empresa.getComplemento())))
                .orElseThrow(() -> new ObjectNotFoundException("Empresa não encontrada."));
    }

}
