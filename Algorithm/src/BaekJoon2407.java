import java.math.BigInteger;
import java.util.Scanner;

public class BaekJoon2407 {

	private static Scanner sc = null;

	private static BigInteger[][] dp = new BigInteger[101][101];

	private static BigInteger comb(int n, int m) {
		if (dp[n][m] != null) {
			return dp[n][m];
		} else if (n == m || m == 0) {
			return dp[n][m] = BigInteger.ONE;
		} else {
			return dp[n][m] = comb(n - 1, m).add(comb(n - 1, m - 1));
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		System.out.println(comb(n, m));
	}
}