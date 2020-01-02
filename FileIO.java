// Zachary Amar
// 260 713 997

import java.io.*;
import java.util.ArrayList;

public class FileIO {
	
	public static void main (String[] args) {

		
				
	}
	
	private static ArrayList<Toy> loadToys(String fileName) throws IOException {
		
		//Opening comments
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//Create the ArrayList before to access it after
		ArrayList<Toy> toys = new ArrayList<Toy>();
		
		try {

			//Code to read from file
			String current = br.readLine();
			
			//Run through it until it is null
			while (current != null) {
				
				//Create the toy
				toys.add(Toy.createToy(current));
				
				//Add it to the array
				current = br.readLine();

			}
			
		} catch (IllegalArgumentException e) {
        	
			System.out.println("This is not the correct format...");
        	
			ArrayList<Toy> emptyArray = new ArrayList<Toy>();
        	
			return emptyArray;
        } finally {
        	
        	//Always close the reader and buffer 
	        br.close();
	        fr.close();
        }
		
        return toys;
		
	}
	
	private static boolean saveToys(ArrayList<Toy> toys, String fileName) {
		
		try {
			
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (Toy c: toys) {
				
				//c is an element of the array
				bw.write(c.getName() +  "\t" + c.getColor() + "\t" + c.getType() + "\t" + c.getXp());
				bw.newLine();
				
			}
			
			bw.close();
			fw.close();
			
			return true;
			
		} catch (IOException e) {
			
			return false;
			
		}
		
	}

	
	public static Tamagotchi loadTamagotchi(String fileName)throws IOException {
		
		FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        
        //Read the first line
	    String tamName = br.readLine();
	    
	    //Cannot use a loop because it is different types
	    
	    int tamLevel = Integer.parseInt(br.readLine());
	    
	    double tamEnergy = Double.parseDouble(br.readLine());
	    
	    int tamXp = Integer.parseInt(br.readLine());
	    
	    int tamMealsConsumed = Integer.parseInt(br.readLine());
	    
	    String tamToys = br.readLine();
	    
	    //Get the toys of the tamagotchi
	    ArrayList<Toy> toys = loadToys(tamToys);
	    
	    //Create a Tamagotchi
        Tamagotchi t = new Tamagotchi(tamName, tamLevel, tamEnergy, tamXp, tamMealsConsumed, toys);
	    
        //Close the reader and buffer
	    br.close();
	    fr.close();
	    
	    //Return the tamagotchi
        return t;
	}
	
	public static boolean saveTamagotchi(Tamagotchi t, String fileName, String toyFile ) {
		
		try {
			
			//Create opening statements
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			
			//Save the values
            bw.write(t.getName()+"\n");
            
            bw.write(t.getLevel()+"\n");
            
            bw.write(t.getEnergy()+"\n");
            
            bw.write(t.getXp()+"\n");
            
            bw.write(t.getNumOfMeals()+"\n");
            
            saveToys(t.getToys(), toyFile);
            
            bw.write(toyFile);
            
            //Close the writer
			bw.close();
            fw.close();
            
            //Return true if everything went well
            return true;
		
		}
		
		catch(IOException e) {
			
			System.out.println("Something went wrong, we could not save the tamagotchi ...");
			
			return false;
		
		}
	}
	

}
