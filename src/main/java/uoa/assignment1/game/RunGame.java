package uoa.assignment1.game;

import java.util.Scanner;

public class RunGame {

	private static boolean gameOver = false;

	public static void main(String[] args) {
        Game game = new Game(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        int roundCounter = 1;
        while (!gameOver) {
			//complete the code
            
            System.out.println("Round " + roundCounter++);
            Scanner user_intput = new Scanner(System.in);
            String input = user_intput.nextLine();
            game.nextRound(input);
            
            
            
            
            
		}
	}

}
