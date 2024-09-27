package ong;

public class Cachorro extends Animal {
	private String porte;

	public Cachorro(String nome, String dataNascimento, int idadeAnos, int idadeMeses, String especie, String sexo, String porte) {
		super(nome, dataNascimento,idadeAnos, idadeMeses, especie, sexo);
		this.porte = porte;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	@Override
	public String toString() {
		return "Animal - ID = " + super.getId() + ", Nome = " + super.getNome() + ", dataNascimento = "
				+ super.getDataNascimento()  + ", Idade = " + super.getIdadeAnos() + " Anos e " + super.getIdadeMeses() + " meses" + ", Especie = " + super.getEspecie() + ", Sexo = " + super.getSexo()
				+ ", Status = " + super.getStatus() + ", Porte = " + porte;
	}

}
