import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon11559_2 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	private static char[][] grid;
	private final static int N = 12;
	private final static int M = 6;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon11559.txt"));
		grid = new char[N][M];
		String str;
		for (int i = 0; i < N; i++) {
			str = sc.next();
			grid[i] = str.toCharArray();
		}

		int cnt = 0;
		while (true) {
			boolean flag = true;
			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < N * M; i++) {
				int x = i / M;
				int y = i % M;
				if (visited[x][y] || grid[x][y] == '.') {
					continue;
				}

				Queue<Puyo2> queue = new LinkedList<>();
				Vector<Puyo2> save = new Vector<>();
				queue.add(new Puyo2(x, y, grid[x][y]));
				save.add(new Puyo2(x, y, grid[x][y]));
				visited[x][y] = true;

				while (!queue.isEmpty()) {
					Puyo2 nowPuyo = queue.poll();
					int nowX = nowPuyo.getX();
					int nowY = nowPuyo.getY();
					char nowColor = nowPuyo.getColor();
					for (int j = 0; j < direct.length; j++) {
						int nextX = nowX + direct[j][0];
						int nextY = nowY + direct[j][1];
						if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
							if (!visited[nextX][nextY] && grid[nextX][nextY] == nowColor) {
								queue.add(new Puyo2(nextX, nextY, grid[nextX][nextY]));
								save.add(new Puyo2(nextX, nextY, grid[nextX][nextY]));
								visited[nextX][nextY] = true;
							}
						}
					}
				}

				if (save.size() >= 4) {
					for (int j = 0; j < save.size(); j++) {
						flag = false;
						grid[save.get(j).getX()][save.get(j).getY()] = '.';
					}
				}

			}

			if (flag) {
				break;
			} else {
				cnt++;

				for (int i = 0; i < M; i++) {
					for (int j = N - 2; j >= 0; j--) {
						for (int k = N - 1; k > j; k--) {
							if (grid[j][i] != '.' && grid[k][i] == '.') {
								grid[k][i] = grid[j][i];
								grid[j][i] = '.';
								break;
							}
						}
					}
				}
			}
		}

		System.out.println(cnt);
	}
}

class Puyo2 {
	private int x;
	private int y;
	private char color;

	public Puyo2() {
		super();
	}

	public Puyo2(int x, int y, char color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
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

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

}