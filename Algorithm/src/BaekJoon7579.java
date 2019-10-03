import java.util.Scanner;

public class BaekJoon7579 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int MaxMemory = sc.nextInt();
		int[] memory = new int[N + 1];
		int[] cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			memory[i] = sc.nextInt();
		}
		int len = 0;
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
			len += cost[i];
		}
		int[] dp = new int[len + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		dp[0] = 0;
		dp[cost[1]] = Math.max(dp[cost[1]], memory[1]);
		int sum = cost[1];
		for (int i = 2; i <= N; i++) {

			for (int j = sum; j >= 0; j--) {
				if (dp[j] != -1) {
					if (dp[j + cost[i]] != -1) {
						dp[j + cost[i]] = Math.max(dp[j + cost[i]], dp[j] + memory[i]);
					} else {
						dp[j + cost[i]] = dp[j] + memory[i];
					}
				}
			}
			sum += cost[i];
		}
		int result = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] >= MaxMemory) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}