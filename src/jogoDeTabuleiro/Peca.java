package jogoDeTabuleiro;

public abstract class Peca {
	
	protected Posicao posicao;									// tipo simples da matriz, não pode ser visivel
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {							// para criar uma peça eu tenho que informar o tabuleiro 
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] possivelMovimento();
	
	
	public boolean possivelMovimento(Posicao posicao) {
		return possivelMovimento()[posicao.getLinha()][posicao.getColuna()];
	}
	
	public boolean temPeloMenosUmMovimento() {
		boolean[][] mat = possivelMovimento();
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	

}
