/*
	A light store owner has several bulb chains of different types which consist of bulbs of different colors in different order.
In addition to that, he has large collection of bulbs of each colors.A bulb chain is identified by the color sequence of its bulbs.
He wants to transform one type of bulb chain into another type of bulb chain by either by.
	
	Adding a bulb at some location.
	Removing a bulb from a location.
	Replacing a bulb with another bulb of different colour.
	
	Given two color sequences of two different bulb chains, Find the minimum no of operations required to do this transformation.
	(Assume each color can be represented by a character and hence, color sequence of a bulb chain can be represented as sequence
	of characters of a string.)
*/
import java.util.Scanner;

public class TheLightStore {

	private static int getOpCount(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String output = sc.next();
		int result = getOpCount(input, output);
		System.out.println(result);
	}
}
