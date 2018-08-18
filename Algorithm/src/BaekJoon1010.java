import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1010 {
	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1010.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] dp = new int[N + 1][M + 1];

			for (int i = 1; i <= M; i++) {
				dp[1][i] = i;
			}

			for (int i = 2; i <= N; i++) {
				for (int k = i; k <= M; k++) {
					for (int l = k - 1; l >= i - 1; l--) {
						dp[i][k] += dp[i - 1][l];
					}
				}
			}
			System.out.println(dp[N][M]);
		}
	}
}