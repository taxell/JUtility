package nu.xell.util.math;

import java.util.Random;

/**
 * A Bernoulli distribution.
 * 
 * @author Tobias Axell
 */
public class BernoulliDistribution extends AbstractDiscreteDistribution {

	protected final double p;
	protected final Random generator;
	
	/**
	 * Constructor for BernoulliDistribution.
	 * 
	 * @param p The probability a Bernoulli trial to result in 1 rather than 0,
	 * (success or failure).
	 */
	public BernoulliDistribution(double p){
		this(p, new Random());
	}
	
	/**
	 * Constructor for BernoulliDistribution.
	 * The probability of a Bernoulli trial to result in 0 rather than 1.
	 * 
	 * @param p The probability a Bernoulli trial to result in 1 rather than 0,
	 * (success or failure).
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public BernoulliDistribution(double p, Random generator){
		if(p < 0 || 1 < p){
			throw new IllegalArgumentException("p must be in the interval [0, 1]");
		}
		if(generator == null){
			throw new NullPointerException();
		}
		
		this.p = p;
		this.generator = generator;
	}
	
	@Override
	public double expectedValue(){
		return p;
	}
	
	@Override
	public double variance(){
		return p - (p * p);
	}
	
	@Override
	public double probabilityMassOf(int x) {
		if(x == 0){
			return 1 - p;
		} else if(x == 1){
			return p;
		}
		return 0;
	}

	@Override
	public double cumulativeDensityOf(double x) {
		if(x < 0){
			return 0;
		} else if(x < 1){
			return 1 - p;
		} else {
			return 1;
		}
	}
	
	@Override
	public double nextRandom() {
		if(generator.nextDouble() < p){
			return 1;
		} else {
			return 0;
		}
	}
}
