import java.util.*

fun main(args:Array<String>) {

    val sc:Scanner = Scanner(System.`in`);
    val N:Int = sc.nextInt();

    if(N % 2 == 1) {
        println("SK");
    } else {
        println("CY");
    }
}