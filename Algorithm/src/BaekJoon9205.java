
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon9205 {

	private static Scanner sc;

	private static final int MAX = 1000;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			boolean[] visited = new boolean[N + 2];
			int[][] store = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				store[i][0] = sc.nextInt();
				store[i][1] = sc.nextInt();
			}
			Queue<Beer> queue = new LinkedList<>();
			visited[0] = true;
			queue.add(new Beer(store[0][0], store[0][1]));
			while (!queue.isEmpty()) {
				Beer beer = queue.poll();
				boolean flag = false;

				for (int i = 1; i < N + 2; i++) {
					if ((Math.abs(beer.getX() - store[i][0]) + Math.abs(beer.getY() - store[i][1]) <= MAX)
							&& !visited[i]) {
						visited[i] = true;
						if (i == N + 1) {
							flag = true;
							break;
						} else {
							queue.add(new Beer(store[i][0], store[i][1]));
						}
					}
				}

				if (flag) {
					break;
				}
			}

			if (visited[N + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}

class Beer {
	private int x;
	private int y;

	public Beer() {
		super();
	}

	public Beer(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}