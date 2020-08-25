import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);

	val n: Int = sc.nextInt();
	val m: Int = sc.nextInt();

	var heap: PriorityQueue<Node> = PriorityQueue<Node>();
	var vec: Vector<Vector<Node>> = Vector();
	for (i in 0 until n + 1) {
		vec.add(Vector<Node>());
	}

	for (i in 0 until m) {
		val x: Int = sc.nextInt();
		val y: Int = sc.nextInt();
		val z: Int = sc.nextInt();
		vec.elementAt(x).add(Node(y, z));
		vec.elementAt(y).add(Node(x, z));
	}

	var s: Int = 1;
	var result: Int = 0;
	var vertex: IntArray = IntArray(n + 1);

	var cnt: Int = 0;
	for (i in 0 until n - 1) {
		vertex[s] = 1;
		for (j in 0 until vec.elementAt(s).size) {
			heap.add(vec.elementAt(s)[j]);
		}
		while (vertex[heap.element().x] == 1) {
			heap.remove();
		}
		result += heap.element().y;
		cnt++;
		if (cnt == n - 2) {
			break;
		}
		s = heap.peek().x;
		heap.remove();
	}
	println(result);

}

class Node : Comparable<Node> {
	var x: Int;
	var y: Int;

	constructor(x: Int, y: Int) {
		this.x = x;
		this.y = y;
	}

	override fun compareTo(other: Node): Int {
		return this.y - other.y;
	}
}