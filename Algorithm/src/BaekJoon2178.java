
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class where {

	private int x;
	private int y;

	public where(int x, int y) {
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

public class BaekJoon2178 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2178.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] board = new int[N][M];
		int[][] distance = new int[N][M];
		int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		String in = null;
		for (int i = 0; i < N; i++) {
			in = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = in.charAt(j) - '0';
			}
		}
		distance[0][0] = 1;
		Queue<where> queue = new LinkedList<>();
		queue.add(new where(0, 0));
		while (!queue.isEmpty()) {
			where now = queue.poll();
			for (int i = 0; i < direct.length; i++) {
				int nowX = now.getX();
				int nowY = now.getY();
				int nextX = nowX + direct[i][0];
				int nextY = nowY + direct[i][1];

				if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && board[nextX][nextY] == 1) {
					queue.add(new where(nextX, nextY));
					board[nextX][nextY] = 0;
					distance[nextX][nextY] = distance[nowX][nowY] + 1;
				}
			}
		}

		System.out.println(distance[N - 1][M - 1]);
	}
}