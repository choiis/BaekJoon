import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1389 {

	private static Scanner sc;

	private static int bfs(int start, boolean[][] relation, int N) {
		int cnt = 0;
		boolean[] visited = new boolean[N];
		Queue<K_B> queue = new LinkedList<>();
		queue.add(new K_B(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			K_B now = queue.poll();
			cnt += now.depth;
			for (int i = 0; i < N; i++) {
				if (relation[now.number][i] && !visited[i]) {
					visited[i] = true;
					queue.add(new K_B(i, now.depth + 1));
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[][] arr = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x - 1][y - 1] = true;
			arr[y - 1][x - 1] = true;
		}

		int min = Integer.MAX_VALUE;
		int min_idx = N - 1;
		for (int i = 0; i < N; i++) {
			int bfs_result = bfs(i, arr, N);
			if (min > bfs_result) {
				min = bfs_result;
				min_idx = i;
			}
		}
		System.out.println(min_idx + 1);
	}
}

class K_B {
	int number;
	int depth;

	public K_B() {

	}

	public K_B(int number, int depth) {
		super();
		this.number = number;
		this.depth = depth;
	}

}