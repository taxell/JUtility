package nu.xell.util.math;

import java.util.Random;

/**
 * A continuous uniform distribution over an interval [a, b].
 * 
 * @author Tobias Axell
 */
public class ContinuousUniformDistribution implements ContinuousDistribution {
	
	protected final double a;
	protected final double b;
	protected final Random randomGenerator;
	
	/**
	 * Constructor for UniformDistribution.
	 * 
	 * @param a The start of the interval of the new distribution.
	 * @param b The end of the interval of the new distribution.
	 */
	public ContinuousUniformDistribution(double a, double b){
		this(a, b, new Random());
	}
	
	/**
	 * Constructor for UniformDistribution.
	 * 
	 * @param a The start of the interval of the new distribution.
	 * @param b The end of the interval of the new distribution.
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public ContinuousUniformDistribution(double a, double b, Random generator) {
		
		if(a <= b){
			throw new IllegalArgumentException();
		}
		
		this.a = a;
		this.b = b;
		randomGenerator = generator;
	}

	@Override
	public double expectedValue() {
		return (0.5 * (b - a)) + a;
	}

	@Override
	public double variance() {
		return (1/12) * (b-a) * (b-a);
	}

	@Override
	public double probabilityDensityOf(double x) {
		if(a <= x && x <= b){
			return 1 / (b - a);
		}
		return 0;
	}

	@Override
	public double cumulativeDensityOf(double x) {
		if(x < a){
			return 0;
		} else if(x < b){
			return (x-a)/(b-a);
		} else {
			return 1;
		}
	}

	@Override
	public double nextRandom() {
		return randomGenerator.nextDouble() * (b - a) + a;
	}

	@Override
	public double probabilityOf(double n, double m) {
		if(n > m){
			throw new IllegalArgumentException();
		} else if(n > b || m < a){
			return 0;
		} else if(n > a && m < b){
			return (m - n) * probabilityDensityOf(n);
		} else if(n <= a && b <= m){
			return 1;
		} else if(n < a){
			return (m - a) * probabilityDensityOf(m);
		} else {
			return (b - n) * probabilityDensityOf(n);
		}
	}
}
