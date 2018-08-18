import java.util.Scanner;

public class BaekJoon2096 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		int[][] dp_max = new int[N][3];
		int[][] dp_min = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
				if (i == 0) {
					dp_max[i][j] = dp_min[i][j] = arr[i][j];
				}
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp_max[i][j] = Math.max(arr[i][j] + dp_max[i - 1][0], arr[i][j] + dp_max[i - 1][1]);
					dp_min[i][j] = Math.min(arr[i][j] + dp_min[i - 1][0], arr[i][j] + dp_min[i - 1][1]);
				} else if (j == 1) {
					dp_max[i][j] = Math.max(arr[i][j] + dp_max[i - 1][0],
							Math.max(arr[i][j] + dp_max[i - 1][2], arr[i][j] + dp_max[i - 1][1]));
					dp_min[i][j] = Math.min(arr[i][j] + dp_min[i - 1][0],
							Math.min(arr[i][j] + dp_min[i - 1][2], arr[i][j] + dp_min[i - 1][1]));
				} else {
					dp_max[i][j] = Math.max(arr[i][j] + dp_max[i - 1][2], arr[i][j] + dp_max[i - 1][1]);
					dp_min[i][j] = Math.min(arr[i][j] + dp_min[i - 1][2], arr[i][j] + dp_min[i - 1][1]);
				}
			}
		}

		int max = dp_max[N - 1][0];
		int min = dp_min[N - 1][0];
		for (int i = 1; i < 3; i++) {
			max = Math.max(max, dp_max[N - 1][i]);
			min = Math.min(min, dp_min[N - 1][i]);
		}
		System.out.println(max + " " + min);
	}
}