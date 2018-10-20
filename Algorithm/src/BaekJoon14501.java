import java.util.Scanner;

public class BaekJoon14501 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int S = sc.nextInt();
		for (int s = 0; s < S; s++) {
			int N = sc.nextInt();
			int[] T = new int[N + 1];
			int[] P = new int[N + 1];

			int[] dp = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				T[i] = sc.nextInt();
				P[i] = sc.nextInt();
				dp[i] = P[i];
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j < i; j++) {
					if (i - j >= T[j]) {
						dp[i] = Math.max(dp[i], dp[j] + P[i]);
					}
				}
			}

			int max = 0;
			for (int i = 1; i <= N; i++) {
				if (i + T[i] <= N + 1) {
					max = Math.max(max, dp[i]);
				}
			}
			System.out.println(max);
		}
	}
}