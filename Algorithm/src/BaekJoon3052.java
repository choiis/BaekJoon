import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaekJoon3052 {

	private static Scanner sc;

	private static int DIV = 42;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();
			set.add(n % DIV);
		}
		System.out.println(set.size());
	}
}