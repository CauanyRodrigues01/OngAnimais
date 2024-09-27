package ong;

public class Gato extends Animal {
	private String pelos;

	public Gato(String nome, String dataNascimento, int idadeAnos, int idadeMeses, String especie, String sexo, String pelos) {
		super(nome, dataNascimento,idadeAnos, idadeMeses, especie, sexo);
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
				+ super.getDataNascimento() + ", idade=" + super.getIdadeAnos() + " anos e " + super.getIdadeMeses() + " meses" + ", especie=" + super.getEspecie() + ", sexo=" + super.getSexo()
				+ ", status=" + super.getStatus() + ", pelos=" + pelos + "]";

	}

}
