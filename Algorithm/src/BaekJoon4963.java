import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon4963 {
	private static Scanner sc = null;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 },
			{ -1, -1 } };

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon4963.txt"));
		while (true) {
			int W = sc.nextInt();
			int H = sc.nextInt();
			if (W == 0 && H == 0) {
				break;
			}
			int[][] island = new int[W][H];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					island[j][i] = sc.nextInt();
				}
			}
			boolean[][] visited = new boolean[W][H];
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[j][i] && island[j][i] == 1) {
						bfs(j, i, island, visited);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void bfs(int x, int y, int[][] island, boolean[][] visited) {

		Queue<Island> queue = new LinkedList<>();
		queue.add(new Island(x, y));
		visited[x][y] = true;
		int H = island[0].length;
		int W = island.length;

		while (!queue.isEmpty()) {
			Island now = queue.poll();
			int X = now.getX();
			int Y = now.getY();
			for (int i = 0; i < direct.length; i++) {
				int nextX = X + direct[i][0];
				int nextY = Y + direct[i][1];
				if (nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) {
					if (!visited[nextX][nextY] && island[nextX][nextY] == 1) {
						queue.add(new Island(nextX, nextY));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}
}

class Island {
	private int x;
	private int y;

	public Island() {

	}

	public Island(int x, int y) {
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
