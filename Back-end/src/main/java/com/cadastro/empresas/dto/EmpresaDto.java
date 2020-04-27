package com.cadastro.empresas.dto;

import com.cadastro.empresas.models.Empresa;

import java.io.Serializable;

public class EmpresaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cnpj;
    private String nome;
    private String razaoSocial;
    private String contato;
    private String email;
    private String logradouro;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String complemento;

    public EmpresaDto() {
    }

    public EmpresaDto(Empresa empresa) {
        this.id = empresa.getId();
        this.cnpj = empresa.getCnpj();
        this.nome= empresa.getNome();
        this.razaoSocial = empresa.getRazaoSocial();
        this.contato= empresa.getContato();
        this.email= empresa.getEmail();
        this.logradouro= empresa.getLogradouro();
        this.cep= empresa.getCep();
        this.cidade= empresa.getCidade();
        this.estado= empresa.getEstado();
        this.bairro= empresa.getBairro();
        this.complemento= empresa.getComplemento();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
