import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon11651 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<CompXY2> heap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			heap.add(new CompXY2(x, y));
		}

		while (!heap.isEmpty()) {
			CompXY2 compXY = heap.poll();
			System.out.println(compXY.getX() + " " + compXY.getY());
		}
	}
}

class CompXY2 implements Comparable<CompXY2> {
	private int x;
	private int y;

	public CompXY2() {
	}

	public CompXY2(int x, int y) {
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

	@Override
	public int compareTo(CompXY2 o) {
		if (this.y == o.y) {
			return this.x - o.getX();
		} else {
			return this.y - o.getY();
		}
	}

}