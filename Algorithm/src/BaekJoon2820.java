
import java.util.Scanner;
import java.util.Vector;

public class BaekJoon2820 {

	private static Scanner sc;
	private static int N;

	private static Vector<Vector<Integer>> relation;
	private static long[] pay;

	private static void payCount(int now, long updown) {
		for (int i = 0; i < relation.elementAt(now).size(); i++) {
			dfs(relation.elementAt(now).get(i), updown);
		}
	}

	private static void dfs(int now, long updown) {
		pay[now] += updown;
		for (int i = 0; i < relation.elementAt(now).size(); i++) {
			dfs(relation.elementAt(now).get(i), updown);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		relation = new Vector<>();
		N = sc.nextInt();
		pay = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			relation.add(new Vector<>());
		}
		int M = sc.nextInt();
		pay[1] = sc.nextLong();
		for (int i = 2; i <= N; i++) {
			pay[i] = sc.nextLong();
			int idx = sc.nextInt();
			relation.get(idx).add(i);
		}

		for (int i = 0; i <= M; i++) {
			String[] str = sc.nextLine().split(" ");
			if ("p".equals(str[0])) {
				int employee = Integer.parseInt(str[1]);
				long updown = Long.parseLong(str[2]);
				payCount(employee, updown);
			} else if ("u".equals(str[0])) {
				int idx = Integer.parseInt(str[1]);
				System.out.println(pay[idx]);
			}
		}
	}
}