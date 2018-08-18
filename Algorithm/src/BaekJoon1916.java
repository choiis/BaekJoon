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

		V = sc.nextInt(); // vertex의 개수
		E = sc.nextInt(); // edge의 개수

		edge = new Vector<Vector<Edges>>();

		for (int i = 0; i < V + 1; i++) {
			Vector<Edges> e = new Vector<Edges>();
			edge.add(e);
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // 시작점
			int v = sc.nextInt(); // 도착점
			int d = sc.nextInt(); // 가중치
			Edges e = new Edges(v, d);
			edge.elementAt(u).add(e); // 시작점 기준으로 벡터에 담는다
		}

		start = sc.nextInt(); // 시작점
		int end = sc.nextInt(); // 도착점
		Vector<Integer> dist = dijkstra(start);

		System.out.println(dist.get(end));
	}

	public static Vector<Integer> dijkstra(int cur) {
		PriorityQueue<Edges> q = new PriorityQueue<>();

		Vector<Integer> dist = new Vector<Integer>(); // 최단거리를 담을 자료구조

		for (int i = 0; i < V + 1; i++) {
			if (i == cur)
				dist.add(0);
			else
				dist.add(-1); // -1은 아직 방문하지 않은 노드
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
