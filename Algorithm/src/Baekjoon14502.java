
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon14502 {

	private static Scanner sc;

	private static int N;
	private static int M;

	private static int max = 0;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	private static void dfsFillGrid(int[][] grid, int cnt) {

		if (cnt == 3) {

			max = Math.max(max, spreadVirus(grid));
			return;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 0) {
						grid[i][j] = 1;
						dfsFillGrid(grid, cnt + 1);
						grid[i][j] = 0;
					}
				}
			}
		}
	}

	private static int spreadVirus(int[][] grid) {

		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = grid[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2) {
					Queue<Virus> queue = new LinkedList<>();
					queue.add(new Virus(i, j));

					while (!queue.isEmpty()) {
						Virus now = queue.poll();
						for (int k = 0; k < direct.length; k++) {
							int nextX = now.x + direct[k][0];
							int nextY = now.y + direct[k][1];
							if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
								if (copy[nextX][nextY] == 0) {
									copy[nextX][nextY] = 3;
									queue.add(new Virus(nextX, nextY));
								}
							}
						}
					}
				}
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				grid[i][j] = sc.nextInt();
			}
		}

		dfsFillGrid(grid, 0);
		System.out.println(max);
	}
}

class Virus {
	int x;
	int y;

	public Virus(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}