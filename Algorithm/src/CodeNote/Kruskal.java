package CodeNote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {
	static int uf[];
	private static Scanner sc;

	static int disjoint(int x) {
		if (x != uf[x])
			return uf[x] = disjoint(uf[x]);
		else
			return x;
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<NodeKruskal> Edges = new ArrayList<NodeKruskal>();

		sc = new Scanner(new FileInputStream("mst.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();
		uf = new int[n + 1];

		for (int i = 1; i <= n; i++)
			uf[i] = i;
		for (int i = 0; i < m; i++)
			Edges.add(new NodeKruskal(sc.nextInt(), sc.nextInt(), sc.nextInt()));

		Collections.sort(Edges);

		long ans = 0;

		for (int i = 0; i < m; i++) {
			int x = Edges.get(i).x, y = Edges.get(i).y;
			if (disjoint(y) != disjoint(x)) {
				uf[disjoint(y)] = uf[x];
				ans += Edges.get(i).z;
			}
		}
		System.out.println(ans);
	}
}

class NodeKruskal implements Comparable<NodeKruskal> {
	int x, y, z;

	public NodeKruskal() {
	}

	public NodeKruskal(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(NodeKruskal arg0) {
		return this.z - arg0.z;
	}
}