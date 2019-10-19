import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon4153 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while (true) {
			int[] edge = new int[3];
			edge[0] = sc.nextInt();
			edge[1] = sc.nextInt();
			edge[2] = sc.nextInt();
			if (edge[0] == 0 && edge[1] == 0 && edge[2] == 0) {
				break;
			}

			Arrays.sort(edge);

			int x = edge[0] * edge[0];
			int y = edge[1] * edge[1];
			int z = edge[2] * edge[2];
			if (x + y == z) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}