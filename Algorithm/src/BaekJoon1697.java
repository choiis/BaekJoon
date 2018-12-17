
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1697 {

	private static Scanner sc = null;

	private static boolean[] visited = new boolean[100001];

	private static int bfs(int N, int K) {
		Queue<Location> queue = new LinkedList<>();
		visited[N] = true;
		queue.add(new Location(N, 0));

		while (!queue.isEmpty()) {
			Location location = queue.poll();
			int now = location.getWhere();
			int dist = location.getTime();
			if (now == K) {
				return dist;
			}

			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) { // -1 Ä­ ÀÌµ¿
					next = now - 1;
					if (next >= 0 && next <= 100000) {
						if (!visited[next]) {
							visited[next] = true;
							queue.add(new Location(next, dist + 1));
						}
					}
				} else if (i == 1) { // +1 Ä­ ÀÌµ¿
					next = now + 1;
					if (next >= 0 && next <= 100000) {
						if (!visited[next]) {
							visited[next] = true;
							queue.add(new Location(next, dist + 1));
						}
					}
				} else { // ¼ø°£ÀÌµ¿
					next = 2 * now;
					if (next >= 0 && next <= 100000) {
						if (!visited[next]) {
							visited[next] = true;
							queue.add(new Location(next, dist + 1));
						}
					}
				}
			}
		}

		return 0;
		
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(bfs(N, K));

	}
}

class Location {
	private int where;
	private int time;

	public Location() {

	}

	public Location(int where, int time) {
		this.where = where;
		this.time = time;
	}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {
		this.where = where;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}