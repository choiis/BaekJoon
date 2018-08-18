import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon10451 {
	private static Scanner sc = null;

	private static boolean[][] graph = null;
	private static boolean[] visited = null;

	private static int cnt = 0;

	private static void dfs(int K, int start, int N) {
		visited[K] = true;
		// cycle 순회 완료
		if (K == start) {
			cnt++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i] && graph[K][i]) {
					visited[i] = true;
					dfs(i, start, N);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon10451.txt"));

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			graph = new boolean[N][N];
			visited = new boolean[N];
			cnt = 0;
			int K;
			for (int i = 0; i < N; i++) {
				K = sc.nextInt();
				graph[i][K - 1] = true;
			}

			for (int i = 0; i < N; i++) {
				int start = i;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && graph[i][j]) {
						dfs(j, start, N);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}