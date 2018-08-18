import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2156 {
	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2156.txt"));

		int N = sc.nextInt();
		int[] A = new int[10000];
		int[] dp = new int[10000];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		dp[0] = A[0];
		dp[1] = A[0] + A[1];

		if (N >= 2) {
			dp[2] = Math.max(Math.max(dp[0] + A[2], A[1] + A[2]), dp[1]);
		}

		if (N >= 3) {
			if (N == 3) {
				dp[N] = Math.max(Math.max(dp[N - 2] + A[N], dp[N - 3] + A[N - 1] + A[N]), dp[N - 1]);
			} else {
				for (int i = 3; i < N; i++) {
					dp[i] = Math.max(Math.max(dp[i - 2] + A[i], dp[i - 3] + A[i - 1] + A[i]), dp[i - 1]);
				}
			}
		}

		System.out.println(dp[N - 1]);

	}
}