package proxy;

import javax.management.RuntimeErrorException;

public class ProxyCalculator implements ICalculator{
	
	private RealCalculator realcalculator;

	public ProxyCalculator() {
		this.realcalculator = new RealCalculator();
	}
	
	@Override
	public double add(double first, double second) {
		if(first + second == 10) {
			System.out.println("muoi");
		}
		return this.realcalculator.add(first, second) ;
	}

	@Override
	public double div(double first, double second) {
		if(second == 0) 
			throw new RuntimeException("KHAC 0 ");
		
		return this.realcalculator.add(first, second);
	}

	
	
}
