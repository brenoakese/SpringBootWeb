package com.springwebundf.repositories;

import com.springwebundf.Model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

    Disciplina findDisciplinaByCodigo(String codigo);
}
