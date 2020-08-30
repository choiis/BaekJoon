import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val N: Int = sc.nextInt();
	val K: Int = sc.nextInt();
	var queue: Queue<Int> = LinkedList();
	for (i in 1..N) {
		queue.add(i);
	}

	print("<");
	while (!queue.isEmpty()) {
		if (queue.size == 1) {
			print(queue.poll());
		} else {
			for (i in 0 until K - 1) {
				queue.add(queue.poll());
			}
			print("" + queue.poll() + ", ");
		}
	}
	println(">");
}