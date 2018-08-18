import java.util.Scanner;

public class BaekJoon1676 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (i % 5 == 0)
				cnt++;
			if (i % 25 == 0)
				cnt++;
			if (i % 125 == 0)
				cnt++;
		}

		System.out.println(cnt);
	}
}