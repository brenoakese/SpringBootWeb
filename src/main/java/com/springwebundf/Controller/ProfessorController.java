package com.springwebundf.Controller;

import com.springwebundf.Dtos.ProfessorDTO;
import com.springwebundf.Model.Professor;
import com.springwebundf.Service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }


    @PostMapping("/salvar")
    public ResponseEntity<Void> Salvar(@RequestBody ProfessorDTO professorDTO){
        this.professorService.saveProfessor(professorDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Professor> login(@RequestBody ProfessorDTO professorDTO){
        Professor professor = this.professorService.getProfessorByCPFAndSenha(professorDTO.getCPF(), professorDTO.getSenha());
        professor.setSenha(null);
        return ResponseEntity.ok().body(professor);
    }


}
