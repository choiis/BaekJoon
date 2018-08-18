
import java.util.Scanner;

public class BaekJoon2965 {

	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();

		System.out.println(Math.max(y - x, z - y) - 1);
	}
}