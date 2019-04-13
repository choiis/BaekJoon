
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1325 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Vector<Vector<Integer>> vec = new Vector<>();
		for (int i = 0; i <= N; i++) {
			vec.add(new Vector<>());
		}
		int[] indegree = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			vec.get(u).add(v);
			indegree[v]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < vec.get(now).size(); i++) {
				int next = vec.get(now).get(i);
				dp[next] += dp[now];
				indegree[next]--;
				if (indegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		Vector<Integer> v = new Vector<>();
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (max < dp[i]) {
				max = dp[i];
				v.clear();
				v.add(i);
			} else if (max == dp[i]) {
				v.add(i);
			}
		}
		for (int i = 0; i < v.size(); i++) {
			System.out.print(v.get(i) + " ");
		}
	}
}
