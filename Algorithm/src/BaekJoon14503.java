
import java.util.Scanner;

public class BaekJoon14503 {

	private static Scanner sc = null;

	private static int[][] direct = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	private static int nextDirect(int nowDirect) {
		if (nowDirect == 0) {
			return 3;
		} else {
			return nowDirect - 1;
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];

		int X = sc.nextInt();
		int Y = sc.nextInt();
		int D = sc.nextInt();

		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		visited[X][Y] = true;
		int cnt = 1;
		while (true) {
			boolean ok = false;

			for (int i = 0; i < 4; i++) {
				D = nextDirect(D);
				int nextX = X + direct[D][0];
				int nextY = Y + direct[D][1];

				if (arr[nextX][nextY] == 0 && !visited[nextX][nextY]) {
					cnt++;
					X = nextX;
					Y = nextY;
					visited[nextX][nextY] = true;
					ok = true;
					break;
				}
			}

			if (ok) {
				continue;
			} else {
				int behind = nextDirect(nextDirect(D));
				int nextX = X + direct[behind][0];
				int nextY = Y + direct[behind][1];
				if (arr[nextX][nextY] == 1) {
					break;
				} else {
					X = nextX;
					Y = nextY;
				}
			}
		}

		System.out.println(cnt);

	}
}