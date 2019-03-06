
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon5558 {
	private static Scanner sc;

	private static int H;
	private static int W;
	private static char[][] grid;
	private static int N;

	private static int[][] direct = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		H = sc.nextInt();
		W = sc.nextInt();
		grid = new char[H][W];
		N = sc.nextInt();

		int startX = 0, startY = 0;
		for (int i = 0; i < H; i++) {
			String str = sc.next();
			grid[i] = str.toCharArray();
			for (int j = 0; j < W; j++) {
				if (grid[i][j] == 'S') {
					startX = i;
					startY = j;
					grid[i][j] = '.';
					break;
				}
			}
		}
		boolean[][] visited;
		Queue<Cheese> queue = new LinkedList<>();
		int dist = 0;
		int nowPower = 1;
		while (nowPower <= N) {
			queue.clear();
			visited = new boolean[H][W];
			queue.add(new Cheese(startX, startY, 0));
			visited[startX][startY] = true;
			while (!queue.isEmpty()) {
				Cheese cheese = queue.poll();
				boolean outWhile = false;
				for (int i = 0; i < direct.length; i++) {
					int nextX = cheese.getX() + direct[i][0];
					int nextY = cheese.getY() + direct[i][1];
					int nextDist = cheese.getDist() + 1;
					if (nextX >= 0 && nextY >= 0 && nextX < H && nextY < W) {
						if ((grid[nextX][nextY] - '0') == nowPower) {
							dist += nextDist;
							startX = nextX;
							startY = nextY;
							nowPower++;
							visited = null;
							outWhile = true;
							break;
						} else if (!visited[nextX][nextY] && grid[nextX][nextY] != 'X') {
							visited[nextX][nextY] = true;
							queue.add(new Cheese(nextX, nextY, nextDist));
						}
					}
				}
				if (outWhile) {
					break;
				}
			}
		}
		System.out.println(dist);
	}
}

class Cheese {
	private int x;
	private int y;
	private int dist;

	public Cheese(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
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

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

}