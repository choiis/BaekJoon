import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2589 {

	private static Scanner sc;

	private static int N;
	private static int M;
	private static char[][] map;
	private static boolean[][] visited;
	private static boolean[][] selected;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static Map bfs_findFar(int x, int y) {
		visited[x][y] = true;
		Queue<Map> queue = new LinkedList<>();
		queue.add(new Map(x, y, 0));
		Map far = new Map(x, y, 0);
		while (!queue.isEmpty()) {
			Map now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowDist = now.dist;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + direct[i][0];
				int nextY = nowY + direct[i][1];
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (!visited[nextX][nextY] && map[nextX][nextY] == 'L') {
						visited[nextX][nextY] = true;
						queue.add(new Map(nextX, nextY, nowDist + 1));
						if (nowDist + 1 > far.dist) {
							far.x = nextX;
							far.y = nextY;
							far.dist = nowDist + 1;
						}
					}
				}
			}
		}
		return far;
	}

	private static int bfs_farDist(Map far) {
		int cnt = 0;
		selected[far.x][far.y] = true;
		Queue<Map> queue = new LinkedList<>();
		queue.add(new Map(far.x, far.y, 0));
		while (!queue.isEmpty()) {
			Map now = queue.poll();
			int nowX = now.x;
			int nowY = now.y;
			int nowDist = now.dist;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + direct[i][0];
				int nextY = nowY + direct[i][1];
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (!selected[nextX][nextY] && map[nextX][nextY] == 'L') {
						selected[nextX][nextY] = true;
						queue.add(new Map(nextX, nextY, nowDist + 1));
						cnt = Math.max(cnt, nowDist + 1);
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon2589.txt"));
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visited = new boolean[N][M];
		selected = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			map[i] = str.toCharArray();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] == 'L') {
					Map far = bfs_findFar(i, j);
					max = Math.max(max, bfs_farDist(far));
				}
			}
		}
		System.out.println(max);
	}
}

class Map {
	int x;
	int y;
	int dist;

	public Map(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}