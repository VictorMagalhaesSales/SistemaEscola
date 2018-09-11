package com.escola.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'nome'")
	@NotNull(message="O campo 'nome' não pode ser nulo!")
	private String nome;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'sobrenome'")
	@NotNull(message="O campo 'sobrenome' não pode ser nulo!")
	private String sobrenome;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'disciplina'")
	@NotNull(message="O campo 'disciplina' não pode ser nulo!")
	private String disciplina;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'login'")
	@NotNull(message="O campo 'login' não pode ser nulo!")
	private String login;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'senha'")
	@NotNull(message="O campo 'senha' não pode ser nulo!")
	private String senha;
	
	@NotNull(message="O campo 'nascimento' não pode ser nulo!")
	private Date nascimento;
	
	@Size(max = 100, message="O você não pode digitar mais do que 50 caracteres no campo 'email'")
	@NotNull(message="O campo 'email' não pode ser nulo!")
	private String email;

	@Size(max = 50, message="O você não pode digitar mais do que 50 caracteres no campo 'telefone'")
	private String telefone;

	@Size(max = 255, message="o caminho da imagem não pode conter mais do que 255 caracteres!")
	private String imagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
