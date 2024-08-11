package main;

import javax.swing.JOptionPane;

public class TesteImprimir {

	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		JOptionPane.showMessageDialog(null, "seu nome é " + nome);

	}

}