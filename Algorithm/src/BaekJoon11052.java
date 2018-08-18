import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11052 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon11052.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] P = new int[N + 1];
			int[] dp = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				P[i] = sc.nextInt();
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					dp[i] = Math.max(P[i + 1 - j] + dp[j - 1], dp[i]);
				}
			}

			System.out.println(dp[N]);
		}
	}
}
