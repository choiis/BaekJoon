import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon2751 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2751.txt"));

		int N = sc.nextInt();
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int M = sc.nextInt();
			heap.add(M);
		}

		for (int i = 0; i < N; i++) {
			System.out.println(heap.poll());
		}
	}
}