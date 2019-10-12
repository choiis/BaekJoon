import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1238 {
	private static Scanner sc;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int X = sc.nextInt();

		Vector<Eg>[] vecForward = new Vector[N];
		Vector<Eg>[] vecReverse = new Vector[N];
		for (int i = 0; i < N; i++) {
			vecForward[i] = new Vector<>();
			vecReverse[i] = new Vector<>();
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			vecForward[x - 1].add(new Eg(y - 1, z));
			vecReverse[y - 1].add(new Eg(x - 1, z));
		}
		int start = X - 1;
		int[] distanceForward = new int[N];
		int[] distanceReverse = new int[N];
		for (int i = 0; i < N; i++) {
			if (i == start) {
				distanceReverse[i] = 0;
				distanceForward[i] = 0;
			} else {
				distanceReverse[i] = -1;
				distanceForward[i] = -1;
			}
		}

		PriorityQueue<Eg> heap = new PriorityQueue<>();
		// start 何磐 沥规氢
		heap.add(new Eg(start, 0));
		while (!heap.isEmpty()) {
			Eg eg = heap.poll();
			int from = eg.to;
			for (int i = 0; i < vecForward[from].size(); i++) {
				Eg next = vecForward[from].get(i);
				int nextDist = next.dist + distanceForward[from];
				int to = next.to;
				if (distanceForward[to] == -1 || distanceForward[to] > nextDist) {
					distanceForward[to] = nextDist;
					heap.add(new Eg(to, nextDist));
				}
			}
		}
		// start 何磐 开规氢
		heap.add(new Eg(start, 0));
		while (!heap.isEmpty()) {
			Eg eg = heap.poll();
			int from = eg.to;
			for (int i = 0; i < vecReverse[from].size(); i++) {
				Eg next = vecReverse[from].get(i);
				int nextDist = next.dist + distanceReverse[from];
				int to = next.to;
				if (distanceReverse[to] == -1 || distanceReverse[to] > nextDist) {
					distanceReverse[to] = nextDist;
					heap.add(new Eg(to, nextDist));
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, distanceForward[i] + distanceReverse[i]);
		}
		System.out.println(max);
	}
}

class Eg implements Comparable<Eg> {
	int to;
	int dist;

	public Eg() {

	}

	public Eg(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Eg o) {
		return this.dist - o.dist;
	}
}
