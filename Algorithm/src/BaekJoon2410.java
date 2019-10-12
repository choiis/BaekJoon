import java.util.Scanner;

public class BaekJoon2410 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		int i = 1;
		while (i <= N) {
			for (int j = i; j <= N; j++) {
				dp[j] += dp[j - i];
				dp[j] %= mod;
			}
			i *= 2;
		}
		System.out.println(dp[N]);
	}

	private static int mod = 1000000000;
}