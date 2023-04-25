import org.jfree.ui.RefineryUtilities;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * Ideas from: http://www.java2s.com/example/java-api/org/jfree/chart/renderer/xy/xylineandshaperenderer/xylineandshaperenderer-0-2.html
 */
public class saltFunctionTester {
	
	 public static void main( String[ ] args ) {
		 //chart creation
	      saltFunction chart = new saltFunction("Graph1", "y=x^2");
	      chart.pack( );          
	      RefineryUtilities.centerFrameOnScreen( chart );          
	      chart.setVisible( true ); 
	      
	   }
}
