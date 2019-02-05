import java.util.Scanner;

public class BaekJoon2302 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		int cnt = 1;
		int now = 0;
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int T = sc.nextInt();
			cnt *= dp[T - now - 1];
			now = T;
		}
		cnt *= dp[N - now];
		System.out.println(cnt);
	}
}