import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1967 {

	private static Scanner sc = null;

	private static int longest_leaf(int[][] graph, int start, int N) {

		boolean[] visited = new boolean[N];
		int[] length = new int[N];

		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		int i, j;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (i = 0; i < N; i++) {
				if (graph[now][i] != 0 && !visited[i]) {
					length[i] = length[now] + graph[now][i];
					visited[i] = true;
					queue.add(i);
				}
			}
		}

		int idx = -1;
		int max = -1;
		for (j = 0; j < N; j++) {
			if (max < length[j]) {
				max = length[j];
				idx = j;
			}
		}
		visited = null;
		length = null;
		return idx;
	}

	private static int find_radius(int[][] graph, int end_point, int N) {

		boolean[] visited = new boolean[N];
		int[] length = new int[N];

		visited[end_point] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(end_point);
		int i, j;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (i = 0; i < N; i++) {
				if (graph[now][i] != 0 && !visited[i]) {
					length[i] = length[now] + graph[now][i];
					visited[i] = true;
					queue.add(i);
				}
			}
		}

		int max = -1;
		for (j = 0; j < N; j++) {
			max = Math.max(max, length[j]);
		}
		visited = null;
		length = null;
		return max;
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1967.txt"));
		int V = sc.nextInt();
		int[][] graph = new int[V][V];
		for (int i = 0; i < V - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			graph[x - 1][y - 1] = z;
			graph[y - 1][x - 1] = z;
		}
		int end_point = longest_leaf(graph, 0, V);
		System.out.println(find_radius(graph, end_point, V));
	}

}
