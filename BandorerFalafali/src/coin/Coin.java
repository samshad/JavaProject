package coin;

public final class Coin{
	
	public static int [] st1x;
	public static int [] st1y;
	public static boolean [] st1b;
	
	public static void init(){
		st1x =  new int[]{100,284,284,284,461,461,461,461,641,641,641,641};
		st1y = new int[]{227,106,239,437,62,198,304,474,80,185,307,422};
		
		st1b = new boolean [100000];
	}
	
}
