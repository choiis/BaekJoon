import java.util.Scanner;

public class BaekJoon1100 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			String str;
			str = sc.next();
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0 && str.charAt(j) == 'F')
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}