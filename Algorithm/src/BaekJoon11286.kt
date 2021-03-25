import java.util.*
import kotlin.Comparator
import kotlin.math.abs

fun main(args: Array<String>) {

	val sc: Scanner = Scanner(System.`in`);
	val N: Int = sc.nextInt();
	var heap: PriorityQueue<AbsoluteValue> = PriorityQueue();
	for (i in 0 until N) {
		val number: Int = sc.nextInt();
		if (number == 0) {
			if (heap.size > 0) {
				println(heap.poll().num);
			} else {
				println(0);
			}
		} else {
			heap.add(AbsoluteValue(number));
		}
	}
}

class AbsoluteValue : Comparable<AbsoluteValue> {

	var num: Int;

	constructor(num: Int) {
		this.num = num;
	}

	override fun compareTo(other: AbsoluteValue): Int {
		if (abs(this.num) != abs(other.num)) {
			return abs(this.num) - abs(other.num);
		} else {
			return this.num - other.num;
		}
	}

}