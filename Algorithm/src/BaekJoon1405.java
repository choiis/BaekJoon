import java.util.Scanner;

public class BaekJoon1405 {
	private static Scanner sc;

	private static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static double[] probability = new double[4];

	private static boolean[][] grid = new boolean[29][29];

	private static double dfs(int x, int y, int n) {
		if (grid[x][y]) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		grid[x][y] = true;
		double cnt = 0;
		for (int i = 0; i < 4; i++) {
			cnt += probability[i] * dfs(x + direction[i][0], y + direction[i][1], n - 1);
		}
		grid[x][y] = false;
		return cnt;
	}

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < 4; i++) {
			int prop = sc.nextInt();
			probability[i] = prop / 100.0;
		}

		System.out.println(dfs(14, 14, N));
	}

}
