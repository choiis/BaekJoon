import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon11650 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<CompXY> heap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			heap.add(new CompXY(x, y));
		}

		while (!heap.isEmpty()) {
			CompXY compXY = heap.poll();
			System.out.println(compXY.getX() + " " + compXY.getY());
		}
	}
}

class CompXY implements Comparable<CompXY> {
	private int x;
	private int y;

	public CompXY() {
	}

	public CompXY(int x, int y) {
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
	public int compareTo(CompXY o) {
		if (this.x == o.x) {
			return this.y - o.getY();
		} else {
			return this.x - o.getX();
		}
	}

}