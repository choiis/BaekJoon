import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2206 {
	private static Scanner sc;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] grid = new int[N][M];
		int[][][] visited = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				grid[i][j] = line.charAt(j) - '0';
			}
		}
		int result = -1;
		Queue<Block> queue = new LinkedList<Block>();
		queue.add(new Block(0, 0, 1));
		visited[0][0][1] = 1;
		while (!queue.isEmpty()) {
			Block block = queue.poll();
			int x = block.getX();
			int y = block.getY();
			int destroy = block.getDestroy();

			if (x == N - 1 && y == M - 1) {
				result = visited[x][y][destroy];
				break;
			}

			for (int i = 0; i < direct.length; i++) {
				int nextX = x + direct[i][0];
				int nextY = y + direct[i][1];

				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
					if (grid[nextX][nextY] == 1 && destroy == 1) {
						visited[nextX][nextY][0] = visited[x][y][destroy] + 1;
						queue.add(new Block(nextX, nextY, 0));
					} else if (grid[nextX][nextY] == 0 && visited[nextX][nextY][destroy] == 0) {
						visited[nextX][nextY][destroy] = visited[x][y][destroy] + 1;
						queue.add(new Block(nextX, nextY, destroy));
					}
				}
			}
		}

		System.out.println(result);
	}

}

class Block {
	private int x;
	private int y;
	private int destroy;

	public Block() {
		super();
	}

	public Block(int x, int y, int destroy) {
		super();
		this.x = x;
		this.y = y;
		this.destroy = destroy;
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

	public int getDestroy() {
		return destroy;
	}

	public void setDestroy(int destroy) {
		this.destroy = destroy;
	}

}