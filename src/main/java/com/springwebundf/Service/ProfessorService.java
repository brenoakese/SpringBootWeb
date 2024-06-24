package com.springwebundf.Service;

import com.springwebundf.Model.Professor;
import com.springwebundf.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public Professor getProfessorByCPF(String CPF){
        Optional<Professor> professor = Optional.ofNullable(this.professorRepository.findProfessorByCPF(CPF));

        return professor.orElseThrow(() -> new RuntimeException("Professor"+ CPF +"não encontrado"));
    }
}
