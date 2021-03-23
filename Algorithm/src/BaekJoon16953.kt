import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val A:Long = sc.nextLong();
    val B:Long = sc.nextLong();

    var queue:Queue<AtoB> = LinkedList();
    queue.add(AtoB(A,1));
    while (!queue.isEmpty()) {
        val n:AtoB = queue.poll();
        val now:Long = n.x;
        if (now == B) {
            println(n.cnt);
            System.exit(0);
        }
        val double:Long = 2 * now;
        val plus1:Long = 10 * now + 1;
        if (double <= B) {
            queue.add(AtoB(double,n.cnt + 1));
        }

        if (plus1 <= B) {
            queue.add(AtoB(plus1,n.cnt + 1));
        }
    }
    println(-1);
}
class AtoB {
    var x:Long;
    var cnt:Int;

    constructor(x:Long,cnt:Int) {
        this.x = x;
        this.cnt = cnt;
    }
}