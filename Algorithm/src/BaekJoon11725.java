import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon11725 {
	private static Scanner sc = null;

	private static void bfs(Vector<Vector<Connect>> graph) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		int[] arr = new int[graph.size()];

		while (!queue.isEmpty()) {
			int now = queue.poll();

			int size = graph.elementAt(now).size();
			for (int i = 0; i < size; i++) {
				Connect connect = graph.elementAt(now).get(i);
				if (arr[connect.to] == 0) {
					arr[connect.to] = connect.from + 1;
					queue.add(connect.to);
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		sc = new Scanner(new FileInputStream("baekjoon11725.txt"));
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			Vector<Vector<Connect>> graph = new Vector<>();
			for (int i = 0; i < N; i++) {
				graph.add(new Vector<>());
			}

			for (int i = 0; i < N - 1; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				Connect connect1 = new Connect(x - 1, y - 1);
				graph.elementAt(x - 1).add(connect1);
				Connect connect2 = new Connect(y - 1, x - 1);
				graph.elementAt(y - 1).add(connect2);
			}
			bfs(graph);

		}
	}
}

class Connect {

	int from;
	int to;

	public Connect(int from, int to) {
		this.from = from;
		this.to = to;
	}

}