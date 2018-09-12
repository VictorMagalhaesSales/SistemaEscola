package com.escola.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.api.model.Professor;
import com.escola.api.repository.ProfessorRepository;
import com.escola.api.repository.filter.ProfessorFilter;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<Professor> listarProfessores(ProfessorFilter professorFilter){
		return this.professorRepository.filtrar(professorFilter);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> listarProfessorPorId(@PathVariable Long id){
		Professor professor = this.professorRepository.findOne(id);
		return professor != null ? ResponseEntity.ok(professor) : ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Professor> salvarProfessor(@Valid @RequestBody Professor professor){
		Professor professorSalvo = this.professorRepository.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAluno(@Valid @PathVariable Long id) {
		this.professorRepository.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Professor> atualizarProfessor(@PathVariable Long id, @Valid @RequestBody Professor professorReq){
		Professor professorOpt = this.professorRepository.findOne(id);		
		BeanUtils.copyProperties(professorReq, professorOpt, "id");
		Professor professorDepois =  professorRepository.save(professorOpt);
		
		return ResponseEntity.ok(professorDepois);
	}

}
