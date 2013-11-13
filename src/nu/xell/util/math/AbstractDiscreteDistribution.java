package nu.xell.util.math;

/**
 * An Abstract class implementing the methods of a discrete distribution
 * that can be defined using only the probability mass function of the
 * discrete distribution.
 * 
 * @author Tobias Axell
 */
public abstract class AbstractDiscreteDistribution implements DiscreteDistribution{
	
	@Override
	public double probabilityOf(int x){
		return probabilityMassOf(x);
	}
	
	@Override
	public double probabilityDensityOf(double x){
		if(x == Math.round(x)){
			return probabilityMassOf((int)Math.round(x));
		} else {
			return 0;
		}
	}
}
