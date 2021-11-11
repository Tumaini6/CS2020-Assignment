package uoa.assignment1.character;

import java.util.Random;

public class Monster extends GameCharacter {
    
    // Defines a random object 
    Random rand = new Random();

    // Monster contructor class
	public  Monster(String name) {
		super(name);
	}

    // If monster is hit uses successfulDefense to decide if monster looses 20 from its health
	public void hurtCharacter(GameCharacter character) {
		if(!character.successfulDefense()) {
            character.setHealth(character.getHealth() - 20);
            System.out.println("!!HIT!! " + this.sayName() + " successfully attacked Player");
            return;
        }
        System.out.println("!!MISS!! Player successfully defended attack from " + this.sayName());
	}


    // Decides if monster has a successful defense with a 50/50 chance
	public boolean successfulDefense() {
		if(rand.nextInt(2) == 0){
            return false;
        }
		  return true;
	}


	// Randomly chooses a direction for the monster to move
	public String decideMove () {
        String move = "";
        switch(rand.nextInt(4)){
            case 0:
                move = "up";
                break;
            case 1:
                move = "down";
                break;
            case 2:
                move = "left";
                break;
            case 3:
                move = "right";
                break;
                
        }
		return move;
	}

}
