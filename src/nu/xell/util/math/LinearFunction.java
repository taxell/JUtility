package nu.xell.util.math;

/**
 * A linear function <i>f(x) = kx + m</i> is a special case
 * of a polynomial function, namely a polynomial function of degree
 * 1.
 * 
 * @author Tobias Axell
 */
public class LinearFunction extends PolynomialFunction {
	
	/**
	 * Constructor for LinearFunction.
	 * 
	 * @param k The slope (derivative) of the function
	 * @param m The 
	 */
	public LinearFunction(double k, double m){
		super(new double[]{m, k});
	}
	
	/**
	 * Gives the degree 1 coefficient of the polynomial, or the 
	 * derivative of the linear function.
	 * 
	 * @return The slope of this linear function.
	 */
	public double getK(){
		return getCoefficient(1);
	}
	
	/**
	 * Gives the degree 0 coefficient of the polynomial
	 * 
	 * @return
	 */
	public double getM(){
		return getCoefficient(0);
	}
	
	@Override
	public String toString(){
		return "f(x) = " + getK() + " * x + " + getM();
	}
}
