package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
	
	private char board[][];
	private Peca tabuleiro[][];
	
	public Tabuleiro(char board[][]) {
		this.board = board;
		for(int i = 0;i < 7; i++) {
			for(int j = 0; j < 7;j++) {
				this.tabuleiro[i][j] = new Peca(i, j);
			}
		}
	}
	
	public void conectaSe(Tabuleiro objTabu) {
		for(int i = 0;i < 7;i++) {
			for(int j = 0;j < 7;j++) {
				tabuleiro[i][j].conectaTabu(objTabu);
			}
		}
	}
	
	public void movimenta(char[] charCommands) {
		int lineOrigin = charCommands[0] - 48;  //se der problema pd ser aqui
		int columnOrigin = charCommands[1] - 97;
		int lineDestiny = charCommands[3] - 48;
		int columnDestiny = charCommands[4] - 97;
		
		if(lineOrigin >= 0 && lineOrigin < 7 && columnOrigin >= 0 && columnOrigin < 7
		&& lineDestiny >= 0 && lineDestiny < 7 && columnDestiny >= 0 && columnDestiny < 7) {
			tabuleiro[lineOrigin][columnOrigin].movimenta(lineDestiny, columnDestiny);
		}
		
	}
	public boolean podeIr(int lineDestiny, int columnDestiny, int lineOrigin, int columnOrigin) {
		if(tabuleiro[lineDestiny][columnDestiny].ehValida() && !tabuleiro[lineDestiny][columnDestiny].taViva()
				&& ((lineOrigin == lineDestiny && tabuleiro[lineOrigin][(columnDestiny+columnOrigin)/2].taViva()) ||
				   (columnOrigin == columnDestiny && tabuleiro[(lineOrigin+lineDestiny)/2][columnOrigin].taViva()))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void meMovimenta(int lineDestiny, int columnDestiny, int lineOrigin, int columnOrigin) {
	
		troca(lineOrigin, columnOrigin, lineDestiny, columnDestiny);
		enche(lineDestiny, columnDestiny);
		esvazia(lineOrigin, columnOrigin);
		
		if(lineOrigin == lineDestiny){
			tabuleiro[lineOrigin][(columnDestiny+columnOrigin)/2].esvazia();
		}
		if(columnOrigin == columnDestiny) {
			tabuleiro[(lineOrigin+lineDestiny)/2][columnOrigin].esvazia();
		}
	}
	
	public void troca(int lineOrigin, int columnOrigin, int lineDestiny, int columnDestiny) {
		Peca aux;
		
		tabuleiro[lineOrigin][columnOrigin].trocaPos(lineDestiny, columnDestiny);
		tabuleiro[lineDestiny][columnDestiny].trocaPos(lineOrigin, columnOrigin);
		
		aux = tabuleiro[lineOrigin][columnOrigin];
		tabuleiro[lineOrigin][columnOrigin] = tabuleiro[lineDestiny][columnDestiny];
		tabuleiro[lineDestiny][columnDestiny] = aux;
	}
	
	public void esvazia(int i, int j) { 
		board[i][j] = '-';
	}
	
	public void enche(int i, int j) {
		board[i][j] = 'P';
	}
	
	public char[][] apresenta() {
		return board;
	}
	
}
