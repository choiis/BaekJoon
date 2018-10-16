
import java.util.Scanner;

public class BaekJoon14888 {
	private static Scanner sc;

	private static int N;
	private static int[] arr;

	private static int plus;
	private static int minus;
	private static int multiply;
	private static int divide;

	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;

	private static void dfs(int idx, int pl, int mi, int mu, int di, int number) {
		if (idx == N) {
			min = Math.min(min, number);
			max = Math.max(max, number);
			return;
		} else {
			if (pl < plus) {
				dfs(idx + 1, pl + 1, mi, mu, di, number + arr[idx]);
			}
			if (mi < minus) {
				dfs(idx + 1, pl, mi + 1, mu, di, number - arr[idx]);
			}
			if (mu < multiply) {
				dfs(idx + 1, pl, mi, mu + 1, di, number * arr[idx]);
			}
			if (di < divide) {
				dfs(idx + 1, pl, mi, mu, di + 1, number / arr[idx]);
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		plus = sc.nextInt();
		minus = sc.nextInt();
		multiply = sc.nextInt();
		divide = sc.nextInt();
		dfs(1, 0, 0, 0, 0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
}