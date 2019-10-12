import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon10282 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			@SuppressWarnings("unchecked")
			Vector<Connection>[] vec = new Vector[N + 1];
			for (int i = 0; i <= N; i++) {
				vec[i] = new Vector<>();
			}
			int d = sc.nextInt();
			int start = sc.nextInt();
			for (int i = 0; i < d; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int z = sc.nextInt();
				vec[y].add(new Connection(x, z));
			}
			int[] distance = new int[N + 1];
			PriorityQueue<Connection> heap = new PriorityQueue<>();
			for (int i = 0; i <= N; i++) {
				if (i == start) {
					distance[i] = 0;
				} else {
					distance[i] = -1; // INF 대신 이것도 가능
				}
			}
			heap.add(new Connection(start, distance[start]));

			while (!heap.isEmpty()) {
				Connection conn = heap.poll();
				int from = conn.to;
				for (int i = 0; i < vec[from].size(); i++) {
					Connection next = vec[from].get(i);
					int nextDist = distance[from] + next.dist;
					// 미방문 또는 더 적은 거리로 갈수 있을 때
					if (distance[next.to] == -1 || distance[next.to] > nextDist) {
						distance[next.to] = nextDist;
						heap.add(new Connection(next.to, nextDist));
					}
				}
			}
			int max = 0;
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (max < distance[i]) {
					max = distance[i];
				}
				if (distance[i] >= 0) {
					cnt++;
				}
			}
			System.out.println(cnt + " " + max);
		}
	}
}

class Connection implements Comparable<Connection> {
	int to;
	int dist;

	public Connection() {

	}

	public Connection(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Connection o) {
		return this.dist - o.dist;
	}

}