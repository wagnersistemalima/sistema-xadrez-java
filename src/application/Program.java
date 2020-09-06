package application;

import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezPosicao;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
		
		while (true) {
			UI.printTabuleiro(partidaDeXadrez.getPecas());
			System.out.println();
			System.out.print("Origem: ");
			XadrezPosicao origem = UI.leiaPosicaoDoXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			XadrezPosicao destino = UI.leiaPosicaoDoXadrez(sc);
			
			PecaDeXadrez capturePeca = partidaDeXadrez.perfomaceXadrezMovimento(origem, destino);
		}

	}

}
