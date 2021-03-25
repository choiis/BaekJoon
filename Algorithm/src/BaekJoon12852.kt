import java.util.*

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val N: Int = sc.nextInt();

	var visied: IntArray = IntArray(N + 1);

	var queue: Queue<Count> = LinkedList();
	queue.add(Count(N, 0));
	var numQueue: Deque<Int> = LinkedList();
	while (!queue.isEmpty()) {
		val count: Count = queue.poll();
		var number: Int = count.num;
		val cnt: Int = count.cnt;

		if (number == 1) {
			println(cnt);
			numQueue.add(number);
			while (number != N) {
				number = visied[number];
				numQueue.addLast(number);
			}
			break;
		}

		if (number % 3 == 0) {
			val next = number / 3;
			if (visied[next] == 0) {
				visied[next] = number;
				queue.add(Count(next, cnt + 1));
			}
		}

		if (number % 2 == 0) {
			val next = number / 2;
			if (visied[next] == 0) {
				visied[next] = number;
				queue.add(Count(next, cnt + 1));
			}
		}

		if (number - 1 > 0) {
			val next = number - 1;
			if (visied[next] == 0) {
				visied[next] = number;
				queue.add(Count(next, cnt + 1));
			}
		}
	}
	while (!numQueue.isEmpty()) {
		print("" + numQueue.pollLast() + " ");
	}
}

class Count {
	var num: Int;
	var cnt: Int;

	constructor(num: Int, cnt: Int) {
		this.num = num;
		this.cnt = cnt;
	}
}