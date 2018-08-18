import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7576 {

	private static Scanner sc = null;

	private static int M, N;
	private static int[][] tomato = null;

	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	private static int find_min_bfs(Queue<Tomato> queue, int[][] tomato) {

		while (!queue.isEmpty()) {
			Tomato now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && tomato[nextX][nextY] == 0) {
					tomato[nextX][nextY] = tomato[now.x][now.y] + 1;
					queue.add(new Tomato(nextX, nextY));
				}
			}

		}

		int max = 0;
		for (int i = 0; i < tomato.length; i++) {
			for (int j = 0; j < tomato[i].length; j++) {
				if (tomato[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, tomato[i][j]);
			}
		}

		return max - 1;
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon7576.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			tomato = new int[N][M];
			Queue<Tomato> queue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tomato[i][j] = sc.nextInt();
					if (tomato[i][j] == 1)
						queue.add(new Tomato(i, j));
				}
			}
			System.out.println(find_min_bfs(queue, tomato));

			tomato = null;
		}
	}

}

class Tomato {
	int x;
	int y;

	public Tomato() {
	}

	public Tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
