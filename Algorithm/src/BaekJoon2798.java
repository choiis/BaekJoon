import java.util.Scanner;

public class BaekJoon2798 {

	private static Scanner sc;
	private static int N;
	private static int M;

	private static int[] arr;

	private static int ans = 0;

	private static void dfs(int idx, int sum, int cnt) {
		if (cnt == 3) {

			if (M >= sum && sum >= ans) {
				ans = sum;
			}

			return;
		}

		if (idx >= N || sum > M) {
			return;
		}
		dfs(idx + 1, sum + arr[idx], cnt + 1);
		dfs(idx + 1, sum, cnt);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0, 0, 0);
		System.out.println(ans);
	}
}