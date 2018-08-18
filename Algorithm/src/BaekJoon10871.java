import java.util.Scanner;

public class BaekJoon10871 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int c = sc.nextInt();
			if (c < X) {
				System.out.print(c + " ");
			}
		}
	}
}