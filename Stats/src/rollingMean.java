import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartUtilities;

public class rollingMean {
    public static void main(String[] args) {
        double[] x = new double[101];
        double[] y = new double[101];
        for (int i = 0; i <= 100; i++) {
            x[i] = i;
            y[i] = i * i;
        }
        int windowSize = 5;
        double[] rollingMeans = computeRollingMeans(y, windowSize);
        double[] rollingMeans2 = computeRollingMeans(rollingMeans, windowSize);
        
        //createChart();
        
        System.out.printf("X       Rolling Means\n");
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%.1f\t%.2f\n", x[i], rollingMeans2[i]);
        }
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
    /*
    public static JFreeChart createChart() {    
    	 
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Mean");
        
        double[] x = new double[101];
        double[] y = new double[101];
        for (int i = 0; i <= 100; i++) {
            x[i] = i;
            y[i] = i * i;
        }
        int windowSize = 5;
        double[] rollingMeans = computeRollingMeans(y, windowSize);
        
        for (int i = 0; i <= 100; i++) {
            series1.addOrUpdate(x[i],rollingMeans[i]);
        }
        
        dataset.addSeries(series1);
        
        JFreeChart scatterPlot = ChartFactory.createScatterPlot(
                "JFreeChart Scatter Plot", // Chart title
                "X", // X-Axis Label
                "Y", // Y-Axis Label
                dataset // Dataset for the Chart
                );
       
        
        return scatterPlot;
		
    }
    
    */
    
   
}
