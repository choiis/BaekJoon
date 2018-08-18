import java.util.Scanner;

public class BaekJoon3053 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int r = sc.nextInt();

		double X = Math.PI * r * r;
		System.out.printf("%.6f\n", X);
		double Y = 2 * r * r;
		System.out.printf("%.6f\n", Y);
	}
}