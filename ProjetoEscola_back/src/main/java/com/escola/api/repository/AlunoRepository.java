package com.escola.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.api.model.Aluno;
import com.escola.api.repository.filter.AlunoRepositoryQuery;

public interface AlunoRepository extends JpaRepository<Aluno, Long>, AlunoRepositoryQuery{
	
	public Optional<Aluno> findByEmail(String email);
}
