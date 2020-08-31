package xadrez;

import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {										// coração do sistema de xadrez / onde vai estár as regras
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		initialSetup();
	}
	
	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i=0; i<tabuleiro.getLinhas(); i++) {
			for (int j=0; j<tabuleiro.getColunas(); j++) {
				mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void coloqueUmaNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).posicionar());
	}
	
	private void initialSetup() {				                                    // metodo p /colocar as peças no tabuleiro
		coloqueUmaNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		coloqueUmaNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
	}
}
