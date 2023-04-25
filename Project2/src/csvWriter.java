/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvWriter {
	/**
	 * Writing the x and y values of the function y=x^2+2x+1 to a csv file
	 * @param fName or file
	 * @return the newly created csv file
	 */
	public static void writer(String fName) throws FileNotFoundException{
		//Print Writer initialization
		PrintWriter writer=null;
		//csv file creation
		String csvFile = "writerOutput.csv";
		//try statement to iterate through x values and output the y's from an equation
		try {
        	
            writer = new PrintWriter(csvFile);
            writer.append("x");
            writer.append(",");
            writer.append("y");            
            writer.append("\n");
            //formula loop
            for (int x = 0; x <= 101; x++) {
            	
                int y = x*x + 2*x + 1;
                writer.append(String.valueOf(x));
                writer.append(",");
                writer.append(String.valueOf(y));
                writer.append("\n");
                
            }

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e);
        } finally {
            writer.flush();
			writer.close();
        }
		
	}
	
}
