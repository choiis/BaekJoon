import java.util.Scanner;

public class BaekJoon2688 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[][] dp = new long[N + 1][10];
			for (int i = 0; i <= 9; i++) {
				dp[1][i] = 1;
			}
			for (int i = 2; i <= N; i++) {
				for (int j = 0; j <= 9; j++) {
					long subsum = 0;
					for (int k = 0; k <= j; k++) {
						subsum += dp[i - 1][k];
					}
					dp[i][j] = subsum;
				}
			}
			long sum = 0;
			for (int i = 0; i <= 9; i++) {
				sum += dp[N][i];
			}
			System.out.println(sum);
		}

	}
}