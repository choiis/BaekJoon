import java.util.Scanner;

public class BaekJoon2011 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		char[] str = sc.next().toCharArray();
		int N = str.length;
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			if (str[i - 1] - '0' > 0) {
				dp[i] = dp[i - 1] % mod;
			}

			int num = (str[i - 2] - '0') * 10 + (str[i - 1] - '0');
			if (num <= 26 && num >= 10) {
				dp[i] = (dp[i] + dp[i - 2]) % mod;
			}
		}
		if (N == 1 && str[0] == '0') {
			System.out.println(0);
		} else {
			System.out.println(dp[N]);
		}
	}

	private static int mod = 1000000;
}
