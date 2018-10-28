import java.util.Scanner;

public class BaekJoon1904 {

	private static Scanner sc;

	private static long DIV = 15746;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] dp = new long[N + 1];
		dp[1] = 1;
		if (N >= 2) {
			dp[2] = 2;
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % DIV;
		}
		System.out.println(dp[N]);
	}
}