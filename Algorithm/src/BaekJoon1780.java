import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon1780 {

	private static Scanner sc;

	private static int minusOne = 0;
	private static int plusOne = 0;
	private static int zero = 0;

	private static int[][] paper;

	private static void cntPapar(int startX, int startY, int len) {

		int base = paper[startX][startY];
		boolean flag = true;
		for (int i = startX; i < startX + len; i++) {
			boolean out = false;
			for (int j = startY; j < startY + len; j++) {
				if (base != paper[i][j]) {
					out = true;
					break;
				}
			}
			if(out) {
				flag = false;
				break;
			}
		}

		if (flag) {
			if (base == -1) {
				minusOne++;
			} else if (base == 0) {
				zero++;
			} else {
				plusOne++;
			}
			return;
		} else {
			int div = len / 3;
			cntPapar(startX, startY, div);
			cntPapar(startX + div, startY, div);
			cntPapar(startX + 2 * div, startY, div);
			cntPapar(startX, startY + div, div);
			cntPapar(startX, startY + 2 * div, div);
			cntPapar(startX + div, startY + div, div);
			cntPapar(startX + 2 * div, startY + div, div);
			cntPapar(startX + div, startY + 2 * div, div);
			cntPapar(startX + 2 * div, startY + 2 * div, div);
		}
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1780.txt"));
		int N = sc.nextInt();
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		cntPapar(0, 0, N);

		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
	}
}