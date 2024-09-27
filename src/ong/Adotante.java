package ong;

import java.util.Objects;

public class Adotante {
	private static int contador = 1;
	private int id;
	private String nome;
	private String endereco;
	private String contato;

	public Adotante(String nome, String endereco, String contato) {
		this.id = contador++;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
	}
	
	//listar adotantes

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Adotante - ID = " + id + ", Nome = " + nome + ", Endereco = " + endereco + ", Contato = " + contato ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adotante other = (Adotante) obj;
		return id == other.id;
	}

}
