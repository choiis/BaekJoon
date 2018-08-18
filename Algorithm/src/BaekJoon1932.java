import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1932 {

	private static Scanner sc = null;

	private static int[][] dp = null;
	private static int[][] tr = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1932.txt"));

		int N = sc.nextInt();
		int i, j;
		tr = new int[N][N];
		dp = new int[N][N];

		int max = 0;

		for (i = 0; i < N; i++) {
			for (j = 0; j < i + 1; j++) {
				tr[i][j] = sc.nextInt();
			}
		}

		for (i = 0; i < N; i++) {
			for (j = 0; j < i + 1; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = tr[i][j];
				} else if (i > 0 && j == 0) {
					dp[i][j] = dp[i - 1][j] + tr[i][j];
				} else if (i > 0 && j == i) {
					dp[i][j] = dp[i - 1][j - 1] + tr[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j] + tr[i][j], dp[i - 1][j - 1] + tr[i][j]);
				}

				if (i == N - 1) {
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);
	}
}