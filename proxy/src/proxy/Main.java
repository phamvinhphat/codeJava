package proxy;

public class Main {
	public static void main(String[] args) {
		ICalculator ca = new ProxyCalculator();
		double a = ca.add(1, 9);
		System.out.println(a);
		
		double b = ca.div(2, 2);
		System.out.println(b);
		
		
	}
}
