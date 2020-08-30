package application;

import xadrez.PecaDeXadrez;

public class UI {
	
	public static void printTabuleiro(PecaDeXadrez[][] pecas) {
		
		for (int i=0; i<pecas.length; i++) {                                   // mostrar o modelo do tabuleiro
			System.out.print(8 - i + " ");
			for (int j=0; j<pecas.length; j++) {
				printPeca(pecas[i][j]);
			}
			System.out.println();                                                // para quebrar linha e passar p/ 8 7 6 5 4 3 2 1
		}
		System.out.print("  a b c d e f g h");
	}
	
	public static void printPeca(PecaDeXadrez peca) {                           // imprimir uma peca.
		if (peca == null) {
			System.out.print("-");
		}
		else {
			System.out.print(peca);
		}
		System.out.print(" ");                                       // para as peças não ficarem grudadas uma nas outras
	}

}
