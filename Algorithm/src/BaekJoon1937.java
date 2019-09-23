import java.util.Scanner;

public class BaekJoon1937 {
	private static Scanner sc;

	private static int N;
	private static int[][] direct = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private static int[][] bamboo;
	private static int[][] dp;

	private static int dfs(int x, int y) {

		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		// �Ǵٰ� �ּ� 1���� ������ �ش� dp�� ���� 1�� ä��� ����
		dp[x][y] = 1;
		for (int i = 0; i < direct.length; i++) {
			int nextX = x + direct[i][0];
			int nextY = y + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < N & nextY < N) {
				// ��濡 �����͸� ������ 1 �״�� ����
				if (bamboo[x][y] < bamboo[nextX][nextY]) {
					// dp�� ���ݱ��� �ִ밪 ���� �Ǿ������Ƿ� max
					dp[x][y] = Math.max(dp[x][y], dfs(nextX, nextY) + 1);
				}
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextInt();
		bamboo = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bamboo[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dfs(i, j));
			}
		}
		System.out.println(max);
	}
}