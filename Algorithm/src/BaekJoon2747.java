
import java.util.Scanner;

public class BaekJoon2747 {

	private static Scanner sc = null;

	private static long[] dp = null;

	private static long fibo(int N) {
		if (dp[N] != 0) {
			return dp[N];
		} else if (N == 1 || N == 2) {
			return dp[N] = 1;
		} else {
			return dp[N] = fibo(N - 1) + fibo(N - 2);
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		dp = new long[N + 1];
		dp[0] = 0;
		System.out.println(fibo(N));
	}
}