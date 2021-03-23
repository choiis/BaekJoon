import java.util.*

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    var queue:Queue<Int> = LinkedList();
    while(true) {
        val n:Int = sc.nextInt();
        queue.clear();
        if (n == -1) {
            break;
        }
        var cnt:Int = 1;
        for (i in 2 .. n / 2) {
            if (n % i == 0) {
                cnt+=i;
                queue.add(i);
            }
        }
        if (cnt == n) {
            print("" + n + " = 1");
            for(i in 0 until queue.size) {
                print(" + " + queue.elementAt(i));
            }
            println();
        } else println(""+ n +" is NOT perfect.")
    }
}