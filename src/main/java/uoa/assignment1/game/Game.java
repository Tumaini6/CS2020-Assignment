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
        map = getMap();
        gamelogic.moveCharacter(input, map, map.characters[0]);
        System.out.println("Player is moving " + input);
        
        
        for(int i=1; i<4; i++){
            Monster monster = (Monster) map.characters[i];
            if(monster.getHealth() > 0){
                String move = monster.decideMove();
                gamelogic.moveCharacter(move, map, monster);
                System.out.println("Monster" + i + " is moving " + move);
            }
            
        }
        return true;
    }
   
}