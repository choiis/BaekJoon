import java.util.HashMap;
import java.util.Scanner;

public class BaekJoon1351 {

	private static Scanner sc;

	private static long N;
	private static long P;
	private static long Q;

	private static HashMap<Long, Long> dp;

	private static long func(Long num) {
		if (dp.containsKey(num)) {
			return dp.get(num);
		} else {

			long res = func(num / P) + func(num / Q);
			dp.put(num, res);
			return res;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		N = sc.nextLong();
		P = sc.nextLong();
		Q = sc.nextLong();
		dp = new HashMap<Long, Long>();

		dp.put(0L, 1L);
		System.out.println(func(N));
	}
}