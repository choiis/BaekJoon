import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon12761 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int[] direct = { -1, 1, A, B, -A, -B };
		int N = sc.nextInt();
		int M = sc.nextInt();

		boolean[] visited = new boolean[100001];

		Queue<StoneBridge> queue = new LinkedList<>();
		queue.add(new StoneBridge(N, 0));
		visited[N] = true;
		int ans = 0;
		while (!queue.isEmpty()) {
			StoneBridge now = queue.poll();
			int nowX = now.loc;
			int nowCnt = now.cnt;

			boolean find = false;
			for (int i = 0; i < direct.length; i++) {
				int nextX = nowX + direct[i];
				if (nextX >= 0 && nextX <= 100000) {
					if (nextX == M) {
						find = true;
						ans = nowCnt + 1;
						break;
					}

					if (!visited[nextX]) {
						visited[nextX] = true;
						queue.add(new StoneBridge(nextX, nowCnt + 1));
					}
				}
			}

			if (find) {
				break;
			}
			if (nowX * A <= 100000) {
				if (nowX * A == M) {
					ans = nowCnt + 1;
					break;
				}

				if (!visited[nowX * A]) {
					visited[nowX * A] = true;
					queue.add(new StoneBridge(nowX * A, nowCnt + 1));
				}
			}

			if (nowX * B <= 100000) {
				if (nowX * B == M) {
					ans = nowCnt + 1;
					break;
				}

				if (!visited[nowX * B]) {
					visited[nowX * B] = true;
					queue.add(new StoneBridge(nowX * B, nowCnt + 1));
				}
			}

		}

		System.out.println(ans);
	}
}

class StoneBridge {
	int loc;
	int cnt;

	public StoneBridge(int loc, int cnt) {
		super();
		this.loc = loc;
		this.cnt = cnt;
	}

}