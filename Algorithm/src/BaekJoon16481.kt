
import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val r1:Int = sc.nextInt();
    val r2:Int = sc.nextInt();
    val r3:Int = sc.nextInt();

    val r:Double = (r1*r2*r3).toDouble() / (r1*r2 + r2*r3 + r3*r1).toDouble();
    println(r);
}