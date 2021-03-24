import java.util.*

fun main(args: Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val n: Int = sc.nextInt();
    var sum: Long = 0;
    for (i in 1 .. n) {
        sum += i;
    }
    println(sum);
}