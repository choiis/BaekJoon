import java.util.Scanner;

public class BaekJoon1076 {
	private static Scanner sc;

	private static String[] color = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey",
			"white" };

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int[] arr = new int[3];
		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();

		for (int i = 0; i < color.length; i++) {
			if (color[i].equals(s1)) {
				arr[0] = i;
			}
			if (color[i].equals(s2)) {
				arr[1] = i;
			}
			if (color[i].equals(s3)) {
				arr[2] = i;
			}
		}
		long result = 10 * arr[0] + arr[1];
		long power = 1;
		for (int i = 0; i < arr[2]; i++) {
			power *= 10;
		}
		System.out.println(result * power);
	}
}