import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1260 {
	private static Scanner sc = null;

	private static boolean[][] graph = null;
	private static boolean[] visited1 = null;
	private static boolean[] visited2 = null;

	private static void dfs(int point, int N) {

		visited1[point] = true;
		System.out.print(point + " ");

		for (int i = 1; i <= N; i++) {
			if (!visited1[i] && graph[point][i]) {
				dfs(i, N);
			}
		}
	}

	private static void bfs(int start, int N) {
		Queue<Integer> queue = new LinkedList<>();
		System.out.print(start + " ");
		visited2[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited2[i] && graph[now][i]) {
					visited2[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("C:/JavaEx/Algorithm/beakjoon1260.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		graph = new boolean[N + 1][N + 1];
		visited1 = new boolean[N + 1];
		visited2 = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = true;
			graph[b][a] = true;
		}
		dfs(start , N);
		System.out.println();
		bfs(start, N);
	}
}