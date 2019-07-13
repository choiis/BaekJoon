import java.util.Scanner;

public class BaekJoon2920 {
	private static Scanner sc;
	private static int N = 8;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int res = 0;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				res++;
			} else if (arr[i] > arr[i + 1]) {
				res--;
			}
		}

		if (res == 7) {
			System.out.println("ascending");
		} else if (res == -7) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}
}