import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon5014 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();

		int U = sc.nextInt();
		int D = sc.nextInt();

		int[] direct = { U, -D };

		boolean[] visited = new boolean[F + 1];

		Queue<Floor> queue = new LinkedList<>();
		visited[S] = true;
		queue.add(new Floor(S, 0));

		int reach = -1;
		while (!queue.isEmpty()) {
			Floor nowFloor = queue.poll();
			if(nowFloor.getNowPosition() == G) {
				reach = nowFloor.getCnt();
				break;
			}
			for (int i = 0; i < direct.length; i++) {
				int nextFloor = nowFloor.getNowPosition() + direct[i];

				if (nextFloor > 0 && nextFloor <= F) {
					if (!visited[nextFloor]) {
						visited[nextFloor] = true;
						queue.add(new Floor(nextFloor, nowFloor.getCnt() + 1));
					}
				}
			}
		}

		if (reach != -1) {
			System.out.println(reach);
		} else {
			System.out.println("use the stairs");
		}
	}
}

class Floor {
	private int nowPosition;
	private int cnt;

	public Floor() {
		super();
	}

	public Floor(int nowPosition, int cnt) {
		super();
		this.nowPosition = nowPosition;
		this.cnt = cnt;
	}

	public int getNowPosition() {
		return nowPosition;
	}

	public void setNowPosition(int nowPosition) {
		this.nowPosition = nowPosition;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}