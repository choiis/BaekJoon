import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2110 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int C = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int left = 1; // 최소거리
		int right = arr[N - 1] - arr[0]; // 최대거리
		int result = 0;
		while (left <= right) {

			int gap = (left + right) / 2;
			int cnt = 1;
			int point = arr[0];
			for (int i = 1; i < N; i++) {
				if (arr[i] - point >= gap) {
					cnt++;
					point = arr[i];
				}
			}
			if (cnt >= C) {
				result = gap;
				left = gap + 1;
			} else {
				right = gap - 1;
			}
		}
		System.out.println(result);
	}
}