import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val prime: IntArray = intArrayOf(0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18);
	val A: Double = sc.nextDouble() / 100;
	val B: Double = sc.nextDouble() / 100;
	var dp: Array<Array<DoubleArray>> = Array(19) { Array(19) { DoubleArray(19) } };

	dp[0][0][0] = 1.0;
	for (i in 0 until 18) {
		for (j in 0..i) {
			for (k in 0..i) {
				dp[i + 1][j][k] += dp[i][j][k] * (1 - A) * (1 - B);
				dp[i + 1][j + 1][k] += dp[i][j][k] * A * (1 - B);
				dp[i + 1][j][k + 1] += dp[i][j][k] * (1 - A) * B;
				dp[i + 1][j + 1][k + 1] += dp[i][j][k] * A * B;
			}
		}
	}

	var result: Double = 1.0;
	for (i in 0 until prime.size) {
		for (j in 0 until prime.size) {
			result -= dp[18][prime[i]][prime[j]];
		}
	}

	println(result);
}