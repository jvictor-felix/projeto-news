package br.com.api.projeto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="avaliacao") 

public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_msg")
	private Integer id_msg;
	@NotBlank(message = "O nome é obrigatório!")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3-50 caracteres." )
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	@Enumerated(EnumType.STRING)
	@Column(name = "classificacao")
	private Classificacao classificacao;
	@Column(name = "comentario", length = 500, nullable = true)
	private String comentario;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="data_msg", columnDefinition = "DATE")
	private LocalDate data_msg;
	
	
	public LocalDate getData_msg() {
		return data_msg;
	}
	public void setData_msg(LocalDate data_msg) {
		this.data_msg = data_msg;
	}
	public int getId_msg() {
		return id_msg;
	}
	public void setId_msg(int id_msg) {
		this.id_msg = id_msg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Classificacao getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
