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
            if(gameMap.layout[character.row][character.column + 1] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.column += 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } else if(gameMap.layout[character.row][character.column + 1] == "%" && character_icon == "*"){
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row && gameMap.characters[x].column == character.column + 1){
                        character.hurtCharacter(gameMap.characters[x]);
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } else if(gameMap.layout[character.row][character.column + 1] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } else if(gameMap.layout[character.row][character.column + 1] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } else{
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go right. You lose a move.");
        }
        
    }
    
    private static void moveLeft(GameCharacter character, Map gameMap){
        if(character.column > 0){
            String character_icon = gameMap.layout[character.row][character.column];
            if(gameMap.layout[character.row][character.column - 1] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.column -= 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } else if(gameMap.layout[character.row][character.column - 1] == "%" && character_icon == "*"){
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row && gameMap.characters[x].column == character.column - 1){
                        character.hurtCharacter(gameMap.characters[x]);
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } else if(gameMap.layout[character.row][character.column - 1] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } else if(gameMap.layout[character.row][character.column - 1] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } else{
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go left. You lose a move.");
        }
        
    }
    
    private static void moveUp(GameCharacter character, Map gameMap){
        if(character.row > 0){
            String character_icon = gameMap.layout[character.row][character.column];
            if(gameMap.layout[character.row - 1][character.column] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.row -= 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } else if (gameMap.layout[character.row - 1][character.column] == "%" && character_icon == "*"){
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row - 1 && gameMap.characters[x].column == character.column){
                        character.hurtCharacter(gameMap.characters[x]);
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } else if(gameMap.layout[character.row - 1][character.column] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } else if(gameMap.layout[character.row - 1][character.column] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } else{
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go up. You lose a move.");
        }
    }
    
    private static void moveDown(GameCharacter character, Map gameMap){
        if(character.row < gameMap.layout.length - 1){
            String character_icon = gameMap.layout[character.row][character.column];
            if(gameMap.layout[character.row + 1][character.column] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.row += 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } else if (gameMap.layout[character.row + 1][character.column] == "%" && character_icon == "*"){
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row + 1 && gameMap.characters[x].column == character.column){
                        character.hurtCharacter(gameMap.characters[x]);
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } else if(gameMap.layout[character.row + 1][character.column] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } else if(gameMap.layout[character.row + 1][character.column] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } else{
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go down. You lose a move.");
        }
        
    }
	
}
