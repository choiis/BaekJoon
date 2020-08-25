import java.util.*

val direct = arrayOf(
		intArrayOf(-2, -1),
		intArrayOf(-2, 1),
		intArrayOf(0, -2),
		intArrayOf(0, 2),
		intArrayOf(2, -1),
		intArrayOf(2, 1)
)

fun solve(): Int {
	val sc = Scanner(System.`in`);
	val N = sc.nextInt();
	val startX = sc.nextInt();
	val startY = sc.nextInt();
	val endX = sc.nextInt();
	val endY = sc.nextInt();
	val visited = Array(N) { BooleanArray(N) };
	val queue: Queue<Knights> = LinkedList<Knights>();
	visited[startX][startY] = true;
	queue.add(Knights(startX, startY, 0));
	while (!queue.isEmpty()) {
		val now: Knights = queue.poll();
		val nowX: Int = now.x;
		val nowY: Int = now.y;
		val nowDist: Int = now.dist;
		for (i in direct.indices) {
			val nextX = nowX + direct[i][0];
			val nextY = nowY + direct[i][1];
			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if (nextX == endX && nextY == endY) {
					return nowDist + 1;
				}
				if (!visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					queue.add(Knights(nextX, nextY, nowDist + 1));
				}
			}
		}
	}
	return -1;
}

fun main(args: Array<String>) {
	println(solve());
}

class Knights {
	val x: Int;
	val y: Int;
	val dist: Int;

	constructor(x: Int, y: Int, dist: Int) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}