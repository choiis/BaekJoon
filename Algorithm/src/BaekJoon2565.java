import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2565 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		Wire[] wires = new Wire[N + 1];
		int dp[] = new int[N + 1];
		wires[0] = new Wire(0, 0);
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			wires[i] = new Wire(x, y);
		}

		Arrays.sort(wires);
		// y ±âÁØ dp
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				if (wires[i].getY() > wires[j].getY()) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
	}
}

class Wire implements Comparable<Wire> {
	private int x;
	private int y;

	public Wire() {
		super();
	}

	public Wire(int x, int y) {
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
	public int compareTo(Wire o) {
		return this.x - o.x;
	}

}