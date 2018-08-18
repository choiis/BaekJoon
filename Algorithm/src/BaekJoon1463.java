import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon1463 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1463.txt"));

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] dp = new int[N + 1];

			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] + 1;
				if (i % 2 == 0) {
					dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
				}
				if (i % 3 == 0) {
					dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
				}
			}
			System.out.println(dp[N]);
		}
	}
}