package uoa.assignment1.character;

public abstract class GameCharacter {
    
    //Defines character name
	private String name ="";
	
    //Initialises character's health at 100
	private int health = 100; 
	
    //Defines character's position in the map
	public int row;
	public int column;
	
	
	public GameCharacter (String name) {
		//Sets character's name
        this.name = name;
	}
	
    
	public abstract void hurtCharacter (GameCharacter character);
	
	public abstract boolean successfulDefense ();
	
	//Returns the character's name
	public String sayName() {
	return this.name; 
	}

    //Returns the character's health
	public int getHealth() {
		return this.health;
	}

    //Sets the character's health to given value
	public void setHealth(int health) {
		//complete
        this.health = health;
	}
}

