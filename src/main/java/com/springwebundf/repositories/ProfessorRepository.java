package com.springwebundf.repositories;

import com.springwebundf.Model.Professor;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Professor findProfessorByCPF(String CPF);
    
    Professor findProfessorByCPFAndSenha(String CPF, String senha);

    Professor findProfessorById(Long id);
}
