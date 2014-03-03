package nu.xell.util.math;

import java.math.BigInteger;

import se.xell.junky.Function1;

/**
 * A mathematics class with slightly more advanced features than
 * java.lang.Math. All methods in this class are static
 * and the class cannot be instantiated. 
 * 
 * @author Tobias Axell
 */
public final class AMath {
	
	//Making the constructor private in order to prevent
	//people from creating instances of this class.
	private AMath(){}
	
	/**
	 * Standard precision for approximating integrals.
	 */
	public static final int STANDARD_INTEGRAL_PRECISION = 500;
	
	/**
	 * Standard precision for approximating derivatives.
	 */
	public static final double STANDARD_DERIVATE_PRECISION = 0.0001;
	
	/**
	 * Calculates an approximate integral the function <b>f</b> on the closed interval
	 * [<b>a</b>, <b>b</b>] with precision N using the trapezodial rule.
	 * 
	 * @param f - The function to integrate.
	 * @param a - The start value of the interval to integrate.
	 * @param b - The end value of the interval to integrate.
	 * @param N - The precision to calculate with. Higher N gives
	 * 				higher precision.
	 * @return An approximation of the integral of <b>f</b> from <b>a</b> to <b>b</b>.
	 */
	public static double integrate(Function1<Double, Double> f, double a, double b, int N) {
		int	s      = (int)Math.ceil((b - a) * N);	// no of steps
		double h   = (b - a) / s;              	    // step size
		double sum = 0.5 * (f.f(a) + f.f(b));       // area
		
		for (int i = 1; i < s; i++) {
			double x = a + h * i;
			sum += f.f(x);
		}
		return sum * h;
	}
	
	/**
	 * Calculates an approximate integral the function <b>f</b> on the closed interval
	 * [<b>a</b>, <b>b</b>] using the trapezodial rule.
	 * 
	 * @param f - The function to integrate.
	 * @param a - The start value of the interval to integrate.
	 * @param b - The end value of the interval to integrate.
	 * @return An approximation of the integral of <b>f</b> from <b>a</b> to <b>b</b>.
	 */
	public static double integrate(Function1<Double, Double> f, double a, double b) {
		return integrate(f, a, b, STANDARD_INTEGRAL_PRECISION);
	}
	
	/**
	 * Calculates the (approximated) derivative of a given function <b>f</b>
	 * at a given point <b>x</b> with a given precision.
	 * 
	 * @param f - The function to calculate the derivative of in the given point.
	 * @param x - The point on the x axis to calculate the derivative of <b>f</b> for.
	 * @param p - The precision to use. <b>p</b> shall be a positive number close to zero
	 * 				but not exactly zero. The closer to zero <b>p</b> is the higher the
	 * 				approximation will be.
	 * 
	 * @return An approximate derivative of the function <b>f</b> at the point<b>x</b>.
	 */
	public static double derive(Function1<Double, Double> f, double x, double p){
		double x1 = x-p;
		double x2 = x+p;
		double y1 = f.f(x1);
		double y2 = f.f(x2);
		
		return (y2-y1)/(x2-x1);
	}
	
	/**
	 * Calculates the (approximated) derivative of a given function <b>f</b>
	 * at a given point <b>x</b>.
	 * 
	 * @param f - The function to calculate the derivative of in the given point.
	 * @param x - The point on the x axis to calculate the derivative of <b>f</b> for.
	 * 
	 * @return An approximate derivative of the function <b>f</b> at the point<b>x</b>.
	 */
	public static double derive(Function1<Double, Double> f, double x){
		return derive(f, x, STANDARD_DERIVATE_PRECISION);
	}
	
