import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1867 {
	private static Scanner sc;

	private static Vector<Vector<Integer>> vec;

	private static boolean[] visited;
	private static int[] match;

	private static boolean dfs(int now) {

		if (!visited[now]) {
			visited[now] = true;
			
			for (int i = 0; i < vec.elementAt(now).size(); i++) {
				int next = vec.elementAt(now).get(i);
				if (visited[next]) {
					continue;
				}
				visited[next] = true;

				if (match[next] == 0 || dfs(match[next])) {
					match[next] = now;
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		vec = new Vector<>();
		match = new int[N];
		for (int i = 0; i < N; i++) {
			vec.add(new Vector<>());
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			vec.elementAt(x - 1).add(y - 1);
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			if (dfs(i)) {
				result++;
			}
		}

		System.out.println(result);
	}
}
