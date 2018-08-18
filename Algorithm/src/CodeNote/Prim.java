package CodeNote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	int v[];

	private static Scanner sc = null;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("mst.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<NodePrim> g[] = new ArrayList[10005];
		PriorityQueue<NodePrim> pq = new PriorityQueue<NodePrim>();

		for (int i = 1; i <= n; i++)
			g[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			g[x].add(new NodePrim(y, z));
			g[y].add(new NodePrim(x, z));
		}

		int s = 1, ans = 0;
		int v[] = new int[n + 1];

		for (int i = 0; i < n - 1; i++) {
			v[s] = 1;
			for (int j = 0; j < g[s].size(); j++) {
				pq.add(g[s].get(j));
			}
			while (v[pq.element().x] == 1) {
				pq.remove();
			}
			ans += pq.element().y;
			s = pq.peek().x;
			pq.remove();
		}
		System.out.println(ans);
	}
}

class NodePrim implements Comparable<NodePrim> {
	int x, y;

	public NodePrim() {
	}

	public NodePrim(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(NodePrim arg0) {
		return this.y - arg0.y;
	}
}