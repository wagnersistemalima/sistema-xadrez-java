package xadrez;

import jogoDeTabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {										// cora��o do sistema de xadrez / onde vai est�r as regras
	
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
	
	private void initialSetup() {				                                    // metodo p /colocar as pe�as no tabuleiro
		coloqueUmaNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		coloqueUmaNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));	
		coloqueUmaNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		coloqueUmaNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		coloqueUmaNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		coloqueUmaNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));
		
		coloqueUmaNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		coloqueUmaNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
