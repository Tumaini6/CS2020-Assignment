package uoa.assignment1.game;

import uoa.assignment1.character.Monster;
import uoa.assignment1.game.GameLogic;

public class Game {
    
    private Map map;
    private GameLogic gamelogic = new GameLogic();
    
    Game (int height, int width) {
        
        map = new Map(height, width);
        map.printLayout();
    }
    			
    public Map getMap() {
        return map;
    }
    
    public boolean nextRound (String input) {
        // moves player and displays the move to console
        gamelogic.moveCharacter(input, map, map.characters[0]);
        System.out.println("Player is moving " + input);
        
        // moves monsters, displays the moves to console and checks how many monsters are still alive
        int monstersAlive = 0;
        for(int i=1; i<4; i++){
            Monster monster = (Monster) map.characters[i];
            if(monster.getHealth() > 0){
                String move = monster.decideMove();
                gamelogic.moveCharacter(move, map, monster);
                System.out.println("Monster" + i + " is moving " + move);
                monstersAlive +=1;
            }
            
        }
        
//         Displays the health of the monsters and player
        for(int i= 0; i < map.characters.length; i++){
                System.out.println("Health " + map.characters[i].sayName() + ":  " + map.characters[i].getHealth());
            }
        // If there are 0 monsters left a live displays winning message and return true, ending the game
        System.out.println();
        if(monstersAlive == 0){
            System.out.println("YOU HAVE WON!");
            return true;
        }
        // If player health reaches 0 displays loosing message and return true, ending the game
        if(map.characters[0].getHealth() <= 0){
            System.out.println("YOU HAVE DIED!");
            return true;
            }
        return false;
        
    }
   
}