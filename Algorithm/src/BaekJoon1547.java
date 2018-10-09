import java.util.Scanner;

public class BaekJoon1547 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int M = sc.nextInt();
		int[] arr = { 1, 0, 0 };
		for (int i = 0; i < 3; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int tmp = arr[x - 1];
			arr[x - 1] = arr[y - 1];
			arr[y - 1] = tmp;
		}

		for (int i = 0; i < 3; i++) {
			if (arr[i] == 1) {
				System.out.println(i + 1);
			}
		}
	}
}
