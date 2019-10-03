import java.util.Scanner;

public class BaekJoon1568 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int idx = 1;
		int second = 0;
		while (N > 0) {
			if (N < idx) {
				idx = 1;
			}
			N -= idx;
			idx++;
			second++;
		}
		System.out.println(second);
	}
}