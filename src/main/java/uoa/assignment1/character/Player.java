package uoa.assignment1.character;

import java.util.Random;

public class Player extends GameCharacter{
    
    Random rand = new Random();

	public Player(String name) {
		super(name);
	}

	
	public
	void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
            character.setHealth(character.getHealth() - 50);
            System.out.println("!!HIT!! Player successfully attacked " + character.sayName());
            return;
        }
        System.out.println("!!MISS!! " + character.sayName() + " successfully defended attack from Player");
	}

	
	public
	boolean successfulDefense() {
        if(rand.nextInt(10) <= 7){
            return false;
        }
		return true;
	}

}
