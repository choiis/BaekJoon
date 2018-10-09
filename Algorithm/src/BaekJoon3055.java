import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon3055 {

	private static Scanner sc;

	private static int[][] direct = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static char[][] forest;

	private static int N;
	private static int M;

	private static Queue<Wood> water;
	private static Queue<Wood> hedgehog;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon3055.txt"));
		N = sc.nextInt();
		M = sc.nextInt();
		forest = new char[N][M];

		water = new LinkedList<>();
		hedgehog = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			forest[i] = str.toCharArray();
			for (int j = 0; j < M; j++) {
				if (forest[i][j] == '*') {
					water.add(new Wood(i, j));
				} else if (forest[i][j] == 'S') {
					hedgehog.add(new Wood(i, j));
				}
			}
		}

		int cnt = 1;
		boolean fail = false;
		while (true) {
			waterTurn();

			int c = hedgehogTurn();
			if (c == 0) {
				fail = true;
				break;
			} else if (c < 0) {
				break;
			} else {
				cnt++;
			}
		}
		if (!fail) {
			System.out.println(cnt);
		} else {
			System.out.println("KAKTUS");
		}

	}

	private static void waterTurn() {

		int size = water.size();

		for (int i = 0; i < size; i++) {
			Wood now = water.poll();
			int nowX = now.getX();
			int nowY = now.getY();
			for (int j = 0; j < 4; j++) {
				int nextX = nowX + direct[j][0];
				int nextY = nowY + direct[j][1];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if (forest[nextX][nextY] == '.') {
						forest[nextX][nextY] = '*';
						water.add(new Wood(nextX, nextY));
					}
				} else {
					continue;
				}
			}
		}

	}

	private static int hedgehogTurn() {

		int size = hedgehog.size();

		for (int i = 0; i < size; i++) {
			Wood now = hedgehog.poll();
			int nowX = now.getX();
			int nowY = now.getY();
			for (int j = 0; j < 4; j++) {
				int nextX = nowX + direct[j][0];
				int nextY = nowY + direct[j][1];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if (forest[nextX][nextY] == 'D') {
						return -1;
					} else if (forest[nextX][nextY] == '.') {
						forest[nextX][nextY] = 'S';
						hedgehog.add(new Wood(nextX, nextY));
					}
				} else {
					continue;
				}
			}
		}

		return hedgehog.size();
	}
}

class Wood {
	private int x;
	private int y;

	public Wood() {

	}

	public Wood(int x, int y) {
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
