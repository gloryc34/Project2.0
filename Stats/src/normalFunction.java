
import java.awt.BasicStroke;

import java.awt.Color;

import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.util.Precision;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * Generated ideas and got information from: https://commons.apache.org/proper/commons-math/  https://www.jfree.org/jfreechart/  https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm  https://www.youtube.com/watch?v=MifbwoCumX0&t=402s
 * 
 */
public class normalFunction extends ApplicationFrame {
	/**
	 * JFreeChart creation
	 * @param applicationTitle and chartTitle
	 */
	public normalFunction( String applicationTitle, String chartTitle ){
	      super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(
	         chartTitle ,"x" ,"y" ,createDataset() ,PlotOrientation.VERTICAL ,true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      final XYPlot plot = xylineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.RED );
	      
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      
	      plot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	   }
	/**
	 * Dataset creation  of y=x^2
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
		for (int i = 0; i <= 100; i++) {
			//adding data to dataset
        	data.add(x[i],y[i]);
      }          
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( data);          
     
      return dataset;
	
	}
	
    
}
