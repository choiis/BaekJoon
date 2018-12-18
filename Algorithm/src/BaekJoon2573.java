import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2573 {
	private static Scanner sc;

	private static int N, M;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			int nowX = pair.getX();
			int nowY = pair.getY();

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + direct[i][0];
				int nextY = nowY + direct[i][1];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if (!visited[nextX][nextY] && arr[nextX][nextY] > 0) {
						visited[nextX][nextY] = true;
						queue.add(new Pair(nextX, nextY));
					}
				}
			}
		}
	}

	private static void init() {
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] > 0) {
					if (i - 1 >= 0) {
						if (arr[i - 1][j] == 0 && arr[i][j] > 0) {
							arr[i][j]--;
						}
					}
					if (i + 1 < N) {
						if (arr[i + 1][j] == 0 && arr[i][j] > 0) {
							arr[i][j]--;
						}
					}
					if (j - 1 >= 0) {
						if (arr[i][j - 1] == 0 && arr[i][j] > 0) {
							arr[i][j]--;
						}
					}
					if (j + 1 < M) {
						if (arr[i][j + 1] == 0 && arr[i][j] > 0) {
							arr[i][j]--;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		while (true) {
			int part = 0;
			boolean clear = true;
			// 초기화
			for (int i = 0; i < N; i++) {
				if (!clear) {
					break;
				}
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 0) {
						clear = false;
						break;
					}
				}
			}
			if (clear) {
				cnt = 0;
				break;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visited[i][j] && arr[i][j] != 0) {
						bfs(i, j);
						part++;
					}
				}
			}
			if (part > 1) {
				break;
			}
			cnt++;

			// 초기화
			init();
		}
		System.out.println(cnt);
	}
}

class Pair {
	private int x;
	private int y;

	public Pair() {
		super();
	}

	public Pair(int x, int y) {
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