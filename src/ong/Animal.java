package ong;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Animal {

	private static int contador = 0;
	private int id;
	private String nome;
	private String dataNascimento;
	private String especie;
	private String sexo;
	private String status;

	public Animal(String nome, String dataNascimento, String especie, String sexo) {
		this.id = contador++;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.especie = especie;
		this.sexo = sexo;
		this.status = "disponivel";
	}

	// listarAnimais()
	// adotarAnimal()

	public void listarAnimais(ArrayList<Animal> animais) {
		for (Animal animal : animais) {
			System.out.println(animal);
		}
	}

	public static void removerAnimal(int index, ArrayList<Integer> id, ArrayList<String> nome,
			ArrayList<String> dataNascimento, ArrayList<String> especie, ArrayList<String> porte,
			ArrayList<String> pelagem) {
		id.remove(index);
		nome.remove(index);
		dataNascimento.remove(index);
		especie.remove(index);
		porte.remove(index);
		pelagem.remove(index);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", especie=" + especie
				+ ", sexo=" + sexo + ", status=" + status + "]";
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
		Animal other = (Animal) obj;
		return Objects.equals(id, other.id);
	}

}
