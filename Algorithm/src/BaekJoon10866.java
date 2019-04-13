import java.util.Scanner;

public class BaekJoon10866 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cute = 0;
		int not = 0;
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();
			if (s == 1) {
				cute++;
			} else {
				not++;
			}
		}

		if (cute > not) {
			System.out.println("Junhee is cute!");
		} else {
			System.out.println("Junhee is not cute!");
		}
	}
}