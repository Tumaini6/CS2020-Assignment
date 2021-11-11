package uoa.assignment1.game;

import java.util.Scanner;

import uoa.assignment1.character.GameCharacter;
import uoa.assignment1.character.Player;
import uoa.assignment1.character.Monster;

public class GameLogic {

    //Decides which move function to run
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
    
    //Moves the character right
    private static void moveRight(GameCharacter character, Map gameMap){
        //Checks if that the character is not on the right edge of the map
        if(character.column < (gameMap.layout[character.row].length - 1)){
            //Saves what the characters icon is
            String character_icon = gameMap.layout[character.row][character.column];
            //If the position to the right does not have another character in it move right
            if(gameMap.layout[character.row][character.column + 1] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.column += 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } 
            //If a player tries to move into a monster, player attacks monster
            else if(gameMap.layout[character.row][character.column + 1] == "%" && character_icon == "*"){
                //Loops through monsters to find correct monster to attack
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row && gameMap.characters[x].column == character.column + 1){
                        character.hurtCharacter(gameMap.characters[x]);
                        //If the monster's health drops to 0 change their icon to show they are dead
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } 
            //If player tries to move into a dead monster displays appropriate message
            else if(gameMap.layout[character.row][character.column + 1] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } 
            //If monster tries to move into a player, attacks player
            else if(gameMap.layout[character.row][character.column + 1] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } 
            //If monster tries to move into another monster displays appropriate message
            else if(gameMap.layout[character.row][character.column + 1] == "%" && character_icon == "%"){
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go right. You lose a move.");
        }
        
    }
    
    //Moves the character left
    private static void moveLeft(GameCharacter character, Map gameMap){
        //Checks if that the character is not on the left edge of the map
        if(character.column > 0){
            //Saves what the characters icon is
            String character_icon = gameMap.layout[character.row][character.column];
            //If the position to the left does not have another character in it move left
            if(gameMap.layout[character.row][character.column - 1] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.column -= 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } 
            //If a player tries to move into a monster, player attacks monster
            else if(gameMap.layout[character.row][character.column - 1] == "%" && character_icon == "*"){
                //Loops through monsters to find correct monster to attack
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row && gameMap.characters[x].column == character.column - 1){
                        character.hurtCharacter(gameMap.characters[x]);
                        //If the monster's health drops to 0 change their icon to show they are dead
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } 
            //If player tries to move into a dead monster displays appropriate message
            else if(gameMap.layout[character.row][character.column - 1] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } 
            //If monster tries to move into a player, attacks player
            else if(gameMap.layout[character.row][character.column - 1] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } 
            //If monster tries to move into another monster displays appropriate message
            else if(gameMap.layout[character.row][character.column - 1] == "%" && character_icon == "%"){
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go left. You lose a move.");
        }
        
    }
    
    //Moves the character up
    private static void moveUp(GameCharacter character, Map gameMap){
        //Checks if that the character is not on the top edge of the map
        if(character.row > 0){
            //Saves what the characters icon is
            String character_icon = gameMap.layout[character.row][character.column];
            //If the position above does not have another character in it move up
            if(gameMap.layout[character.row - 1][character.column] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.row -= 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } 
            //If a player tries to move into a monster, player attacks monster
            else if (gameMap.layout[character.row - 1][character.column] == "%" && character_icon == "*"){
                //Loops through monsters to find correct monster to attack
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row - 1 && gameMap.characters[x].column == character.column){
                        character.hurtCharacter(gameMap.characters[x]);
                        //If the monster's health drops to 0 change their icon to show they are dead
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } 
            //If player tries to move into a dead monster displays appropriate message
            else if(gameMap.layout[character.row - 1][character.column] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } 
            //If monster tries to move into a player, attacks player
            else if(gameMap.layout[character.row - 1][character.column] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } 
            //If monster tries to move into another monster displays appropriate message
            else if(gameMap.layout[character.row - 1][character.column] == "%" && character_icon == "%"){
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go up. You lose a move.");
        }
    }
    //Moves the character down
    private static void moveDown(GameCharacter character, Map gameMap){
        //Checks if that the character is not on the bottom edge of the map
        if(character.row < gameMap.layout.length - 1){
            //Saves what the characters icon is
            String character_icon = gameMap.layout[character.row][character.column];
            //If the position above does not have another character in it move up
            if(gameMap.layout[character.row + 1][character.column] == "."){
                gameMap.layout[character.row][character.column] = ".";
                character.row += 1;
                gameMap.layout[character.row][character.column] = character_icon;
            } 
            //If a player tries to move into a monster, player attacks monster
            else if (gameMap.layout[character.row + 1][character.column] == "%" && character_icon == "*"){
                //Loops through monsters to find correct monster to attack
                for(int x=1; x<gameMap.characters.length;x++){
                    if(gameMap.characters[x].row == character.row + 1 && gameMap.characters[x].column == character.column){
                        character.hurtCharacter(gameMap.characters[x]);
                        //If the monster's health drops to 0 change their icon to show they are dead
                        if(gameMap.characters[x].getHealth() == 0){
                            gameMap.layout[gameMap.characters[x].row][gameMap.characters[x].column] = "x";
                        }
                    }
                }
            } 
            //If player tries to move into a dead monster displays appropriate message
            else if(gameMap.layout[character.row + 1][character.column] == "x" && character_icon == "*"){
                System.out.println("“Character already dead");
            } 
            //If monster tries to move into a player, attacks player
            else if(gameMap.layout[character.row + 1][character.column] == "*" && character_icon == "%"){
                character.hurtCharacter(gameMap.characters[0]);
            } 
            //If monster tries to move into another monster displays appropriate message
            else if(gameMap.layout[character.row + 1][character.column] == "%" && character_icon == "%"){
                System.out.println("Monster already there so can't move");
            }
        }
        else{
            System.out.println("You can't go down. You lose a move.");
        }
        
    }
	
}
