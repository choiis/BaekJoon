import java.util.Scanner;

public class BaekJoon4677 {

	private static Scanner sc;

	private static int m;
	private static int n;

	private static char[][] grid = null;
	private static boolean[][] visited = null;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
			{ -1, -1 } };

	private static void dfs(int startX, int startY) {
		visited[startX][startY] = true;

		for (int i = 0; i < direct.length; i++) {
			int nextX = startX + direct[i][0];
			int nextY = startY + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
				if (!visited[nextX][nextY] && grid[nextX][nextY] == '@') {
					dfs(nextX, nextY);
				}
			}
		}
		//visited[startX][startY] = false;
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		while (true) {
			m = sc.nextInt();
			n = sc.nextInt();

			if (m == 0) {
				break;
			}

			grid = new char[m][n];

			for (int i = 0; i < m; i++) {
				String line = sc.next();
				grid[i] = line.toCharArray();
			}

			visited = new boolean[m][n];
			int cnt = 0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && grid[i][j] == '@') {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}