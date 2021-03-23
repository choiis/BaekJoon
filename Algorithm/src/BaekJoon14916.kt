import java.util.*

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    var n:Int = sc.nextInt();
    var cnt:Int = 0;
    while (n > 0) {
        if (n % 5 == 0) {
            cnt = (n / 5 + cnt);
            break;
        }
        n -= 2;
        cnt++;
    }

    if (n < 0) {
        println(-1);
    } else {
        println(cnt);
    }
}