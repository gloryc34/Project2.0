import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class DescriptiveStats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Get a DescriptiveStatistics instance
		double[] inputArrayX = new double[101];
		double[] inputArrayY = new double[101];
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// Add the data from the array
		for( int x = 0; x < 100; x++) {
			int y = x*x + 2*x + 1;
		    //stats.addValue(inputArray[x]=Math.random());
			stats.addValue(inputArrayX[x]=x);
		}
		
		// Add the data from the array
		for( int x = 0; x < 101; x++) {
			int y = x*x + 2*x + 1;
				 //stats.addValue(inputArray[x]=Math.random());
			stats.addValue(inputArrayY[y]=y);
				}
		// Compute some statistics
		/*
		double mean = stats.getMean();
		double std = stats.getStandardDeviation();
		double median = stats.getPercentile(50);
		System.out.println(Arrays.toString(inputArray));
		System.out.println(mean);
		System.out.println(std);
		System.out.println(median);
		*/
		System.out.println(Arrays.toString(inputArrayX));
		System.out.println(Arrays.toString(inputArrayY));
	}

}
