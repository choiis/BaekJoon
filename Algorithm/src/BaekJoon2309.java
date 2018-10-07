
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2309 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sum -= 100;
		for (int i = 0; i < 8; i++) {
			boolean flag = false;
			for (int j = i + 1; j < 9; j++) {
				if (arr[i] + arr[j] == sum && i != j) {
					arr[i] = 0;
					arr[j] = 0;
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		Arrays.sort(arr);
		for (int i = 2; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}