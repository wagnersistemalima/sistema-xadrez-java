package jogoDeTabuleiro;

public class Peca {
	
	protected Posicao posicao;									// tipo simples da matriz, n�o pode ser visivel
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
