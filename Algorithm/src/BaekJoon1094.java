import java.util.Scanner;

public class BaekJoon1094 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int K = sc.nextInt();

		int cnt = 0;
		int div;
		while (true) {
			if ((K % 2) == 1) {
				cnt++;
			}
			K /= 2;
			if (K == 0) {
				break;
			}
		}
		System.out.println(cnt);
	}
}