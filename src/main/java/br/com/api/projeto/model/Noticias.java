package br.com.api.projeto.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "info")
public class Noticias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_noticia")
	private Integer id_noticia;
	@Column(name = "titulo", length = 200, nullable = true)
	private String titulo;
	@Column(name = "fonte", length = 50, nullable = true)
	private String fonte;
	@Column(name = "imagem", columnDefinition = "TEXT", nullable = true)
	private String imagem;
	@Column(name = "site", columnDefinition = "TEXT", nullable = true)
	private String site;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "data_noticia", columnDefinition = "DATE")
	private LocalDate data_noticia;
	
	public LocalDate getData_noticia() {
		return data_noticia;
	}
	public void setData_noticia(LocalDate data_noticia) {
		this.data_noticia = data_noticia;
	}
	public Integer getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(Integer id_noticia) {
		this.id_noticia = id_noticia;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFonte() {
		return fonte;
	}
	public void setFonte(String fonte) {
		this.fonte = fonte;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
}
