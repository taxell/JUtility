package nu.xell.util.math;

import java.util.Random;

/**
 * A discrete uniform probability distribution  over an interval [a, b]; 
 * a probability distribution with a finite outcome space where all outcomes 
 * are equally likely.
 * 
 * @author Tobias Axell
 */
public class DiscreteUniformDistribution extends AbstractDiscreteDistribution {
	
	protected final int a;
	protected final int b;
	protected final Random randomGenerator;
	
	/**
	 * Constructor for DiscreteUniformDistribution.
	 * 
	 * @param a The start of the outcome space interval.
	 * @param b The end of the outcome space interval.
	 */
	public DiscreteUniformDistribution(int a, int b) {
		this(a, b, new Random());
	}
	
	/**
	 * Constructor for DiscreteUniformDistribution.
	 * 
	 * @param a The start of the outcome space interval.
	 * @param b The end of the outcome space interval.
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public DiscreteUniformDistribution(int a, int b, Random generator){
		if(b < a){
			throw new IllegalArgumentException("n must be greater than 0");
		}
		if(generator == null){
			throw new NullPointerException();
		}
		this.a = a;
		this.b = b;
		this.randomGenerator = generator;
	}

	@Override
	public double probabilityMassOf(int x) {
		if(a <= x && x <= b){
			return 1 / (b - a + 1);
		}
		return 0;
	}

	@Override
	public double expectedValue() {
		return (a + b) / 2;
	}

	@Override
	public double variance() {
		return (Math.pow(b-a+1, 2) - 1) / 12.0;
	}

	@Override
	public double cumulativeDensityOf(double x) {
		if(x < a){
			return 0;
		} else if(x <= b){
			return (((int)x) - a + 1) / (b - a + 1.0);
		}
		return 1;
	}
	
	@Override
	public double nextRandom() {
		return randomGenerator.nextInt(b - a + 1) + a;
	}
}
