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
		return "Animal - ID = " + super.getId() + ", Nome = " + super.getNome() + ", dataNascimento = "
				+ super.getDataNascimento() + ", Idade = " + super.getIdadeAnos() + " Anos e " + super.getIdadeMeses() + " meses" + ", Especie = " + super.getEspecie() + ", Sexo = " + super.getSexo()
				+ ", Status = " + super.getStatus() + ", Pelos = " + pelos;

	}

}
