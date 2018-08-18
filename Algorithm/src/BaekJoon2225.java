import java.util.Scanner;

public class BaekJoon2225 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		long DIV = 1000000000;

		long[][] dp = new long[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][1] = 1;
		}

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				for (int k = 0; k <= j; k++) {
					dp[j][i] = (dp[j][i] + dp[k][i - 1]) % DIV;
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}