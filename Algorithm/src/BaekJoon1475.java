import java.util.Scanner;

public class BaekJoon1475 {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		String line = sc.next();
		int[] numbers = new int[10];
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '9') {
				numbers[6]++;
			} else {
				numbers[line.charAt(i) - '0']++;
			}
		}
		numbers[6] = numbers[6] / 2 + numbers[6] % 2;
		int max = -1;
		for (int i = 0; i < numbers.length; i++) {
			max = Math.max(max, numbers[i]);
		}
		System.out.println(max);
	}
}