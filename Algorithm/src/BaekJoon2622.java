import java.util.Scanner;

public class BaekJoon2622 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 삼각형 세변 a<=b<=c (a+b+c=N) 이고 a+b>c
		int cnt = 0;
		for (int a = 1; a < N; a++) {
			for (int b = a; b < N - a; b++) {
				int c = N - (a + b);
				if (c < b) {
					break;
				} else if (a + b > c) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
