import java.util.Scanner;

public class BaekJoon11051 {

	private static Scanner sc = null;

	private static int DIV = 10007;

	private static long[][] dp = null;

	private static long comb(int N, int K) {

		if (dp[N][K] != 0) {
			return dp[N][K];
		}

		if (N == K || K == 0) {
			return dp[N][K] = 1;
		} else {
			return dp[N][K] = (comb(N - 1, K) + comb(N - 1, K - 1)) % DIV;
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		dp = new long[N + 1][K + 1];
		System.out.println(comb(N, K));
	}
}