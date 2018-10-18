import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1890 {
	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1890.txt"));

		int N = sc.nextInt();
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0) { // °¥¼ö ¾ø´ÂÄ­ pass
					continue;
				}
				if (i == N - 1 && j == N - 1) { // µµÂø
					continue;
				}
				int jump = grid[i][j];
				int nextI = jump + i;
				int nextJ = jump + j;
				if (nextI < N) {
					dp[nextI][j] += dp[i][j];
				}
				if (nextJ < N) {
					dp[i][nextJ] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}
}