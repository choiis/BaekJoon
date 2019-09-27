import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1038 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		if (N > 1022) {
			System.out.println("-1");
			return;
		}
		long[] dp = new long[N + 1];
		dp[0] = 1;
		int idx = 1;
		Queue<Long> queue = new LinkedList<Long>();

		for (int i = 1; i <= Math.min(N, 9); i++) {
			dp[i] = i;
			queue.add((long) i);
			idx++;
		}

		while (!queue.isEmpty() && N >= idx) {

			boolean out = false;
			long num = queue.poll();
			long digit = num % 10;
			for (int i = 0; i < digit; i++) {
				long newNum = 10 * num + i;
				dp[idx++] = newNum;
				if (idx > N) {
					out = true;
					break;
				}
				queue.add(newNum);
			}
			if (out) {
				break;
			}
		}
		if (dp[N] == 0) {
			System.out.println("-1");
		} else {
			System.out.println(dp[N]);
		}
	}
}