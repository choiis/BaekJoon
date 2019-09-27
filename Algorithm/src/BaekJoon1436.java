import java.util.Scanner;

public class BaekJoon1436 {
	private static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 1;
		int calculateNum = 666;
		while (true) {

			if (cnt == N) {
				break;
			}
			calculateNum++;

			int tmpNum = calculateNum;
			boolean find = false;
			while (tmpNum != 0) {
				if (tmpNum % 1000 == 666) {
					find = true;
					break;
				}
				tmpNum /= 10;
			}

			if (find) {
				cnt++;
			}
		}
		System.out.println(calculateNum);
	}
}