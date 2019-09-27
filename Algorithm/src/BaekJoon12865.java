import java.util.Scanner;

public class BaekJoon12865 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt(); // ����
		int K = sc.nextInt(); // ���� MAX
		int[] w = new int[N + 1]; // ����
		int[] v = new int[N + 1]; // ��ġ
		for (int i = 1; i <= N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		int max = 0;
		// i�������� �ְ� �ȳְ�, ���� j���ϸ� ä��µ� �ִ� v��
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) { // i���� ����
			for (int j = 0; j <= K; j++) { // ���� j����
				// dp[i][j] = Math.max(dp[i-1][j] , dp[i - 1][j - w[i]] + v[i]);
				if (j - w[i] < 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);
	}
}