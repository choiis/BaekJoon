import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon9465 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon9465.txt"));
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] S = new int[N][2];
			int[][] dp = new int[N][2];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < S.length; j++) {
					S[j][i] = sc.nextInt();
				}
			}
			dp[0][0] = S[0][0];
			dp[0][1] = S[0][1];

			for (int i = 1; i < N; i++) {
				if (i == 1) {
					dp[i][0] = dp[i - 1][1] + S[i][0];
					dp[i][1] = dp[i - 1][0] + S[i][1];
				} else {
					dp[i][0] = Math.max(Math.max(dp[i - 2][0], dp[i - 2][1]), dp[i - 1][1]) + S[i][0];
					dp[i][1] = Math.max(Math.max(dp[i - 2][1], dp[i - 2][0]), dp[i - 1][0]) + S[i][1];
				}
			}

			System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));

		}
	}
}