package CodeNote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Dijkstra {

	private static Vector<Vector<Edge>> edge = null;
	private static int V;
	private static int E;
	private static int start;

	private static Scanner sc = null;

	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("dijkstra.txt"));
		V = sc.nextInt(); // vertex�� ����
		E = sc.nextInt(); // edge�� ����
		start = sc.nextInt(); // ���� ����

		edge = new Vector<Vector<Edge>>();

		for (int i = 0; i < V + 1; i++) {
			Vector<Edge> e = new Vector<Edge>();
			edge.add(e);
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // ������
			int v = sc.nextInt(); // ������
			int d = sc.nextInt(); // ����
			Edge e = new Edge(v, d);
			edge.elementAt(u).add(e); // ������ �������� ���Ϳ� ��´�
		}

		Vector<Integer> dist = dijkstra(start);
		for (int i = 1; i < dist.size(); i++) {
			System.out.println(String.valueOf(dist.elementAt(i)));
		}
	}

	public static Vector<Integer> dijkstra(int cur) {
		PriorityQueue<Edge> heap = new PriorityQueue<>();

		Vector<Integer> distance = new Vector<Integer>(); // �ִܰŸ��� ���� �ڷᱸ��

		for (int i = 0; i < V + 1; i++) {
			if (i == cur)
				distance.add(0);
			else
				distance.add(-1); // -1�� ���� �湮���� ���� ���
		}
		Edge e = new Edge(cur, 0);
		heap.add(e);

		while (!heap.isEmpty()) {
			Edge here = heap.remove();
			// ���� ������ �����ִ� ��Ʈ ��
			for (int i = 0; i < edge.elementAt(here.point).size(); i++) {
				Edge nextEdge = edge.elementAt(here.point).elementAt(i);
				int nextPoint = nextEdge.point;
				int nextdist = distance.elementAt(here.point) + nextEdge.weight;
				// �湮�� ���߰ų�
				// ���� �湮 �Ÿ����� ���ο� �湮 �Ÿ��� ª����
				if (distance.elementAt(nextPoint) == -1 || distance.elementAt(nextPoint) > nextdist) {
					distance.setElementAt(nextdist, nextPoint);// ���� �� �ڰ� �ε���
					// point������ �ִ� �Ÿ��� nextdist�� ����
					Edge ne = new Edge(nextPoint, nextdist);
					heap.add(ne);
				}
			}
		}
		return distance;
	}
}

class Edge implements Comparable<Edge> {

	int point;
	int weight;

	public Edge() {
	}

	public Edge(int dst, int weight) {
		this.point = dst;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge e) {
		return this.weight - e.weight;
	}
}