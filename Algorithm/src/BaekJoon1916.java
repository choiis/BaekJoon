import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon1916 {

	private static Vector<Vector<Edges>> edge = null;
	private static int V;
	private static int E;
	private static int start;

	private static Scanner sc = null;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("baekjoon1916.txt"));

		V = sc.nextInt(); // vertex�� ����
		E = sc.nextInt(); // edge�� ����

		edge = new Vector<Vector<Edges>>();

		for (int i = 0; i < V + 1; i++) {
			Vector<Edges> e = new Vector<Edges>();
			edge.add(e);
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // ������
			int v = sc.nextInt(); // ������
			int d = sc.nextInt(); // ����ġ
			Edges e = new Edges(v, d);
			edge.elementAt(u).add(e); // ������ �������� ���Ϳ� ��´�
		}

		start = sc.nextInt(); // ������
		int end = sc.nextInt(); // ������
		Vector<Integer> dist = dijkstra(start);

		System.out.println(dist.get(end));
	}

	public static Vector<Integer> dijkstra(int cur) {
		PriorityQueue<Edges> q = new PriorityQueue<>();

		Vector<Integer> dist = new Vector<Integer>(); // �ִܰŸ��� ���� �ڷᱸ��

		for (int i = 0; i < V + 1; i++) {
			if (i == cur)
				dist.add(0);
			else
				dist.add(-1); // -1�� ���� �湮���� ���� ���
		}
		Edges e = new Edges(cur, 0);
		q.add(e);

		while (!q.isEmpty()) {
			Edges here = q.remove();
			for (int i = 0; i < edge.elementAt(here.point).size(); i++) {
				Edges a = edge.elementAt(here.point).elementAt(i);
				int there = a.point;
				int nextdist = dist.elementAt(here.point) + a.weight;
				if (dist.elementAt(there) == -1 || dist.elementAt(there) > nextdist) {
					dist.setElementAt(nextdist, there);
					Edges ne = new Edges(there, nextdist);
					q.add(ne);
				}
			}
		}
		return dist;
	}
}
