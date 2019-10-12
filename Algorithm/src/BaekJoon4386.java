import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon4386 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		double[][] stars = new double[N][2];
		for (int i = 0; i < N; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}

		int cnt = 0; // 선택 간선 수
		int nowPoint = 0; // 지금 선택 점
		boolean[] visited = new boolean[N];
		PriorityQueue<Star> heap = new PriorityQueue<>();
		visited[nowPoint] = true;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				heap.add(new Star(i, calcDistance(stars, nowPoint, i)));
			}
		}
		double result = 0;
		while (true) {
			Star star = heap.poll();
			if (visited[star.to]) {
				continue;
			}

			nowPoint = star.to;
			visited[nowPoint] = true;
			cnt++;
			result += star.dist;
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					heap.add(new Star(i, calcDistance(stars, nowPoint, i)));
				}
			}

			if (cnt >= N - 1) {
				break;
			}
		}
		System.out.printf("%.2f", result);
	}

	private static double calcDistance(double[][] stars, int from, int to) {

		double x = Math.abs(stars[from][0] - stars[to][0]);
		double y = Math.abs(stars[from][1] - stars[to][1]);
		return Math.sqrt((x * x + y * y));
	}
}

class Star implements Comparable<Star> {

	int to;
	double dist;

	public Star() {

	}

	public Star(int to, double dist) {
		super();
		this.to = to;
		this.dist = dist;
	}

	@Override
	public int compareTo(Star s) {
		if (this.dist > s.dist) {
			return 1;
		} else if (this.dist < s.dist) {
			return -1;
		} else {
			return 0;
		}
	}

}