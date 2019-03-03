import java.util.Scanner;

public class BaekJoon5543 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int minBurger = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			int m = sc.nextInt();
			minBurger = Math.min(minBurger, m);
		}

		int minBeverage = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			int m = sc.nextInt();
			minBeverage = Math.min(minBeverage, m);
		}
		System.out.println(minBeverage + minBurger - 50);
	}
}