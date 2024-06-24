package com.springwebundf.Dtos;

import com.springwebundf.Model.Professor;

public class ProfessorDTO {

    private Long id;
    private String nome;
    private String senha;
    private String CPF;

    public ProfessorDTO(String nome, String senha, String CPF) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
    }

    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.senha = professor.getSenha();
        this.CPF = professor.getCPF();
    }
}
