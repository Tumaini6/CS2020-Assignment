package uoa.assignment1.game;

import uoa.assignment1.character.Monster;
import uoa.assignment1.game.GameLogic;

public class Game {
    
    Map map;
    GameLogic gamelogic = new GameLogic();
    
    Game (int height, int width) {
        
        map = new Map(height, width);
        map.printLayout();
    }
    			
    public Map getMap() {
        return map;
    }
    
    public boolean nextRound (String input) {
        gamelogic.moveCharacter(input, map, map.characters[0]);
        System.out.println("Player is moving " + input);
        
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
        
        for(int i= 0; i < map.characters.length; i++){
                System.out.println("Health " + map.characters[i].sayName() + ":  " + map.characters[i].getHealth());
            }
        System.out.println();
        if(monstersAlive == 0){
            System.out.println("YOU HAVE WON!");
            return true;
        }
        if(map.characters[0].getHealth() <= 0){
            System.out.println("YOU HAVE DIED!");
            return true;
            }
        return false;
        
    }
   
}