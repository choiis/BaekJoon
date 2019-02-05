import java.util.Scanner;

public class BaekJoon1110 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 1;
		int num = N;
		while (true) {
			int sum = (num / 10) + (num % 10);
			int nextNum = 10 * (num % 10) + (sum % 10);
			if (nextNum != N) {
				num = nextNum;
				cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
	}
}