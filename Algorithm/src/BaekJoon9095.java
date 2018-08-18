import java.util.Scanner;

public class BaekJoon9095 {
	private static Scanner sc = null;

	private static int func_dp(int n) {
		if (dp[n] != 0) {
			return dp[n];
		} else if (n == 0 || n == 1) {
			return dp[n] = 1;
		} else if (n == 2) {
			return dp[n] = 2;
		} else {
			return dp[n] = func_dp(n - 1) + func_dp(n - 2) + func_dp(n - 3);
		}
	}

	private static int[] dp = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			dp = new int[N + 1];
			System.out.println(func_dp(N));
		}
	}
}
