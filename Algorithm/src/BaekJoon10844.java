
import java.util.Scanner;

public class BaekJoon10844 {

	private static Scanner sc = null;

	private static long div = 1000000000;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[][] dp = new long[10][N + 1];
		for (int i = 1; i <= 9; i++) {
			dp[i][1] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[0][i] = dp[1][i - 1];
				} else if (j == 9) {
					dp[9][i] = dp[8][i - 1];
				} else {
					dp[j][i] = (dp[j - 1][i - 1] + dp[j + 1][i - 1]) % div;
				}
			}
		}

		long cnt = 0;
		for (int i = 0; i < 10; i++) {
			cnt = (cnt + dp[i][N]) % div;
		}
		System.out.println(cnt);
	}
}