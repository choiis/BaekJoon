import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val d1:Int = sc.nextInt();
    val d2:Int = sc.nextInt();
    val PI:Double = 3.141592;

    val result:Double = 2 * d1 + 2 * d2 * PI;
    println(result);
}