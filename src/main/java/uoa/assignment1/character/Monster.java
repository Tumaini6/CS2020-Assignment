package uoa.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {
    
    Random rand = new Random();

    // Monster contructor
	public  Monster(String name) {
		super(name);
	}

    // If monster is hit uses successfulDefense to decide if monster looses 20 from its health
	public void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
            character.setHealth(character.getHealth() - 20);
        }
	}


    // Decides if monster has a successful defense with a 50/50 chance
	public boolean successfulDefense() {
		if(rand.nextInt(2) == 0){
            return false;
        }
		  return true;
	}


	
	public String decideMove () {
		
		return "move";
	}

}
