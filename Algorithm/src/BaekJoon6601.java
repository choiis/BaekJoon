import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon6601 {

	private static Scanner sc;

	private static int[][] direct = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 },
			{ -1, -2 } };

	private final static int N = 8;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String s;
		while ((s = sc.nextLine()) != null && s.length() != 0) {

			String[] ch = s.split(" ");
			String char1 = ch[0];
			String char2 = ch[1];
			int startX = (int) s.charAt(0) - 'a';
			int startY = (int) s.charAt(1) - '0' - 1;
			int endX = s.charAt(3) - 'a';
			int endY = s.charAt(4) - '0' - 1;
			boolean[][] check = new boolean[N][N];
			Queue<Knight> queue = new LinkedList<Knight>();
			queue.add(new Knight(startX, startY, 0));
			check[startX][startY] = true;
			int dist = 0;
			while (!queue.isEmpty()) {
				Knight knight = queue.poll();
				int nowX = knight.getX();
				int nowY = knight.getY();
				int distance = knight.getDistance();
				if (nowX == endX && nowY == endY) {
					dist = distance;
					break;
				}

				for (int j = 0; j < direct.length; j++) {
					int nextX = nowX + direct[j][0];
					int nextY = nowY + direct[j][1];
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
						if (!check[nextX][nextY]) {
							check[nextX][nextY] = true;
							queue.add(new Knight(nextX, nextY, distance + 1));
						}
					}
				}
			}
			System.out.println("To get from " + char1 + " to " + char2 + " takes " + dist + " knight moves.");

		}
	}
}

class Knight {
	private int x;
	private int y;
	private int distance;

	public Knight() {
		super();
	}

	public Knight(int x, int y, int distance) {
		super();
		this.x = x;
		this.y = y;
		this.distance = distance;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}