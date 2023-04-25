import org.jfree.ui.RefineryUtilities;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * Followed tutorial from https://www.tutorialspoint.com/jfreechart/jfreechart_xy_chart.htm
 */
public class smoothFunctionTester {
	/**
	 * running the smoothed JFreeChart
	 */
	public static void main(String[] args) {
		//gui chart name & actual plot name
		smoothFunction chart = new smoothFunction("Smooth","y=x^2");
		chart.pack( );          
		RefineryUtilities.centerFrameOnScreen( chart );          
		chart.setVisible( true ); 
		      

	}

}
