import java.util.Scanner;

public class BaekJoon2193 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[1] = 1;
		for (int n = 2; n < dp.length; n++) {
			dp[n] = dp[n - 1] + dp[n - 2];
		}
		System.out.println(dp[N]);
	}
}