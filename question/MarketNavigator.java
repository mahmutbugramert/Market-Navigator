
package question;

import java.io.*;
import java.util.*;

public class MarketNavigator
{  
	
	private static final String String = null;

	/* Method that gives the distance between two points */
	public static double distanceFinder(int x1, int y1, int x2, int y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

	public static int pathFinder(String filename) {
		
		/* Find the smallestTotalDistance */
		double smallestTotalDistance = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		ArrayList<House> houses = new ArrayList<>();  // Arraylist of house objects
		try {  // it reads file and adds objects to the arraylist here

			FileInputStream fileInput = new FileInputStream(filename);       
			Scanner sc=new Scanner(fileInput);  

			while(sc.hasNextLine()) { 
				
				String line = sc.nextLine();				
				String houseNameAndCoordinates = line;
				String[] partsOf = houseNameAndCoordinates.split(" ");
				String namePart = partsOf[0];
				String xPart = partsOf[1];
				String yPart = partsOf[2];

				int xCoordinate = Integer.valueOf(xPart);
				int yCoordinate = Integer.valueOf(yPart);
				
				House house = new House(namePart, xCoordinate, yCoordinate);
				houses.add(house);
				
			}  
			sc.close();      
		}  
		catch(IOException e) {  
			
			e.printStackTrace();  
		} 
			
		ArrayList<String> houseNamesList = new ArrayList<>();
		
		for(int i = 0; i < houses.size(); i++) {  // this loop separates the houses from Migros and add them into an arraylist
			if (houses.get(i).getName().length() == 1) {
				houseNamesList.add(houses.get(i).getName());
			}
			 
		}
		String houseNamesListString = java.lang.String.join("", houseNamesList); // this makes the arraylist a string

        int n = houseNamesListString.length();

        double	finalSum = 0;
        double temporarySum = 0;
        int index1 = 0;
        int index2 = 0;
        for (String eachPermutation : permute(houseNamesListString, 0, n-1)) { // this loop calculates path's distance and assign it to finalSum
        	
        	for (int b = 0 ; b < houses.size() ; b++) { // this loop calculates the distance between the Migros and the first house and add it to temporarySum
        		char permu = houses.get(b).getName().charAt(0);
        		if (permu == eachPermutation.charAt(0) && houses.get(b).getName().length() == 1 ) {
        			temporarySum = temporarySum + distanceFinder(houses.get(0).getX(), houses.get(0).getY(), houses.get(b).getX(), houses.get(b).getY());
        			break;
        		}
        		else {
        			continue;
        		}
								
			}
        	
        	for (int k = 0 ; k < houses.size() - 1 ; k++) { // this loop calculates the distance between two consecutive houses and add it to temporarySum
        		for(int g = 0 ; g < houses.size() ; g++) {	

					char termu = houses.get(g).getName().charAt(0); 
					
					if (termu == eachPermutation.charAt(k) && houses.get(g).getName().length() == 1) {
	        			index1 = g;
	        		}
        		}	
				for (int r = 0 ; r < houses.size() ; r++) {
        			if (k == houses.size() - 2) {
						continue;
					}						 
					char termu2 = houses.get(r).getName().charAt(0);	        		
	        		if (termu2 == eachPermutation.charAt(k+1) && houses.get(r).getName().length() == 1) {
	        			index2 = r;

	        		}	
				}

        		temporarySum = temporarySum + distanceFinder(houses.get(index1).getX(), houses.get(index1).getY(), houses.get(index2).getX(), houses.get(index2).getY());        			
        			        	        		
	        }
        	// adds the distance between the last house and the Migros to temporarySum
        	temporarySum = temporarySum + distanceFinder(houses.get(index2).getX(), houses.get(index2).getY(), houses.get(0).getX(), houses.get(0).getY()); 
        	
        	if( finalSum == 0 ) {
        		finalSum = temporarySum;
        		temporarySum = 0;
        	}	
        	else if ( finalSum > temporarySum) {
        		finalSum = temporarySum;
        		temporarySum = 0;       	
        	}
        	else {
        		temporarySum = 0;
        	}
	    }
        smallestTotalDistance = finalSum;
        
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		int roundedValue = (int) Math.round(smallestTotalDistance);
		return roundedValue;
		
	}

	public static void main(String[] args) {
		
		/* This part is for you to test your method, no points will be given from here */
		String path = MarketNavigator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + ".." + File.separator+"coordinates.txt";
		int distance = pathFinder(path);
		System.out.println("Smallest distance:" + distance);
		
	}

    private static ArrayList<String> permute(String str, int l, int r){ // this 2 methods permutate the houses' names
      	
        if (l == r) {
        	permutationList.add(str);        	
        }	
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    	return permutationList;
    }
 
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return java.lang.String.valueOf(charArray);
    }
    
    public static ArrayList<String> permutationList = new ArrayList<String>();
}   


