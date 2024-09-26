package ong;

public class Cachorro extends Animal {
	private String porte;

	public Cachorro(String nome, String dataNascimento, String especie, String sexo, String porte) {
		super(nome, dataNascimento, especie, sexo);
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
				+ super.getDataNascimento() + ", especie=" + super.getEspecie() + ", sexo=" + super.getSexo()
				+ ", status=" + super.getStatus() + ", porte=" + porte + "]";
	}

}
