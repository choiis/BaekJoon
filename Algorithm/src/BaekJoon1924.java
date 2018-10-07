import java.util.Scanner;

public class BaekJoon1924 {

	private static Scanner sc;

	private static int[] month = { 0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i <= N; i++) {
			M += month[i];
		}

		int div = M % 7;
		if (div == 1) {
			System.out.println("MON");
		} else if (div == 2) {
			System.out.println("TUE");
		} else if (div == 3) {
			System.out.println("WED");
		} else if (div == 4) {
			System.out.println("THU");
		} else if (div == 5) {
			System.out.println("FRI");
		} else if (div == 6) {
			System.out.println("SAT");
		} else {
			System.out.println("SUN");
		}
	}
}