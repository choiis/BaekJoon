import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BaekJoon2644 {

	private static void dfs(int start, int end, int N, int depth) {
		visited[start] = true;
		if (start == end) {
			cnt = depth;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i] && relation[start][i]) {
				dfs(i, end, N, depth + 1);
			}
		}
	}

	private static Scanner sc;

	private static boolean[][] relation = null;
	private static boolean[] visited = null;

	private static int cnt;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon2644.txt"));

		int N = sc.nextInt();
		int from = sc.nextInt();
		int to = sc.nextInt();
		int M = sc.nextInt();

		relation = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			relation[x - 1][y - 1] = true;
			relation[y - 1][x - 1] = true;
		}

		dfs(from - 1, to - 1, N, 0);
		if (cnt == 0) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}

	}
}
