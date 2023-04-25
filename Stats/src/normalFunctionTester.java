import org.jfree.ui.RefineryUtilities;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * 
 */
public class normalFunctionTester {
	/**
	 * running the JFreeChart
	 */
	public static void main(String[] args) {
		normalFunction chart = new normalFunction("Graph1",
		         "y=x^2");
		      chart.pack( );          
		      RefineryUtilities.centerFrameOnScreen( chart );          
		      chart.setVisible( true ); 
		

	}

}
