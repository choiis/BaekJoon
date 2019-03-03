import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1707 {
	private static Scanner sc;

	private static int[] visited;
	private static Vector<Vector<Integer>> graph;

	private static void dfs(int point, int color) {
		visited[point] = color;
		Vector<Integer> subgraph = graph.get(point);
		for (int i = 0; i < subgraph.size(); i++) {
			if (visited[subgraph.get(i)] == 0) {
				dfs(subgraph.get(i), color * -1);
			}
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			visited = new int[V + 1];
			graph = new Vector<>();
			for (int i = 0; i <= V; i++) {
				graph.add(new Vector<>());
			}

			for (int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph.get(x).addElement(y);
				graph.get(y).addElement(x);
			}

			for (int i = 1; i <= V; i++) {
				if (visited[i] == 0) {
					dfs(i, 1);

				}
			}
			boolean bipartite = true;
			for (int i = 1; i <= V; i++) {
				boolean out = false;
				for (int j = 0; j < graph.get(i).size(); j++) {
					if (visited[i] == visited[graph.get(i).get(j)]) {
						out = true;
						break;
					}
				}
				if (out) {
					bipartite = false;
					break;
				}
			}
			if (bipartite) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
}