import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon2468 {
	private static Scanner sc = null;

	private static int N;

	private static int[][] water = null;

	private static int[][] direct = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

	private static boolean[][] visited = null;

	private static void dfs(int x, int y, int water_level) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {

			int dx = x + direct[i][0];
			int dy = y + direct[i][1];

			if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
				if (!visited[dx][dy] && water_level < water[dx][dy]) {
					dfs(dx, dy, water_level);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon2468.txt"));

		N = sc.nextInt();
		water = new int[N][N];

		int min_water = Integer.MAX_VALUE;
		int max_water = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				water[i][j] = sc.nextInt();
				min_water = Math.min(min_water, water[i][j]);
				max_water = Math.max(max_water, water[i][j]);
			}
		}

		int max = 1;

		for (int water_level = min_water; water_level < max_water; water_level++) {
			visited = new boolean[N][N];
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && water_level < water[j][k]) {
						dfs(j, k, water_level);
						cnt++;
					}
				}
			}

			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}
}