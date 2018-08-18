import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7569 {
	private static Scanner sc = null;
	private static int M, N, H;

	private static int[][][] tomatos = null;

	private static int[] dx = { 1, -1, 0, 0, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1, 0, 0 };
	private static int[] dz = { 0, 0, 0, 0, 1, -1 };

	private static int short_time(Queue<Tomato3> queue, int[][][] tomato) {

		while (!queue.isEmpty()) {
			Tomato3 now = queue.poll();
			for (int i = 0; i < 6; i++) {
				int nextX = now.getX() + dx[i];
				int nextY = now.getY() + dy[i];
				int nextZ = now.getZ() + dz[i];
				if (nextX >= 0 && nextY >= 0 && nextZ >= 0 && nextX < M && nextY < N && nextZ < H) {
					if (tomato[nextX][nextY][nextZ] == 0) {
						tomato[nextX][nextY][nextZ] = tomato[now.getX()][now.getY()][now.getZ()] + 1;
						queue.add(new Tomato3(nextX, nextY, nextZ));
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < H; k++) {
					if (tomato[i][j][k] == 0) {
						return -1;
					} else {
						max = Math.max(max, tomato[i][j][k]);
					}
				}
			}
		}
		return max - 1;
	}

	public static void main(String[] args) throws FileNotFoundException {

		sc = new Scanner(new FileInputStream("baekjoon7579.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			H = sc.nextInt();
			tomatos = new int[M][N][H];
			// 초기 토마토의 위치
			Queue<Tomato3> queue = new LinkedList<>();

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						tomatos[k][j][i] = sc.nextInt();
						if (tomatos[k][j][i] == 1) {
							queue.add(new Tomato3(k, j, i));
						}
					}
				}
			}
			// 토마토 위치 셋팅 끝
			System.out.println(short_time(queue, tomatos));
		}
	}

}

class Tomato3 {
	private int x, y, z;

	public Tomato3() {
	}

	public Tomato3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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

}