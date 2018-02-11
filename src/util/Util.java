package util;

public class Util {
	
	private Util(){}
	
	public static double round(final double num){
		return (double)Math.round(num * 10000) / 10000; 
	}
}
