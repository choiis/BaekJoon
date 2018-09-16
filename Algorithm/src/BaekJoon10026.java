import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon10026 {

	private static Scanner sc = null;

	private static String[] str = null;

	private static boolean[][] visited1 = null;
	private static boolean[][] visited2 = null;

	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	private static int N;

	private static void dfs_1(int x, int y, char now_color) {

		visited1[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if (!visited1[nextX][nextY] && now_color == str[nextX].charAt(nextY)) {
					dfs_1(nextX, nextY, now_color);
				}
			}
		}
	}

	private static void dfs_2(int x, int y, char now_color) {

		visited2[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if (!visited2[nextX][nextY]) {
					if (now_color == 'B') {
						if (now_color == str[nextX].charAt(nextY)) {
							dfs_2(nextX, nextY, now_color);
						}
					} else {
						if (str[nextX].charAt(nextY) == 'R' || str[nextX].charAt(nextY) == 'G') {
							dfs_2(nextX, nextY, str[nextX].charAt(nextY));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon10026.txt"));
		N = sc.nextInt();

		str = new String[N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			str[i] = sc.next();
		}

		int ans1 = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited1[x][y]) {
					dfs_1(x, y, str[x].charAt(y));
					ans1++;
				}
			}
		}

		int ans2 = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited2[x][y]) {
					dfs_2(x, y, str[x].charAt(y));
					ans2++;
				}
			}
		}

		System.out.println(ans1 + " " + ans2);
	}
}