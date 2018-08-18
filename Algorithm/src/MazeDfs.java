import java.io.FileInputStream;
import java.util.Scanner;

public class MazeDfs {

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int N = 4;
	private static int M = 6;

	private static int min = Integer.MAX_VALUE;
	private static boolean[][] visited = null;
	private static String[] grid = null;

	public static void main(String[] args) throws Exception {

		visited = new boolean[N][M];
		grid = new String[4];
		grid[0] = "110110";
		grid[1] = "110110";
		grid[2] = "111111";
		grid[3] = "111101";
		
		dfs(0, 0, 1);
		System.out.println(min);
	}

	private static void dfs(int x, int y, int c) {

		if (x == N - 1 && y == M - 1) {
			if (c < min) {
				min = c;
			}
			return;
		}
		
		if (x < 0 || y < 0 || x >= N || y >= M) {
			return;
		}

		if (visited[x][y] || (grid[x].charAt(y) == '0')) {
			return;
		}

		

		visited[x][y] = true;

		for (int i = 0; i < direct.length; i++) {
			dfs(x + direct[i][0], y + direct[i][1], c + 1);
		}

		visited[x][y] = false;
	}
}