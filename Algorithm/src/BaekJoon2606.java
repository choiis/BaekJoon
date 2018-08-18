import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2606 {
	private static Scanner sc = null;

	private static boolean[][] graph = null;
	private static boolean[] visited = null;

	private static int cnt = 0;

	private static void dfs(int K) {

		for (int i = 0; i < graph.length; i++) {
			if (i == K || visited[i] || !graph[K][i]) {
				continue;
			} else if (graph[K][i] && !visited[i]) {
				visited[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2606.txt"));

		int N = sc.nextInt();
		int K = sc.nextInt();

		graph = new boolean[N][N];
		visited = new boolean[N];

		int X, Y;
		for (int i = 0; i < K; i++) {
			X = sc.nextInt();
			Y = sc.nextInt();
			graph[X - 1][Y - 1] = true;
			graph[Y - 1][X - 1] = true;
		}

		visited[0] = true;
		dfs(0);
		System.out.println(cnt);
	}
}