import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon16234 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	private static int[][] arr;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;

		while (true) {
			boolean flag = true;
			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N * N; i++) {
				int x = i / N;
				int y = i % N;
				if (visited[x][y]) {
					continue;
				}

				Queue<Grid> queue = new LinkedList<>();
				Vector<Grid> save = new Vector<>();
				queue.add(new Grid(x, y));
				save.add(new Grid(x, y));
				visited[x][y] = true;
				int totalSum = arr[x][y];

				while (!queue.isEmpty()) {
					Grid grid = queue.poll();
					int nowX = grid.getX();
					int nowY = grid.getY();
					for (int j = 0; j < direct.length; j++) {
						int nextX = nowX + direct[j][0];
						int nextY = nowY + direct[j][1];
						if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
							if (!visited[nextX][nextY]) {
								int gap = Math.abs(arr[nextX][nextY] - arr[nowX][nowY]);
								if (L <= gap && gap <= R) {
									visited[nextX][nextY] = true;
									queue.add(new Grid(nextX, nextY));
									save.add(new Grid(nextX, nextY));
									totalSum += arr[nextX][nextY];
								}
							}
						}
					}
				}
				if (save.size() > 1) {
					flag = false;
					int population = totalSum / save.size();
					for (int j = 0; j < save.size(); j++) {
						arr[save.elementAt(j).getX()][save.elementAt(j).getY()] = population;
					}
				}

			}

			if (flag) {
				break;
			} else {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}

class Grid {

	private int x;
	private int y;

	public Grid() {
		super();
	}

	public Grid(int x, int y) {
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