	/**
	 * Gives a linear function fitting a given set of (x, y) coordinates
	 * as well as possible.
	 * 
	 * @param xValues - The x coordinates.
	 * @param yValues - The y coordinates.
	 * @return A linear function, <code>f(x)=kx+m</code>, that fits the given
	 * 			data points as well as possible.
	 */
	public static Function1<Double, Double> linearRegress(double[] xValues, double[] yValues){
		if(xValues.length != yValues.length){
			throw new IllegalArgumentException("Input lengths does not match.");
		}
		
		double sumx = 0.0;
		double sumy = 0.0;
		for(int i = 0; i < xValues.length; i++){
			sumx += xValues[i];
			sumy += yValues[i];
		}
		double avgx = sumx / xValues.length;
		double avgy = sumy / yValues.length;
		
		double xBar = 0.0;
		double xyBar = 0.0;
		for(int i = 0; i < xValues.length; i++){
			xBar += (xValues[i] - avgx) * (xValues[i] - avgx);
			xyBar += (xValues[i] - avgx) * (yValues[i] - avgy);
		}
		
		double k = xyBar / xBar;
		double m = avgy - k * avgx;
		return new LinearFunction(k, m);
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(long[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(int[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(short[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(byte[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(double[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * Calculates the average of all values in an array
	 * 
	 * @param values - The values to calculate the average of.
	 * @return The average of all values in <b>values</b>
	 */
	public static double average(float[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++){
			sum += values[i];
		}
		return sum / values.length;
	}
	
	/**
	 * The error function, <i>erf</i>, (a.k.a. Gauss error function).
	 * <br></br><br></br>
	 * 
	 * NOTE: This is an approximation of the <i>real</i> error function.
	 * The maximum error of this approximation is estimated to be
	 * <i>1.7 * 10^-7<i>
	 * 
	 * @param x The argument to erf.
	 * @return An approximation of <code>erf(x)</code>
	 */
	public static double erf(double x){
		//http://en.wikipedia.org/wiki/Error_function#Approximation_with_elementary_functions
		if(x < 0){
			return -erf(Math.abs(x));
		}
		final double p = 0.3275911;
		final double t = 1 / (1 + (p*x));
		final double[] a = {0.254829592, -0.284496736, 1.421413741, -1.453152027, 1.061405429};
		final double c = (a[0] * t) + 
						  (a[1] * t * t) + 
						  (a[2] * t * t * t) + 
						  (a[3] * t * t * t * t) + 
						  (a[4] * t * t * t * t * t);
		return 1 - c * Math.exp(-(x*x));
	}
	
	/**
	 * The complementary error function <i>erfc</i>. 
	 * (The complementary error function is defined as 
	 * <code>erfc(x) = 1 - erf(x)</code>).
	 * <br></br><br></br>
	 * 
	 * NOTE: This is an approximation of the <i>real</i> complementary 
	 * error function. The maximum error of this approximation is 
	 * estimated to be <i>1.7 * 10^-7<i>
	 *  
	 * @param x The argument to erfc.
	 * @return An approximation of <code>erf(x)</code>
	 */
	public static double erfc(double x){
		return 1 - erf(x);
	}
	
	/**
	 * Calculates the factorial of <b>n</b>; (<b>n</b>!).
	 * 
	 * @param n - The number to calculate the factorial of.
	 * @return <b>n</b>! as a BigInteger object.
	 * @throws IllegalArgumentException if <b>n</b> is negative.
	 */
	public static BigInteger factorial(int n){
		if(n < 0){
			throw new IllegalArgumentException("Factorial is not defined for negative numbers");
		} else if(n == 0 || n == 1){
			return new BigInteger("1");
		} else {
			BigInteger fac = new BigInteger("1");
			for(int i = 2; i <= n; i++){
				fac = fac.multiply(new BigInteger(""+i));
			}
			return fac;
		}
	}
	
	/**
	 * Calculates the binomial coefficient, "n choose k",
	 * for given values of n and k.
	 * 
	 * @param n - The n of "n choose k".
	 * @param k - The k of "n choose k".
	 * @return The number of possible combinations of choosing
	 * 			k elements from a set of n elements.
	 */
	public static BigInteger nChooseK(int n, int k){
		if(n < k || k < 0){
			return new BigInteger("0");
		} if (n == k || k == 0) {
			return new BigInteger("1");
		} else {
			int max = Math.max(k, n-k);
			int min = Math.min(k, n-k);
			
			BigInteger num = new BigInteger("1");
			BigInteger denom = new BigInteger("1");
			for(long i = max + 1; i <= n; i++){
				num = num.multiply(new BigInteger(""+i));
			}
			for(long i = 1; i <= min; i++){
				denom = denom.multiply(new BigInteger(""+i));
			}
			
			return num.divide(denom);
		}
	}
}
