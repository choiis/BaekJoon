import java.util.*

var n: Int = 0;
var m: Int = 0;

var bools: Boolean = false;

lateinit var inside: Array<CharArray>;
lateinit var insideVisited: Array<BooleanArray>;
val directs: Array<IntArray> = arrayOf(
		intArrayOf(0, -1), intArrayOf(0, 1),
		intArrayOf(1, 0), intArrayOf(-1, 0)
);

fun insideDfs(x: Int, y: Int) {
	insideVisited[x][y] = true;

	if (x == n - 1) {
		bools = true;
		return;
	}

	directs.forEach { i ->
		run {
			val nextX: Int = i[0] + x;
			val nextY: Int = i[1] + y;

			if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m) {
				if (!insideVisited[nextX][nextY] && inside[nextX][nextY] == '0') {
					insideDfs(nextX, nextY);
				}
			}
		}
	}

}

fun main(args: Array<String>) {
	val sc: Scanner = Scanner(System.`in`);
	n = sc.nextInt();
	m = sc.nextInt();
	inside = Array(n) { CharArray(m) };
	insideVisited = Array(n) { BooleanArray(m) };
	for (i in 0 until n) {
		inside[i] = sc.next().toCharArray();
	}

	for (i in 0 until m) {
		if (bools) {
			break;
		}
		if (!insideVisited[0][i] && inside[0][i] == '0') {
			insideDfs(0, i);
		}
	}

	if (bools) {
		println("YES");
	} else {
		println("NO");
	}
}