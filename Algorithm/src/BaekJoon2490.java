import java.io.FileInputStream;
import java.util.Scanner;

public class BaekJoon2490 {

	private static Scanner sc = null;

	public static void main(String[] args) throws Exception {

		sc = new Scanner(new FileInputStream("baekjoon2490.txt"));

		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 4; j++) {
				int num = sc.nextInt();
				if (num == 0) {
					cnt++;
				} else {

				}
			}

			switch (cnt) {
			case 0:
				System.out.println("E");
				break;
			case 1:
				System.out.println("A");
				break;
			case 2:
				System.out.println("B");
				break;
			case 3:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
				break;
			}
		}
	}
}