import java.util.Scanner;

public class BaekJoon1145 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		int result = 1;
		while (true) {
			int cnt = 0;

			for (int i = 0; i < 5; i++) {
				if (result % arr[i] == 0 && result >= arr[i]) {
					cnt++;
				}
			}
			if (cnt >= 3) {
				break;
			}
			result++;
		}
		System.out.println(result);
	}
}
