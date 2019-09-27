import java.util.Scanner;

public class BaekJoon2231 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = 0;
		for (int i = 1; i <= N; i++) {
			int create = i;
			int sum = create;
			while (create != 0) {
				sum += (create % 10);
				create /= 10;
			}
			if (sum == N) {
				min = i;
				break;
			}
		}

		System.out.println(min);
	}
}