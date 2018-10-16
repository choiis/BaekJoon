
import java.util.Scanner;

public class BaekJoon1668 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr = new int[T];
		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt1 = 0;
		int max1 = 0;
		for (int i = 0; i < T; i++) {
			if (max1 < arr[i]) {
				cnt1++;
				max1 = arr[i];
			}
		}
		System.out.println(cnt1);

		int cnt2 = 0;
		int max2 = 0;
		for (int i = T - 1; i >= 0; i--) {
			if (max2 < arr[i]) {
				cnt2++;
				max2 = arr[i];
			}
		}
		System.out.println(cnt2);
	}
}