package com.springwebundf.Controller;

import com.springwebundf.Dtos.AlunoDTO;
import com.springwebundf.Model.Aluno;
import com.springwebundf.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> Salvar(@RequestBody AlunoDTO alunoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.alunoService.saveAluno(alunoDTO));
    }
}
