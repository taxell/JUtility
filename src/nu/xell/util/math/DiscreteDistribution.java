package nu.xell.util.math;

/**
 * An interface representing a discrete probability distribution.
 * 
 * @author Tobias Axell
 */
public interface DiscreteDistribution extends ProbabilityDistribution{
	
	/**
	 * The probability mass function for the distribution.
	 * 
	 * @param x - The value to calculate the probability mass of.
	 * @return The probability mass of x.
	 */
	public double probabilityMassOf(int x);
	
	/**
	 * Calculates the probability that a random variable
	 * in this distribution is a specified value.<br></br><br></br>
	 * 
	 * Note: This is the same thing as the probability mass function
	 * and should be implemented as:<br></br><br></br>
	 * <code>
	 * public double probabilityOf(int x) {<br></br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;return probabilityMassOf(x);<br></br>
	 * }
	 * </code>
	 * 
	 * @param x - The value/index to calculate the probability of.
	 * @return The probability of a random variable in this 
	 * 				distribution to be x.
	 */
	public double probabilityOf(int x);
}
