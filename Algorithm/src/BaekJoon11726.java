import java.util.Scanner;

public class BaekJoon11726 {

	private static Scanner sc;

	private static final int DIV = 10007;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % DIV;
		}
		System.out.println(dp[N]);
	}
}