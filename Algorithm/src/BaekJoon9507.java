import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon9507 {

	private static Scanner sc = null;

	private static long koong(int N) {

		if (dp[N] != 0) {
			return dp[N];
		} else if (N < 2) {
			return dp[N] = 1;
		} else if (N == 2) {
			return dp[N] = 2;
		} else if (N == 3) {
			return dp[N] = 4;
		} else {
			return dp[N] = koong(N - 1) + koong(N - 2) + koong(N - 3) + koong(N - 4);
		}
	}

	private static long[] dp = new long[70];

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon9507.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			System.out.println(koong(N));
		}
	}
}