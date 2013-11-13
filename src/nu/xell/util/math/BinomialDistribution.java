package nu.xell.util.math;

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
	 * @param n The n of ~Bin(n, p)
	 * @param p The p of ~Bin(n, p)
	 */
	public BinomialDistribution(int n, double p){
		this(n, p, new Random());
	}
	
	/**
	 * Constructor for BinomialDistribution.
	 * 
	 * @param n The n of ~Bin(n, p)
	 * @param p The p of ~Bin(n, p)
	 * @param generator A pseudo random number generator 
	 * 					   for the <code>nextRandom()</code> method for 
	 * 					   producing random numbers distributed over ~Bin(n, p).
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
	 * Gives the <b>n</b>, number of experiments, of this distribution.
	 * 
	 * @return The <b>n</b> of this distribution.
	 */
	public int getN(){
		return n;
	}
	
	/**
	 * Gives the <b>p</b>, probability of one experiment to give a certain outcome
	 * (i.e. one over the number of possible outcomes), of this distribution.
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
		return nk.multiply(new BigDecimal(Math.pow(p, x))).
					multiply(new BigDecimal(Math.pow(1-p, n-x))).doubleValue();
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
