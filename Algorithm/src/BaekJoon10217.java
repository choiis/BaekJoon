import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon10217 {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {
		sc = new Scanner(new FileInputStream("baekjoon10217.txt"));
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			Vector<Vector<Air>> graph = new Vector<Vector<Air>>();
			int N = sc.nextInt(); // ���� ����
			int M = sc.nextInt(); // �� �������
			int K = sc.nextInt(); // edge�� ����

			for (int i = 0; i < N + 1; i++) {
				Vector<Air> e = new Vector<Air>();
				graph.add(e);
			}

			for (int i = 0; i < K; i++) {
				int u = sc.nextInt(); // ������
				int v = sc.nextInt(); // ������
				int c = sc.nextInt(); // ���
				int d = sc.nextInt(); // ����
				Air e = new Air(v, c, d);
				graph.elementAt(u).add(e); // ������ �������� ���Ϳ� ��´�
			}

			Vector<Integer> dist = new Vector<Integer>(); // �ִܰŸ��� ���� �ڷᱸ��
			PriorityQueue<Air> q = new PriorityQueue<>();

			for (int i = 0; i < N + 1; i++) {
				if (i == 1)
					dist.add(0);
				else
					dist.add(-1); // -1�� ���� �湮���� ���� ���
			}
			Air e = new Air(1, 0, 0);
			q.add(e);

			while (!q.isEmpty()) {
				Air edge = q.remove();

				for (int i = 0; i < graph.elementAt(edge.point).size(); i++) {
					Air nextEdge = graph.elementAt(edge.point).elementAt(i);
					int there = nextEdge.point;
					int cost = nextEdge.cost;

					int nextCost = cost + edge.cost;
					int nextdist = dist.elementAt(edge.point) + nextEdge.weight;
					if (M >= nextCost && (dist.elementAt(there) == -1 || dist.elementAt(there) > nextdist)) {
						dist.setElementAt(nextdist, there);
						Air ne = new Air(there, nextCost, nextdist);
						q.add(ne);
					}
				}
			}

			String result = String.valueOf(dist.elementAt(N));
			if ("-1".equals(result)) {
				System.out.println("Poor KCM");
			} else {
				System.out.println(String.valueOf(dist.elementAt(N)));
			}

		}

	}

}

class Air implements Comparable<Air> {

	int point;
	int cost;
	int weight;

	public Air(int dst, int weight) {
		this.point = dst;
		this.weight = weight;
	}

	public Air(int dst, int cost, int weight) {
		this.point = dst;
		this.cost = cost;
		this.weight = weight;
	}

	@Override
	public int compareTo(Air e) {
		if (this.weight != e.weight)
			return this.weight - e.weight;
		else
			return this.cost - e.cost;
	}
}
