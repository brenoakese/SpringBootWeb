package com.springwebundf.Controller;

import com.springwebundf.Dtos.AlunoDTO;
import com.springwebundf.Model.Aluno;
import com.springwebundf.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Void> Salvar(@RequestBody AlunoDTO alunoDTO){
        this.alunoService.saveAluno(alunoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{matricula}").buildAndExpand(alunoDTO.getMatricula()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> getAlunoByMatricula(@PathVariable String matricula){
        Aluno aluno = this.alunoService.getAlunoByMatricula(matricula);
        aluno.setSenha(null);
        return ResponseEntity.ok().body(aluno);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO){
        this.alunoService.updateAluno(id, alunoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id){
        this.alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Aluno> login(@RequestParam  String matricula, @RequestParam String senha){
        Aluno aluno = this.alunoService.getAlunoByMatriculaAndSenha(matricula, senha);
        aluno.setSenha(null);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Aluno>> getAllAlunos(){
        return ResponseEntity.ok().body(this.alunoService.findAllAlunos());
    }


}
