import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon3190 {

	private static Scanner sc;

	// 0 위 1아래 2왼 3오른
	private static int[][] directs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 0 위 1아래 2왼 3오른
	private static int nextDirect(int now, char next) {
		if (next == 'L') { // 왼쪽
			if (now == 0) {
				return 2;
			} else if (now == 1) {
				return 3;
			} else if (now == 2) {
				return 1;
			} else {
				return 0;
			}
		} else { // 오른쪽
			if (now == 0) {
				return 3;
			} else if (now == 1) {
				return 2;
			} else if (now == 2) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon3190.txt"));
		int N = sc.nextInt();
		int[][] grid = new int[N][N];
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			grid[x - 1][y - 1] = 1; // 1 사과
		}
		int L = sc.nextInt();
		List<Direction> list = new ArrayList<>();
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			char y = sc.next().charAt(0);
			list.add(new Direction(x, y));
		}

		int x = 0;
		int y = 0;
		int direct = 3;
		grid[x][y] = 2;
		List<Snake> snake = new ArrayList<>();
		snake.add(new Snake(x, y));
		int second = 0;

		int idx = 0;
		boolean flag = false;

		while (true) {
			if (!flag && second == list.get(idx).getGo()) {
				direct = nextDirect(direct, list.get(idx++).getDirect());
				if (idx == list.size()) {
					flag = true;
				}
			}
			int nextX = x + directs[direct][0];
			int nextY = y + directs[direct][1];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				break;
			}
			if (grid[nextX][nextY] == 2) {
				break;
			} else if (grid[nextX][nextY] == 0) {
				grid[snake.get(0).getX()][snake.get(0).getY()] = 0;
				snake.remove(0);
			}

			x = nextX;
			y = nextY;
			grid[x][y] = 2;
			snake.add(new Snake(x, y));
			second++;
		}
		System.out.println(second + 1);
	}
}

class Snake {
	private int x;
	private int y;

	public Snake(int x, int y) {
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

class Direction {
	private int go;
	private char direct;

	public Direction(int go, char direct) {
		super();
		this.go = go;
		this.direct = direct;
	}

	public int getGo() {
		return go;
	}

	public void setGo(int go) {
		this.go = go;
	}

	public char getDirect() {
		return direct;
	}

	public void setDirect(char direct) {
		this.direct = direct;
	}

}