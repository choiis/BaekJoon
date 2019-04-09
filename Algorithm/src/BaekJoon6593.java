import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon6593 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	private static char[][][] building;
	private static int[][][] distance;
	private static boolean[][][] visited;
	private static int L;
	private static int R;
	private static int C;

	private static void dfs(int x, int y, int z, int dist) {
		visited[x][y][z] = true;
		if (distance[x][y][z] == -1) {
			distance[x][y][z] = dist;
		} else {
			distance[x][y][z] = Math.min(distance[x][y][z], dist);
		}

		for (int i = 0; i < direct.length; i++) {
			int nextX = x + direct[i][0];
			int nextY = y + direct[i][1];
			int nextZ = z + direct[i][2];
			if (nextX >= 0 && nextX < L && nextY >= 0 && nextY < R && nextZ >= 0 && nextZ < C) {
				if (building[nextX][nextY][nextZ] != '#' && !visited[nextX][nextY][nextZ]) {
					dfs(nextX, nextY, nextZ, dist + 1);
					visited[nextX][nextY][nextZ] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon6593.txt"));
		while (true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			building = new char[L][R][C];
			distance = new int[L][R][C];
			visited = new boolean[L][R][C];
			int startX = 0, startY = 0, startZ = 0;
			int endX = 0, endY = 0, endZ = 0;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					building[i][j] = sc.next().toCharArray();
					for (int k = 0; k < C; k++) {
						distance[i][j][k] = -1;
						if (building[i][j][k] == 'S') {
							startX = i;
							startY = j;
							startZ = k;
						} else if (building[i][j][k] == 'E') {
							endX = i;
							endY = j;
							endZ = k;
						}
					}
				}
			}
			dfs(startX, startY, startZ, 0);
			if (distance[endX][endY][endZ] == -1) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + distance[endX][endY][endZ] + " minute(s).");
			}
		}
	}
}