
import java.util.Scanner;

public class BaekJoon9084 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = sc.nextInt();
			}
			int sum = sc.nextInt();
			int[] dp = new int[sum + 1];
			dp[0] = 1;

			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= sum; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}

			System.out.println(dp[sum]);
		}
	}
}