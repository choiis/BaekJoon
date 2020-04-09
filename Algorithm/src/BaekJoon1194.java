import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1194 {
	private static Scanner sc;

	private static int N;
	private static int M;
	private static char[][] maze;
	private static boolean[][][] visited;

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int bfs(int startX, int starty) {
		Queue<Moon> queue = new LinkedList<Moon>();
		visited[startX][starty][0] = true;
		queue.add(new Moon(startX, starty, 0));
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Moon now = queue.poll();
				int nowX = now.getX();
				int nowY = now.getY();
				int nowKey = now.getKey();

				if (maze[nowX][nowY] == '1') {
					return time;
				}

				for (int j = 0; j < 4; j++) {
					int nextX = nowX + direct[j][0];
					int nextY = nowY + direct[j][1];
					int key = nowKey;

					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
						if (maze[nextX][nextY] != '#') {
							if ('a' <= maze[nextX][nextY] && maze[nextX][nextY] <= 'f') {
								key |= (1 << maze[nextX][nextY] - 'a');
							}
							if ('A' <= maze[nextX][nextY] && maze[nextX][nextY] <= 'F') {
								if ((key & (1 << (maze[nextX][nextY] - 'A'))) == 0) {
									continue;
								}
							}
							if (visited[nextX][nextY][key]) {
								continue;
							}
							visited[nextX][nextY][key] = true;
							queue.add(new Moon(nextX, nextY, key));
						}
					}

				}
			}
			time++;
		}
		return -1;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		maze = new char[N][M];
		visited = new boolean[N][M][1 << 6];
		int startX = -1;
		int startY = -1;
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j);
				if (maze[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		System.out.println(bfs(startX, startY));
	}
}

class Moon {
	private int x;
	private int y;
	private int key;

	Moon(int x, int y, int key) {
		this.x = x;
		this.y = y;
		this.key = key;
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

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

}