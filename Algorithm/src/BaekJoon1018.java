
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1018 {

	private static Scanner sc;

	private static char[][] chess;

	private static char[][] chess1 = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
			{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

	private static char[][] chess2 = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
			{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

	private static int compare1(int x, int y) {
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (chess[i][j] != chess1[i - x][j - y]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int compare2(int x, int y) {
		int cnt = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (chess[i][j] != chess2[i - x][j - y]) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1018.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		chess = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			chess[i] = str.toCharArray();
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int cnt = Math.min(compare1(i, j), compare2(i, j));

				min = Math.min(min, cnt);
			}
		}
		System.out.println(min);
	}
}