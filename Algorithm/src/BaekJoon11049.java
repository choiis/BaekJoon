import java.util.Scanner;

public class BaekJoon11049 {
	private static Scanner sc;

	private static int[][] matrix;
	private static int[][] dp;

	// dp[x][y] = calc(x,y) => x부터 y까지의 행렬 곱
	private static int calc(int x, int y) {

		if (dp[x][y] != 0) {
			return dp[x][y];
		} else if (x + 1 == y) {
			return matrix[x][0] * matrix[x][1] * matrix[y][1];
		}

		for (int i = x; i < y; i++) {
			// matrix[x][0] * matrix[i][1] * matrix[y][1] 양쪽의 행렬곱하기
			if (dp[x][y] == 0) {
				dp[x][y] = calc(x, i) + calc(i + 1, y) + matrix[x][0] * matrix[i][1] * matrix[y][1];
			} else {
				dp[x][y] = Math.min(calc(x, i) + calc(i + 1, y) + matrix[x][0] * matrix[i][1] * matrix[y][1], dp[x][y]);
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		matrix = new int[N + 1][2];
		dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		System.out.println(calc(1, N));
	}
}