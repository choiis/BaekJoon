import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1197 {

	private static Scanner sc;
	private static int uf[];

	private static int disjoint(int x) {
		if (x != uf[x])
			return uf[x] = disjoint(uf[x]);
		else
			return x;
	}

	private static int kruskal(List<Edg> edges, int M) {
		Collections.sort(edges);

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			int x = edges.get(i).x, y = edges.get(i).y;
			if (disjoint(y) != disjoint(x)) {
				uf[disjoint(y)] = uf[x];
				cnt += edges.get(i).dist;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon1197.txt"));
		List<Edg> Edges = new ArrayList<Edg>();

		int N = sc.nextInt();
		int M = sc.nextInt();
		uf = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			uf[i] = i;
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			Edges.add(new Edg(x, y, d));
		}

		System.out.println(kruskal(Edges, M));
	}
}

class Edg implements Comparable<Edg> {
	int x;
	int y;
	int dist;

	public Edg() {
	}

	public Edg(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Edg ed) {
		return this.dist - ed.dist;
	}

}