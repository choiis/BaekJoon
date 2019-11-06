import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon1774 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt(); // 우주선
		int M = sc.nextInt(); // 이미 연결

		int[][] space = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			space[i][0] = sc.nextInt();
			space[i][1] = sc.nextInt();
		}

		boolean[] visited = new boolean[N + 1];

		PriorityQueue<Spaceship> heap = new PriorityQueue<>();
		int cnt = 0; // 선택 간선수
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			visited[x] = true;
			visited[y] = true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					heap.add(new Spaceship(j, calcDistance(space, x, j)));
				}
			}
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					heap.add(new Spaceship(j, calcDistance(space, y, j)));
				}
			}
			cnt++;
		}

		double result = 0;

		int nowPoint = 0; // => 최소 가중치 간선에서 다음 노드가 선택됨
		while (true) {
			Spaceship spaceship = heap.poll();
			if (visited[spaceship.to]) {
				continue;
			}

			nowPoint = spaceship.to;
			visited[nowPoint] = true;
			cnt++;
			result += spaceship.dist;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					heap.add(new Spaceship(i, calcDistance(space, nowPoint, i)));
				}
			}

			if (cnt >= N - 1) {
				break;
			}
		}

		System.out.printf("%.2f", result);
	}

	private static double calcDistance(int[][] stars, int from, int to) {

		double x = Math.abs(stars[from][0] - stars[to][0]);
		double y = Math.abs(stars[from][1] - stars[to][1]);
		return Math.sqrt((x * x + y * y));
	}
}

class Spaceship implements Comparable<Spaceship> {
	int to;
	double dist;

	public Spaceship() {

	}

	public Spaceship(int to, double dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Spaceship s) {
		if (this.dist > s.dist) {
			return 1;
		} else if (this.dist < s.dist) {
			return -1;
		} else {
			return 0;
		}
	}
}