
import java.util.Scanner;

public class BaekJoon2293 {
	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int sum = sc.nextInt();
		int[] coin = new int[N];
		int[] dp = new int[sum + 1];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}

		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= sum; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}

		System.out.println(dp[sum]);
	}
}