import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon10216 {

	private static Scanner sc = null;

	private static int group(boolean[][] graph, boolean[] visited) {

		int cnt = 0;
		int N = graph.length;

		for (int i = 0; i < N; i++) {

			if (!visited[i]) {
				visited[i] = true;

				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);

				while (!queue.isEmpty()) {

					int now = queue.poll();
					for (int j = 0; j < N; j++) {
						if (graph[now][j] && !visited[j]) {
							queue.add(j);
							visited[j] = true;
						}

					}
				}

				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon10216.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			int N = sc.nextInt();
			int[][] enemy = new int[N][3];
			boolean[][] graph = new boolean[N][N];
			boolean[] visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				enemy[i][0] = sc.nextInt();
				enemy[i][1] = sc.nextInt();
				enemy[i][2] = sc.nextInt();
			}

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double dist = Math.sqrt((enemy[i][0] - enemy[j][0]) * (enemy[i][0] - enemy[j][0])
							+ (enemy[i][1] - enemy[j][1]) * (enemy[i][1] - enemy[j][1]));
					if (dist <= (enemy[i][2] + enemy[j][2])) {
						graph[i][j] = true;
						graph[j][i] = true;
					}
				}
			}

			System.out.println(group(graph, visited));
		}
	}
}