package com.cadastro.empresas.services;

import com.cadastro.empresas.dto.EmpresaDto;
import com.cadastro.empresas.models.Empresa;

import java.util.List;

public interface EmpresaService {
    List<Empresa> findAll();

    Empresa findById(Long id);

    Empresa save(Empresa empresa);

    void delete(Long id) throws Exception;

    Empresa fromDTO(EmpresaDto empresaDto);

    Empresa update(Empresa empresa);
}
