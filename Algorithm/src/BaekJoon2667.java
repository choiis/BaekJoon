import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

public class BaekJoon2667 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2667.txt"));

		int N = sc.nextInt();
		int[][] grid = new int[N][N];

		for (int i = 0; i < grid.length; i++) {
			String input = sc.next();
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = input.charAt(j) - '0';
			}
		}

		boolean[][] visited = new boolean[N][N];

		int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int part = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (grid[i][j] == 1 && !visited[i][j]) {
					Queue<Point> queue = new LinkedList<>();
					// 여기서 부터 BFS 시작
					int way = 0;
					Point where = new Point(i, j);
					visited[i][j] = true;
					queue.add(where);
					way++;

					while (!queue.isEmpty()) {
						Point now = queue.poll();

						for (int k = 0; k < direct.length; k++) {
							int X = now.getX() + direct[k][0];
							int Y = now.getY() + direct[k][1];
							if (X >= 0 && Y >= 0 && X < N && Y < N) {
								if (grid[X][Y] == 1 && !visited[X][Y]) {
									visited[X][Y] = true;
									Point put = new Point(X, Y);
									queue.add(put);
									way++;
								}
							}
						}
					}
					pq.add(way);
					// BFS 끝
					part++;
				} else {
					continue;
				}
			}
		}
		System.out.println(part);
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}