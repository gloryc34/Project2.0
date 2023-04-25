import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
/**
 * @author Colin Glory
 * @version Version: 2022-12 (4.26.0)
 * 
 */
public class statsLibrary {
	
	/**
	 * Finds factorial of a number
	 * @param int n
	 * @returns the factorial of a number
	 */
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    /**
	 * Finds Poisson 
	 * @returns the poisson 
	 */
	public static void poissonCalc() {
		
		Scanner input = new Scanner(System.in);

        // Get user input for x and lambda
        System.out.print("Enter the value of x: ");
        int x = input.nextInt();
        System.out.print("Enter the value of lambda: ");
        double lambda = input.nextDouble();

        // Calculate the Poisson distribution
        double poisson = Math.pow(lambda, x) * Math.exp(-lambda) / factorial(x);

        // Display the result
        System.out.printf("P(X = %d) = %.4f", x, poisson);
	}
	/**
	 * Finds Uniform Calculation
	 * @returns the uniform calculation
	 */
	public static void uniformCalc() {
		Random rand = new Random();
	    double minValue = 0.0;
	    double maxValue = 1.0;
	    double randomValue = minValue + (maxValue - minValue) * rand.nextDouble();
	    System.out.println("Random value from uniform distribution: " + randomValue);
	}
	/**
	 * Used to assit the any formulas dealing with combinations
	 * @param int n int x
	 */
	public static long combinations(int n, int x) {
			
			return factorial(x)*factorial(n-x) / factorial(n);
			
		}
	/**
	 * hypogeometric method given user input
	 *
	 */
	public static void hypo2() {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the population size (N): ");
        int N = scanner.nextInt();

        System.out.print("Enter the number of successes in the population (K): ");
        int K = scanner.nextInt();

        System.out.print("Enter the sample size (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of successes in the sample (k): ");
        int k = scanner.nextInt();
        
        double n1 = combinations(K,k);
        double n2 = combinations(N-K,n-k);
        double d = combinations(N,n);
        
        double hypo = (n1*n2)/d;
        System.out.println(hypo);
	}
	
	public static void chebby() {
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number (k): ");
	    int k = scanner.nextInt();
	    
	    double chebby = 1 - (1/Math.pow(k,2));
	    System.out.println(chebby);
	}

	}

	
