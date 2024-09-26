package ong;

import java.util.ArrayList;
import java.util.Scanner;

public class ONG {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> id = new ArrayList<>();
		ArrayList<String> nomeAnimal = new ArrayList<>();
		ArrayList<String> dataNascimento = new ArrayList<>();
		ArrayList<String> especie = new ArrayList<>();
		ArrayList<String> porte = new ArrayList<>();
		ArrayList<String> pelagem = new ArrayList<>();

		System.out.println("Seja Bem-Vindo ao Sistema de ONG para Adoção de Animais.");
		int opcao = 1;
		int idGlobal = 0;

		while (opcao != 4) {
			System.out.println(
					"Opções Disponíveis: \n 1) Cadastrar Animal. \n 2) Listar Animais disponíveis para adoção. \n 3) Adotar Animal \n 4) Sair do sistema.");
			System.out.println("Digite sua opção.");
			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				System.out.println("Digite o nome do animal: ");
				nomeAnimal.add(sc.nextLine());
				System.out.println("Data de Nascimento do animal: ");
				dataNascimento.add(sc.nextLine());
				System.out.println("Digite a espécie do animal (Gato/Cachorro): ");
				especie.add(sc.nextLine());
				System.out.println("Digite o porte do animal (Pequeno/Médio/Grande): ");
				porte.add(sc.nextLine());
				System.out.println("Digite o tipo de pelagem do animal (Escura/Branco): ");
				pelagem.add(sc.nextLine());
				System.out.println("-------------------------------------------------------");

			} else if (opcao == 2) {
				System.out.println("Listagem de animais disponíveis:");
				for (int i = 0; i < id.size(); i++) {
					System.out.println("ID: " + id.get(i));
					System.out.println("Nome: " + nomeAnimal.get(i));
					System.out.println("Data de Nascimento: " + dataNascimento.get(i));
					System.out.println("Espécie: " + especie.get(i));
					System.out.println("Porte: " + porte.get(i));
					System.out.println("Pelagem: " + pelagem.get(i));
					System.out.println("--------------------------------------");
				}
				System.out.println("Total de animais disponíveis: " + id.size());

			} else if (opcao == 3) {
				System.out.println("Informe a espécie do animal que deseja adotar (Gato/Cachorro): ");
				String especieFiltro = sc.nextLine();
				System.out.println("Informe o porte do animal que deseja adotar (Pequeno/Médio/Grande): ");
				String porteFiltro = sc.nextLine();

				ArrayList<Integer> idsFiltrados = new ArrayList<>();
				for (int i = 0; i < id.size(); i++) {
					if (especie.get(i).equalsIgnoreCase(especieFiltro) && porte.get(i).equalsIgnoreCase(porteFiltro)) {
						idsFiltrados.add(id.get(i));
						System.out.println("ID: " + id.get(i));
						System.out.println("Nome: " + nomeAnimal.get(i));
						System.out.println("Data de Nascimento: " + dataNascimento.get(i));
						System.out.println("Espécie: " + especie.get(i));
						System.out.println("Porte: " + porte.get(i));
						System.out.println("Pelagem: " + pelagem.get(i));
						System.out.println("--------------------------------------");
					}
				}
				if (idsFiltrados.isEmpty()) {
					System.out.println("Nenhum animal encontrado com os critérios informados.");
				} else {
					System.out.println("Digite o ID do animal que deseja adotar:");
					int idAdocao = sc.nextInt();
					sc.nextLine();

					if (idsFiltrados.contains(idAdocao)) {
						int index = id.indexOf(idAdocao);
						removerAnimal(index, id, nomeAnimal, dataNascimento, especie, porte, pelagem);
						System.out.println("Animal adotado com sucesso!");
					} else {
						System.out.println("ID não encontrado na listagem filtrada.");
					}
				}
			} else {
				if (opcao == 4) {
					System.out.println("Saindo do Sistema, obrigada por usar! ");
				} else {
					System.out.println("Opção inválida, tente novamente. ");
				}

			}
		}
		sc.close();
	}

	public static void removerAnimal(int index, ArrayList<Integer> id, ArrayList<String> nomeAnimal,
			ArrayList<String> dataNascimento, ArrayList<String> especie, ArrayList<String> porte,
			ArrayList<String> pelagem) {
		id.remove(index);
		nomeAnimal.remove(index);
		dataNascimento.remove(index);
		especie.remove(index);
		porte.remove(index);
		pelagem.remove(index);
	}
}
