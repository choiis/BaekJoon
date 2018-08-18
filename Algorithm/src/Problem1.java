import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Problem1 {

	private static Scanner sc = null;

	private static int find_long_point(Vector<Vector<E>> graph, int V, int start) {

		int[] length = new int[V];
		for (int i = 0; i < length.length; i++) {
			length[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		length[start] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			Vector<E> ve = graph.elementAt(now);
			for (int i = 0; i < ve.size(); i++) {
				if (length[ve.get(i).to] == -1 && ve.get(i).weight != 0) {
					queue.add(ve.get(i).to);
					length[ve.get(i).to] = length[now] + ve.get(i).weight;
				}
			}
		}

		int max = -1;
		int point = -1;
		for (int i = 0; i < length.length; i++) {
			if (max < length[i]) {
				max = length[i];
				point = i;
			}
		}

		return point;
	}

	private static int find_radius(Vector<Vector<E>> graph, int V, int start) {

		int[] length = new int[V];
		for (int i = 0; i < length.length; i++) {
			length[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		length[start] = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			Vector<E> ve = graph.elementAt(now);
			for (int i = 0; i < ve.size(); i++) {
				if (length[ve.get(i).to] == -1 && ve.get(i).weight != 0) {
					queue.add(ve.get(i).to);
					length[ve.get(i).to] = length[now] + ve.get(i).weight;
				}
			}
		}

		int max = -1;
		for (int i = 0; i < length.length; i++) {
			if (max < length[i]) {
				max = length[i];
			}
		}

		return max;
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("C:/JavaEx/Algorithm/beakjoon1967.txt"));
		int V = sc.nextInt();
		Vector<Vector<E>> graph = new Vector<Vector<E>>();
		for (int i = 0; i < V; i++) {
			Vector<E> g = new Vector<>();
			graph.add(g);
		}

		for (int i = 0; i < V - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			E e1 = new E(y - 1, z);
			E e2 = new E(x - 1, z);
			graph.elementAt(x - 1).add(e1);
			graph.elementAt(y - 1).add(e2);
		}

		int long_point = find_long_point(graph, V, 0);
		System.out.println(find_radius(graph, V, long_point));

	}
}

class E {
	int to;
	int weight;

	public E(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

}