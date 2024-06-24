package com.springwebundf.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String matricula;
    @Column(nullable = false)
    private String senha;

    @ManyToMany(mappedBy = "alunos",fetch = FetchType.LAZY)//"alunos" é o dono do relacionamento, está definido na classe Disciplina
    private Set<Disciplina> disciplinas = new HashSet<>();

    public Aluno(String nome, String matricula, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }

    public Aluno() {

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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
