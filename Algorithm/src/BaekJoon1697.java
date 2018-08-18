
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1697 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(N, 0));
		int result = 0;
		while (!queue.isEmpty()) {
			Location now = queue.poll();

			boolean flag = false;

			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					int where = now.getWhere() + 1;
					int time = now.getTime() + 1;

					if (where == K) {
						flag = true;
						result = time;
						break;
					} else {
						queue.add(new Location(where, time));
					}
				} else if (i == 1) {

					int where = now.getWhere() - 1;
					int time = now.getTime() + 1;

					if (where == K) {
						flag = true;
						result = time;
						break;
					} else {
						queue.add(new Location(where, time));
					}
				} else {

					int where = now.getWhere() * 2;
					int time = now.getTime() + 1;

					if (where == K) {
						flag = true;
						result = time;
						break;
					} else {
						queue.add(new Location(where, time));
					}
				}
			}

			if (flag) {
				break;
			}
		}

		System.out.println(result);
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