import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1726 {
	private static Scanner sc;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static int M;
	private static int N;
	private static int[][] board;

	private static int startX;
	private static int startY;
	private static int startD;
	private static int endX;
	private static int endY;
	private static int endD;

	private static boolean[][][] visited;

	private static Queue<Robot> queue;

	private static int bfs() {
		while (!queue.isEmpty()) {
			Robot now = queue.poll();

			int nowX = now.x;
			int nowY = now.y;
			int nowD = now.d;
			int nowCnt = now.cnt;

			if (nowX == endX && nowY == endY && nowD == endD) {
				return nowCnt;
			}

			for (int i = 1; i <= 3; i++) {
				int nextX = nowX + direct[nowD][0] * i;
				int nextY = nowY + direct[nowD][1] * i;

				if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
					if (!visited[nextX][nextY][nowD] && board[nextX][nextY] == 0) {
						visited[nextX][nextY][nowD] = true;
						queue.add(new Robot(nextX, nextY, nowD, nowCnt + 1));
					} else {
						break;
					}
				}

			}

			for (int j = 0; j < 4; j++) {
				if (j != nowD && !visited[nowX][nowY][j]) {
					visited[nowX][nowY][j] = true;
					queue.add(new Robot(nowX, nowY, j, nowCnt + 1));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		board = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 0 µ¿ 1¼­ 2³² 3ºÏ
		visited = new boolean[M][N][4];
		startX = sc.nextInt() - 1;
		startY = sc.nextInt() - 1;
		startD = sc.nextInt() - 1;
		queue = new LinkedList<Robot>();
		queue.add(new Robot(startX, startY, startD, 0));
		visited[startX][startY][startD] = true;
		endX = sc.nextInt() - 1;
		endY = sc.nextInt() - 1;
		endD = sc.nextInt() - 1;
		System.out.println(bfs());
	}
}

class Robot {
	int x;
	int y;
	int d;

	int cnt;

	public Robot() {

	}

	public Robot(int x, int y, int d, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}

}