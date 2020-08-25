import java.util.*

val dirt = arrayOf(
		intArrayOf(0, -1), intArrayOf(0, 1),
		intArrayOf(1, 0), intArrayOf(-1, 0)
)

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	var t: Int = 1;
	while (true) {
		val N: Int = sc.nextInt();
		if (N == 0) {
			break;
		}
		var matrix: Array<IntArray> = Array(N) { IntArray(N) };
		var dist: Array<IntArray> = Array(N) { IntArray(N) };

		for (i in 0 until N) {
			for (j in 0 until N) {
				matrix[i][j] = sc.nextInt();
				dist[i][j] = -1;
			}
		}

		dist[0][0] = matrix[0][0];
		val heap: PriorityQueue<Vertex> = PriorityQueue<Vertex>();
		heap.add(Vertex(0, 0, dist[0][0]));

		while (!heap.isEmpty()) {
			val now: Vertex = heap.poll();
			val nowX: Int = now.x;
			val nowY: Int = now.y;

			for (i in 0 until dirt.size) {
				val nextX: Int = nowX + dirt[i][0];
				val nextY: Int = nowY + dirt[i][1];
				if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0) {

					if (dist[nextX][nextY] == -1) {
						dist[nextX][nextY] = dist[nowX][nowY] + matrix[nextX][nextY];
						heap.add(Vertex(nextX, nextY, dist[nextX][nextY]));
					} else {
						if (dist[nextX][nextY] > dist[nowX][nowY] + matrix[nextX][nextY]) {
							dist[nextX][nextY] = dist[nowX][nowY] + matrix[nextX][nextY];
							heap.add(Vertex(nextX, nextY, dist[nextX][nextY]));
						}
					}
				}
			}
		}
		println("Problem " + t + ": " + dist[N - 1][N - 1]);
		t++;
	}
}

class Vertex : Comparable<Vertex> {
	val x: Int;
	val y: Int;
	val dist: Int;

	constructor(x: Int, y: Int, dist: Int) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	override fun compareTo(other: Vertex): Int {
		return dist - other.dist;
	}
}