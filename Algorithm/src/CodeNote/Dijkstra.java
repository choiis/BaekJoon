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
		V = sc.nextInt(); // vertex의 개수
		E = sc.nextInt(); // edge의 개수
		start = sc.nextInt(); // 시작 정점

		edge = new Vector<Vector<Edge>>();

		for (int i = 0; i < V + 1; i++) {
			Vector<Edge> e = new Vector<Edge>();
			edge.add(e);
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // 시작점
			int v = sc.nextInt(); // 도착점
			int d = sc.nextInt(); // 길이
			Edge e = new Edge(v, d);
			edge.elementAt(u).add(e); // 시작점 기준으로 벡터에 담는다
		}

		Vector<Integer> dist = dijkstra(start);
		for (int i = 1; i < dist.size(); i++) {
			System.out.println(String.valueOf(dist.elementAt(i)));
		}
	}

	public static Vector<Integer> dijkstra(int cur) {
		PriorityQueue<Edge> heap = new PriorityQueue<>();

		Vector<Integer> distance = new Vector<Integer>(); // 최단거리를 담을 자료구조

		for (int i = 0; i < V + 1; i++) {
			if (i == cur)
				distance.add(0);
			else
				distance.add(-1); // -1은 아직 방문하지 않은 노드
		}
		Edge e = new Edge(cur, 0);
		heap.add(e);

		while (!heap.isEmpty()) {
			Edge here = heap.remove();
			// 지금 점에서 갈수있는 루트 수
			for (int i = 0; i < edge.elementAt(here.point).size(); i++) {
				Edge nextEdge = edge.elementAt(here.point).elementAt(i);
				int nextPoint = nextEdge.point;
				int nextdist = distance.elementAt(here.point) + nextEdge.weight;
				// 방문을 안했거나
				// 현재 방문 거리보다 새로운 방문 거리가 짧을때
				if (distance.elementAt(nextPoint) == -1 || distance.elementAt(nextPoint) > nextdist) {
					distance.setElementAt(nextdist, nextPoint);// 앞이 값 뒤가 인덱스
					// point까지의 최단 거리를 nextdist로 갱신
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