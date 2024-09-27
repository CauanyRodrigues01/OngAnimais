package ong;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class main {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Seja Bem-Vindo ao Sistema de ONG para Adoção de Animais.\n");
		ArrayList<Animal> animais = new ArrayList<Animal>();
		ArrayList<Adotante> adotantes = new ArrayList<Adotante>();

		while (true) {
			System.out.println(
					"Opções Disponíveis: \n 1) Cadastrar Animal. \n " + "2) Listar Animais disponíveis para adoção. \n "
							+ "3) Adotar Animal \n " + "4) Cadastrar adotante \n " + "5) Listar adotantes \n "
							+ "6) Exibir relatório \n " + "7) Sair do sistema.");
			System.out.println("Digite sua opção.");
			String opcao = sc.nextLine();

			try {
				int opcaoMenu = Integer.parseInt(opcao);

				if (opcaoMenu == 1) {
					cadastrarAnimal(animais, sc);

				} else if (opcaoMenu == 2) {
					listarAnimaisDisponiveis(animais);

				} else if (opcaoMenu == 3) {
					adotarAnimal(animais, adotantes, sc);

				} else if (opcaoMenu == 4) {
					cadastrarAdotante(adotantes,sc);

				} else if (opcaoMenu == 5) {
					listarAdotantes(adotantes);

				} else if (opcaoMenu == 6) {
					exibirRelatorio(animais);

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
		sc.close();
	}

	public static void cadastrarAdotante(ArrayList<Adotante> adotantes, Scanner sc) {
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
			System.out.println("Listar adotantes");
			for (Adotante adotante : adotantes) {
				System.out.println(adotante);

			}
		}
	}

	public static void cadastrarAnimal(ArrayList<Animal> animais, Scanner sc) {
		System.out.println("Adotar Animal");
		System.out.println("Digite o nome do animal: ");
		String nome = sc.nextLine();

		String dataNascimento = "";
		boolean dataValida = false;

		int idadeAnos = 0;
		int idadeMeses = 0;

		while (!dataValida) {
			System.out.println("Mês e ano de Nascimento do animal: (mm/aaaa)");
			dataNascimento = sc.nextLine();

			try {
				int mes = Integer.parseInt(dataNascimento.substring(0, 2));
				int ano = Integer.parseInt(dataNascimento.substring(3, 7));

				if (mes >= 1 && mes <= 12 && ano > 0) {
					dataValida = true;
				} else {
					System.out.println("Data inválida. Mês deve estar entre 01 e 12 e o ano deve ser positivo.");
				}

				Calendar calendario = Calendar.getInstance();
				int mesAtual = calendario.get(Calendar.MONTH) + 1;
				int anoAtual = calendario.get(Calendar.YEAR);

				idadeAnos = anoAtual - ano;

				if (mesAtual < mes) {
					idadeAnos--;
					idadeMeses = (12 - mes) + mesAtual;
				} else {
					idadeMeses = mesAtual - mes;
				}

			} catch (StringIndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("Formato de data inválido. Por favor, use o formato mm/aaaa.");
			}
		}
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
			Cachorro cachorro = new Cachorro(nome, dataNascimento, idadeAnos, idadeMeses, especie, sexo, porte);
			animais.add(cachorro);

		} else if (especie.equals("gato")) {
			Gato gato = new Gato(nome, dataNascimento, idadeAnos, idadeMeses, especie, sexo, pelos);
			animais.add(gato);
		}
		System.out.println("Seu animal cadastrado com sucesso! ");
		System.out.println("-------------------------------------------------------");
	}

	public static void listarAnimaisDisponiveis(ArrayList<Animal> animais) {
		if (animais.isEmpty()) {
			System.out.println("Não há animais disponíveis para adoção.");
		} else {
			System.out.println("Listagem de Animais Disponíveis para Adoção:");
			for (Animal animal : animais) {
				if (animal.getStatus().equalsIgnoreCase("disponivel")) {
					System.out.println(animal);
				}
			}
		}
	}

	public static void adotarAnimal(ArrayList<Animal> animais, ArrayList<Adotante> adotantes, Scanner sc) {
	    if (adotantes.isEmpty()) {
	        System.out.println("Não há adotantes disponíveis, se cadastre para adotar um animal.");
	        return;
	    }

	    int contAdotante = 0;
	    Adotante adotanteSelecionado = null;
	    while (contAdotante == 0) {
	        System.out.println("Informe o seu ID: ");
	        String opcao = sc.nextLine();
	        try {
	            int id = Integer.parseInt(opcao);

	            for (Adotante adotante : adotantes) {
	                if (adotante.getId() == id) {
	                    adotanteSelecionado = adotante;
	                    contAdotante++;
	                    break;
	                }
	            }
	            if (contAdotante == 0) {
	                System.out.println("Adotante não cadastrado em nosso sistema, tente mais uma vez.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. Por favor, insira um número.");
	        }
	    }

	    int opcaoEspecie = 0;
		String especie = "";
		while (opcaoEspecie != 1 && opcaoEspecie != 2 && opcaoEspecie != 3) {
			System.out.println("Digite a espécie do animal: 1) Gato 2) Cachorro 3) Não tenho preferência");
			String opcao = sc.nextLine();
			try {
				opcaoEspecie = Integer.parseInt(opcao);
			    if (opcaoEspecie == 1) {
			        especie = "gato";
			    } else if (opcaoEspecie == 2) {
			        especie = "cachorro";
			    } else if (opcaoEspecie == 3) {
			    	especie = "";
			    } else {
			    	System.out.println("Opção inválida, digite novamente.");
			    }
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}
		}
	    
	    int opcaoSexo = 0;
		String sexo = "";
		while (opcaoSexo != 1 && opcaoSexo != 2 && opcaoSexo != 3) {
			System.out.println("Digite qual sexo do animal: 1) Fêmea 2) Macho 3) Não tenho preferência");
			String opcao = sc.nextLine();
			try {
				opcaoSexo = Integer.parseInt(opcao);
			    if (opcaoSexo == 1) {
			    	sexo = "femea";
			    } else if (opcaoSexo == 2) {
			    	sexo = "macho";
			    } else if (opcaoSexo == 3) {
			    	sexo = "";
			    } else {
			    	System.out.println("Opção inválida, digite novamente.");
			    }
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}
		}

	    int opcaoIdadeMaxima = 0;
		int idadeMaxima = 0;
		while (true) {
			System.out.println("Digite a idade máxima que o animal deve ter: 0) Não tenho preferência");
			String opcao = sc.nextLine();
			try {
				opcaoIdadeMaxima = Integer.parseInt(opcao);
			    if (opcaoIdadeMaxima == 0) {
			    	break;
			    } else {
			    	idadeMaxima = opcaoIdadeMaxima;
			    	break;
			    }
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Por favor, insira um número.");
			}
		}
	    

	    ArrayList<Animal> animaisFiltrados = new ArrayList<>();

	    for (Animal animal : animais) {
	        boolean filtroEspecie = (especie == null || especie.isEmpty() || animal.getEspecie().equalsIgnoreCase(especie));
	        boolean filtroSexo = (sexo == null || sexo.isEmpty() || animal.getSexo().equalsIgnoreCase(sexo));
	        boolean filtroIdade = (idadeMaxima <= 0 || animal.getIdadeAnos() <= idadeMaxima);
	        
	        if (filtroEspecie && filtroSexo && filtroIdade) {
	            animaisFiltrados.add(animal);
	        }
	    }

	    if (animaisFiltrados.isEmpty()) {
	        System.out.println("Não há animais que correspondem ao filtro.");
	    } else {
	        System.out.println("Animais disponíveis para adoção:");
	        for (Animal animal : animaisFiltrados) {
	            System.out.println(animal);
	        }
	        System.out.println("Digite o ID do animal que você deseja adotar");
			int idFiltrado = sc.nextInt();

			for (Animal animal : animais) {
				if (animal.getId() == idFiltrado) {
					if (animal.getStatus().equals("disponivel")) {
						animal.setStatus("indisponivel");
						System.out.println("Você adotou um animal, parabéns!");
						salvarRelatorio(animal, adotanteSelecionado);
					} else {
						System.out.println("Animal está indisponivel, já foi adotado. ");
					}
				} 
			}
	    }
	    
	}
	
	public static void salvarRelatorio(Animal animal, Adotante adotante) {
		try {
			FileWriter writer = new FileWriter("relatorio_adocoes.txt", true);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dataAtual = sdf.format(new Date());

			writer.write(dataAtual + " - " + animal.getEspecie() + " " + animal.getNome() + " (ID: " + animal.getId()
					+ ") foi adotado por " + adotante.getNome() + " (ID: " + adotante.getId() + ").\n");
			writer.close();
			System.out.println("Relatório de adoção salvo com sucesso.");
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao salvar o relatório.");
			e.printStackTrace();
		}
	}

	public static void exibirRelatorio(ArrayList<Animal> animais) {
		if (animais.isEmpty()) {
		    System.out.println("Não há animais cadastrados.");
		} else {
		    File relatorio = new File("relatorio_adocoes.txt");
		    
		    if (relatorio.length() == 0) {
		        System.out.println("O relatório de adoções está vazio.");
		    } else {
		        try {
		            BufferedReader reader = new BufferedReader(new FileReader(relatorio));
		            String linha;

		            System.out.println("----- Relatório de Adoções -----");
		            while ((linha = reader.readLine()) != null) {
		                System.out.println(linha);
		            }
		            reader.close();
		        } catch (IOException e) {
		            System.out.println("Ocorreu um erro ao ler o relatório.");
		            e.printStackTrace();
		        }
		    }
		}

	}


}

