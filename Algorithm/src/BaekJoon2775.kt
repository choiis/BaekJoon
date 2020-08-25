import java.util.*

var dpp: Array<IntArray>? = null

fun dfs(k: Int, n: Int): Int {

	if (dpp!![k][n] != 0) {
		return dpp!![k][n];
	} else if (k == 0) {
		dpp!![k][n] = n;
		return dpp!![k][n];
	} else {
		var cnt: Int = 0;
		for (i in 1 until n + 1) {
			cnt += dfs(k - 1, i);
		}
		dpp!![k][n] = cnt;
		return cnt;
	}
};

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val T: Int = sc.nextInt();

	for (t in 0 until T) {
		val k: Int = sc.nextInt();
		val n: Int = sc.nextInt();
		dpp = Array(k + 1) { IntArray(n + 1) };

		println(dfs(k, n));
	}
}