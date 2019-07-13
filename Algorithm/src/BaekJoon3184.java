import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon3184 {

	private static Scanner sc;

	private static int[][] direct = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] grid = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			grid[i] = str.toCharArray();
		}

		int totalWolf = 0;
		int totalSheep = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && (grid[i][j] == 'v' || grid[i][j] == 'o')) {
					// bfs½ÃÀÛÁ¡
					int wolf = 0;
					int sheep = 0;
					if (grid[i][j] == 'v') {
						wolf++;
					} else if (grid[i][j] == 'o') {
						sheep++;
					}

					Queue<Field> queue = new LinkedList<>();
					queue.add(new Field(i, j));
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						Field field = queue.poll();
						int nowX = field.x;
						int nowY = field.y;
						for (int k = 0; k < direct.length; k++) {
							int nextX = nowX + direct[k][0];
							int nextY = nowY + direct[k][1];
							if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
								if (!visited[nextX][nextY] && grid[nextX][nextY] != '#') {
									queue.add(new Field(nextX, nextY));
									visited[nextX][nextY] = true;
									if (grid[nextX][nextY] == 'v') {
										wolf++;
									} else if (grid[nextX][nextY] == 'o') {
										sheep++;
									}
								}
							}
						}
					}

					if (sheep > wolf) {
						totalSheep += sheep;
					} else {
						totalWolf += wolf;
					}
				
				}
			}
		}

		System.out.println(totalSheep + " " + totalWolf);
	}
}

class Field {
	int x;
	int y;

	public Field() {
	}

	public Field(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}