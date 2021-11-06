package uoa.assignment1.game;

import java.util.Scanner;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		switch (input){
            case "up":
                moveUp(character, gameMap);
                break;
            case "down":
                moveDown(character, gameMap);
                break;
            case "left":
                moveLeft(character, gameMap);
                break;
            case "right":
                moveRight(character, gameMap);
                break;
            default:
                System.out.println("Use only keywords up, down, left, right");
        }
	}
    
    private static void moveRight(GameCharacter character, Map gameMap){
        if(character.column < (gameMap.layout[character.row].length - 1)){
            String character_icon = gameMap.layout[character.row][character.column];
            gameMap.layout[character.row][character.column] = ".";
            character.column += 1;
            gameMap.layout[character.row][character.column] = character_icon;
        }
        
    }
    
    private static void moveLeft(GameCharacter character, Map gameMap){
        if(character.column > 0){
            String character_icon = gameMap.layout[character.row][character.column];
            gameMap.layout[character.row][character.column] = ".";
            character.column -= 1;
            gameMap.layout[character.row][character.column] = character_icon;
        }
        
    }
    
    private static void moveUp(GameCharacter character, Map gameMap){
        if(character.row > 0){
            String character_icon = gameMap.layout[character.row][character.column];
            gameMap.layout[character.row][character.column] = ".";
            character.row -= 1;
            gameMap.layout[character.row][character.column] = character_icon;
        }
        
    }
    
    private static void moveDown(GameCharacter character, Map gameMap){
        if(character.row < gameMap.layout.length - 1){
            String character_icon = gameMap.layout[character.row][character.column];
            gameMap.layout[character.row][character.column] = ".";
            character.row += 1;
            gameMap.layout[character.row][character.column] = character_icon;
        }
        
    }
	
}
