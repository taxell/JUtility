package nu.xell.util.math;

import java.math.BigDecimal;
import java.util.Random;

/**
 * A Poisson probability distribution.
 * 
 * @author Tobias Axell
 */
public class PoissonDistribution extends AbstractDiscreteDistribution{

	protected final double lambda;
	protected final Random generator;
	
	/**
	 * Constructor for PoissonDistribution.
	 * 
	 * @param lambda The lambda (expected value and variance) of this distribution.
	 */
	public PoissonDistribution(double lambda){
		this(lambda, new Random());
	}
	
	/**
	 * Constructor for PoissonDistribution.
	 * 
	 * @param lambda The lambda (expected value and variance) of this distribution.
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public PoissonDistribution(double lambda, Random generator){
		if(lambda <= 0){
			throw new IllegalArgumentException("lambda must be greater than 0");
		}
		if(generator == null){
			throw new NullPointerException();
		}
		this.lambda = lambda;
		this.generator = generator;
	}
	
	/**
	 * Gives the lambda (expected value and variance) of this distribution.
	 * 
	 * @return The lambda of this distribution.
	 */
	public double getLambda(){
		return lambda;
	}
	
	@Override
	public double expectedValue(){
		return lambda;
	}
	
	@Override
	public double variance(){
		return lambda;
	}
	
	@Override
	public double probabilityMassOf(int x) {
		BigDecimal numerator = new BigDecimal(Math.exp(-lambda)*Math.pow(lambda, x));
		BigDecimal denominator = new BigDecimal(AMath.factorial(x));
		return numerator.divide(denominator).doubleValue();
	}
	
	@Override
	public double cumulativeDensityOf(double x) {
		double sum = 0;
		for(int i = 0; i <= x; i++){
			sum += probabilityMassOf(i);
		}
		return sum;
	}

	@Override
	public double nextRandom() {
		//http://en.wikipedia.org/wiki/Poisson_distribution#Generating_Poisson-distributed_random_variables
		final double l = Math.exp(-lambda);
		double p = 1;
		int k = 0;
		do {
			k++;
			p *= generator.nextDouble();
		} while(p > l);
		return k-1;
	}
}
