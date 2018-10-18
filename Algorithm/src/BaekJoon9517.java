import java.util.Scanner;

public class BaekJoon9517 {

	private static Scanner sc;

	private static int next(int now) {
		if (now == 8) {
			return 1;
		} else {
			return now + 1;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int now = sc.nextInt();
		int N = sc.nextInt();
		int timeLimit = 210;
		for (int i = 0; i < N; i++) {
			int time = sc.nextInt();
			timeLimit -= time;
			if (timeLimit <= 0) {
				System.out.println(now);
				break;
			}
			char ch = sc.next().charAt(0);
			if (ch == 'T') {
				now = next(now);
			} else {
				continue;
			}
		}
	}
}