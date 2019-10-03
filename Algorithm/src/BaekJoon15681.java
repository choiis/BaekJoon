import java.util.Scanner;
import java.util.Vector;

public class BaekJoon15681 {

	private static Scanner sc;

	private static Vector<Vector<Integer>> vec;
	private static int N;

	private static int[] dp;
	private static boolean[] visited;

	private static int dfs(int from) {
		visited[from] = true;
		dp[from] = 1;

		Vector<Integer> route = vec.get(from);
		for (int i = 0; i < route.size(); i++) {
			int to = route.get(i);
			if (!visited[to]) {
				dp[from] += dfs(to);
			}
		}

		return dp[from];
	}

	private static void calc(int root) {
		dfs(root);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		visited = new boolean[N + 1];

		int R = sc.nextInt();
		int Q = sc.nextInt();

		vec = new Vector<>();
		for (int i = 0; i <= N; i++) {
			vec.add(new Vector<>());
		}

		for (int i = 0; i < N - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			vec.get(x).add(y);
			vec.get(y).add(x);
		}
		calc(R);
		for (int i = 0; i < Q; i++) {
			int query = sc.nextInt();
			System.out.println(dp[query]);
		}
	}
}