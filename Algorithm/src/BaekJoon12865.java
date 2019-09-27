import java.util.Scanner;

public class BaekJoon12865 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt(); // 갯수
		int K = sc.nextInt(); // 무게 MAX
		int[] w = new int[N + 1]; // 무게
		int[] v = new int[N + 1]; // 가치
		for (int i = 1; i <= N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		int max = 0;
		// i번쨰까지 넣고 안넣고, 무게 j이하를 채우는데 최대 v합
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) { // i번쨰 물건
			for (int j = 0; j <= K; j++) { // 무게 j까지
				// dp[i][j] = Math.max(dp[i-1][j] , dp[i - 1][j - w[i]] + v[i]);
				if (j - w[i] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);
	}
}