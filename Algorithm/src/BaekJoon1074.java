import java.util.Scanner;

public class BaekJoon1074 {

	private static Scanner sc;

	private static int cnt = 0;
	private static int N;
	private static int r;
	private static int c;

	private static void divideConquer(int startX, int startY, int len) {
		if (len == 1) {
			if (startX == r && startY == c) {
				System.out.println(cnt);
				return;
			} else {
				cnt++;
				return;
			}
		} else {
			divideConquer(startX, startY, len / 2);
			divideConquer(startX, startY + len / 2, len / 2);
			divideConquer(startX + len / 2, startY, len / 2);
			divideConquer(startX + len / 2, startY + len / 2, len / 2);
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int pow = (int) Math.pow(2, N);
		divideConquer(0, 0, pow);
	}
}