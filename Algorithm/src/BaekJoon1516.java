import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1516 {

	private static int N;
	private static Scanner sc;

	public static void main(String args[]) {
		sc = new Scanner(System.in);
		N = sc.nextInt();

		Vector<Vector<Integer>> vec = new Vector<>();
		for (int i = 0; i <= N; i++) {
			vec.add(new Vector<>());
		}
		int[] indegree = new int[N + 1];
		int[] buildTime = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			buildTime[i] = sc.nextInt();
			while (true) {
				int v = sc.nextInt();
				if (v == -1) {
					break;
				}
				vec.get(v).add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				dp[i] = buildTime[i];
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int now = q.remove();
			for (int i = 0; i < vec.get(now).size(); i++) {
				int next = vec.get(now).get(i);
				indegree[next]--;
				dp[next] = Math.max(dp[next], buildTime[next] + dp[now]);
				if (indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}
}
