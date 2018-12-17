import java.util.Scanner;

public class Baekjoon2908 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int X2 = (X / 100) + 10 * ((X % 100) / 10) + 100 * ((X % 100) % 10);
		int Y2 = (Y / 100) + 10 * ((Y % 100) / 10) + 100 * ((Y % 100) % 10);

		System.out.println(Math.max(X2, Y2));
	}
}
