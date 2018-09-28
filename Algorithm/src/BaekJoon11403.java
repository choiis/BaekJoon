import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11403 {
	private static Scanner sc = null;

	private static int[][] graph = null;
	private static int[][] reach = null;

	private static int N;

	private static void dfs(int startPoint, int now, boolean[] visited) {

		for (int i = 0; i < N; i++) {
			if (!visited[i] && graph[now][i] == 1) {
				visited[i] = true;
				reach[startPoint][i] = 1;
				dfs(startPoint, i, visited);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon11403.txt"));

		N = sc.nextInt();
		graph = new int[N][N];
		reach = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			dfs(i, i, visited);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(reach[i][j] + " ");
			}
			System.out.println();
		}
	}
}