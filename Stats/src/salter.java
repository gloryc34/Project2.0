import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.Precision;

public class salter {

	public static void saltData() {
		double[] x = new double[101];
        double[] y = new double[101];
        for (int i = 0; i <= 100; i++) {
            x[i] = i;
            y[i] = i * i;
        }
        
        for (int i = 0; i < y.length; i++) {
            if (i % 2 == 0) {
                // Add 100 to even y values
                y[i] += 100;
            } else {
                // Subtract 200 from odd y values
                y[i] -= 200;
            }
        }
        
        // Output x values and new y values
        System.out.println("x\t\ty");
        System.out.println("--------------------");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + "\t\t" + Precision.round(y[i], 2));
        }

	}

}
