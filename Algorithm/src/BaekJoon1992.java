import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1992 {

	private static Scanner sc = null;

	private static int[][] grid = null;

	private static void quadTree(int x, int y, int size) {
		boolean same = true;
		int now = grid[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (now != grid[i][j]) {
					same = false;
					break;
				}
			}
		}

		if (same) {
			System.out.print(now);
		} else {
			System.out.print("(");
			quadTree(x, y, size / 2);
			quadTree(x, y + size / 2, size / 2);
			quadTree(x + size / 2, y, size / 2);
			quadTree(x + size / 2, y + size / 2, size / 2);
			System.out.print(")");
		}

	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon1992.txt"));

		int N = sc.nextInt();

		grid = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = line.charAt(j) - '0'; // 코드값을 숫자로 변환
			}
		}

		quadTree(0, 0, N);

	}
}