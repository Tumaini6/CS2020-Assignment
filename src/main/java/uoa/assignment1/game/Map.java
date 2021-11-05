package uoa.assignment1.game;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Monster;
import uoa.assignment1.character.Player;

public class Map {

public String [][] layout;
public GameCharacter[] characters = new GameCharacter[4];
 
  Map (int height, int width) {
	 layout = new String[height][width];
     initialiseArray();
     
//      Initialize game characters
     Player player = new Player("player");
     Monster monster1 = new Monster("monster1");
     Monster monster2 = new Monster("monster2");
     Monster monster3 = new Monster("monster3");
      
//      Set character's positions
     player.row = height - 1;
     player.column = width - 1;
     
     monster1.row = 0;
     monster1.column = width - 1;
      
     monster2.row = height - 1;
     monster2.column = 0;
      
     monster3.row = 0;
     monster3.column = 0;
      
//      Add game characters to characters array
     characters[0] = player;
     characters[1] = monster1;
     characters[2] = monster2;
     characters[3] = monster3;
      
//      Store monsters and player positions in the layout array
     layout[player.row][player.column] = "*";
     layout[monster1.row][monster1.column] = "%";
     layout[monster2.row][monster2.column] = "%";
     layout[monster3.row][monster3.column] = "%";
     
  }
 
  public void printLayout() {
	for (String [] row : layout) {
          for (String cell : row) {
              System.out.print(cell);
          }
      }
   }
    
  private void  initialiseArray(){
      for (int row = 0; row < layout.length; row++) {
          for (int col = 0; col < layout[row].length; col++) {
              layout[row][col] = ".";
          }
      }
  }
}

