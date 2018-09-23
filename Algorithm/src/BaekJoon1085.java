import java.util.Scanner;

public class BaekJoon1085 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		int min1 = Math.min(w - x, x);
		int min2 = Math.min(h - y, y);
		System.out.println(Math.min(min1, min2));
	}
}