import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon15683 {
	private static Scanner sc = null;

	private static int N;
	private static int M;

	private static int min = Integer.MAX_VALUE;

	private static int[][] field;

	private static List<Camara> camaras;

	private static void copyArr(int[][] grid, int[][] copy) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = grid[i][j];
			}
		}
	}

	private static void dfs(int[][] prev, int depth, int nowDepth) {
		if (depth == nowDepth) {
			min = Math.min(min, count(prev));
			return;
		} else {
			Camara camara = camaras.get(nowDepth);
			int X = camara.x;
			int Y = camara.y;
			int direct = field[X][Y];

			if (direct == 1) {
				for (int i = 1; i <= 4; i++) {
					int[][] copy = new int[N][M];
					copyArr(prev, copy);
					fillGrid(copy, X, Y, i);
					dfs(copy, depth, nowDepth + 1);
				}
			} else if (direct == 2) {
				for (int i = 0; i <= 1; i++) {
					int[][] copy = new int[N][M];
					copyArr(prev, copy);
					fillGrid(copy, X, Y, i);
					fillGrid(copy, X, Y, i + 2);
					dfs(copy, depth, nowDepth + 1);
				}
			} else if (direct == 3) {
				for (int i = 1; i <= 4; i++) {
					int[][] copy = new int[N][M];
					copyArr(prev, copy);
					fillGrid(copy, X, Y, i);
					fillGrid(copy, X, Y, (i + 1) % 4);
					dfs(copy, depth, nowDepth + 1);
				}
			} else if (direct == 4) {
				for (int i = 1; i <= 4; i++) {
					int[][] copy = new int[N][M];
					copyArr(prev, copy);
					fillGrid(copy, X, Y, i);
                    fillGrid(copy, X, Y, (i + 1) % 4);
                    fillGrid(copy, X, Y, (i + 2) % 4);
					dfs(copy, depth, nowDepth + 1);
				}
			} else if (direct == 5) {
				int[][] copy = new int[N][M];
				copyArr(prev, copy);
				for (int i = 0; i < 4; i++) {
					fillGrid(copy, X, Y, i);
				}
				dfs(copy, depth, nowDepth + 1);
			}
		}
	}

	public static void fillGrid(int[][] visited, int i, int j, int direction) {
		switch (direction) {
		case 0:
			for (int k = j; k >= 0; k--) {
				if (field[i][k] == 6) {
					break;
				}
				visited[i][k] = 7;
			}
			break;
		case 1:
			for (int k = i; k >= 0; k--) {
				if (field[k][j] == 6) {
					break;
				}
				visited[k][j] = 7;
			}
			break;
		case 2:
			for (int k = j; k < M; k++) {
				if (field[i][k] == 6) {
					break;
				}
				visited[i][k] = 7;
			}
			break;
		case 3:
			for (int k = i; k < N; k++) {
				if (field[k][j] == 6) {
					break;
				}
				visited[k][j] = 7;
			}
			break;
		}
	}

	private static int count(int[][] grid) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon15683.txt"));

		N = sc.nextInt();
		M = sc.nextInt();
		field = new int[N][M];
		camaras = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				field[i][j] = sc.nextInt();
				if (0 < field[i][j] && field[i][j] < 6) {
					camaras.add(new Camara(i, j));
				}
			}
		}

		dfs(field, camaras.size(), 0);
		System.out.println(min);
	}
}

class Camara {
	int x;
	int y;

	public Camara(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
