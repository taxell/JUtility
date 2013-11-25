package nu.xell.util.math;

import java.util.Arrays;

import nu.xell.util.functional.Function1;

/**
 * A polynomial function.
 * 
 * @author Tobias Axell
 */
public class PolynomialFunction implements Function1<Double, Double> {

	private double[] coefficients;
	
	/**
	 * Constructor for PolynomialFunction.
	 * 
	 * @param coefficients The coefficients for the polynomial function.
	 *   				   <code>coefficients[i]</code> will be the coefficient 
	 *   				   for the <i>i</i>-th degree variable. So the size of the
	 *   				   coefficients array decides the degree of the polynomial
	 *   				   function. Example:
	 *   				   If <code>coefficients = {1, 2, 3}</code> then the function
	 *   				   will be <i>f(x) = 3x<sup>2</sup> + 2x + 1</i>
	 */
	public PolynomialFunction(double[] coefficients) {
		if(coefficients.length < 1){
			throw new IllegalArgumentException(
					"Polynomials must have at least 1 coefficient");
		}
		this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
	}
	
	/**
	 * Gives the degree of the polynomial function.
	 * 
	 * @return The degree of the polynomial.
	 */
	public int degree(){
		return coefficients.length - 1;
	}
	
	/**
	 * Gives the coefficient of the term of a specified degree.
	 * 
	 * @param degree The degree of the term to give the coefficient for.
	 * @return The coefficient of the specified term.
	 */
	public double getCoefficient(int degree){
		return coefficients[degree];
	}

	@Override
	public Double f(Double x) {
		
		double sum = 0;
		for(int i = 0; i < coefficients.length; i++){
			sum += coefficients[i] * Math.pow(x, i);
		}
		return sum;
	}
	
	@Override
	public String toString(){
		String s = "f(x) = ";
		
		for(int i = coefficients.length - 1; i > 0; i--){
			s += coefficients[i] + "x^" + i + " + ";
		}
		s += coefficients[0];
		
		return s;
	}
}