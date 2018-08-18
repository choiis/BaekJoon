
public class BaekJoon2589 {

	private static int max = Integer.MIN_VALUE;
	private static int M;
	private static int N;
	private static boolean[][] visited = null;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {

		M = 5;
		N = 7;

		String[] land = { "WLLWWWL", "LLLWLLL", "LWLWLWW", "LWLWLLL", "WLLWLWW" };

		visited = new boolean[M][N];
		int start_x = 0;
		int start_y = 6;

		dfs(start_x, start_y, 0, land);
		System.out.println(max);
	}

	private static void dfs(int x, int y, int cnt, String[] land) {

		if (x < 0 || y < 0 || x >= M || y >= N) {
			return;
		}

		if (visited[x][y] || land[x].charAt(y) == 'W') {
			return;
		}

		if (max <= cnt) {
			max = cnt;
		}

		visited[x][y] = true;
		for (int i = 0; i < direct.length; i++) {
			dfs(x + direct[i][0], y + direct[i][1], cnt + 1, land);
		}

	}
}