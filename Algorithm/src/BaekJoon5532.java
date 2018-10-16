
import java.util.Scanner;

public class BaekJoon5532 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int div1 = 0;
		int div2 = 0;
		if (A % C == 0) {
			div1 = A / C;
		} else {
			div1 = A / C + 1;
		}

		if (B % D == 0) {
			div2 = B / D;
		} else {
			div2 = B / D + 1;
		}
		System.out.println(L - Math.max(div1, div2));
	}
}