import java.awt.Color; 
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.util.Precision;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * Ideas from: http://www.java2s.com/example/java-api/org/jfree/chart/renderer/xy/xylineandshaperenderer/xylineandshaperenderer-0-2.html
 */
public class saltFunction extends ApplicationFrame {
	/**
	 * JFreeChart creation
	 * @param applicationTitle and chartTitle
	 */
	   public saltFunction( String applicationTitle, String chartTitle ) {
		   
	      super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(chartTitle ,"x" ,"y" ,createDataset() ,PlotOrientation.VERTICAL ,true , true , false);
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      final XYPlot plot = xylineChart.getXYPlot( );
	      
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.CYAN );
	      
	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	      
	      plot.setRenderer( renderer ); 
	      setContentPane( chartPanel ); 
	   }
	   
  /**
   * JFreeChart datset creation
   * @returns the dataset
   */
   private XYDataset createDataset( ) {
	   //series creation and arrays creation
	   final XYSeries mean = new XYSeries( "Function" );          
	   double[] x = new double[101];
	   double[] y = new double[101];
	   //fill values
	   for (int i = 0; i <= 100; i++) {
	       x[i] = i;
	       y[i] = i * i;
	      }
	   //salt values
	   for (int i = 0; i < y.length; i++) {
	       if (i % 2 == 0) {
	           // Add 100 to even y values
	           y[i] += 100;
	        } else {
	              // Subtract 200 from odd y values
	        	y[i] -= 100;
	          }
	      }
	   //use apache precision round to add values to series
	   	for (int i = 0; i <= 100; i++) {
	   		mean.add(x[i],(Precision.round(y[i], i)));
	      }          
	   	//return dataset
	    final XYSeriesCollection dataset = new XYSeriesCollection( );          
	    dataset.addSeries( mean );          
	    return dataset;
	   }

   
  
}