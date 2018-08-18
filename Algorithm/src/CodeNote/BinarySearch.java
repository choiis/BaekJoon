package CodeNote;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearch {

	private static Scanner sc = null;

	public static void main(String[] args) throws IOException {

		sc = new Scanner(new FileInputStream("binarySearch.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int K = sc.nextInt();

			int left = 0;
			int right = N - 1;
			int mid;
			boolean find = false;
			while (left <= right) {
				mid = (left + right) / 2;
				if (arr[mid] == K) {
					find = true;
					break;
				} else if (arr[mid] > K) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			if (find) {
				System.out.println("exist");
			} else {
				System.out.println("not exist");
			}
		}
	}
}
