import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon5214 {

	private static Vector<Vector<Integer>> vector = null;

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon5214.txt"));

		int N = sc.nextInt();
		int K = sc.nextInt();
		int M = sc.nextInt();

		vector = new Vector<Vector<Integer>>();

		for (int i = 0; i <= N + M; i++) {
			Vector<Integer> connection = new Vector<Integer>();
			vector.add(connection);
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < K; j++) {
				int u = sc.nextInt();
				vector.elementAt(u).add(N + i);
				vector.elementAt(N + i).add(u);
			}
		}

		int[] visited = new int[N + M + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			if (now == N) {
				break;
			}
			Vector<Integer> vec = vector.elementAt(now);
			for (int i = 0; i < vec.size(); i++) {
				if (visited[vec.get(i)] == 0) {
					if (vec.get(i) <= N) {
						visited[vec.get(i)] = 1 + visited[now];
					} else {
						visited[vec.get(i)] = visited[now];
					}
					queue.add(vec.get(i));
				}
			}
		}

		if (visited[N] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(visited[N]);
		}
	}
}
