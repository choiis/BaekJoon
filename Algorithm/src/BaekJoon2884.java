import java.util.Scanner;

public class BaekJoon2884 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		M -= 45;
		if (M >= 0) {
			System.out.println(N + " " + M);
		} else {
			M += 60;
			N -= 1;
			if (N >= 0) {
				System.out.println(N + " " + M);
			} else {
				N += 24;
				System.out.println(N + " " + M);
			}
		}
	}
}