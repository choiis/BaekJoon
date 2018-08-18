import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon11729 {

	private static Scanner sc = null;

	private static int cnt = 0;

	private static ArrayList<String> array = new ArrayList<>();

	public static void main(String[] args) {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		hanoi(1, 2, 3, N);
		System.out.println(cnt);
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

	private static void hanoi(int from, int center, int to, int N) {

		cnt++;
		if (N == 1) {
			array.add(from + " " + to);
		} else {
			hanoi(from, to, center, N - 1);
			array.add(from + " " + to);
			hanoi(center, from, to, N - 1);
		}
	}
}
