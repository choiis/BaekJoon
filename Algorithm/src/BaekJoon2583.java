import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon2583 {

	private static int[][] grid = null;
	private static boolean[][] visited = null;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static int M;
	private static int N;

	private static int dfs(int startX, int startY, int cnt) {

		visited[startX][startY] = true;
		cnt++;
		for (int i = 0; i < direct.length; i++) {
			int nextX = startX + direct[i][0];
			int nextY = startY + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
				if (!visited[nextX][nextY] && grid[nextX][nextY] == 0) {
					cnt = dfs(nextX, nextY, cnt);
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileInputStream("baekjoon2583.txt"));

		M = sc.nextInt();
		N = sc.nextInt();

		int K = sc.nextInt();
		grid = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					grid[x][y] = 1;
				}
			}
		}

		int cnt = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && grid[i][j] == 0) {
					cnt++;
					int result = dfs(i, j, 0);
					heap.add(result);
				}
			}
		}

		System.out.println(cnt);
		Iterator<Integer> iter = heap.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}