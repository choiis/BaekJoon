import java.util.Scanner;

public class BaekJoon9461 {

	private static Scanner sc = null;

	private static long[] dp = new long[101];

	private static long P(int N) {
		if (dp[N] != 0) {
			return dp[N];
		} else if (N == 1 || N == 2 || N == 3) {
			return dp[N] = 1;
		} else if (N == 4 || N == 5) {
			return dp[N] = 2;
		} else {
			return dp[N] = P(N - 1) + P(N - 5);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			System.out.println(P(N));
		}
	}
}