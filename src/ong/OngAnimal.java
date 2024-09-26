package ong;

import java.util.Scanner;

public class OngAnimal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seja Bem-Vindo ao Sistema de ONG para Adoção de Animais.");
		int opcao = 1;
		int id = 0;

		while (opcao != 4) {
			System.out.println(
					"Opções Disponíveis: \n 1) Cadastrar Animal. \n 2) Listar Animais disponíveis para adoção. \n 3) Adotar Animal \n 4) Sair do sistema.");
			System.out.println("Digite sua opção.");
			opcao = sc.nextInt();
			sc.nextLine();

			if (opcao == 1) {
				System.out.println("Digite o nome do animal: ");
				String nome = sc.nextLine();

				System.out.println("Data de Nascimento do animal: ");
				String dataNascimento = sc.nextLine();
				
				int opcaoEspecie = 0;
				String especie = "";
				System.out.println("Digite a espécie do animal 1) Gato 2) Cachorro: ");
				opcaoEspecie = sc.nextInt();
				sc.nextLine();
				if (opcaoEspecie == 1) {
					especie = "gato";
				} else if (opcaoEspecie == 2) {
					especie = "cachorro";
				} else {
					System.out.println("Opção inválida, digite novamente");
				}
				

				if (especie.equalsIgnoreCase("cachorro")) {
					System.out.println("Digite o porte do animal 1) Pequeno 2) Médio 3) Grande: ");
					int opcaoPorte = sc.nextInt();
					String porte ="";
					if (opcaoPorte == 1) {
						porte = "pequeno";
					} else if (opcaoPorte == 2) {
						porte = "medio";
					} else if (opcaoPorte == 3) {
						porte = "grande";
					}
				} else if (especie.equalsIgnoreCase("gato")) {
					System.out.println("Digite o padrão de pelagem do animal:  ");
					String pelagem = sc.nextLine();
				} else {
					System.out.println("Espécie Inválida");
				}

				System.out.println("Digite qual sexo do animal: 1) Fêmea 2) Macho");
				int opcaoSexo = sc.nextInt();
				String sexo = "";
				
				if (opcaoSexo == 1) {
					sexo = "femea";
				} else if (opcaoSexo == 2) {
					sexo = "macho";
				}

				System.out.println(" Seu animal cadastrado com sucesso! ");
				System.out.println("-------------------------------------------------------");
				
				
				
			} else if (opcao == 2) {
				System.out.println("Listagem de animais disponíveis:");

			} else if (opcao == 3) {
				System.out.println("oi");

			} else {
				if (opcao == 4) {
					System.out.println("Saindo do Sistema, obrigada por Usar.");
				} else {
					System.out.println("Opção inválida.");
				}

			}
		}

	}

}
