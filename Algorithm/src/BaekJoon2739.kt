import java.util.*

fun main(args: Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val N: Int = sc.nextInt();
    for (i in 1 .. 9) {
        println("" + N + " * " + i + " = " + i * N);
    }
}