package nu.xell.util.math;

/**
 * A continuous probability distribution.
 * 
 * @author Tobias Axell
 */
public interface ContinuousDistribution extends ProbabilityDistribution{
	
	/**
	 * Calculates the probability that a random variable
	 * in this distribution is in the closed interval [a, b].
	 * 
	 * @param a - The first value of the interval.
	 * @param b - The last value of the interval.
	 * @return The probability of a random variable in this 
	 * 				distribution to be in the interval [a, b].
	 */
	public double probabilityOf(double a, double b);
}
