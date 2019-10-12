import java.util.Scanner;

public class BaekJoon1958 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();

		int N1 = str1.length();
		int N2 = str2.length();
		int N3 = str3.length();
		int[][][] dp = new int[N1 + 1][N2 + 1][N3 + 1];

		for (int i = 1; i <= N1; i++) {
			for (int j = 1; j <= N2; j++) {
				for (int k = 1; k <= N3; k++) {
					if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
					}
				}
			}
		}
		System.out.println(dp[N1][N2][N3]);
	}
}