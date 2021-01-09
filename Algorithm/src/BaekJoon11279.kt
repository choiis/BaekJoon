import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var heap: PriorityQueue<MaxHeap> = PriorityQueue();
    val N:Int = sc.nextInt();
    for(t in 0 until N) {
        val num:Int = sc.nextInt();
        if(num == 0) {
            val res:Int = if(heap.isEmpty()) 0 else heap.poll().number;
            println(res);
        } else {
            heap.add(MaxHeap(num));
        }
    }

}

class MaxHeap : Comparable<MaxHeap> {

    var number:Int;

    constructor(number:Int) {
        this.number = number;
    }

    override fun compareTo(other: MaxHeap): Int {
        return other.number - this.number;
    }
}