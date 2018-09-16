import java.util.ArrayList;
import java.util.Scanner;

public class BaekJoon1914 {

	private static Scanner sc = null;

	private static int cnt = 0;
	private static ArrayList<String> arrayList = null;

	private static void hanoiTower(int N, int from, int by, int to) {

		cnt++;
		if (N == 1) {
			arrayList.add(from + " " + to);
		} else {

			hanoiTower(N - 1, from, to, by);
			arrayList.add(from + " " + to);
			hanoiTower(N - 1, by, from, to);
		}
	}

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();
		arrayList = new ArrayList<>();

		hanoiTower(N, 1, 2, 3);
		System.out.println(cnt);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}
}