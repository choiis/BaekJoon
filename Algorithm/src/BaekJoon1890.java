import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1890 {
	private static Scanner sc = null;

	private static int[][] grid = null;

	private static long dfs(int x, int y, int N, int cnt) {

		if (x == N - 1 && y == N - 1) {
			return 1;
		}

		int jump = grid[x][y];
		if (x + jump >= 0 && y >= 0 && x + jump < N && y < N) {
			return cnt += dfs(x + jump, y, N, cnt);
		} else if (x >= 0 && y + jump >= 0 && x < N && y + jump < N) {
			return cnt + dfs(x, y + jump, N, cnt);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1890.txt"));

		int N = sc.nextInt();
		grid = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		System.out.println(dfs(0, 0, N, 0));
	}
}