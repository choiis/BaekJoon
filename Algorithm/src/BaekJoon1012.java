import java.util.Scanner;

public class BaekJoon1012 {

	private static Scanner sc;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int M, N;

	private static void dfs(int X, int Y, int[][] grid) {
		for (int i = 0; i < 4; i++) {
			int nextX = X + direct[i][0];
			int nextY = Y + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
				if (grid[nextX][nextY] == 1) {
					grid[nextX][nextY] = -1; // ¹æ¹® grid
					dfs(nextX, nextY, grid);
				}
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int K;

			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			int[][] grid = new int[M][N];

			for (int i = 0; i < K; i++) {
				int X, Y;
				X = sc.nextInt();
				Y = sc.nextInt();
				grid[X][Y] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == 1) {
						grid[i][j] = -1;
						dfs(i, j, grid);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}