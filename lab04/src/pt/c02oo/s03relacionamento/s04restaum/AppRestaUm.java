package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null, null);
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();
      
      char board[][] = {
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	         {'P', 'P', 'P', '-', 'P', 'P', 'P'},
    	         {'P', 'P', 'P', 'P', 'P', 'P', 'P'},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '},
    	         {' ', ' ', 'P', 'P', 'P', ' ', ' '}
    	      };
      
      Tabuleiro objTabu = new Tabuleiro(board);
      
      
      tk.writeBoard("Tabuleiro inicial", board);
      
      for (int l = 0; l < commands.length; l++) {
          char[] charCommands = commands[l].toCharArray();
          
          objTabu.movimenta(charCommands); //talvez chamaer o metodo da peca pra movimentar
          
          
          tk.writeBoard("source: " + charCommands[0] + charCommands[1] + ";" + " target: " + charCommands[3] + charCommands[4],
          objTabu.apresenta());
          
      }
      
   
      
     
       
      tk.stop();
   }
   
   //preciso enviar uma matriz de char para a whiteboard
   //
   //o tabuleiro recebe a ordem de mudar a peca, ai ele chama a peca e la dentro vai ter um metodo para o tabuleiro mudar a peca.
   
   //o objeto tabuleiro deve ter uma matriz de pecas
   
   //o objeto deve ter a char board, e uma outra matriz de pecas
   
   
   //peca tem q julgar se pode se mover ou n, isso pode ser feito com base em parametros passdos pelo tabuleiro ou a peca 
   //pergunta pro tabuleiro
  

}