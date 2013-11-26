package nu.xell.util.math;

import java.util.Random;

/**
 * An exponential probability distribution.
 * 
 * @author Tobias Axell
 */
public class ExponentialDistribution implements ContinuousDistribution {

	protected final double lambda;
	protected final Random randomGenerator;
	
	/**
	 * Constructor for ExponentialDistribution.
	 * 
	 * @param l The lambda (intensity) of the distribution.
	 */
	public ExponentialDistribution(double l){
		this(l, new Random());
	}
	
	/**
	 * Constructor for ExponentialDistribution.
	 * 
	 * @param l The lambda (intensity) of the distribution.
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public ExponentialDistribution(double l, Random generator) {
		if(l <= 0){
			throw new IllegalArgumentException("l must be greater than 0");
		}
		if(generator == null){
			throw new NullPointerException();
		}
		lambda = l;
		randomGenerator = generator;
	}

	@Override
	public double expectedValue() {
		return 1 / lambda;
	}

	@Override
	public double variance() {
		return 1 / (lambda * lambda);
	}

	@Override
	public double probabilityDensityOf(double x) {
		if(x < 0){
			return 0;
		}
		return lambda * Math.exp(-lambda * x);
	}

	@Override
	public double cumulativeDensityOf(double x) {
		if(x < 0){
			return 0;
		}
		return 1 - Math.exp(-lambda * x);
	}

	@Override
	public double nextRandom() {
		return -Math.log(1 - randomGenerator.nextDouble()) / lambda;
	}

	@Override
	public double probabilityOf(double a, double b) {
		return cumulativeDensityOf(b) - cumulativeDensityOf(a);
	}
}
