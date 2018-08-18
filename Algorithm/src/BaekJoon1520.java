import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1520 {

	private static int[][] height = null;
	private static int[][] dp = null;

	private static int M;
	private static int N;

	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	private static int dfs(int x, int y) {

		if (x == 0 && y == 0) {
			return 1;
		}
		
		if (dp[x][y] == -1) {

			dp[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
					if (height[nextX][nextY] > height[x][y]) {
						dp[x][y] += dfs(nextX, nextY);
					}
				}
			}
		}
		return dp[x][y];
	}

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1520.txt"));

		M = sc.nextInt();
		N = sc.nextInt();
		int i, j;
		height = new int[M][N];
		dp = new int[M][N];
		for (i = 0; i < M; i++) {
			for (j = 0; j < N; j++) {
				height[i][j] = sc.nextInt();
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(M - 1, N - 1));
	}
}