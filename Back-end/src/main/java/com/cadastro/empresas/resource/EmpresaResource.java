package com.cadastro.empresas.resource;

import com.cadastro.empresas.dto.EmpresaDto;
import com.cadastro.empresas.event.RecursoCriadoEvent;
import com.cadastro.empresas.models.Empresa;
import com.cadastro.empresas.services.EmpresaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaResource {

    @Autowired
    EmpresaService empresaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @CrossOrigin
    @ApiOperation(value = "Retorna uma lista de Empresas")
    @GetMapping("/listarEmpresas")
    public ResponseEntity<List<EmpresaDto>> listaEmpresa() {
        List<Empresa> empresas = empresaService.findAll();
        List<EmpresaDto> listDTO = empresas.stream().map(x -> new EmpresaDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @CrossOrigin
    @ApiOperation(value = "Retorna uma empresa unica")
    @GetMapping("/empresa/{id}")
    public ResponseEntity<EmpresaDto> listaEmpresaUnica(@PathVariable Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(new EmpresaDto(empresa));
    }

    @CrossOrigin
    @ApiOperation(value = "Salva uma empresa")
    @PostMapping("/salvaEmpresa")
    public ResponseEntity<EmpresaDto> save( @RequestBody EmpresaDto empresaDto, HttpServletResponse response) {
        Empresa empresa = empresaService.fromDTO(empresaDto);
        EmpresaDto dto = new EmpresaDto(empresaService.save(empresa));
        publisher.publishEvent(new RecursoCriadoEvent(this, response, dto.getId()));
        return ResponseEntity.ok().body(dto);
    }

    @CrossOrigin
    @ApiOperation(value = "Atualiza uma empresa")
    @PutMapping("/atualizaEmpresa/{id}")
    public ResponseEntity<EmpresaDto> update(@PathVariable Long id, @RequestBody EmpresaDto empresaDto, HttpServletResponse response) {
        Empresa empresa = empresaService.fromDTO(empresaDto);
        empresa.setId(id);
        EmpresaDto dto = new EmpresaDto(empresaService.update(empresa));
        //publisher.publishEvent(new RecursoCriadoEvent(this, response, dto.getId()));
        return ResponseEntity.ok().body(dto);
    }

    @CrossOrigin
    @ApiOperation(value = "Deleta uma empresa")
    @DeleteMapping("/deletarEmpresa/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
