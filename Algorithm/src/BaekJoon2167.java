import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon2167 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon2167.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[][] dp = new int[N][M];
			dp[i - 1][j - 1] = arr[i - 1][j - 1];

			for (int a = i - 1; a < x; a++) {
				for (int b = j - 1; b < y; b++) {

				}
			}

			System.out.println(dp[x - 1][y - 1]);
		}
	}
}