import java.util.Scanner;

public class BaekJoon10164 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[N][M];
		if (K != 0) {
			int x = (K - 1) / M;
			int y = (K - 1) % M;
			for (int i = 0; i <= x; i++) {
				dp[i][0] = 1;
			}
			for (int i = 0; i <= y; i++) {
				dp[0][i] = 1;
			}
			for (int i = 1; i <= x; i++) {
				for (int j = 1; j <= y; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			for (int i = x + 1; i < N; i++) {
				dp[i][y] = dp[x][y];
			}
			for (int i = y + 1; i < M; i++) {
				dp[x][i] = dp[x][y];
			}
			for (int i = x + 1; i < N; i++) {
				for (int j = y + 1; j < M; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			System.out.println(dp[N - 1][M - 1]);
		} else {
			for (int i = 0; i < N; i++) {
				dp[i][0] = 1;
			}
			for (int i = 0; i < M; i++) {
				dp[0][i] = 1;
			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < M; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			System.out.println(dp[N - 1][M - 1]);
		}
	}
}