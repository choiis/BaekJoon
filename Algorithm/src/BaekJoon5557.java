import java.util.Scanner;

public class BaekJoon5557 {

	private static Scanner sc;

	private static final int Max = 21;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		long[][] dp = new long[N][Max];
		dp[0][arr[0]] = 1;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < Max; j++) {
				if (dp[i - 1][j] != 0) {
					if (j + arr[i] <= Max - 1) {
						dp[i][j + arr[i]] += dp[i - 1][j];
					}
					if (j - arr[i] >= 0) {
						dp[i][j - arr[i]] += dp[i - 1][j];
					}
				}
			}
		}
		System.out.println(dp[N - 2][arr[N - 1]]);
	}
}