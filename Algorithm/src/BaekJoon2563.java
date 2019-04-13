import java.util.Scanner;

public class BaekJoon2563 {
	private static Scanner sc;

	private final static int length = 101;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();

		boolean[][] paper = new boolean[length][length];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x + 1; j <= x + 10; j++) {
				for (int k = y + 1; k <= y + 10; k++) {
					paper[j][k] = true;
				}
			}

		}

		int result = 0;
		for (int i = 1; i < length; i++) {
			for (int j = 1; j < length; j++) {
				if (paper[i][j]) {
					result++;
				}
			}
		}

		System.out.println(result);
	}
}