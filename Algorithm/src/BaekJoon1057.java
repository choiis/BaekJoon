import java.util.Scanner;

public class BaekJoon1057 {
	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();

		int round = 1;
		while (N != 1) {
			if ((A + 1) / 2 == (B + 1) / 2) {
				break;
			}
			round++;
			A = (A + 1) / 2;
			B = (B + 1) / 2;
			N = (N + 1) / 2;
		}

		System.out.println(round);
	}
}