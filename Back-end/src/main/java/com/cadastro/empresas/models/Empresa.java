package com.cadastro.empresas.models;

import com.cadastro.empresas.dto.EmpresaDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_EMPRESA")
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    public Empresa() {
    }

    public Empresa(EmpresaDto dto) {
        this.id = dto.getId();
        this.cnpj = dto.getCnpj();
        this.nome = dto.getNome();
        this.razaoSocial = dto.getRazaoSocial();
        this.contato = dto.getContato();
        this.email = dto.getEmail();
        this.logradouro = dto.getLogradouro();
        this.cep = dto.getCep();
        this.cidade = dto.getCidade();
        this.estado = dto.getEstado();
        this.bairro = dto.getBairro();
        this.complemento = dto.getComplemento();
    }


    public Empresa(Long id, String cnpj, String nome, String razaoSocial, String contato, String email, String logradouro, String cep, String cidade, String estado, String bairro, String complemento) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.contato = contato;
        this.email = email;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.complemento = complemento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(cnpj, empresa.cnpj) &&
                Objects.equals(nome, empresa.nome) &&
                Objects.equals(razaoSocial, empresa.razaoSocial) &&
                Objects.equals(contato, empresa.contato) &&
                Objects.equals(email, empresa.email) &&
                Objects.equals(logradouro, empresa.logradouro) &&
                Objects.equals(cep, empresa.cep) &&
                Objects.equals(cidade, empresa.cidade) &&
                Objects.equals(estado, empresa.estado) &&
                Objects.equals(bairro, empresa.bairro) &&
                Objects.equals(complemento, empresa.complemento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, nome, razaoSocial, contato, email, logradouro, cep, cidade, estado, bairro, complemento);
    }
}
