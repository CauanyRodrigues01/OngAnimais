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
		return "Animal [id=" + super.getId() + ", nome=" + super.getNome() + ", dataNascimento="
				+ super.getDataNascimento()  + ", idade=" + super.getIdadeAnos() + " anos e " + super.getIdadeMeses() + " meses" + ", especie=" + super.getEspecie() + ", sexo=" + super.getSexo()
				+ ", status=" + super.getStatus() + ", porte=" + porte + "]";
	}

}
