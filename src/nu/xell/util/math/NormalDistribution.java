package nu.xell.util.math;

import java.util.Random;

import nu.xell.util.functional.Function1;

/**
 * This is a normal distribution for mathematical and statistical
 * purposes.
 * 
 * @author Tobias Axell
 */
public class NormalDistribution implements ContinuousDistribution{
	
	private final double mean;
	private final double variance;
	private final Random randomGenerator;
	
	private final double probabilityDensityCoefficient;
	
	/**
	 * Constructor for NormalDistribution.
	 * 
	 * @param mean - The mean value of the distribution.
	 * @param variance - The variance of the distribution.
	 */
	public NormalDistribution(double mean, double variance){
		this(mean, variance, new Random());
	}
	
	/**
	 * Constructor for NormalDistribution.
	 * 
	 * @param mean - The mean value of the distribution.
	 * @param variance - The variance of the distribution.
	 * @param generator - A random generator for generating random variables
	 * 						distributed in N(mean, variance).
	 */
	public NormalDistribution(double mean, double variance, Random generator){
		this.mean = mean;
		this.variance = variance;
		this.probabilityDensityCoefficient = 
					1/StrictMath.sqrt(2 * StrictMath.PI * variance);
		this.randomGenerator = generator;
	}
	

	@Override
	public double expectedValue(){
		return mean;
	}
	
	@Override
	public double variance(){
		return variance;
	}

	/**
	 * Gives the standard deviation of the distribution.
	 * 
	 * @return The standard deviation of the distribution.
	 */
	public double standardDeviation(){
		return StrictMath.sqrt(variance);
	}
	
	@Override
	public double probabilityDensityOf(double x){	
		// (1/Sqrt(2*pi*variance)) * e^(-(x-mean)²/(2*variance))
		double exp = -((x-mean)*(x-mean)/(2 * variance));
		double fac = StrictMath.pow(StrictMath.E, exp);
		return probabilityDensityCoefficient * fac;
	}
	
	@Override
	public double cumulativeDensityOf(double x) {
		return 0.5 * (1 + AMath.erf((x-mean)/StrictMath.sqrt(2 * variance)));
	}
	
	@Override
	public double probabilityOf(double a, double b){
		return AMath.integrate(new Function1<Double, Double>(){

				@Override
				public Double f(Double x) {
					return probabilityDensityOf(x);
				}},
			a, b);
	}
	
	@Override
	public double nextRandom(){
		double X = randomGenerator.nextGaussian();
		return StrictMath.sqrt(variance) * X + mean;
	}
	
	/*
	public static NormalDistribution distributionFor(double[] sample){
		//TODO - Implement for real...
		double sumTerm = 0;
		double squareSumTerm = 0;
		
		for(int i = 0; i < sample.length; i++){
			sumTerm += sample[i];
			squareSumTerm += sample[i] * sample[i];
		}
		
		double mean = sumTerm / sample.length;
		
		sumTerm /= sample.length;
		sumTerm *= sumTerm;
		sumTerm *= sample.length / (sample.length - 1);
		
		squareSumTerm /= (sample.length - 1);
		
		double standardDeviation = StrictMath.sqrt(squareSumTerm - sumTerm);
		
		return new NormalDistribution(mean, (standardDeviation * standardDeviation));
	}*/
}
