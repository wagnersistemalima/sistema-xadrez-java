package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosicao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		
		while (true) {
			try {
			
				UI.clearScreen();
				UI.printTabuleiro(partidaDeXadrez.getPecas());                // imprimir o tabuleiro
				System.out.println();
				System.out.print("Origem: ");
				XadrezPosicao origem = UI.leiaPosicaoDoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				XadrezPosicao destino = UI.leiaPosicaoDoXadrez(sc);
				
				PecaDeXadrez capturePeca = partidaDeXadrez.perfomaceXadrezMovimento(origem, destino);
			} 
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
