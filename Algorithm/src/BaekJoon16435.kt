import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    var L:Int = sc.nextInt();
    val h:IntArray = IntArray(N);
    for (i in 0 until N) {
        h[i] = sc.nextInt();
    }
    Arrays.sort(h);
    h.forEach { i ->
        run {

            if (i <= L) {
                L++;
            }
        }
    };

    println(L);
}