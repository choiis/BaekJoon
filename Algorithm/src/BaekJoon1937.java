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
		// 판다가 최소 1개는 먹으니 해당 dp의 값을 1로 채우고 시작
		dp[x][y] = 1;
		for (int i = 0; i < direct.length; i++) {
			int nextX = x + direct[i][0];
			int nextY = y + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < N & nextY < N) {
				// 사방에 작은것만 있으면 1 그대로 리턴
				if (bamboo[x][y] < bamboo[nextX][nextY]) {
					// dp에 지금까지 최대값 저장 되어있으므로 max
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