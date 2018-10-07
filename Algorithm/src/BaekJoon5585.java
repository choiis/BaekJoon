import java.util.Scanner;

public class BaekJoon5585 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 1000 - N;
		int[] arr = { 500, 100, 50, 10, 5, 1 };
		int cnt = 0;
		for (int i = 0; i < 6; i++) {
			if (arr[i] > sum) {
				continue;
			}

			int div = sum / arr[i];
			cnt += div;
			sum -= div * arr[i];
		}
		System.out.println(cnt);
	}
}