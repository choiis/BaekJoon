import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2146 {
	private static Scanner sc;

	private static int N;

	private static int[][] map;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static boolean[][] visited;

	private static void dfs(int nowX, int nowY, int island) {
		visited[nowX][nowY] = true;
		map[nowX][nowY] = island;

		for (int i = 0; i < direct.length; i++) {
			int nextX = nowX + direct[i][0];
			int nextY = nowY + direct[i][1];
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}
			if (map[nextX][nextY] > 0 && !visited[nextX][nextY]) {
				dfs(nextX, nextY, island);
			}
		}
	}

	private static int bfs(int island) {
		visited = new boolean[N][N];
		Queue<IslandSea> queue = new LinkedList<IslandSea>();

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				if (island == map[j][k]) {
					queue.add(new IslandSea(j, k));
					visited[j][k] = true;
				}
			}
		}

		int cnt = 0;
		while (!queue.isEmpty()) {

			int nowSize = queue.size();
			for (int j = 0; j < nowSize; j++) {

				IslandSea now = queue.poll();
				int x = now.getX();
				int y = now.getY();
				for (int k = 0; k < direct.length; k++) {
					int nextX = x + direct[k][0];
					int nextY = y + direct[k][1];
					if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
						continue;
					}

					if (!visited[nextX][nextY] && (map[nextX][nextY] != island && map[nextX][nextY] != 0)) {
						return cnt;
					} else if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
						visited[nextX][nextY] = true;
						queue.add(new IslandSea(nextX, nextY));
					}
				}
			}
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int island = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					dfs(i, j, island);
					island++;
				}
			}
		}
		int result = N * N;
		for (int i = 1; i < island; i++) {
			result = Math.min(result, bfs(i));
		}
		System.out.println(result);
	}
}

class IslandSea {
	private int x;
	private int y;

	public IslandSea() {

	}

	public IslandSea(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}