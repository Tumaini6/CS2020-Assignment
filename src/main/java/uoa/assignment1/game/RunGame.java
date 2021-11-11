package uoa.assignment1.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
        Game game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        int roundCounter = 1;
        while (!gameOver) {
			//Displayes the current round number
            System.out.println("Round " + roundCounter++ + "\n");
            
            //Gets a console input from the user
            Scanner user_intput = new Scanner(System.in);
            String input = user_intput.nextLine();
            
            //If game ending requirements are met sets game over to True ending the while loop
            gameOver = game.nextRound(input);
            
            //Displayes the game map to the console
            game.getMap().printLayout();
            
            
		}
	}

}
