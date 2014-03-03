package se.xell.util.math;

import java.math.BigDecimal;
import java.util.Random;

/**
 * A binomial probability distribution.
 * 
 * @author Tobias Axell
 */
public class BinomialDistribution extends AbstractDiscreteDistribution {

	protected final int n;
	protected final double p;
	
	protected final double[] limits;
	protected final Random randomGenerator;
	
	/**
	 * Constructor for BinomialDistribution.
	 * 
	 * @param n The number of Bernoulli trials.
	 * @param p The probability of each Bernoulli trial to result in 1 (success)
	 * 			rather than 0 (failure).
	 */
	public BinomialDistribution(int n, double p){
		this(n, p, new Random());
	}
	
	/**
	 * Constructor for BinomialDistribution.
	 * 
	 * @param n The number of Bernoulli trials.
	 * @param p The probability of each Bernoulli trial to result in 1 (success)
	 * 			rather than 0 (failure).
	 * @param generator A random generator for generating random numbers of this distribution.
	 */
	public BinomialDistribution(int n, double p, Random generator){
		this.n = n;
		this.p = p;
		this.randomGenerator = generator;
		this.limits = new double[n+1];
		
		double sum = 0.0;
		for(int i = 0; i <= n; i++){
			sum += probabilityOf(i);
			limits[i] = sum;
		}
	}
	
	/**
	 * Gives the <b>n</b>, number of experiments (Bernoulli trials), 
	 * of the binomial distribution.
	 * 
	 * @return The <b>n</b> of this distribution.
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * Gives the <b>p</b>, probability of each Bernoulli trial to succeed.
	 * 
	 * @return The <b>p</b> of this distribution.
	 */
	public double getP(){
		return p;
	}
	
	@Override
	public double expectedValue(){
		return n * p;
	}
	
	@Override
	public double variance(){
		return n * p * (1-p);
	}
	
	@Override
	public double probabilityMassOf(int x) {
		if(x < 0 || x > n){
			return 0;
		}
		
		BigDecimal nk = new BigDecimal(AMath.nChooseK(n, x));
		return nk.multiply(new BigDecimal(StrictMath.pow(p, x)))
				.multiply(new BigDecimal(StrictMath.pow(1-p, n-x))).doubleValue();
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
		double d = randomGenerator.nextDouble();
		
		for(int i = 0; i <= n; i++){
			if(d <= limits[i]){
				return i;
			}
		}
		
		//This function should never reach this point since d always will be 
		//smaller than 1 and limits[n] should be exactly one, however if the
		//loop should pass the last if check the most reasonable thing to do
		//would be to return what should have been returned in the last if
		//check, namely n.
		return n;
	}
}
