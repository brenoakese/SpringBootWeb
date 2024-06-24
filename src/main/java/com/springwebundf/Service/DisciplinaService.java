package com.springwebundf.Service;

import com.springwebundf.Model.Disciplina;
import com.springwebundf.repositories.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;

    DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }


    public Disciplina getDisciplinaBycodigo(String codigo){
        Optional<Disciplina> disciplina = Optional.ofNullable(this.disciplinaRepository.findDisciplinaByCodigo(codigo));

        return disciplina.orElseThrow(() -> new RuntimeException("Disciplina"+ codigo +"não encontrada"));
    }


}
