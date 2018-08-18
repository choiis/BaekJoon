import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon11724 {

	private static Scanner sc = null;

	private static boolean[] visited = null;
	private static boolean[][] route = null;

	private static void dfs(int start) {
		visited[start] = true;
		for (int i = 0; i < route.length; i++) {
			if (!visited[i] && route[start][i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("baekjoon11724.txt"));

		int N = sc.nextInt();
		int M = sc.nextInt();

		visited = new boolean[N];
		route = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			route[x - 1][y - 1] = true;
			route[y - 1][x - 1] = true;
		}
		int cnt = 0;
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
}