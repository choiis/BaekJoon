import java.util.*


fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();
    var milk:IntArray = IntArray(N);
    for (i in 0 until N) {
        milk[i] = sc.nextInt();
    }
    milk.sortDescending();
    val length:Int = N / 3;
    var cnt:Long = 0;
    for (i in 0 until length) {
        cnt += milk[3 * i];
        cnt += milk[3 * i + 1];
    }

    if ( (3 * length) < N) {
        cnt += milk[3 * length];
    }
    if ( (3 * length + 1) < N) {
        cnt += milk[3 * length + 1];
    }
    println(cnt);
}