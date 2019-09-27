import java.util.Scanner;

public class BaekJoon11054 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] lis = new int[N];
		int[] lds = new int[N];
		lis[0] = 1;
		for (int i = 1; i < N; i++) {
			lis[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}

		lds[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = i + 1; j < N; j++) {
				if (arr[i] > arr[j]) {
					lds[i] = Math.max(lds[i], lds[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(lis[i] + lds[i] - 1, max);
		}
		System.out.println(max);
	}
}