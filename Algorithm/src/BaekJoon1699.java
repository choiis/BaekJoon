
import java.util.Scanner;

public class BaekJoon1699 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}