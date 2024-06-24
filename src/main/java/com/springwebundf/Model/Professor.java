package com.springwebundf.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professores")
public class Professor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha",nullable = false)
    private String senha;

    @Column(name = "CPF",unique = true,nullable = false)
    private String CPF;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "professor",fetch=FetchType.LAZY) //"professor" é o dono do relacionamento com a tabela disciplinas
    private Set<Disciplina> disciplinas = new HashSet<>();

    public Professor(String nome, String senha, String CPF) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
    }

    public Professor() {

    }


    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
