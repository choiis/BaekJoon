
import java.util.Scanner;

public class BaekJoon14500 {

	private static Scanner sc = null;

	private static int N;
	private static int M;

	private static int[][] score;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int max = 0;

	private static void dfs(int cnt, int x, int y, boolean[][] visit, int num) {
		if (cnt == 4) {
			max = Math.max(max, num);
			return;
		} else {
			for (int i = 0; i < direct.length; i++) {
				int nextX = x + direct[i][0];
				int nextY = y + direct[i][1];
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (!visit[nextX][nextY]) {
						visit[nextX][nextY] = true;
						dfs(cnt + 1, nextX, nextY, visit, score[nextX][nextY] + num);
						visit[nextX][nextY] = false;
					}
				}
			}
		}
	}

	private static void cross(int x, int y) {
		for (int i = 0; i < direct.length; i++) {
			boolean flag = true;
			int sum = score[x][y];

			for (int j = 0; j < direct.length; j++) {
				if (i == j) {
					continue;
				} else {
					int nextX = x + direct[j][0];
					int nextY = y + direct[j][1];
					if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
						sum += score[nextX][nextY];
					} else {
						flag = false;
						break;
					}
				}
			}
			if (!flag) {
				continue;
			} else {
				max = Math.max(max, sum);
			}
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		score = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				score[i][j] = sc.nextInt();
			}
		}
		boolean[][] visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(1, i, j, visit, score[i][j]);
				visit[i][j] = false;
				cross(i, j);
			}
		}
		System.out.println(max);
	}
}