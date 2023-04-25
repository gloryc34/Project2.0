import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.awt.BasicStroke;
import java.awt.Color;

import org.apache.commons.math3.analysis.function.Pow;
import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * Generated ideas and got information from: https://commons.apache.org/proper/commons-math/  https://www.jfree.org/jfreechart/  https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm  https://www.youtube.com/watch?v=MifbwoCumX0&t=402s
 * Followed tutorial to graph from https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
 */
public class smoothFunction extends ApplicationFrame {
	/**
	 * JFreeChart creation
	 * @param applicationTitle and chartTitle
	 */
	public smoothFunction( String applicationTitle, String chartTitle ){
		
	      super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(
	         chartTitle ,"x" ,"y" ,createDataset() ,PlotOrientation.VERTICAL ,true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      final XYPlot plot = xylineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.DARK_GRAY );
	      
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      
	      plot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	      
	   }
	/**
	 * Dataset creation  of y=x^2, but the data
	 * @return the new dataset filled with values
	 */
	public static XYSeriesCollection createDataset() {
		
		final XYSeries data = new XYSeries( "Function" ); 
		
		Power power = new Power(2); // Construct a Power function with exponent 2

		double[] x = new double[101]; // Build an array for holding the values of x

		double[] y = new double[101]; // Hold the y values in an array

		// now using the for loop
		for (int a = 0; a <= 100; a++) {
			
			x[a] = a;

			y[a] = power.value(a);

		}
		
		//salt values
        for (int i = 0; i < y.length; i++) {
        	
            if (i % 2 == 0) {
                // Add 100 to even y values
                y[i] += 60;
                
            } 
            
            else {
            	
                // Subtract 200 from odd y values
                y[i] -= 60;
                
            }
        }
		
		double[] rollingMeans = new double[101];
		// 10-point rolling window
		DescriptiveStatistics stats = new DescriptiveStatistics(10); 
		//rolling mean throughout y values
		for (int i = 0; i <= 100; i++) {
			//changing y to the rolling mean
		    stats.addValue(y[i]);
		    rollingMeans[i] = stats.getMean();
		    
		}
		
		for (int i = 0; i <= 100; i++) {
			//adding data to dataset
        	data.add(x[i],rollingMeans[i]);
      }  
		
		final XYSeriesCollection dataset = new XYSeriesCollection( );          
	    dataset.addSeries( data);          
	     
	    return dataset;
	     
	}
	
	/**
	 * Used to see the array results, does not affect the above methods
	 * @return the new dataset filled with values
	 */
	public static void generateData() {
		Power power = new Power(2); // Construct a Power function with exponent 2

		double[] x = new double[101]; // Build an array for holding the values of x

		double[] y = new double[101]; // Hold the y values in an array

		// now using the for loop
		for (int a = 0; a <= 100; a++) {

		 x[a] = a;

		 y[a] = power.value(a);

		}
		
		//salt values
        for (int i = 0; i < y.length; i++) {
        	
            if (i % 2 == 0) {
                // Add 100 to even y values
                y[i] += 60;
                
            } else {
                // Subtract 200 from odd y values
                y[i] -= 60;
            }
        }
		
		double[] rollingMeans = new double[101];
		// 10-point rolling window
		DescriptiveStatistics stats = new DescriptiveStatistics(10); 
		//rolling mean throughout y values
		for (int i = 0; i <= 100; i++) {
			
		    stats.addValue(y[i]);
		    rollingMeans[i] = stats.getMean();
		    
		}
		System.out.printf("X       Rolling Means\n");
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%.1f\t%.2f\n", x[i], rollingMeans[i]);
        }
	}
}
