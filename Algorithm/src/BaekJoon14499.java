import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon14499 {

	private static Scanner sc = null;

	private static int[][] directs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon14499.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int K = sc.nextInt();
		int[] dice = new int[7];
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			int direct = sc.nextInt();
			int nextX = x + directs[direct - 1][0];
			int nextY = y + directs[direct - 1][1];

			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
				continue;
			}

			int d1 = dice[1];
			int d2 = dice[2];
			int d3 = dice[3];
			int d4 = dice[4];
			int d5 = dice[5];
			int d6 = dice[6];

			if (direct == 1) { // 悼率
				dice[1] = d6;
				dice[2] = d2;
				dice[3] = d1;
				dice[4] = d3;
				dice[5] = d5;
				dice[6] = d4;
			} else if (direct == 2) { // 辑率
				dice[1] = d3;
				dice[2] = d2;
				dice[3] = d4;
				dice[4] = d6;
				dice[5] = d5;
				dice[6] = d1;
			} else if (direct == 3) { // 巢率
				dice[1] = d5;
				dice[2] = d1;
				dice[3] = d3;
				dice[4] = d2;
				dice[5] = d4;
				dice[6] = d6;
			} else { // 合率
				dice[1] = d2;
				dice[2] = d4;
				dice[3] = d3;
				dice[4] = d5;
				dice[5] = d1;
				dice[6] = d6;
			}
			
			if (board[nextX][nextY] == 0) {
				board[nextX][nextY] = dice[4];
			} else {
				dice[4] = board[nextX][nextY];
				board[nextX][nextY] = 0;
			}
			System.out.println(dice[1]);
			x = nextX;
			y = nextY;

		}

	}
}