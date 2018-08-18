import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1167 {

	private static Scanner sc = null;

	private static int longest_leaf(Vector<Vector<Node>> graph, int start, int N) {

		boolean[] visited = new boolean[N];
		int[] length = new int[N];

		visited[start] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		int i, j;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			Vector<Node> ve = graph.elementAt(now);
			for (i = 0; i < ve.size(); i++) {
				if (!visited[ve.get(i).vertex]) {
					length[ve.get(i).vertex] = length[now] + ve.get(i).weight;
					visited[ve.get(i).vertex] = true;
					queue.add(ve.get(i).vertex);
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

	private static int find_radius(Vector<Vector<Node>> graph, int end_point, int N) {

		boolean[] visited = new boolean[N];
		int[] length = new int[N];

		visited[end_point] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(end_point);
		int i, j;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			Vector<Node> ve = graph.elementAt(now);
			for (i = 0; i < ve.size(); i++) {
				if (!visited[ve.get(i).vertex]) {
					length[ve.get(i).vertex] = length[now] + ve.get(i).weight;
					visited[ve.get(i).vertex] = true;
					queue.add(ve.get(i).vertex);
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

		sc = new Scanner(new FileInputStream("baekjoon1167.txt"));

		int V = sc.nextInt();
		Vector<Vector<Node>> graph = new Vector<Vector<Node>>();

		for (int i = 0; i < V; i++) {
			Vector<Node> e = new Vector<Node>();
			graph.add(e);
		}

		for (int i = 0; i < V; i++) {
			int x = sc.nextInt();
			while (true) {
				int y = sc.nextInt();
				if (y == -1) {
					break;
				}
				int z = sc.nextInt();
				Node e1 = new Node(y - 1, z);
				graph.elementAt(x - 1).add(e1);

				Node e2 = new Node(x - 1, z);
				graph.elementAt(y - 1).add(e2);
			}
		}

		int end_point = longest_leaf(graph, 0, V);
		System.out.println(find_radius(graph, end_point, V));
	}
}

class Node implements Comparable<Node> {
	int vertex;
	int weight;

	public Node() {
	}

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node e) {
		return this.weight - e.weight;
	}
}