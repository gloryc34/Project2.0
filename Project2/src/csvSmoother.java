/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvSmoother {
	/**
	 * Smoothes the y values in a csv file, can be done multiple times to get better results
	 * @param fName or file
	 * @return the newly created smoothed csv file
	 */
	public static void smoother(String fName) throws FileNotFoundException{
		//initialize print writer and tempAvg
		PrintWriter writer=null;
		int tempAvg;
		//try statement to read a file, change data, then write to a new file while being tested for errors
		 try {
	            // Read input CSV file
	            Scanner scanner = new Scanner(new File("smootherOutput2.csv"));
	            //Initialize lists for x and y values
	            List<Integer> xList = new ArrayList<>();
	            List<Integer> yList = new ArrayList<>();
	            //iterates through the csv file, then adds x and y values to sep lists
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] parts = line.split(",");
	                int x = Integer.parseInt(parts[0]);
	                int y = Integer.parseInt(parts[1]);
	                xList.add(x);
	                yList.add(y);
	            }
	            scanner.close();
	            //Smoothes the data. It takes the current element and finds the average with itself, number infront, and the number behind to give itself
	            //a new value
	            for (int i = 0; i < xList.size(); i++) {
	            	//case for when the index is 0
	            	if(i==0) {
	            		tempAvg = ((yList.get(i+2)+yList.get(i)+yList.get(i+1))/3);
	            		yList.set(i, tempAvg);
	            	}
	            	//case for when index is 102
	            	if(i==102) {
	            		tempAvg = ((yList.get(i-1)+yList.get(i)+yList.get(i-2))/3);
		            	yList.set(i, tempAvg);
	            	}
	            	//case for everything else
	            	if(i>0) {
	            		if(i<101) {
	            			tempAvg = ((yList.get(i-1)+yList.get(i)+yList.get(i+1))/3);
			            	yList.set(i, tempAvg);
	            		}
	            	}
	            
	            }
	            //new file creation
	            writer = new PrintWriter(new File("smootherOutput3.csv"));
	            //write new values to csv
	            for (int i = 0; i < xList.size(); i++) {
	                writer.println(xList.get(i) + "," + yList.get(i));
	            }
	            
	            writer.close();
	            System.out.println("Successfully read and wrote CSV file.");
	    
		 		}finally{
		 			
		 		}
}
}