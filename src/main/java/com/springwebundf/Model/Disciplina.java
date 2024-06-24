package com.springwebundf.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String codigo;

    private String cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToMany
    @JoinTable(name = "disciplinas_alunos",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private Set<Aluno> alunos = new HashSet<>();

    public Disciplina(String nome, String codigo, String cargaHoraria, Professor professor) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public Disciplina() {

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
