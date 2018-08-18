import java.util.Scanner;

public class BaekJoon1977 {

	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int M, N;

		M = sc.nextInt();
		N = sc.nextInt();

		int from = (int) Math.ceil(Math.sqrt(M));
		int to = (int) Math.floor(Math.sqrt(N));

		int sum = 0;
		int min = (int) Math.pow(from, 2);
		for (int i = from; i <= to; i++) {
			sum += (int) Math.pow(i, 2);
		}

		if (sum > 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println("-1");
		}

		sc.close();
	}
}