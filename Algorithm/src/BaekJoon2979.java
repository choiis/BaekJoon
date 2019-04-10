import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2979 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int[] startTime = new int[3];
		int[] endTime = new int[3];
		for (int i = 0; i < 3; i++) {
			startTime[i] = sc.nextInt();
			endTime[i] = sc.nextInt();
		}

		Arrays.sort(startTime);
		Arrays.sort(endTime);

		int cnt = 0;
		cnt += 3 * C * (endTime[0] - startTime[2]);
		cnt += 2 * B * ((endTime[1] - endTime[0]) + (startTime[2] - startTime[1]));
		cnt += A * ((endTime[2] - endTime[1]) + (startTime[1] - startTime[0]));
		System.out.println(cnt);
	}
}