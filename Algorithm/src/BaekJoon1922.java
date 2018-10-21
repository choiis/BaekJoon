
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1922 {

	private static Scanner sc;

	public static int prim(ArrayList<Ed>[] edge, int N) {
		PriorityQueue<Ed> pq = new PriorityQueue<Ed>();

		int s = 1, cnt = 0;
		int v[] = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			v[s] = 1;
			for (int j = 0; j < edge[s].size(); j++) {
				pq.add(edge[s].get(j));
			}
			while (v[pq.element().v] == 1) {
				pq.remove();
			}
			cnt += pq.element().dist;
			s = pq.peek().v;
			pq.remove();
		}
		return cnt;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		ArrayList<Ed>[] edge = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			edge[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			edge[x].add(new Ed(y, z));
			edge[y].add(new Ed(x, z));
		}
		System.out.println(prim(edge, N));
	}
}

class Ed implements Comparable<Ed> {
	int v;
	int dist;

	public Ed(int v, int dist) {
		super();
		this.v = v;
		this.dist = dist;
	}

	@Override
	public int compareTo(Ed ed) {
		return this.dist - ed.dist;
	}

}