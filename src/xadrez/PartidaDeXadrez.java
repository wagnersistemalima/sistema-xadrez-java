package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
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
	
	public boolean[][] possiveisMovimentos(XadrezPosicao origemPosicao) {
		Posicao posicao = origemPosicao.posicionar();
		validacaoPosicaoOrigem(posicao);
		return tabuleiro.peca(posicao).possivelMovimento();
	}
	
	public PecaDeXadrez perfomaceXadrezMovimento(XadrezPosicao posicaoOrigem, XadrezPosicao posicaoDestino) {
		Posicao origem = posicaoOrigem.posicionar();
		Posicao destino = posicaoDestino.posicionar();
		validacaoPosicaoOrigem(origem);
		validacaoPosicaoDestino(origem, destino);
		Peca capturePeca = fazerMover(origem, destino);
		return (PecaDeXadrez)capturePeca;
	}
	
	private Peca fazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removePeca(origem);
		Peca capturePeca = tabuleiro.removePeca(destino);
		tabuleiro.colocarPeca(p, destino);
		return capturePeca;
	}
	
	private void validacaoPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.temPecaNaPosicao(posicao)) {
			throw new XadrezException("Nao existe peca na posicao de origem");
		}
		if (!tabuleiro.peca(posicao).temPeloMenosUmMovimento()) {
			throw new XadrezException("Nao existe movimento possivel para a peca escolhida");
		}
	}
	
	private void validacaoPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).possivelMovimento(destino)) {
			throw new XadrezException("A peca escolhida, nao pode se mover para a posicao de destino");
		}
	}
	
	private void coloqueUmaNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.colocarPeca(peca, new XadrezPosicao(coluna, linha).posicionar());
	}
	
	private void initialSetup() {				                                    // metodo p /colocar as peças no tabuleiro
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
