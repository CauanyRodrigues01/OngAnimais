package ong;

public class Gato extends Animal {
	private String pelos;

	public Gato(String nome, String dataNascimento, String especie, String sexo, String pelos) {
		super(nome, dataNascimento, especie, sexo);
		this.pelos = pelos;
	}

	public String getPelos() {
		return pelos;
	}

	public void setPelos(String pelos) {
		this.pelos = pelos;
	}

	@Override
	public String toString() {
		return "Animal [id=" + super.getId() + ", nome=" + super.getNome() + ", dataNascimento="
				+ super.getDataNascimento() + ", especie=" + super.getEspecie() + ", sexo=" + super.getSexo()
				+ ", status=" + super.getStatus() + ", pelos=" + pelos + "]";

	}

}
