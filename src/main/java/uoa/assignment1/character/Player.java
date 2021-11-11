package uoa.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{
    
    // Defines a random object 
    Random rand = new Random();

    // Player constructor class
	public Player(String name) {
		super(name);
	}

	// If monster is hit uses successfulDefense to decide if player looses 50 from its health
	public void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
            character.setHealth(character.getHealth() - 50);
            System.out.println("!!HIT!! Player successfully attacked " + character.sayName());
            return;
        }
        System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from Player");
	}

	// Decides if monster has a successful defense with a 30/70 chance
	public boolean successfulDefense() {
        if(rand.nextInt(10) <= 7){
            return false;
        }
		return true;
	}

}
