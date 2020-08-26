import java.util.*

fun main(args:Array<String>) {
    var sc:Scanner = Scanner(System.`in`);

    val num: Int = sc.nextInt();
    var cnt = 0;
    for (i in 0 .. 4) {
        val num2: Int = sc.nextInt();
        if (num == num2) {
            cnt++;
        }
    }
    println(cnt);
}