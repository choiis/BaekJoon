import java.util.Scanner;

public class BaekJoon5582 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int N1 = str1.length();
		int N2 = str2.length();

		int[][] dp = new int[N1 + 1][N2 + 1];
		int max = 0;
		for (int i = 1; i <= N1; i++) {
			for (int j = 1; j <= N2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		System.out.println(max);
	}
}
