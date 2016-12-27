package coin;

public final class Coin{
	
	public static int [] st1x;
	public static int [] st1y;
	public static int [] st2x;
	public static int [] st2y;
	public static int [] st3x;
	public static int [] st3y;
	public static int [] st4x;
	public static int [] st4y;
	public static boolean [] stb;
	
	public static int points;
	
	public static void init(){
		st1x =  new int[]{100,284,284,284,461,461,461,461,641,641,641,641};
		st1y = new int[]{227,106,239,437,62,198,304,474,80,185,307,422};
		
		st2x = new int[]{102,283,283,283,460,460,460,460,643,643,643,643};
		st2y = new int[]{204,282,69,438,108,219,363,476,51,162,324,460};
		
		st3x = new int[]{101,101,287,287,287,287,461,461,461,461,461,642,642,642,642,642,642};
		st3y = new int[]{333,222,295,188,90,441,77,228,317,415,505,107,176,241,327,399,470};
		
		st4x = new int[]{102,284,284,284,462,462,641,641};
		st4y = new int[]{275,107,272,484,73,475,185,306};
		
		stb = new boolean [100000];
	}
	
}
