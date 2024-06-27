package com.springwebundf.Service;

import com.springwebundf.Dtos.ProfessorDTO;
import com.springwebundf.Model.Professor;
import com.springwebundf.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Professor getProfessorByCPFAndSenha(String CPF, String senha){
        Optional<Professor> professor = Optional.ofNullable(this.professorRepository.findProfessorByCPFAndSenha(CPF, senha));

        return professor.orElseThrow(() -> new RuntimeException("Professor"+ CPF +"não encontrado"));
    }

    public Professor getProfessorById(Long id){
        Optional<Professor> professor = Optional.ofNullable(this.professorRepository.findProfessorById(id));

        return professor.orElseThrow(() -> new RuntimeException("Professor"+ id +"não encontrado"));
    }

    @Transactional
    public Professor saveProfessor(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setSenha(professorDTO.getSenha());
        professor.setCPF(professorDTO.getCPF());
        return this.professorRepository.save(professor);

    }

    @Transactional
    public Professor updateProfessor(long Id, Professor professorDTO) {
        Professor professor1 = professorRepository.findById(Id).get();
        professor1.setSenha(professorDTO.getSenha());

        return this.professorRepository.save(professor1);
    }

    @Transactional
    public void deleteProfessor(Long id){
        try {
            this.professorRepository.deleteById(id);
        }catch (Exception e) {
            throw new RuntimeException("Professor ministrando disciplina, não pode ser deletado.");
        }
    }


}
