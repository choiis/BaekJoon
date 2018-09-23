import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon2167 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon2167.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[][] dp = new int[N + 1][M + 1];

			for (int a = i; a <= x; a++) {
				dp[a][j] = arr[a][j];
				for (int b = j + 1; b <= y; b++) {
					dp[a][b] += dp[a][b - 1] + arr[a][b];
				}
			}
			for (int a = i + 1; a <= x; a++) {
				dp[a][y] += dp[a - 1][y];
			}

			System.out.println(dp[x][y]);
		}
	}
}