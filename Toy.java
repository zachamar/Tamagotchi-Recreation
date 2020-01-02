// Zachary Amar
// 260 713 997

import java.util.ArrayList;
import java.util.Random;

public class Toy {
	
    // static attributes
    private static String[] names = {"Bob", "Penny", "Fisher", "Snoopy", "Garfield", "Mary", "Chuchu", "Trooper", "Lovebug", "Bella"};
    private static String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
    private static String[] types = {"car", "doll", "stuffed cat", "train", "ball", "kite", "teddy bear", "trike"};
    
    private static Random r = new Random();
    
    //Non Static Attributes
    private String name;
    private String color;
    private String type;
    private int xp;
    
    // private static methods provided
    private static String getRandomName() {
        int i = r.nextInt(names.length);
        return names[i];
    }
    
    private static String getRandomColor() {
        int i = r.nextInt(colors.length);
        return colors[i];
    }
    
    private static String getRandomType() {
        int i = r.nextInt(types.length);
        return types[i];
    }
    
    //Constructors
    
    	//Constructor 1 -  takes the inputs
    
    public Toy (String name, String color, String type, int xp) {
    	
    	//Set the attributes
    	this.name = name;
    	this.color = color;
    	this.type = type;
    	this.xp = xp;
    	
    }
    
		//Constructor 2 -  takes no inputs
	    
	public Toy () {
		
		this.name = getRandomName();
		this.color = getRandomColor();
		this.type = getRandomType();
		this.xp = r.nextInt(15)+10;

	}
    
    //Get Methods
	
	public String getName () {
		
		return this.name;
		
	}
	
	public String getColor () {
		
		return this.color;
		
	}
	
	public String getType () {
		
		return this.type;
		
	}
	
	public int getXp () {
		
		return this.xp;
		
	}
	
	//To String Method
	
	public String toString () {
		
		return this.name + " the " + this.color + " " + this.type;
		
	}
    
    //Other methods
	
		//A method to create a new toy
	public static Toy createToy (String info) {
		
		//Create an array to store the split
		String[] newToy = info.split("\t");
		
		//Check if there are 4 attributes
		if(newToy.length == 4) {
			
			//Create a new Toy
			Toy createdToy = new Toy(newToy[0], newToy[1], newToy[2], Integer.parseInt(newToy[3]));
			
	    	return createdToy;
			
		} else {
			
			throw new IllegalArgumentException ("Make sure you have a name, color, type and xp separated by a tab in the input.");
			
		}
	
	}
	
		//A method to get the toy that gives the most xp
	public static Toy findBestToy (ArrayList<Toy> toys) {
		
		//Return null if the arraylist is empty
		if (toys.size() == 0) {
			
			return null;
			
		} else {
			
			//Create an array that will store the xps gainned
			int[] xps = new int[toys.size()];
			
			//Run through the array list and store the Xps
			for (int i = 0; i < toys.size(); i++) {
				
				xps[i] = toys.get(i).getXp();
				
			}
			
			//Create an int to store the max position and max xp
			int pos = 0;
			int maxXp = xps[0];

			//Loop though the xp array to find the max xp gainned and postion of it
			for (int i = 0; i < xps.length; i++) {
				
				if (xps[i] > maxXp) {
					
					maxXp = xps[i];
					pos = i;
					
				}
				
			}
			
			//Return the best toy
			return toys.get(pos);
			
		}
				
	}
}
