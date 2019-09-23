import java.util.Scanner;

public class BaekJoon5597 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		boolean[] students = new boolean[31];
		for (int i = 0; i < 28; i++) {
			int input = sc.nextInt();
			students[input] = true;
		}

		for (int i = 1; i <= 30; i++) {
			if (!students[i]) {
				System.out.println(i);
			}
		}
	}
}