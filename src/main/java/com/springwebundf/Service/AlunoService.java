package com.springwebundf.Service;

import com.springwebundf.Dtos.AlunoDTO;
import com.springwebundf.Model.Aluno;
import com.springwebundf.Model.Disciplina;
import com.springwebundf.Model.Professor;
import com.springwebundf.repositories.AlunoReposiroty;
import com.springwebundf.repositories.DisciplinaRepository;
import com.springwebundf.repositories.ProfessorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlunoService {

    private AlunoReposiroty alunoReposiroty;

    public AlunoService(AlunoReposiroty alunoReposiroty){
        this.alunoReposiroty = alunoReposiroty;
    }

    public Aluno getAlunoByMatricula(String matricula){
        Optional<Aluno> aluno = Optional.ofNullable(this.alunoReposiroty.findAlunoByMatricula(matricula));

        return aluno.orElseThrow(() -> new RuntimeException("Aluno"+ matricula +"não encontrado"));
    }

    @Transactional
    public Aluno saveAluno(AlunoDTO alunoDTO){
        Aluno aluno = new Aluno();
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNome(alunoDTO.getNome());
        aluno.setSenha(alunoDTO.getSenha());
        return this.alunoReposiroty.save(aluno);
    }


}
