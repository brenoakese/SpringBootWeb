package com.springwebundf.Dtos;

import com.springwebundf.Model.Aluno;

public class AlunoDTO {


    private String matricula;
    private String nome;
    private String senha;

    public AlunoDTO(String matricula, String nome, String senha) {
        setMatricula(matricula);
        setNome(nome);
        setSenha(senha);

    }

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.senha = aluno.getSenha();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
