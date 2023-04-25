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
/**
 * Goes through a csv file then salts the data
 */
public class csvSalter {
	
	/**
	 * Salts the y values in a csv file
	 * @param fName or file
	 * @return the newly created salted csv file
	 */
	public static void salter(String fName) throws FileNotFoundException{
		//initialize PrintWriter
		PrintWriter writer=null;
		//try statement to read a file, change data, then write to a new file while being tested for errors
		 try {
	            // Read input CSV file
	            Scanner scanner = new Scanner(new File("output.csv"));
	            //initialize lists for x and y values
	            List<Integer> xList = new ArrayList<>();
	            List<Integer> yList = new ArrayList<>();
	            //going through the file and parsing the x and y values to sep arrays
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine();
	                String[] parts = line.split(",");
	                int x = Integer.parseInt(parts[0]);
	                int y = Integer.parseInt(parts[1]);
	                xList.add(x);
	                yList.add(y);
	            }
	            scanner.close();
	            //salting the data. I decided to use two salt values to salt the data even more. If even, plus 100; else, -200
	            for (int i = 0; i < yList.size(); i++) {
	            	if(yList.get(i)%2==0) {
	            		yList.set(i, yList.get(i) + 100);
	            	}
	            	
	            	else {
	            		yList.set(i, yList.get(i) - 200);
	            	}
	                
	            }
	            //initialize new csv then write to it
	            writer = new PrintWriter(new File("salterOutput.csv"));
	            for (int i = 0; i < xList.size(); i++) {
	                writer.println(xList.get(i) + "," + yList.get(i));
	            }
	            //close writer
	            writer.close();
	            System.out.println("Successfully read and wrote CSV file.");
	    
		 		}finally{
		 			writer.close();
		 		}
}
	
}
