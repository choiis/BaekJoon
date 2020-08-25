import java.util.*

var dp: Array<IntArray> = Array(31) { IntArray(31) };


fun func(n: Int, k: Int): Int {
	if (n == k || k == 1) {
		dp[n][k] = 1;
		return dp[n][k];
	} else {
		dp[n][k] = func(n - 1, k - 1) + func(n - 1, k);
		return dp[n][k];
	}
}

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val N: Int = sc.nextInt();
	val K: Int = sc.nextInt();

	println(func(N, K));
}