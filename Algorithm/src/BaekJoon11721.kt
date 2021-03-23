import java.util.*

fun main(args:Array<String>) {

    val sc: Scanner = Scanner(System.`in`);
    val str:String = sc.next();
    val length:Int = str.length / 10;
    for (i in 0 until length) {
        for (j in 0 until 10) {
            print("" + str.get(10 * i + j) + "");
        }
        println();
    }
    val mod:Int = str.length % 10;
    for (j in 0 until mod) {
        print("" + str.get(10 * length + j) + "");
    }
}