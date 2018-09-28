
import java.util.Scanner;

public class BaekJoon2869 {

	private static Scanner sc = null;

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		System.out.println((int) Math.ceil((double) (V - B) / (double) (A - B)));
	}
}