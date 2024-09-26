package ong;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Seja Bem-Vindo ao Sistema de ONG para Adoção de Animais.\n");
		ArrayList<Animal> animais = new ArrayList<Animal>();
		ArrayList<Adotante> adotantes = new ArrayList<Adotante>();

		while (true) {
			System.out.println(
					"Opções Disponíveis: \n 1) Cadastrar Animal. \n " 
							+ "2) Listar Animais disponíveis para adoção. \n "
							+ "3) Adotar Animal \n " 
							+ "4) Cadastrar adotante \n " 
							+ "5) Listar adotantes \n "
							+ "6) Exibir relatório \n " 
							+ "7) Sair do sistema.");
			System.out.println("Digite sua opção.");
			String opcao = sc.nextLine();

			try {
				int opcaoMenu = Integer.parseInt(opcao);

				if (opcaoMenu == 1) {
					cadastrarAnimal(animais);

				} else if (opcaoMenu == 2) {
					System.out.println("Listagem de animais disponíveis:");

				} else if (opcaoMenu == 3) {
					System.out.println("Adotar Animal");

				} else if (opcaoMenu == 4) {
					System.out.println("Cadastrar adotante");
					cadastrarAdotante(adotantes);

				} else if (opcaoMenu == 5) {
					System.out.println("Listar adotantes");
					listarAdotantes(adotantes);

				} else if (opcaoMenu == 6) {
					System.out.println("Exibir relatório");

				} else if (opcaoMenu == 7) {
					System.out.println("Saindo do Sistema, obrigada por Usar.");
					break;
				} else {
					System.out.println("Opção inválida, digite novamente");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}
		}
	}// fim - main

	public static void cadastrarAdotante(ArrayList<Adotante> adotantes) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"------------- Você escolheu a opção cadastrar adotante, informe os dados abaixos. -----------------");
		System.out.println("Nome Completo do Adotante: ");
		String nomeAdotante = sc.nextLine();

		System.out.println("Digite seu endereço: ");
		String endereço = sc.nextLine();

		System.out.println("Contato: ");
		String contato = sc.nextLine();

		Adotante adotante = new Adotante(nomeAdotante, endereço, contato);
		adotantes.add(adotante);

		System.out.println("Adotante cadastrado com sucesso! ");
	}

	public static void listarAdotantes(ArrayList<Adotante> adotantes) {

		if (adotantes.isEmpty()) {
			System.out.println("Não há adotantes disponíveis.");
		} else {
			System.out.println("Listagem de Adotantes: ");
			for (Adotante adotante : adotantes) {
				System.out.println(adotante);

			}
		}
	}

	public static void cadastrarAnimal(ArrayList<Animal> animais) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do animal: ");
		String nome = sc.nextLine();

		System.out.println("Data de Nascimento do animal: (mm/aaaa) ");
		// TRATAR ERRO DE DATA
		String dataNascimento = sc.nextLine();
		int mes = Integer.parseInt(dataNascimento.substring(0, 2));
		int ano = Integer.parseInt(dataNascimento.substring(3, 7));

		int opcaoEspecie = 0;
		String especie = "";
		while (opcaoEspecie != 1 && opcaoEspecie != 2) {
			System.out.println("Digite a espécie do animal 1) Gato 2) Cachorro: ");
			String opcao = sc.nextLine();
			try {
				opcaoEspecie = Integer.parseInt(opcao);
				if (opcaoEspecie == 1) {
					especie = "gato";
				} else if (opcaoEspecie == 2) {
					especie = "cachorro";
				} else {
					System.out.println("Opção inválida, digite novamente.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}
		}

		String porte = "";
		String pelos = "";
		if (especie.equalsIgnoreCase("cachorro")) {
			int opcaoPorte = 0;
			String entradaPorte = "";
			while (opcaoPorte != 1 && opcaoPorte != 2 && opcaoPorte != 3) {
				System.out.println("Digite o porte do animal 1) Pequeno 2) Médio 3) Grande: ");
				entradaPorte = sc.nextLine();
				try {
					opcaoPorte = Integer.parseInt(entradaPorte);
					if (opcaoPorte == 1) {
						porte = "pequeno";
					} else if (opcaoPorte == 2) {
						porte = "medio";
					} else if (opcaoPorte == 3) {
						porte = "grande";
					} else {
						System.out.println("Opção inválida, digite novamente");
					}
				} catch (NumberFormatException e) {
					System.out.println("Entrada inválida. Por favor, insira um número.");
				}
			}
		} else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("Digite o padrão de pelagem do gato:  ");
			pelos = sc.nextLine();
		}

		int opcaoSexo = 0;
		String sexo = "";
		while (opcaoSexo != 1 && opcaoSexo != 2) {
			System.out.println("Digite qual sexo do animal: 1) Fêmea 2) Macho");
			String entradaSexo = sc.nextLine();
			try {
				opcaoSexo = Integer.parseInt(entradaSexo);
				if (opcaoSexo == 1) {
					sexo = "femea";
				} else if (opcaoSexo == 2) {
					sexo = "macho";
				} else {
					System.out.println("Opção inválida, digite novamente");
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}

		}
		if (especie.equals("cachorro")) {
			Cachorro cachorro = new Cachorro(nome, dataNascimento, especie, sexo, porte);
			animais.add(cachorro);

			System.out.println(cachorro);
		} else if (especie.equals("gato")) {
			Gato gato = new Gato(nome, dataNascimento, especie, sexo, pelos);
			System.out.println(gato);
		}
		System.out.println("Seu animal cadastrado com sucesso! ");
		System.out.println("-------------------------------------------------------");
		sc.close();
	}// fim - cadastrar animal
}// fim - main
