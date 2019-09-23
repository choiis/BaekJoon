import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2251 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		Queue<Bucket> queue = new LinkedList<>();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];
		queue.add(new Bucket(0, 0, C));

		while (!queue.isEmpty()) {
			Bucket bucket = queue.poll();
			int a = bucket.getA();
			int b = bucket.getB();
			int c = bucket.getC();

			if (visited[a][b][c]) {
				continue;
			}
			visited[a][b][c] = true;
			if (a == 0) {
				heap.add(c);
			}

			// A -> B
			if (a + b > B) {
				queue.add(new Bucket(a + b - B, B, c));
			} else {
				queue.add(new Bucket(0, a + b, c));
			}
			// B -> A
			if (a + b > A) {
				queue.add(new Bucket(A, a + b - A, c));
			} else {
				queue.add(new Bucket(a + b, 0, c));
			}
			// A -> C
			if (a + c > C) {
				queue.add(new Bucket(a + c - C, b, C));
			} else {
				queue.add(new Bucket(0, b, a + c));
			}
			// C -> A
			if (a + c > A) {
				queue.add(new Bucket(A, b, a + c - A));
			} else {
				queue.add(new Bucket(a + c, b, 0));
			}
			// B -> C
			if (b + c > C) {
				queue.add(new Bucket(a, b + c - C, C));
			} else {
				queue.add(new Bucket(a, 0, b + c));
			}
			// C -> B
			if (b + c > B) {
				queue.add(new Bucket(a, B, b + c - B));
			} else {
				queue.add(new Bucket(a, b + c, 0));
			}
		}

		while (!heap.isEmpty()) {
			System.out.print(heap.poll() + " ");
		}

	}
}

class Bucket {
	private int a;
	private int b;
	private int c;

	public Bucket() {
		super();
	}

	public Bucket(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

}