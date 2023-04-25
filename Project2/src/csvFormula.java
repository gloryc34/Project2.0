import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class csvFormula {
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		csv test = new csv();
		int result = test.formula();
		System.out.println(result);
		
	}*/
	public static void main(String[] args) {
		
        String csvFile = "output.csv";
        FileWriter writer = null;

        try {
        	
            writer = new FileWriter(csvFile);
            writer.append("x");
            writer.append(",");
            writer.append("y");            
            writer.append("\n");

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
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error closing writer: " + e);
            }
        }
    }
}