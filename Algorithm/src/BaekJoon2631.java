import java.util.Scanner;

public class BaekJoon2631 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[N + 1];
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);

	}
}