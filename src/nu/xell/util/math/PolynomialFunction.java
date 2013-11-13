package nu.xell.util.math;

import java.util.Arrays;

import nu.xell.util.functional.Function1;

/**
 * 
 * @author Tobias Axell
 */
public class PolynomialFunction implements Function1<Double, Double> {

	private double[] coefficients;
	
	/**
	 * 
	 * @param coefficients
	 */
	public PolynomialFunction(double[] coefficients) {
		if(coefficients.length < 1){
			throw new IllegalArgumentException(
					"Polynomials must have at least 1 coefficient");
		}
		this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
	}
	
	/**
	 * 
	 * @return
	 */
	public int degree(){
		return coefficients.length - 1;
	}
	
	/**
	 * 
	 * @param degree
	 * @return
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
}