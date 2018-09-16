import java.util.Scanner;

public class BaekJoon2864 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		String str = sc.nextLine();
		String[] num = str.split(" ");

		int min_num1 = Integer.parseInt(num[0].replace("6", "5"));
		int max_num1 = Integer.parseInt(num[0].replace("5", "6"));

		int min_num2 = Integer.parseInt(num[1].replace("6", "5"));
		int max_num2 = Integer.parseInt(num[1].replace("5", "6"));

		System.out.println((min_num1 + min_num2) + " " + (max_num1 + max_num2));
	}
}