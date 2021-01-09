import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val l:Int = sc.nextInt();
    val r:Int = sc.nextInt();

    println(l * (l  - 2 * r));
}