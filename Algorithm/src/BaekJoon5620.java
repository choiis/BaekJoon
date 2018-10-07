import java.util.Scanner;

public class BaekJoon5620 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[T][2];
		for (int i = 0; i < T; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE - 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int dist = (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0])
						+ (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);
				min = Math.min(min, dist);
			}
		}
		System.out.println(min);
	}
}