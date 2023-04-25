import java.awt.BasicStroke;
import java.awt.Color;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.util.Precision;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class rollingMeansGraph extends ApplicationFrame {
	//code from http://www.java2s.com/example/java-api/org/jfree/chart/renderer/xy/xylineandshaperenderer/xylineandshaperenderer-0-2.html
	public rollingMeansGraph( String applicationTitle, String chartTitle ) {
		
	      super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(
	    		  
	         chartTitle ,
	         "x" ,
	         "y" ,
	         createDataset() ,
	         PlotOrientation.VERTICAL ,
	         true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      final XYPlot plot = xylineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.RED );
	      
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      
	      plot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	   }
	
	private static double[] computeRollingMeans(double[] data, int windowSize) {
		
        Mean mean = new Mean();
        double[] rollingMeans = new double[data.length];
        
        for (int i = 0; i < data.length; i++) {
        	
            int start = Math.max(0, i - windowSize + 1);
            double[] window = new double[i - start + 1];
            System.arraycopy(data, start, window, 0, window.length);
            rollingMeans[i] = mean.evaluate(window);
        }
        return rollingMeans;
    }
	
	private XYDataset createDataset( ) {
		//series creation and datasets
	     final XYSeries mean = new XYSeries( "Function" );          
	     double[] x = new double[101];
	     double[] y = new double[101];
	     //fill arrays
	     for (int i = 0; i <= 100; i++) {
	        	
	            x[i] = i;
	            y[i] = i * i;
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
	        
	        
	        //computes rolling mean on salted values, then adds to dataset
	        int windowSize = 100;
	        double[] rollingMeans = computeRollingMeans(y, windowSize);
	        double[] rollingMeans2 = computeRollingMeans(rollingMeans,windowSize);
	        double[] rollingMeans3 = computeRollingMeans(rollingMeans2,windowSize);
	        double[] rollingMeans4 = computeRollingMeans(rollingMeans3,windowSize);
	        for (int i = 0; i <= 100; i++) {
	        	mean.add(x[i],rollingMeans4[i]);
	      }          
	      
	                
	      //adds dataset to series
	      final XYSeriesCollection dataset = new XYSeriesCollection( );          
	      dataset.addSeries( mean );          
	     
	      return dataset;
	   }
	 public static void main( String[ ] args ) {
	      saltFunction chart = new saltFunction("Graph1",
	         "y=x^2");
	      chart.pack( );          
	      RefineryUtilities.centerFrameOnScreen( chart );          
	      chart.setVisible( true ); 
	   }
}
