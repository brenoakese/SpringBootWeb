package com.springwebundf.Dtos;

import com.springwebundf.Model.Aluno;

public class AlunoDTO {

    private Long Id;
    private String matricula;
    private String nome;
    private String senha;

    public AlunoDTO(String matricula, String nome, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
    }

    public AlunoDTO(){}

    public AlunoDTO(Aluno aluno) {
        this.Id = aluno.getId();
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.senha = aluno.getSenha();
    }


}
