// Zachary Amar
// 260 713 997

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tamagotchi {
	
    // static attributes
    
	private static final double MAX_ENERGY = 10;
    private static Random r = new Random();
    
    //Extra attributes
    
    private String tamName;
    private int tamLevel;
    private double tamEnergy;
    private int tamXp;
    private int tamMealsConsumed;
    private ArrayList<Toy> tamToys;
    
    //Constructors
    
		//Constructor 1 -  takes the inputs
    
    public Tamagotchi (String name, int lvl, double energy, int xp, int meals, ArrayList<Toy> toys) {
    	
    	//Set values for the attributes
    	this.tamName = name;
    	this.tamLevel = lvl;
    	this.tamEnergy = energy;
    	this.tamXp = xp;
    	this.tamMealsConsumed = meals;
    	this.tamToys = toys;
    	
    }
    
		//Constructor 2 -  takes no inputs
    
    public Tamagotchi (String name) {
    	
    	//Set values for the attributes
    	this.tamName = name;
    	this.tamLevel = 1;
    	this.tamEnergy = MAX_ENERGY;
    	this.tamXp = 0;
    	this.tamMealsConsumed = 0;
    	
    	//Create an ArrayList and a toy
		Toy t = new Toy();
		ArrayList<Toy> toys = new ArrayList<Toy>();
		toys.add(t);
		
		//Initialize the list
    	this.tamToys = toys;
    	
    }
    
    //Get methods
    
    public String getName() {
    	
    	return this.tamName;
    	
    }
    
    public int getLevel() {
    	
    	return this.tamLevel;
    	
    }
    
    public double getEnergy() {
    	
    	return this.tamEnergy;
    	
    }
    
    public int getXp() {
    	
    	return this.tamXp;
    	
    }
    
    public int getNumOfMeals() {
    	
    	return this.tamMealsConsumed;
    	
    }
    
    public ArrayList<Toy> getToys() {
    	
    	//Copy the toys in another array
    	ArrayList<Toy> copy = this.tamToys;
    	
    	return copy;
    	
    }
    
    //Other Methods
    
    private void levelUp () {
   	
    	if (this.tamXp >= (50*this.tamLevel*(this.tamLevel + 1))/2) {
    		
    		//Increase level and reset meals
    		this.tamLevel++;
    		this.tamMealsConsumed = 0;
    		
    		//Print out beginning info
    		System.out.println("*** YAY, time to level up!! ***");
    		System.out.println(this.tamName + " is now level " + this.tamLevel);
    		
    		//Create new toy and add it to the list
    		Toy t = new Toy();
    		tamToys.add(t);
    		
    		System.out.println("Your new toy is " + t);
    		
    	}
    	
    }
    
    public void play (int mode) {
    	
    	if (this.tamToys.size() == 0 || this.tamEnergy < 2 ) {
    		
    		throw new IllegalStateException ("You tamagotchi cannot play right now ...");
    		
    	} else {
    		
    		if (mode == 1) {
    			
    			//Determine the toy to play with 
    			Toy toyPlayedWith = Toy.findBestToy(this.tamToys);
    			
    			//Adjust the XP gained
    			int xPGained = toyPlayedWith.getXp();
    			this.tamXp = this.tamXp + xPGained;
    			
    			//Adjust the energy
    			double energyUsed = ((xPGained/20.0))+(r.nextDouble())*0.5;
    			this.tamEnergy = this.tamEnergy-energyUsed;
    			
    			//Print out the display message
    			System.out.println(this.tamName + " played with " + toyPlayedWith + " and earned " + xPGained + " xp.");
    			System.out.println(this.tamName + " has now " + this.tamXp + " and  " + this.tamEnergy + " energy.");
    			
        		levelUp();

    			
    		}
    		
    		if (mode == 2) {
    			
    			//Get random number
    			int toyNumber = r.nextInt(this.tamToys.size());
    			
    			//Determine the toy to play with 
    			Toy toyPlayedWith = this.tamToys.get(toyNumber);
    			
    			//Adjust the XP gained
    			int xPGained = toyPlayedWith.getXp();
    			this.tamXp = this.tamXp + xPGained;
    			
    			//Adjust the energy
    			double energyUsed = ((xPGained/20.0))+(r.nextDouble())*0.5;
    			this.tamEnergy = this.tamEnergy-energyUsed;
    			
    			//Print out the display message
    			System.out.println(this.tamName + " played with " + toyPlayedWith + " and earned " + xPGained + " xp.");
    			System.out.println(this.tamName + " has now " + this.tamXp + " xp and  " + this.tamEnergy + " energy.");

    			levelUp();

    			
    		}
    		
    		
    	}
    	
    }
    
    public void feed () {
    	
    	//Check if he an eat
    	if (this.tamEnergy < 1 || this.tamMealsConsumed >= 2*this.tamLevel) {
    		
    		throw new IllegalStateException ("You tamagotchi cannot eat right now ...");
    		
    	} else {
    		
    		//Create random attributes
    		double energyGainned = r.nextDouble()/2.0;
    		int xpGainned = r.nextInt(4);
    		
    		//Update attributes
    		this.tamEnergy = this.tamEnergy + energyGainned;
    		this.tamXp = this.tamXp + xpGainned;
    		this.tamMealsConsumed++;
    		
    		//Print out new info
    		System.out.println("Nom nom nom");
    		System.out.println(this.tamName + " has now " + this.tamXp + " xp and " + this.tamEnergy + " energy.");
    		
    	}
    	
    }
    
    public void sleep () {
    	
    	//Print out the statement and reset energy
		System.out.println(this.tamName + " is going to take a nap now");
		this.tamEnergy = MAX_ENERGY;
    	
    }
    
    public String toString () {
    	
    	//Join all the info in a string and return it
    	String info = "Name:\t" + this.tamName + "\nLevel:\t" + this.tamLevel+ "\nEnergy:\t" + this.tamEnergy + "\nXP: \t" + this.tamXp + "\nMeals:\t" + this.tamMealsConsumed + "\nToys:\t" + this.tamToys;
    	return info;
    	
    }


}
