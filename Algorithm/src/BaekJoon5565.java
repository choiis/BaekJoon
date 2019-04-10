import java.util.Scanner;

public class BaekJoon5565 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int total = sc.nextInt();
		int book;
		for (int i = 0; i < 9; i++) {
			book = sc.nextInt();
			total -= book;
		}
		System.out.println(total);
	}
}