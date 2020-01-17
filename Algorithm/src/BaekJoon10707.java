import java.util.Scanner;

public class BaekJoon10707 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();

		int min = A * P;
		if (P <= C) {
			min = Math.min(min, B);
		} else {
			min = Math.min(min, B + D * (P - C));
		}
		System.out.println(min);
	}
}