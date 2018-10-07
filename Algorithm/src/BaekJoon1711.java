import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1711 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon1711.txt"));
		int N = sc.nextInt();
		int[][] xy = new int[N][2];
		for (int i = 0; i < N; i++) {
			xy[i][0] = sc.nextInt();
			xy[i][1] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int[] ds = new int[3];
					ds[0] = dist(xy[i][0], xy[i][1], xy[j][0], xy[j][1]);
					ds[1] = dist(xy[k][0], xy[k][1], xy[j][0], xy[j][1]);
					ds[2] = dist(xy[i][0], xy[i][1], xy[k][0], xy[k][1]);
					Arrays.sort(ds);
					if (ds[0] + ds[1] == ds[2]) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static int dist(int x1, int y1, int x2, int y2) {

		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}