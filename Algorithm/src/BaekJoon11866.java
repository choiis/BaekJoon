import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon11866 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		int M = sc.nextInt();
		System.out.print("<");
		while (true) {
			for (int i = 0; i < M - 1; i++) {
				queue.add(queue.peek());
				queue.poll();
			}
			System.out.print(queue.poll());
			if (!queue.isEmpty()) {
				System.out.print(", ");
			} else {
				break;
			}

		}

		System.out.println(">");
	}
}