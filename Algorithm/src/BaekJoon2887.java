import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon2887 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] planets = new int[N][3];
		for (int i = 0; i < N; i++) {
			planets[i][0] = sc.nextInt();
			planets[i][1] = sc.nextInt();
			planets[i][2] = sc.nextInt();
		}

		int cnt = 0;
		int result = 0;
		PriorityQueue<Planet> heap = new PriorityQueue<>();
		int nowPoint = 0;
		boolean[] visited = new boolean[N];
		visited[nowPoint] = true;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				heap.add(new Planet(i, calcDistance(planets, nowPoint, i)));
			}
		}

		while (true) {
			Planet planet = heap.poll();
			if (visited[planet.to]) {
				continue;
			}

			nowPoint = planet.to;
			visited[nowPoint] = true;
			result += planet.dist;
			cnt++;

			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					heap.add(new Planet(i, calcDistance(planets, nowPoint, i)));
				}
			}
			if (cnt >= N - 1) {
				break;
			}
		}
		System.out.println(result);
	}

	private static int calcDistance(int[][] planets, int from, int to) {

		int x = Math.abs(planets[from][0] - planets[to][0]);
		int y = Math.abs(planets[from][1] - planets[to][1]);
		int z = Math.abs(planets[from][2] - planets[to][2]);
		return Math.min(x, Math.min(y, z));
	}
}

class Planet implements Comparable<Planet> {

	int to;
	int dist;

	public Planet() {

	}

	public Planet(int to, int dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Planet p) {
		return this.dist - p.dist;
	}

}