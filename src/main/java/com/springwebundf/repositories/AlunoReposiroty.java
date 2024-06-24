package com.springwebundf.repositories;

import com.springwebundf.Model.Aluno;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoReposiroty extends JpaRepository<Aluno, Long>{

    Aluno findAlunoByMatricula(String matricula);


}
