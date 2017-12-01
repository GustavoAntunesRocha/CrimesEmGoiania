package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Crime {
	@Id
	@GeneratedValue
	private int id;
	
	private String tipo;
	
	private String arma;
	
	private String descricao;
	
	private String imagePath;
	
	private String email;
	
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return this.id;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return this.tipo;
	}
	
	public void setArma(String arma) {
		this.arma = arma;
	}
	public String getArma() {
		return this.arma;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setImagePath(String path) {
		this.imagePath = path;
	}
	public String getImagePath() {
		return this.imagePath;
	}
}
