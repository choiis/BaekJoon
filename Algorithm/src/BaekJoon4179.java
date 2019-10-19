import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon4179 {
	private static Scanner sc;

	private static int R;
	private static int C;
	private static char[][] maze;
	private static boolean[][] visited;

	private static Queue<FireRun> queueJihun = new LinkedList<FireRun>();
	private static Queue<FireRun> queueFire = new LinkedList<FireRun>();

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		maze = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			maze[i] = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if ('J' == maze[i][j]) {
					queueJihun.add(new FireRun(i, j));
					maze[i][j] = '.';
					visited[i][j] = true;
				} else if ('F' == maze[i][j]) {
					queueFire.add(new FireRun(i, j));
				}
			}
		}
		sc.close();
		int result = bfs();
		if (result == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs() {
		int cnt = 0;
		while (!queueJihun.isEmpty()) {

			int fireSize = queueFire.size();
			for (int i = 0; i < fireSize; i++) {
				FireRun fireRunNow = queueFire.poll();
				for (int j = 0; j < direct.length; j++) {
					int nextX = fireRunNow.x + direct[j][0];
					int nextY = fireRunNow.y + direct[j][1];
					if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
						if (maze[nextX][nextY] == '.') {
							maze[nextX][nextY] = 'F';
							queueFire.add(new FireRun(nextX, nextY));
						}
					}
				}
			}

			int jihunSize = queueJihun.size();
			for (int i = 0; i < jihunSize; i++) {
				FireRun fireRunNow = queueJihun.poll();
				for (int j = 0; j < direct.length; j++) {
					int nextX = fireRunNow.x + direct[j][0];
					int nextY = fireRunNow.y + direct[j][1];
					if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
						return cnt + 1;
					} else {
						if (maze[nextX][nextY] == '.' && !visited[nextX][nextY]) {
							visited[nextX][nextY] = true;
							queueJihun.add(new FireRun(nextX, nextY));
						}
					}
				}
			}
			cnt++;
		}
		return -1;
	}

	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
}

class FireRun {

	int x;
	int y;

	public FireRun() {

	}

	public FireRun(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}