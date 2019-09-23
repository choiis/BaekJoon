import java.util.Scanner;

public class BaekJoon11066 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			int[] sum = new int[N + 1];
			int[][] dp = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = sc.nextInt();
				sum[i] = sum[i - 1] + arr[i];
			}
			for (int i = 2; i <= N; i++) {
				for (int j = i - 1; j > 0; j--) {
					dp[j][i] = Integer.MAX_VALUE;
					for (int k = j; k <= i; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]);
					}
					dp[j][i] += sum[i] - sum[j - 1];
				}
			}

			System.out.println(dp[1][N]);
		}
	}
}