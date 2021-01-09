import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    var heap:PriorityQueue<Int> = PriorityQueue();
    val N:Int = sc.nextInt();
    for(t in 0 until N) {
        val num:Int = sc.nextInt();
        if(num == 0) {
            val res:Int = if(heap.isEmpty()) 0 else heap.poll();
            println(res);
        } else {
            heap.add(num);
        }
    }

}