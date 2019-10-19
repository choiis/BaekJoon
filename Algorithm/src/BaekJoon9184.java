import java.util.Scanner;

public class BaekJoon9184 {
	private static Scanner sc;

	private static int[][][] dp;

	private static int f(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if (a > 20 || b > 20 || c > 20) {
			return f(20, 20, 20);
		} else if (dp[a][b][c] > 0) {
			return dp[a][b][c];
		} else if (a < b && b < c) {
			return dp[a][b][c] = f(a, b, c - 1) + f(a, b - 1, c - 1) - f(a, b - 1, c);
		} else {
			return dp[a][b][c] = f(a - 1, b, c) + f(a - 1, b - 1, c) + f(a - 1, b, c - 1) - f(a - 1, b - 1, c - 1);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (true) {
			dp = new int[21][21][21];
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (x == -1 && y == -1 && z == -1) {
				break;
			}
			System.out.println("w(" + x + ", " + y + ", " + z + ") = " + f(x, y, z));
		}
	}
}