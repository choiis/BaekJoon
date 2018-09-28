import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7562 {

	private static Scanner sc = null;

	private static int[][] direct = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 },
			{ -1, -2 } };

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon7562.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();
			boolean[][] visited = new boolean[N][N];
			Queue<ChessBoard> queue = new LinkedList<>();
			int cnt = 0;
			visited[startX][startY] = true;
			queue.add(new ChessBoard(startX, startY, cnt));
			while (!queue.isEmpty()) {
				ChessBoard now = queue.poll();
				int nowX = now.getX();
				int nowY = now.getY();
				int nowIdx = now.getIdx();
				if (nowX == endX && nowY == endY) {
					System.out.println(nowIdx);
					break;
				}

				for (int i = 0; i < direct.length; i++) {
					int nextX = nowX + direct[i][0];
					int nextY = nowY + direct[i][1];
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
						if (!visited[nextX][nextY]) {
							visited[nextX][nextY] = true;
							queue.add(new ChessBoard(nextX, nextY, nowIdx + 1));
						}
					}
				}
			}
		}
	}
}

class ChessBoard {
	private int x;
	private int y;
	private int idx;

	public ChessBoard(int x, int y, int idx) {
		super();
		this.x = x;
		this.y = y;
		this.idx = idx;
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

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

}