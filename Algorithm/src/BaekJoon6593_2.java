import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon6593_2 {

	private static Scanner sc;

	private static int[][] direct = { { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

	private static char[][][] building;
	private static int[][][] distance;
	private static boolean[][][] visited;
	private static int L;
	private static int R;
	private static int C;

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
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					building[i][j] = sc.next().toCharArray();
					for (int k = 0; k < C; k++) {
						distance[i][j][k] = -1;
						if (building[i][j][k] == 'S') {
							startX = i;
							startY = j;
							startZ = k;
						}
					}
				}
			}

			Queue<Building> queue = new LinkedList<>();
			queue.add(new Building(startX, startY, startZ, 0));
			visited[startX][startY][startZ] = true;
			int solution = -1;
			while (!queue.isEmpty()) {
				Building nowBuilding = queue.poll();
				int nowX = nowBuilding.getX();
				int nowY = nowBuilding.getY();
				int nowZ = nowBuilding.getZ();
				int nowDist = nowBuilding.getDist();

				boolean finish = false;
				for (int i = 0; i < direct.length; i++) {
					int nextX = nowX + direct[i][0];
					int nextY = nowY + direct[i][1];
					int nextZ = nowZ + direct[i][2];
					if (nextX >= 0 && nextX < L && nextY >= 0 && nextY < R && nextZ >= 0 && nextZ < C) {
						if (building[nextX][nextY][nextZ] == '.' && !visited[nextX][nextY][nextZ]) {
							queue.add(new Building(nextX, nextY, nextZ, nowDist + 1));
							visited[nextX][nextY][nextZ] = true;
						} else if (building[nextX][nextY][nextZ] == 'E') {
							solution = nowDist + 1;
							finish = true;
						}
					}
				}

				if (finish) {
					break;
				}
			}

			if (solution == -1) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + solution + " minute(s).");
			}
		}
	}
}

class Building {
	private int x;
	private int y;
	private int z;
	private int dist;

	public Building() {
		super();
	}

	public Building(int x, int y, int z, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
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

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

}