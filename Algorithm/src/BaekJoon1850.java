import java.util.Scanner;

public class BaekJoon1850 {

	private static Scanner sc = null;

	private static int gcd(int N, int M) {
		int r = 1;

		int val1 = Math.max(N, M);
		int val2 = Math.min(N, M);
		while (r > 0) {// 유클리드 호제법을 이용한 GCD(최대공약수)구하기
			r = val1 % val2;
			val1 = val2;
			val2 = r;
		}

		return val1;
	}

	public static void main(String[] args) throws Exception {

		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < gcd(N, M); i++) {
			System.out.print("1");
		}
	}
}
